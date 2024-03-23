package common;

import org.springframework.stereotype.Component;

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

}
