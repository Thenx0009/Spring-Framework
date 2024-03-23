package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	private String name;
	
	private String serviceCode;

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

	public String getName() {
		System.out.println(getClass() + " getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " setServiceCode()");
		this.serviceCode = serviceCode;
	}

	@Override
	public List<Account> findAccounts() {
		// TODO Auto-generated method stub
		return findAccounts(false);
	}

	@Override
	public List<Account> findAccounts(boolean tripwire) {
		// TODO Auto-generated method stub
		if(tripwire) {
			throw new RuntimeException("runtime exception!!!!");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		//create sample accounts
		Account tempAccount1 = new Account("John", "Silver");
		Account tempAccount2 = new Account("Simba","Platinum");
		Account tempAccount3 = new Account("Luca", "Gold");
		
		//add them to our accounts list
		myAccounts.add(tempAccount1);
		myAccounts.add(tempAccount2);
		myAccounts.add(tempAccount3);	
		
		return myAccounts;
	}
}
