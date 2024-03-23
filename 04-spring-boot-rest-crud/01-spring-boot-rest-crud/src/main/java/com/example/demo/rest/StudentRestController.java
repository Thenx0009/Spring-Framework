package com.example.demo.rest;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudent;

	// define @PostConstruct to load the student data....only once!
	@PostConstruct
	public void loadData() {

		theStudent = new ArrayList<>();
		theStudent.add(new Student("Ayush", "Verma"));
		theStudent.add(new Student("John", "Doe"));
		theStudent.add(new Student("Rohit", "Sharma"));

	}

	@GetMapping("/students")
	public List<Student> getStudent() {
		return theStudent;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudentbyId(@PathVariable int studentId) {
		if (studentId > theStudent.size() - 1 || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return theStudent.get(studentId);
	}


}
