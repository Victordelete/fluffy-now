package br.com.fluffynow.api.funcionario;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.fluffynow.api.cargo.Cargo;
import br.com.fluffynow.api.departamento.Departamento;
import br.com.fluffynow.api.empresa.Empresa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@jakarta.persistence.Column(name="idFuncionario")
	private Long idFuncionario;
	
	@jakarta.persistence.Column(name="nome")
	private String nome; 
	
	@jakarta.persistence.Column(name="cpf")
	private String cpf; 
	
	@jakarta.persistence.Column(name="salario")
	private BigDecimal salario;
	
	@jakarta.persistence.Column(name="dataNascimento")
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa", nullable=false)
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="idCargo", nullable=false)
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="idDepartamento", nullable=false)
	private Departamento departamento;
	
}
