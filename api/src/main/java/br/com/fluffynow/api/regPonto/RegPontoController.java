package br.com.fluffynow.api.regPonto;

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
@RequestMapping("/regPonto")
public class RegPontoController {
	
	@Autowired
	private RegPontoRepository regPontoRepository;
	
	@GetMapping("/list")
    public List<RegPonto> list(){
		List<RegPonto> regPontos= null; 
		try {
			regPontos = regPontoRepository.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
        return regPontos;
    }
	
	@PostMapping("/")
	public RegPonto savePaciente(@RequestBody RegPonto regPonto){
		try {
			regPonto = regPontoRepository.save(regPonto);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return regPonto; 
	}
	
	@GetMapping("/{id}")
    public RegPonto getPacienteById(@PathVariable("id") Long id){
		RegPonto regPonto = null; 
		try {
			regPonto = regPontoRepository.getReferenceById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return regPonto; 
    }
	
	@PutMapping("/{id}")
	public RegPonto editPaciente(@PathVariable("id") Long id,
			@RequestBody RegPonto regPonto) {
		RegPonto regPontoEdit = null; 
		try {
			regPontoRepository.save(regPonto);
			regPontoEdit = regPontoRepository.getReferenceById(regPonto.getIdRegPonto());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return regPontoEdit; 
	}
	
	@DeleteMapping("/{id}")
	public RegPonto deletePaciente(@PathVariable("id") Long id) {
		RegPonto regPonto = null; 
		try{
			regPonto = regPontoRepository.getReferenceById(id);
			regPontoRepository.deleteById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

        return regPonto; 
	}
}
