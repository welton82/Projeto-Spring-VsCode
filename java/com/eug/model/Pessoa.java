package com.eug.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="vacinou")
	private Boolean vacinou;
	
	@Column(name="primeiraDose")
	private Date primeiraDose;
	
	@Column(name="segundaDose")
	private Date segundaDose;
	
	
	
	public Pessoa() {
		super();
	}
	public Pessoa(String nome, String cpf, Long id, Boolean vacinou, Date primeiraDose, Date segundaDose) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
		this.vacinou = vacinou;
		this.primeiraDose = primeiraDose;
		this.segundaDose = segundaDose;
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getVacinou() {
		return vacinou;
	}
	public void setVacinou(Boolean vacinou) {
		this.vacinou = vacinou;
	}
	public java.sql.Date getPrimeiraDose() {
		java.util.Date dt = (java.util.Date) primeiraDose;
		java.sql.Date nova = new java.sql.Date(dt.getTime());
		
		return nova;
	}
	public void setPrimeiraDose(Date primeiraDose) {
		this.primeiraDose = primeiraDose;
	}
	public java.sql.Date getSegundaDose() {
		
		java.util.Date dt = (java.util.Date) segundaDose;
		java.sql.Date nova = new java.sql.Date(dt.getTime());
		
		return nova;
	}
	public void setSegundaDose(Date segundaDose) {
		this.segundaDose = segundaDose;
	}
	
	
	
}
