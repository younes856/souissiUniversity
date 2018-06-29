package com.SoussiUnivesity.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Compte implements Serializable {

	@Id
	@GeneratedValue
	private Long id ;
	private String num ;
	@ManyToOne
	private Etablissement etablissement ;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
