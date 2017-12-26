package com.niit.Dao;

import java.util.List;

import com.niit.model.User1;

public interface UserDao {
	
	public boolean saveOrUpdate(User1 user1);
	public User1 updateUser(User1 validUser);
	public void delete(User1 user1);
	public User1 getUser(String username);
	public User1 getUserById(int userid);
	public User1 viewUser(int userid);
	public List<User1> UserList();
	public User1 login(User1 user1);
	
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);
	
}
