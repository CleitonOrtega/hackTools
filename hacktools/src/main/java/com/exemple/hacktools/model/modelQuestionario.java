package com.exemple.hacktools.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_questionario")
public class modelQuestionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestionario;
	
	@Column
	@NotNull
	private String titulo;
	
	@Column
	@NotNull
	private String primeiraPergunta;
	
	@Column
	private String segundaPergunta;
	
	@Column
	@NotNull
	private String usuario;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date data;
	
	@OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("questionario")
	private List<modelResposta> modelResposta;

	public Long getIdQuestionario() {
		return idQuestionario;
	}

	public void setIdQuestionario(Long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrimeiraPergunta() {
		return primeiraPergunta;
	}

	public void setPrimeiraPergunta(String primeiraPergunta) {
		this.primeiraPergunta = primeiraPergunta;
	}

	public String getSegundaPergunta() {
		return segundaPergunta;
	}

	public void setSegundaPergunta(String segundaPergunta) {
		this.segundaPergunta = segundaPergunta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<modelResposta> getModelResposta() {
		return modelResposta;
	}

	public void setModelResposta(List<modelResposta> modelResposta) {
		this.modelResposta = modelResposta;
	}
	
}
