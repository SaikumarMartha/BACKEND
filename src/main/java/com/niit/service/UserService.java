package com.niit.service;

import java.util.List;

import com.niit.model.UserDetails;

public interface UserService 
{
	
	public boolean saveOrUpdate(UserDetails users);
	public UserDetails updateUser(UserDetails users);
	public void delete(UserDetails user);
	public UserDetails getUserByUsername(String username);
	public UserDetails viewUser(int userid);
	public List<UserDetails> UserList();
	public UserDetails login(String username,String password);
	public boolean isUsernameValid(String username);
	public boolean isEmailValid(String email);
}
