package com.SoussiUnivesity.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="utilisateur",uniqueConstraints = @UniqueConstraint(columnNames= {"login"}))
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id ;
	private String login ;
	private String password ;
	@ManyToMany(cascade= {CascadeType.PERSIST , CascadeType.MERGE} , fetch=FetchType.EAGER)
	private List<Etablissement> etablissements ;
	
	
	
	public List<Etablissement> getEtablissements() {
		return etablissements;
	}
	public void setEtablissements(List<Etablissement> etablissements) {
		this.etablissements = etablissements;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
