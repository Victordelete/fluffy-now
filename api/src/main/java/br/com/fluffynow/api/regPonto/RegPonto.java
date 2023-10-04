package br.com.fluffynow.api.regPonto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.fluffynow.api.funcionario.Funcionario;
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
@Table(name = "regPonto") 
public class RegPonto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@jakarta.persistence.Column(name="idRegPonto")
	private Long idRegPonto;
	
	@jakarta.persistence.Column(name="dataPonto")
	private Date dataPonto; 
	
	@jakarta.persistence.Column(name="local")
	private String local; 
	
	@jakarta.persistence.Column(name="distancia")
	private String distancia;
	
	@ManyToOne
	@JoinColumn(name="id_funcionario", nullable=false)
	private Funcionario funcionario;
}
