package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	//need a controller method to show initial HTML forms
	@GetMapping("/showform")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@PostMapping("/processform")
	public String processForm() {
		return "helloworld";
	}
	
	// need a controller method to read form data and
	// add data to the model
	
	@GetMapping("/processformVersionTwo")
	public String Shout(HttpServletRequest request, Model model) {
		
		//read he request parameter from the HTML form
		String theName = request.getParameter("studentName");
		//convert the data to all caps
		theName = theName.toUpperCase();
		//create the message
		String result = "yo! "+theName;
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@PostMapping("/processformVersionThree")
	public String processForm(@RequestParam("studentName") String theName, Model model) {
		
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hey My friend from v3! "+theName;
		
		//add message to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
