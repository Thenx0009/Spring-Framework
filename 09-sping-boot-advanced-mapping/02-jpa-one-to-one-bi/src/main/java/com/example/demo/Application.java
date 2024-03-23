package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDao;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO) {

		return runner -> {
			//createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			//findInstructordetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	

	private void createInstructor(AppDao appDAO) {
		// create the instructor
		// Instructor theInstructor = new Instructor("Ayush", "Verma",
		// "vermaayu2424@gmail.com");
		// create the instructor detail
		// InstructorDetail theInstructorDetail = new
		// InstructorDetail("https://www.youtube.com/", "luv2code");

		Instructor theInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("https://www.youtube.com/", "guitar");

		// associate the objects
		theInstructor.setInstructorDetail(theInstructorDetail);

		// NOTE: this will also save the details object
		// because of CascadeType.ALL
		appDAO.save(theInstructor);

		System.out.println("Instructor and its details is saved!");
	}

	private void findInstructor(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstrutor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstrutor);
		System.out.println("the Associate instructor Detail " + tempInstrutor.getInstructorDetail());
	}

	private void deleteInstructor(AppDao appDAO) {
		// TODO Auto-generated method stub

		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
	}

	private void findInstructordetail(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId=1;
		InstructorDetail theInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		//print the instructor detail
		System.out.println("Instructor Detail: "+theInstructorDetail);
		
		//print the associate instructor
		System.out.println("The associate instructor: "+theInstructorDetail.getInstructor());
	}
	
	private void deleteInstructorDetail(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 4;
		
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Instructor details of the Id is deleted!");
	}

}
