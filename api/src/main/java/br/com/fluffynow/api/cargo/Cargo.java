package br.com.fluffynow.api.cargo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.fluffynow.api.funcionario.Funcionario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@Entity
@Getter
@Setter
@Table(name = "cargo") 
public class Cargo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@jakarta.persistence.Column(name="idCargo")
	private Long idCargo;
	
	@jakarta.persistence.Column(name="nome")
	private String nome; 
	
	@jakarta.persistence.Column(name="descricao")
	private String descricao;
	
	@JsonBackReference
	@OneToMany(mappedBy="cargo")
	private List<Funcionario> funcionarios;
	
}
