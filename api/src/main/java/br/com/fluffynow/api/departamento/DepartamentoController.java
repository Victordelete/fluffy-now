package br.com.fluffynow.api.departamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository DepartamentoRepository;
	
	@GetMapping("/list")
    public List<Departamento> list(){
		List<Departamento> Departamentos= null; 
		try {
			Departamentos = DepartamentoRepository.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
        return Departamentos;
    }
	
	@PostMapping("/")
	public Departamento savePaciente(@RequestBody Departamento Departamento){
		try {
			Departamento = DepartamentoRepository.save(Departamento);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Departamento; 
	}
	
	@GetMapping("/{id}")
    public Departamento getPacienteById(@PathVariable("id") Long id){
		Departamento Departamento = null; 
		try {
			Departamento = DepartamentoRepository.getReferenceById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return Departamento; 
    }
	
	@PutMapping("/{id}")
	public Departamento editPaciente(@PathVariable("id") Long id,
			@RequestBody Departamento Departamento) {
		Departamento DepartamentoEdit = null; 
		try {
			DepartamentoRepository.save(Departamento);
			DepartamentoEdit = DepartamentoRepository.getReferenceById(Departamento.getIdDepartamento());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return DepartamentoEdit; 
	}
	
	@DeleteMapping("/{id}")
	public Departamento deletePaciente(@PathVariable("id") Long id) {
		Departamento Departamento = null; 
		try{
			Departamento = DepartamentoRepository.getReferenceById(id);
			DepartamentoRepository.deleteById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

        return Departamento; 
	}
}
