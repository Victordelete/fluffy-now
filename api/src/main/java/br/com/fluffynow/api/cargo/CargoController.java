package br.com.fluffynow.api.cargo;

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
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping("/list")
    public List<Cargo> list(){
		List<Cargo> cargos= null; 
		try {
			cargos = cargoRepository.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
        return cargos;
    }
	
	@PostMapping("/")
	public Cargo savePaciente(@RequestBody Cargo cargo){
		try {
			cargo = cargoRepository.save(cargo);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cargo; 
	}
	
	@GetMapping("/{id}")
    public Cargo getPacienteById(@PathVariable("id") Long id){
		Cargo cargo = null; 
		try {
			cargo = cargoRepository.getReferenceById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return cargo; 
    }
	
	@PutMapping("/{id}")
	public Cargo editPaciente(@PathVariable("id") Long id,
			@RequestBody Cargo cargo) {
		Cargo cargoEdit = null; 
		try {
			cargoRepository.save(cargo);
			cargoEdit = cargoRepository.getReferenceById(cargo.getIdCargo());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cargoEdit; 
	}
	
	@DeleteMapping("/{id}")
	public Cargo deletePaciente(@PathVariable("id") Long id) {
		Cargo cargo = null; 
		try{
			cargo = cargoRepository.getReferenceById(id);
			cargoRepository.deleteById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

        return cargo; 
	}
}
