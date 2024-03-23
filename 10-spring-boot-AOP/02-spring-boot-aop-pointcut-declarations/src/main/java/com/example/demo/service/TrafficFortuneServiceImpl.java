package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		//return a fortune
		
		return "Expect heavy traffic this morning";
	}

	@Override
	public String getFortune(boolean tripWire) {
		// TODO Auto-generated method stub
		
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		
		return getFortune();
	}
	
	
}
