package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

public interface AppDao {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	
	void deleteInstructorDetailById(int theId);
	
	List<Course> findCoursesByInstructorId(int theID); 
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor tempInstructor);
	
	void update(Course tempCourse);
	
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);
	
	void save(Course theCourse);
	
	Course findCourseAndReviewsByCourseId(int theId);
	
	Course findCourseAndStudentsByCourseId(int theId);
	
	Student findStudentAndCoursesByStudentId(int theID);
	
	void update(Student tempStudent);
	
	void deleteStudentById(int theId);
	
}
