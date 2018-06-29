package com.SoussiUnivesity.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoussiUnivesity.dao.CompteDao;
import com.SoussiUnivesity.entities.Compte;


@Service
public class CompteService {

	@Autowired
	private CompteDao compteDao ;
	
	public Compte getCompteById(String id)
	{
		return compteDao.findById(Long.parseLong(id)).get();
	}
	
	public boolean addOrUpdateCompte(Compte compte )
	{
		try {
			compteDao.save(compte);
			return true ;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void deleteCompte(Compte compte)
	{
		compteDao.delete(compte);
	}
	
	public List<Compte> getComptes()
	{
		return compteDao.findAll();
	}
}
