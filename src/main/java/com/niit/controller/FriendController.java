/*package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	private FriendDAO friendDAO;
	
	
	@RequestMapping(value="/suggestedUserDetailslist",method=RequestMethod.POST)
	public ResponseEntity<?> getSuggestedUserDetailsList(HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if(validUser==null)
		{
			Error error=new Error(3, "UnAuthoribute user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<UserDetails> suggestedUserDetails=friendDAO.listOfSuggestedUsers(validUser.getUsername());
		return new ResponseEntity<List<UserDetails>>(suggestedUserDetails,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/friendrequest/{toUsername}",method=RequestMethod.POST)
	public ResponseEntity<?> friendRequest(@PathVariable String toUsername, HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if(validUser==null)
		{
			Error error=new Error(3, "UnAuthorised user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		String fromUsername=validUser.getUsername();
		friendDAO.friendRequest(fromUsername,toUsername);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}	
	
	
	@RequestMapping(value="/pendingrequests",method=RequestMethod.GET)
	public ResponseEntity<?> pendingRequest(HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if(validUser==null)
		{
			Error error=new Error(3, "UnAuthorised user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Friend> pendingRequests=friendDAO.listOfPendingRequest(validUser.getUsername());
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/updatependingrequest/{fromId}/{status}",method=RequestMethod.PUT)
	public ResponseEntity<?> updatePendingRequests(@PathVariable String fromId,@PathVariable char status,HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		if(validUser==null)
		{
			Error error=new Error(3, "UnAuthorised user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
			friendDAO.updatePendingRequest(fromId, validUser.getUsername(),status);
			return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value="/listoffriends",method=RequestMethod.GET)
	public ResponseEntity<?>listOfFriends(HttpSession session)
	{
		UserDetails validUser=(UserDetails)session.getAttribute("validUser");
		
		if(validUser==null)
		{
			Error error=new Error(3, "UnAuthorised user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
			List<Friend> friends=friendDAO.listOfFriends(validUser.getUsername());
			return new ResponseEntity<List<Friend>>(friends,HttpStatus.OK);
	}
}
*/