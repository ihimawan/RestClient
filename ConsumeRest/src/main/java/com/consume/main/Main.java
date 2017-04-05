package com.consume.main;

public class Main {

	public static void main(String[] args) {

		//initialize the database the user will use.
		//the data will be obtained from the REST service.
		UserStates userStates = new UserStates("http://services.groupkt.com/state/get/USA/all");
		
		//begin the program.
		userStates.start();
		
		System.out.println("Program has started.");
		
	}

}
