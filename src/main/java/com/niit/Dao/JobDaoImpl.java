package com.niit.Dao;

import java.util.List;



import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Job;
@Repository
public class JobDaoImpl implements JobDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addJobs(Job job) {
		try
		{
		    sessionFactory.getCurrentSession().save(job);
			return true;
		}catch(Exception e){
			System.out.println("Exception raised: "+e);
			return false;
		}
	}
	@Transactional
	public boolean updateJobs(Job job) {
		try{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}catch(Exception e){
			System.out.println("Exception raised: "+e);
			return false;
		}
	}
	@Transactional
	public boolean deleteJobs(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
			
		}catch(Exception e){
			
			System.out.println("Exception raised: "+e);
			return false;
		}
	}
	@Transactional
	public Job getJobDetail(int jobId) {
Session session = sessionFactory.openSession();
		
		Job jobsObj = session.get(Job.class, jobId);
		
		session.close();
		
		return jobsObj;
	}
	@Transactional
	public List<Job> getAllJobDetails() {
Session session = sessionFactory.openSession();
		
		List<Job> jobsList= session.createQuery("from Job",Job.class).list();
		
		session.close();
		
		return jobsList;
	}

}
