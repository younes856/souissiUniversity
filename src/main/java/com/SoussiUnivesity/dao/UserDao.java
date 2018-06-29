package com.SoussiUnivesity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoussiUnivesity.entities.User;

public interface UserDao extends JpaRepository<User, Long>{

}
