package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao {

	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection

	@Autowired
	public AppDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		// TODO Auto-generated method stub
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Instructor.class, theId);

	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// TODO Auto-generated method stub
		Instructor theInstructor = entityManager.find(Instructor.class, theId);
		entityManager.remove(theInstructor);  
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(InstructorDetail.class, theId) ;
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class, theId);
		
		//remove the associated object reference
		//break bi-directional link
		theInstructorDetail.getInstructor().setInstructorDetail(null);
		
		entityManager.remove(theInstructorDetail);
	}

}
