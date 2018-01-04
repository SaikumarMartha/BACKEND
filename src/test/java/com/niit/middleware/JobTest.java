/*package com.niit.middleware;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguartion;
import com.niit.dao.JobDao;
import com.niit.model.Job;
import com.niit.service.JobService;

public class JobTest {

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfiguartion.class);
		context.scan("com.niit");
         context.refresh();
		
		jobDao=(JobDao)context.getBean("jobDao");
	}
	

	@Test
	public void addJobTest(){
		Job job=new Job();
		job.setId(12);
		job.setJobTitle("Software");
		job.setJobDesc("Process ASsociate");
		
		
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problems in Inserting Job",jobDao.addJob(job));
	}*/
//	@Autowired
//	private static JobService jobService;
//	
//	@BeforeClass
//	public static void initialize(){
//		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.niit");
//		context.refresh();
//		
//		jobService = (JobService) context.getBean("jobService");
//	}
//	
//	@Test
//	public void createJobsTest(){
//		
//		Job job = new Job();
//		job.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
//		job.setJobTitle("Software Engineer");
//		job.setSkillsRequired("B.Tech");
//		job.setCompanyName("XYZ Pvt Ltd");
//		job.setLocation("Hyderabad");
//		job.setYrsOfExp("2+ Yrs");
//		job.setSalary("250000");
//		job.setPostedOn(new Date());
//		
//		assertTrue("Problem in storing Job details",jobService.addJobs(job));
//	}
//	
//	
//	@Test
//	public void updateJobsTest(){
//		
//		Job job = new Job();
//		job.setId(142);
//		job.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
//		job.setJobTitle("Software Engineer");
//		job.setSkillsRequired("B.Tech");
//		job.setCompanyName("ABC Pvt Ltd");
//		job.setLocation("Chennai");
//		job.setYrsOfExp("4+ Yrs");
//		job.setSalary("450000");
//		job.setPostedOn(new Date());
//		
//		assertTrue("Problem in updating job details",jobService.updateJobs(job));
//	}
//	
//  
//	@Test
//	public void deleteJobsTest(){
//		
//		Job job = new Job();
//		job.setId(142);
//		job.setJobDesc("Responsible for coding, testing and deploying user friendly applications");
//		job.setJobTitle("Software Engineer");
//		job.setSkillsRequired("B.Tech");
//		job.setCompanyName("XYZ Pvt Ltd");
//		job.setLocation("Hyderabad");
//		job.setYrsOfExp("2+ Yrs");
//		job.setSalary("250000");
//		job.setPostedOn(new Date());
//		
//		assertTrue("Problem in deleting job details",jobService.deleteJobs(job));
//	}
//	
//	@Test
//	public void getJobTest(){
//		
//		Job job = jobService.getJobs(141);
//		assertNotNull("Problem in retrieving Job details",job);
//		System.out.println("Job Id : "+job.getId()+"  Job Desc: "+job.getJobDesc()+"  Job Profile : "+job.getJobTitle()+"  Job Qualification : "+job.getSkillsRequired()+"  Job "+job.getPostedOn());
//		
//	}
//	
//
//	@Test
//	public void getAllJobsTest(){
//		
//		List<Job> jobsList = jobService.getAllJobs();
//		assertNotNull("Problem in retrieving All Jobs details",jobsList);
//		showJobsDetails(jobsList);
//		
//	}
//
//	private void showJobsDetails(List<Job> jobsList) {
//		
//		for (Job jobs : jobsList) {
//			
//			System.out.println(" Job Id : "+jobs.getId());
//			System.out.println(" Job Desc : "+jobs.getJobDesc());
//			System.out.println(" Job Profile : "+jobs.getJobTitle());
//			System.out.println(" Job Qualification : "+jobs.getSkillsRequired());
//			System.out.println(" Job Posted Date : "+jobs.getPostedOn());
//			
//		}
//		
//	}

