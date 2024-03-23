package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.service.TrafficFortuneService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO,TrafficFortuneService trafficFortuneService) {

		return runner -> {
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO);
			//demoTheAfterThrowingAdvice(accountDAO);
			//demoTheAfterAdvice(accountDAO);
			//demoTheAroundAdvice(trafficFortuneService);
			demoTheAroundAdviceHandleException(trafficFortuneService);
		};
	}

	



	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();

		// call the accountdao setters/getters methods
		accountDAO.setName("ayush");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		// System.out.println(name+ " "+ code);

		// call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();

	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		// TODO Auto-generated method stub
		List<Account> theAccounts = accountDAO.findAccounts();

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("------");
		System.out.println(theAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		// TODO Auto-generated method stub
		List<Account> theAccounts = null;

		try {
			//add a boolean flag to simulate exceptions
			boolean tripwire = true;
			theAccounts = accountDAO.findAccounts(tripwire);
		} 
		catch (Exception exc) {
			System.out.println("\n\nMain Program: .....caught exception: " + exc);
		}

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}
	
	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		// TODO Auto-generated method stub
		List<Account> theAccounts = null;

		try {
			//add a boolean flag to simulate exceptions
			boolean tripwire = false;
			theAccounts = accountDAO.findAccounts(tripwire);
		} 
		catch (Exception exc) {
			System.out.println("\n\nMain Program: .....caught exception: " + exc);
		}

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}
	
	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		// TODO Auto-generated method stub
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		
		String data = trafficFortuneService.getFortune();
		System.out.println("\nMy Fortune is: "+data);
	}
	

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		// TODO Auto-generated method stub
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true; 
		String data = trafficFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy Fortune is: "+data);
	}

}
