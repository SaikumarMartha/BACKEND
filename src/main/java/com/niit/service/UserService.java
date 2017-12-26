package com.niit.service;

import java.util.List;

import com.niit.model.User1;

public interface UserService 
{
	
	public boolean saveOrUpdate(User1 user1);
	public User1 updateUser(User1 user1);
	public void delete(User1 user1);
	public User1 getUser(String username);
	public User1 viewUser(int userid);
	public List<User1> UserList();
	public User1 login(User1 user1);
	public boolean isUsernameValid(String username);
	public boolean isEmailValid(String email);
}
