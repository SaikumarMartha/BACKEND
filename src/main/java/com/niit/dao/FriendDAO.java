package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.UserDetails;

public interface FriendDAO {

	List<UserDetails> suggestedUsersList(String username);
	public void addFriendRequest(Friend friend);
	List<Friend> pendingRequests(String username);
	public void updatePendingRequest(Friend friend);
	List<UserDetails> listofFriends(String username);
	List<UserDetails> listofMutualFriends(String loginId,String suggestedUsername);
}
