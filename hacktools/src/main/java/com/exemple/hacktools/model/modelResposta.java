package com.exemple.hacktools.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_resposta")
public class modelResposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResposta;
	
	@Column
	@NotNull
	private String primeiraResposta;
	
	@Column
	@NotNull
	private String segundaResposta;
	
	@Column
	@NotNull
	private String lat;
	
	@Column
	@NotNull
	private String longi;
	
	@ManyToOne
	@JsonIgnoreProperties("modelResposta")
	private modelQuestionario questionario;

	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}

	public String getPrimeiraResposta() {
		return primeiraResposta;
	}

	public void setPrimeiraResposta(String primeiraResposta) {
		this.primeiraResposta = primeiraResposta;
	}

	public String getSegundaResposta() {
		return segundaResposta;
	}

	public void setSegundaResposta(String segundaResposta) {
		this.segundaResposta = segundaResposta;
	}
	
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	public modelQuestionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(modelQuestionario questionario) {
		this.questionario = questionario;
	}
	
	
}
