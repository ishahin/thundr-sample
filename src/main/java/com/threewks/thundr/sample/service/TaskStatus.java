package com.threewks.thundr.sample.service;

public enum TaskStatus {
	Pending,
	Underway,
	Done;
	
	public boolean isDone(){
		return this == Done;
	}
	public boolean isUnderway(){
		return this == Underway;
	}
	public boolean isPending(){
		return this == Pending;
	}
}
