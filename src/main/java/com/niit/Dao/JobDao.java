package com.niit.Dao;

import java.util.List;

import com.niit.model.Job;

public interface JobDao {

	
public boolean addJobs(Job job);
	
	public boolean updateJobs(Job job);
	
	public boolean deleteJobs(Job job);
	
	public Job getJobDetail(int jobId);
	
	public List<Job> getAllJobDetails();
}
