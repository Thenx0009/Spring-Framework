package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import common.Coach;

@RestController
public class DemoController {
	
	private Coach myCoach;
	private Coach anotherCoach;
	
	//define the constructor injection
	@Autowired
	public DemoController(@Qualifier("cricketCoach")Coach theCoach,
			              @Qualifier("cricketCoach")Coach theanotherCoach) {
		myCoach = theCoach;
		anotherCoach = theanotherCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	//If bean scope is singleton then true
	//If bean scope is prototype then false
	@GetMapping("/check")
	public String check() {
		return "Comparing beans: myCoach == anotherCoach is,  "+ (myCoach == anotherCoach);
	}
}
