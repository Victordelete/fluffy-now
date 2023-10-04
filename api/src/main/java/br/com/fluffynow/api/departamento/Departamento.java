package br.com.fluffynow.api.departamento;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.fluffynow.api.empresa.Empresa;
import br.com.fluffynow.api.funcionario.Funcionario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "departamento") 
public class Departamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@jakarta.persistence.Column(name="idDepartamento")
	private Long idDepartamento;
	
	@jakarta.persistence.Column(name="nome")
	private String nome; 
	
	@jakarta.persistence.Column(name="descricao")
	private String descricao; 
	
	@ManyToOne
	@JoinColumn(name="id_empresa", nullable=false)
	private Empresa empresa;
	
	@JsonBackReference
	@OneToMany(mappedBy="departamento")
	private List<Funcionario> funcionarios;
}
