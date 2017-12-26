package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Dao.UserDao;
import com.niit.model.User1;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public boolean saveOrUpdate(User1 user1) {
		return userDao.saveOrUpdate(user1);
	}

	public User1 updateUser(User1 user1) {
		return userDao.updateUser(user1);
	}

	public void delete(User1 user1) {
		userDao.delete(user1);
		
	}

	public User1 getUser(String username) {
		return userDao.getUser(username);
	}

	public User1 viewUser(int userid) {
		return userDao.viewUser(userid);
	}

	public List<User1> UserList() {
		return userDao.UserList();
	}

	public User1 login(User1 user1) {
		return userDao.login(user1);
	}

	public boolean isUsernameValid(String username) {
		return userDao.isUsernameValid(username);
	}

	public boolean isEmailValid(String email) {
		return userDao.isEmailValid(email);
	}

}
