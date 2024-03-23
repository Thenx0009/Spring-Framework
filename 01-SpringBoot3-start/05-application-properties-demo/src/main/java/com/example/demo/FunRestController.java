package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	// inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	//expose new endpoints "teaminfo"
	
	@GetMapping("/teaminfo")
	public String getTeamName() {
		return "Coach: "+coachName + ", Team name: "+teamName;
	}
	
	
}
