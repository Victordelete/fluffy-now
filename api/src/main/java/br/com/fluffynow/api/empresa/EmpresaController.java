package br.com.fluffynow.api.empresa;

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
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping("/list")
    public List<Empresa> list(){
		List<Empresa> Empresas= null; 
		try {
			Empresas = empresaRepository.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
        return Empresas;
    }
	
	@PostMapping("/")
	public Empresa savePaciente(@RequestBody Empresa empresa){
		try {
			empresa = empresaRepository.save(empresa);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return empresa; 
	}
	
	@GetMapping("/{id}")
    public Empresa getPacienteById(@PathVariable("id") Long id){
		Empresa empresa = null; 
		try {
			empresa = empresaRepository.getReferenceById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return empresa; 
    }
	
	@PutMapping("/{id}")
	public Empresa editPaciente(@PathVariable("id") Long id,
			@RequestBody Empresa empresa) {
		Empresa empresaEdit = null; 
		try {
			empresaRepository.save(empresa);
			empresaEdit = empresaRepository.getReferenceById(empresa.getIdEmpresa());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return empresaEdit; 
	}
	
	@DeleteMapping("/{id}")
	public Empresa deletePaciente(@PathVariable("id") Long id) {
		Empresa empresa = null; 
		try{
			empresa = empresaRepository.getReferenceById(id);
			empresaRepository.deleteById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

        return empresa; 
	}
}
