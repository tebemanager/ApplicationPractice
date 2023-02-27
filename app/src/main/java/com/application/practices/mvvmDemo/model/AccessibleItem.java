package com.application.practices.mvvmDemo.model;

public class AccessibleItem{
	private boolean success;
	private String type;
	private String message;
	private String name;
	private String api;
	private int status;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setApi(String api){
		this.api = api;
	}

	public String getApi(){
		return api;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}
