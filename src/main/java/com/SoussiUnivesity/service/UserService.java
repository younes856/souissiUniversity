package com.SoussiUnivesity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoussiUnivesity.dao.UserDao;
import com.SoussiUnivesity.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao ;
	
	public User getUserById(String id)
	{
		return userDao.findById(Long.parseLong(id)).get();
	}
	
	
	public boolean addOrUpdateUser(User user)
	{
		try {
			userDao.save(user); 
			return true ;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void deleteUser(User user)
	{
		userDao.delete(user);
	}
	
	public List<User> getUsers()
	{
		return userDao.findAll();
	}
	
}
