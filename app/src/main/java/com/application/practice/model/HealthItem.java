package com.application.practice.model;

import java.util.List;

public class HealthItem{
	private List<AccessibleItem> accessible;
	private String name;

	public void setAccessible(List<AccessibleItem> accessible){
		this.accessible = accessible;
	}

	public List<AccessibleItem> getAccessible(){
		return accessible;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}