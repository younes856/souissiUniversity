package com.SoussiUnivesity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoussiUnivesity.dao.EtablissementDao;
import com.SoussiUnivesity.entities.Etablissement;

@Service
public class EtablissementService {

	@Autowired
	private EtablissementDao etablissementDao ;
	
	public Etablissement getEtablissementById(String id)
	{
		return etablissementDao.findById(Long.parseLong(id)).get();
	}
	
	public boolean addOrUpdateEtablissement(Etablissement etablissement)
	{
		try {
			etablissementDao.save(etablissement);
			return true ;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void deleteEtablissement(Etablissement etablissement)
	{
		etablissementDao.delete(etablissement);
	}
	
	public List<Etablissement> getEtablissements()
	{
		return etablissementDao.findAll();
	}
	
}
