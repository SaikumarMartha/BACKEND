package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Dao.JobDao;
import com.niit.model.Job;
@Service("jobsService")
public class JobServiceImpl implements JobService{

	

	@Autowired
	JobDao jobDao;
	public boolean addJobs(Job job) {
		return jobDao.addJobs(job);
	}

	public boolean updateJobs(Job job) {
		return jobDao.updateJobs(job);
	}

	public boolean deleteJobs(Job job) {
		return jobDao.deleteJobs(job);
	}

	public Job getJobs(int jobId) {
		return jobDao.getJobDetail(jobId);
	}

	public List<Job> getAllJobs() {
		return jobDao.getAllJobDetails();
	}

}
