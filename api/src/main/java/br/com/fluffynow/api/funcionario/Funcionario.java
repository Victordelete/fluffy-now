package br.com.fluffynow.api.funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.fluffynow.api.cargo.Cargo;
import br.com.fluffynow.api.departamento.Departamento;
import br.com.fluffynow.api.regPonto.RegPonto;
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
@Table(name = "funcionario") 
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@jakarta.persistence.Column(name="idFuncionario")
	private Long idFuncionario;
	
	@jakarta.persistence.Column(name="nome")
	private String nome; 
	
	@jakarta.persistence.Column(name="cpf")
	private String cpf; 
	
	@jakarta.persistence.Column(name="salario")
	private BigDecimal salario;
	
	@jakarta.persistence.Column(name="dataNascimento")
	private LocalDate dataNascimento;
	
	@ManyToOne
	@JoinColumn(name="id_cargo", nullable=false)
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="id_departamento", nullable=false)
	private Departamento departamento;
	
	@JsonBackReference
	@OneToMany(mappedBy="funcionario")
	private List<RegPonto> regPontos;
	
}
