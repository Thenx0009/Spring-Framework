package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public boolean addSillyMember() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " Adding a membership account");
		
		return true;
	}

	@Override
	public void goToSleep() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " I am going to sleep");
	}
 
}
