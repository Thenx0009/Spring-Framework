package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDao;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO) {

		return runner -> {
			//createCourseAndReviews(appDAO);
			//retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
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
		int theId = 1;
		InstructorDetail theInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("Instructor Detail: " + theInstructorDetail);

		// print the associate instructor
		System.out.println("The associate instructor: " + theInstructorDetail.getInstructor());
	}

	private void deleteInstructorDetail(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 4;

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Instructor details of the Id is deleted!");
	}

	private void createIstructorWithCourses(AppDao appDAO) {
		// TODO Auto-generated method stub
		 //create the instructor
		 Instructor theInstructor = new Instructor("Ayush", "Verma","vermaayu2424@gmail.com");
		 //create the instructor detail
		 InstructorDetail theInstructorDetail = new InstructorDetail("https://www.youtube.com/", "video games");

		 theInstructor.setInstructorDetail(theInstructorDetail);
		 
		 //create some courses
		 Course course1 = new Course("core java");
		 Course course2 = new Course("AWS cloud");
		 Course course3 = new Course("Web dev");
		 
		 //add courses to instructor	
		 theInstructor.add(course1);
		 theInstructor.add(course2);
		 theInstructor.add(course3);
		 
		 //save the instructor
		 System.out.println("Saving instructor: "+ theInstructor);
		 System.out.println("The Courses: "+ theInstructor.getCourse());
		 appDAO.save(theInstructor);
	}
	
	private void findInstructorWithCourses(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("theInstructor: "+theInstructor);
		System.out.println("the associated courses: "+theInstructor.getCourse());
	}
	
	private void findCoursesForInstructor(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("theInstructor: "+theInstructor);
		
		//find courses for instructor
		System.out.println("Finding courses for instructor id: "+theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		
		//associate the objects
		theInstructor.setCourse(courses);
		
		System.out.println("the associated courses: "+ theInstructor.getCourse());
	}
	
	
	
	private void findInstructorWithCoursesJoinFetch(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		
		Instructor theInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("theInstructor: "+theInstructor);
		System.out.println("the associated courese: "+theInstructor.getCourse());
	}
	

	private void updateInstructor(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		
		Instructor theInstructor = appDAO.findInstructorById(theId);
		//update the Instructor
		System.out.println("Updating instructor id: "+theId);
		theInstructor.setLastName("Developer");
		
		appDAO.update(theInstructor);
		
	}
	

	private void updateCourse(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 12;
		System.out.println("Finding Course id: "+theId);
		
		Course theCourse = appDAO.findCourseById(theId);
		
		//update the course
		System.out.println("Update course id: "+theId);
		theCourse.setTitle("Advance Java");
		
		appDAO.update(theCourse);
	}
	
	private void deleteCourse(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 12;
		System.out.println("Deleting course id: "+theId);
		
		appDAO.deleteCourseById(theId);
	}
	
	private void createCourseAndReviews(AppDao appDAO) {
		// TODO Auto-generated method stub
		//create a course
		Course theCourse = new Course("Advance Java");
		//add some reviews 
		
		Review review1 = new Review("Nice course");
		Review review2 = new Review("love the course");
		Review review3 = new Review("Great course...well done!");
		
		theCourse.addReview(review1);
		theCourse.addReview(review2);
		theCourse.addReview(review3);
		//save the course...and leverage the cascade all
		//saving the course will save the associate reviews because of cascade
		
		System.out.println("savng the course");
		appDAO.save(theCourse);
		System.out.println("Done");
	}
	
	private void retrieveCourseAndReviews(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		
		Course theCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		
		//print the course
		System.out.println(theCourse);
		
		//print the reviews
		System.out.println(theCourse.getReviews()	);
	}

	private void deleteCourseAndReviews(AppDao appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		
		System.out.println("Deleting course of the given id: "+theId);
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("Done");
	}
}
