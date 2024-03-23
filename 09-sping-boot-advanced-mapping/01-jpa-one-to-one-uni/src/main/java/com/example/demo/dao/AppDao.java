package com.example.demo.dao;

import com.example.demo.entity.Instructor;

public interface AppDao {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
}
