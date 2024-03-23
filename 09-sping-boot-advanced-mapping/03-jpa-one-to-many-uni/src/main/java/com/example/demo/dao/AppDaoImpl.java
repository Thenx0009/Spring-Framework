package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		
		//get the course
		List<Course> courses = theInstructor.getCourse();
		
		//break association of all courses for the instructor
		for(Course tempCourse:courses) {
			tempCourse.setInstructor(null);
		}
		
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

	@Override
	public List<Course> findCoursesByInstructorId(int theID) {
		// TODO Auto-generated method stub
		//create query
		TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id = :data", Course.class);
		query.setParameter("data", theID);
		
		//execute query
		List<Course> courses = query.getResultList();
		
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		// TODO Auto-generated method stub
		
		//create query
		TypedQuery<Instructor> query = entityManager.createQuery(
				"SELECT i from Instructor i "+
		        "JOIN FETCH i.courses "+
				"JOIN FETCH i.instructorDetail "+
				"WHERE i.id = :data" , 
				Instructor.class);
		
		query.setParameter("data", theId);
		
		Instructor instructor = query.getSingleResult();
		
		return instructor;
	}

	@Transactional
	@Override
	public void update(Instructor tempInstructor) {
		// TODO Auto-generated method stub
		entityManager.merge(tempInstructor);
	}
	
	@Override
	public Course findCourseById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Course.class, theId);
	}

	@Transactional
	@Override
	public void update(Course tempCourse) {
		// TODO Auto-generated method stub
		entityManager.merge(tempCourse);
	}

	@Transactional
	@Override
	public void deleteCourseById(int theId) {
		// TODO Auto-generated method stub
		Course theCourse = entityManager.find(Course.class, theId);
		
		entityManager.remove(theCourse);
	}

	@Transactional
	@Override
	public void save(Course theCourse) {
		// TODO Auto-generated method stub
		entityManager.persist(theCourse);
	}

	@Override
	public Course findCourseAndReviewsByCourseId(int theId) {
		// TODO Auto-generated method stub
		
		TypedQuery<Course> query = entityManager.createQuery(
				"select c from Course c "+
				"JOIN FETCH c.reviews "+
				"where c.id = :data",Course.class);
		
		query.setParameter("data",theId);
		
		Course course = query.getSingleResult();
		
		return course;
	}

	

}
