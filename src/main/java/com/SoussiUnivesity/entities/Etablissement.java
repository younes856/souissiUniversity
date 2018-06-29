package com.SoussiUnivesity.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Etablissement implements Serializable {

	@Id
	@GeneratedValue
	private Long id ;
	private String  codeEtabe ;
	private String libEtabe ;
	@ManyToMany(mappedBy="etablissements" , cascade= {CascadeType.MERGE , CascadeType.PERSIST} )
	private List<User> users ;
	@OneToMany(mappedBy="etablissement")
	private List<Compte> comptes ;
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeEtabe() {
		return codeEtabe;
	}
	public void setCodeEtabe(String codeEtabe) {
		this.codeEtabe = codeEtabe;
	}
	public String getLibEtabe() {
		return libEtabe;
	}
	public void setLibEtabe(String libEtabe) {
		this.libEtabe = libEtabe;
	}
	public Etablissement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
