package com.example.demo.rest;

public class StudentErrorRespone {

	private int status;
	private String message;
	private long timeStamp;

	public StudentErrorRespone() {

	}

	public StudentErrorRespone(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timeStamp;
	}

	public void setTimestamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
