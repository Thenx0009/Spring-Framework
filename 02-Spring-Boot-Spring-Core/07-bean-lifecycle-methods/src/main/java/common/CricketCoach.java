package common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component		
public class CricketCoach implements Coach{
	
	public CricketCoach() {
		System.out.println("In Constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes!!!";
	}
	// define our init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In my doMyStartupStuff: "+getClass().getSimpleName());
	}
	
	//define our destroy methd 
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In my doMyCleanupStuff: "+getClass().getSimpleName());
	}
}
