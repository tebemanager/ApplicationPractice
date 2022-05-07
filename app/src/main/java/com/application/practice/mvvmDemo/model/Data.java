package com.application.practice.mvvmDemo.model;

import java.util.List;

public class Data{
	private List<HealthItem> health;
	private String message;

	public void setHealth(List<HealthItem> health){
		this.health = health;
	}

	public List<HealthItem> getHealth(){
		return health;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}