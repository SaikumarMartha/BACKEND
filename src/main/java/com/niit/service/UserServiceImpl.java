package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.model.UserDetails;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;

	public boolean saveOrUpdate(UserDetails users) {

		return userDAO.saveOrUpdate(users);
	}

	public void delete(UserDetails user) {
		userDAO.delete(user);
		
	}

	public UserDetails getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}

	public UserDetails viewUser(int userid) {
		
		return userDAO.viewUser(userid);
	}

	public List<UserDetails> UserList() {
	
		return userDAO.UserList();
	}

	public UserDetails login(String username,String password) {
		
		return userDAO.login(username,password);
	}

	public boolean isUsernameValid(String username) {
	
		return userDAO.isUsernameValid(username);
	}

	public boolean isEmailValid(String email) {
	
		return userDAO.isEmailValid(email);
	}

	public UserDetails updateUser(UserDetails users) {

		return userDAO.updateUser(users);
	}


}
