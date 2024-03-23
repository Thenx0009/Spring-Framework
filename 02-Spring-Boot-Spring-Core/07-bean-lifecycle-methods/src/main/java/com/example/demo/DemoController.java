package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import common.Coach;

@RestController
public class DemoController {
	
	private Coach myCoach;
	
	//define the constructor injection
	@Autowired
	public DemoController(@Qualifier("cricketCoach")Coach theCoach) {
		System.out.println("In Constructor: "+ getClass().getSimpleName());
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
