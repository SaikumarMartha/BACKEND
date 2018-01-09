/*package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.Friend;
import com.niit.model.UserDetails;

public class FriendDAOImpl implements FriendDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public List<UserDetails> listOfSuggestedUsers(String username) 
	{
		
		Session session=sessionFactory.openSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from users where username in " 
							 					+"(select username from users where username!=? "
												+"minus "
												+"(select fromId from friend_batch19 where toId=?"
												+"union "
												+"select toId from friend_batch19 where fromId=? ))");
		sqlQuery.setString(0, username);
		sqlQuery.setString(1, username);
		sqlQuery.setString(2, username);
		sqlQuery.addEntity(UserDetails.class);
		List<UserDetails> suggestedUsersList=sqlQuery.list();
		session.close();
		return suggestedUsersList;
		
	}
	
	public void friendRequest(String fromUsername, String toUsername){
		Session session=sessionFactory.openSession();
		Friend friend=new Friend();
		friend.setFromId(fromUsername);
		friend.setToId(toUsername);
		friend.setStatus('p');
		session.save(friend);
		session.flush();
		session.close();
	}

	
	public List<Friend> listOfPendingRequest(String toUsername)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where toId=? and status=?");
		query.setString(0, toUsername);
		query.setCharacter(1, 'p');
		List<Friend> pendingRequests=query.list();
		session.close();
		return pendingRequests;
	}

	public void updatePendingRequest(String fromId,String toId,char status) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where fromId=? and toId=?");
		query.setString(0, fromId);
		query.setString(1, toId);
		Friend friend=(Friend)query.uniqueResult();
		friend.setStatus(status);
		session.update(friend);
		session.flush();
		session.close();
	}
	
	
	
public void updatePendingRequest(String fromId, String toId, char status) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Friend set status=? where fromId = ? and toId=? ");
		query.setCharacter(0, status);
		query.setString(1, fromId);
		query.setString(2, toId);
		query.executeUpdate();
		session.flush();
		session.close();
	}
    
	
	
	
	
	
	
	public List<Friend> listOfFriends(String Username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where(fromId=? or toId=?) and status=?");
		query.setString(0, Username);
		query.setString(1, Username);
		query.setCharacter(2, 'A');
		List<Friend> friends=query.list();
		session.close();
		return friends;
	}
	
}

*/