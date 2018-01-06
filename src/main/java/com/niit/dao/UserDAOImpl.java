package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetails;


@Repository
public class UserDAOImpl implements UserDAO{


	Logger Logger=LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean saveOrUpdate(UserDetails users) {
		Logger.info("save Operation started", users.getId());
		Session session=sessionFactory.openSession();

		Transaction tx=session.beginTransaction();
		users.setEnabled(true);
		users.setOnline(false);
		session.saveOrUpdate(users);
		tx.commit();
		Logger.info("User object has been saved successfually", users.getId());
	
		return true;
	}
	@Transactional
	public void delete(UserDetails user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}
		@SuppressWarnings("deprecation")
		@Transactional
		public UserDetails getUserByUsername(String username) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
		c.add(Restrictions.eq("username", username));
		UserDetails user=(UserDetails)c.uniqueResult();
		return user;
	}
	
@SuppressWarnings("deprecation")
@Transactional
	public UserDetails viewUser(int userid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
		c.add(Restrictions.eq("userid", userid));
		UserDetails user=(UserDetails) c.uniqueResult();
		return user;
		
	}
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<UserDetails> UserList() {
		Criteria c=sessionFactory.openSession().createCriteria(UserDetails.class);
		List<UserDetails> l = c.list();
		return l;
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Transactional
		public UserDetails login(String username,String password) {
		
		Session session=sessionFactory.openSession();
	//String hql = "from Users where userName= " + "'" + username + "'" + "and password= " + "'" + password + "'";
		Query query=session.createQuery("from UserDetails where username=? and password=? and enabled=?");
	
		query.setString(0, username); //for assigning the values to parameter username
		query.setString(1, password);
		query.setBoolean(2, true);
		UserDetails validUsers=(UserDetails)query.uniqueResult();
		session.close();
		System.out.println("login Dao completed");
		return validUsers;
	}
	
	
		@Transactional
		public boolean isUsernameValid(String username) {
		List<UserDetails> list = UserList();

		for (UserDetails usersDetail : list) {
			if (usersDetail.getUsername().equals(username)) {
				return false;// invalid user
			}
		}
		return true;// valid user
	}
	

	@Transactional
		public boolean isEmailValid(String email) {
		List<UserDetails> list = UserList();

		for (UserDetails usersDetail : list) {
			if (usersDetail.getEmail().equals(email)){
				return false;// invalid user
			}
		}
		return true;// valid user
	}

	@Transactional
	public UserDetails updateUser(UserDetails validUser)
	
	
	{
		System.out.println("UserDAOImpl"+validUser.getOnline());
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(validUser);
		tx.commit();
		session.clear();
		return validUser;
	}
	

}
