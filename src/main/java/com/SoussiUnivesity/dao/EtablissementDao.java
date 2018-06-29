package com.SoussiUnivesity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoussiUnivesity.entities.Etablissement;

public interface EtablissementDao extends JpaRepository<Etablissement, Long> {

}
