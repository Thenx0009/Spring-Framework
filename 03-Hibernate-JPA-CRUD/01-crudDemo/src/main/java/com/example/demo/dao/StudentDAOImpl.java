package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	//implement save method 
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}


	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}


	@Override
	public List<Student> findAll() {
		//create query
		//here always use the JPA entity name not the database name or fields
		TypedQuery<Student>  theQuery = entityManager.createQuery("FROM Student",Student.class);
		
		//return query results	
		return theQuery.getResultList();
	}


	@Override
	public List<Student> findByLastName(String theLastName) {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :theData",Student.class);
		theQuery.setParameter("theData", theLastName);
		return theQuery.getResultList();
		
	}


	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		//retrieve the student
		Student theStudent = entityManager.find(Student.class, id);
		//delete the student 
		entityManager.remove(theStudent);
		
	}


	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}
	
}
