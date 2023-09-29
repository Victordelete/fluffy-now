package br.com.fluffynow.api.empresa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "empresa") 
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@jakarta.persistence.Column(name="idEmpresa")
	private Long idEmpresa;
	
	@jakarta.persistence.Column(name="nomeFantasia")
	private String nomeFantasia;
	
	@jakarta.persistence.Column(name="cnpj")
	private String cnpj;
	
	@jakarta.persistence.Column(name="insEstadual")
	private String insEstadual;
	
	@jakarta.persistence.Column(name="ramo")
	private String ramo;
	
	@jakarta.persistence.Column(name="endereco")
	private String endereco;
	
	@jakarta.persistence.Column(name="localizacao")
	private String localizacao;
	
}
