package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " Adding an account");
	}

	@Override
	public boolean doWork() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " doWork()");
		return false;
	}

}
