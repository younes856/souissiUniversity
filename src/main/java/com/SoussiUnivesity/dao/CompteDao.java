package com.SoussiUnivesity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoussiUnivesity.entities.Compte;

public interface CompteDao  extends JpaRepository<Compte, Long>{

}
