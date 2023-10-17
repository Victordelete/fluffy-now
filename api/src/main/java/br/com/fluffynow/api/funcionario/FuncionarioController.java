package br.com.fluffynow.api.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/list")
    public List<Funcionario> list(){
		List<Funcionario> funcionarios= null; 
		try {
			funcionarios = funcionarioRepository.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
        return funcionarios;
    }
	
	@PostMapping("/")
	public Funcionario savePaciente(@RequestBody Funcionario funcionario){
		try {
			funcionario = funcionarioRepository.save(funcionario);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return funcionario; 
	}
	
	@GetMapping("/{id}")
    public Funcionario getPacienteById(@PathVariable("id") Long id){
		Funcionario funcionario = null; 
		try {
			funcionario = funcionarioRepository.getReferenceById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return funcionario; 
    }
	
	@PutMapping("/{id}")
	public Funcionario editPaciente(@PathVariable("id") Long id,
			@RequestBody Funcionario funcionario) {
		Funcionario funcionarioEdit = null; 
		try {
			funcionarioRepository.save(funcionario);
			funcionarioEdit = funcionarioRepository.getReferenceById(funcionario.getIdFuncionario());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionarioEdit; 
	}
	
	@DeleteMapping("/{id}")
	public Funcionario deletePaciente(@PathVariable("id") Long id) {
		Funcionario funcionario = null; 
		try{
			funcionario = funcionarioRepository.getReferenceById(id);
			funcionarioRepository.deleteById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

        return funcionario; 
	}
}
