package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Friend;
import com.niit.model.UserDetails;
@Repository
@Transactional
public class FriendDAOImpl implements FriendDAO{
	@Autowired
	private SessionFactory sessionFactory;


	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<UserDetails> suggestedUsersList(String username) {

		Session session=sessionFactory.openSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from Register where username in " 
							 					+"(select username from Register where username!=? "
												+"minus "
												+"(select fromId from Friends where toId=?"
												+"union "
												+"select toId from Friends where fromId=? ))");
		sqlQuery.setString(0, username);
		sqlQuery.setString(1, username);
		sqlQuery.setString(2, username);
		sqlQuery.addEntity(UserDetails.class);
		List<UserDetails> suggestedUsersList=sqlQuery.list();
		session.close();
		return suggestedUsersList;
	}

	
	public void addFriendRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		session.save(friend); //insert into friend values(fromId,toId,status)
		
	}

	
	public List<Friend> pendingRequests(String username) {
		Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Friend where toId=? and status=?");
	query.setString(0, username);
	query.setCharacter(1,'P');
	List<Friend> pendingRequests=query.list();
		return pendingRequests;
	}

	public void updatePendingRequest(Friend friend) {
	Session session=sessionFactory.getCurrentSession();
	if(friend.getStatus()=='A')
		session.update(friend); //update friend set status='A' where id=?
	else
		session.delete(friend);  //delete friend where id=?
		
		
	}

	
	public List<UserDetails> listofFriends(String username) {
		Session session=sessionFactory.getCurrentSession();
	SQLQuery query1=session.createSQLQuery("select * from  Register where username in " + "(select toId from Friends where fromId=? and status='A')");
	SQLQuery query2=session.createSQLQuery("select * from Register where username in (select fromId from Friends where toId=? and status='A') ")	;
	query1.setString(0, username);
	query2.setString(0, username);
	query1.addEntity(UserDetails.class);
	query2.addEntity(UserDetails.class);
	List<UserDetails> list1=query1.list();
	List<UserDetails> list2=query2.list();
	list1.addAll(list2);
	return list1;
	}

	
	public List<UserDetails> listofMutualFriends(String loginId, String suggestedUsername) {
		List<UserDetails> friendlist1=listofFriends(loginId);
		List<UserDetails> friendlist2=listofFriends(suggestedUsername);
		List<UserDetails> mutualFriends=new ArrayList<UserDetails>();
		for(UserDetails user1:friendlist1)
		{
			for(UserDetails user2:friendlist2)
			{
				if(user1.getUsername().equals(user2.getUsername()))
					mutualFriends.add(user1);
			}
		}
		return mutualFriends;
	}

	
	
	
	
	
	
}

