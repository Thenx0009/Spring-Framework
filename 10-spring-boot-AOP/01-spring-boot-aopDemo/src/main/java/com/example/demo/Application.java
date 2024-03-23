package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.dao.MembershipDAO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		// TODO Auto-generated method stub
		
		//call the business method
		Account myAccount = new Account();
		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();
		
		//call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
	}

}
