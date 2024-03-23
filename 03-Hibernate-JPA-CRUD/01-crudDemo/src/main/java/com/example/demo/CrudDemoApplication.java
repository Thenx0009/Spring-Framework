package com.example.demo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		//Java expression
		return runner -> {
			//createStudent(studentDAO);
			
			createMultipleStudens(studentDAO);
			
			//readStudent(studentDAO);
			
			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);
			
			//deleteAllStudents(studentDAO);
			
		};
	}
	
	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows that are deleted: "+rowsDeleted);
		
	}


	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		studentDAO.delete(studentId);
	}


	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id
		System.out.println("Getting student with id... ");
		Student theStudent = studentDAO.findById(3);
		
		//change first name to Rohit
		System.out.println("updating student...");
		theStudent.setFirstName("Rohit");
		
		//update the student
		studentDAO.update(theStudent);
		
		//display the updated student 
		System.out.println("updates student: "+theStudent);
		
	}


	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		
		List<Student> thestudents = studentDAO.findByLastName("sharma");
		
		for(Student student:thestudents) {
			System.out.println(student);
		}
	}


	private void queryForStudents(StudentDAO studentDAO) {
		
		//get a list of students
		List<Student> theStudents =  studentDAO.findAll();
		
		//display list of students
		for(Student student:theStudents) {
			System.out.println(student);
		}
	}



	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object....");
		Student tempStudent1 = new Student("John","Doe","doejohn905@gmail.com");
		
		//save the student
		System.out.println("saving the student....");
		studentDAO.save(tempStudent1);
		
		//display the id of the save student
		int theId = tempStudent1.getId();
		System.out.println("saved student generated ID is: "+theId);
		
		//retrieve student based on the id:primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);
		
		//Display the student
		System.out.println(myStudent);
		
	}



	private void createMultipleStudens(StudentDAO studentDAO) {
		//Create multiple students
		System.out.println("Creating 3 student objects....");
		Student tempStudent1 = new Student("John","Doe","doejohn905@gmail.com"); 
		Student tempStudent2 = new Student("Mary","Jane","janemary0009@gmail.com"); 
		Student tempStudent3 = new Student("Rohit","Sharma","sharmaro5@gmail.com"); 
		
		//save the student objects 
		System.out.println("saving the students....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
		
	}



	private void createStudent(StudentDAO studentDAO) {
		
		//Create the student object
		Student tempStudent = new Student("Ayush","verma","vermaayush455@gmail.com");
		//save the student object
		studentDAO.save(tempStudent);
		// display id of the save student
		System.out.println("saved student generated ID is: "+tempStudent.getId());
	}

}
