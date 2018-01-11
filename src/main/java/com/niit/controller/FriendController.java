package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.FriendDAO;
import com.niit.model.Friend;
import com.niit.model.Error;
import com.niit.model.UserDetails;
@RestController
public class FriendController {

	
	

	@Autowired
	private FriendDAO friendDao;
	
	@RequestMapping(value="/suggestedusers",method=RequestMethod.GET)
	public ResponseEntity<?> getSuggestedUsers(HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		String username=validUser.getUsername();
		System.out.println("==================================="+username);
		
		if (validUser == null)
		{
			Error error = new Error(5, "UnAuthorized Access");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		//String username="ser";
		List<UserDetails> suggestedUsers=friendDao.suggestedUsersList(username);
		return new ResponseEntity<List<UserDetails>>(suggestedUsers,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addfriendrequest/{toId}",method=RequestMethod.POST)
	public ResponseEntity<?> addFriendRequest(@PathVariable String toId,HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if (validUser == null)
		{
			Error error = new Error(5, "UnAuthorized Access");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		Friend friend=new Friend();
		friend.setFromId(validUser.getUsername());
		friend.setToId(toId);
		friend.setStatus('P');
		friendDao.addFriendRequest(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	@RequestMapping(value="/pendingrequests",method=RequestMethod.GET)
	public ResponseEntity<?> pendingRequests(HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if (validUser == null)
		{
			Error error = new Error(5, "UnAuthorized Access");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		
	
		List<Friend> pendingRequests=friendDao.pendingRequests(validUser.getUsername());
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/updatependingrequest",method=RequestMethod.PUT)
	public ResponseEntity<?> updatePendingRequest(@RequestBody Friend friend,HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if (validUser == null)
		{
			Error error = new Error(5, "UnAuthorized Access");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		friendDao.updatePendingRequest(friend); //updated status[a/r]
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	@RequestMapping(value="/getfriends",method=RequestMethod.GET)
	public ResponseEntity<?> getListofFriends(HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if (validUser == null)
		{
			Error error = new Error(5, "UnAuthorized Access");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		}
		List<UserDetails> friends=friendDao.listofFriends(validUser.getUsername());
		return new ResponseEntity<List<UserDetails>>(friends,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/mutualfriends/{toId}",method=RequestMethod.GET)
	public ResponseEntity<?> getListofMutualFriends(@PathVariable String toId ,HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		/*String username = (String) session.getAttribute("username");
		if (username == null)
		{
			ErrorClass error = new ErrorClass(5, "UnAuthorized Access");
			return new ResponseEntity<ErrorClass>(error, HttpStatus.UNAUTHORIZED);
		}*/
		//String username="ser";
		List<UserDetails> mutualfriends=friendDao.listofMutualFriends(validUser.getUsername(), toId);
		return new ResponseEntity<List<UserDetails>>(mutualfriends,HttpStatus.OK);
		
	}
}