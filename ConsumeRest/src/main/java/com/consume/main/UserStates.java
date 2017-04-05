package com.consume.main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.consume.client.ClientService;
import com.consume.dto.State;

public class UserStates {

	//stateMap contains the hashMap with abbr and name as keys for easy finding.
	private StateMap<String, String, State> stateMap = new StateMap<String, String, State>();
	
	//url of the REST service
	private String url;
	
	//scanner
	private Scanner sc;

	// Constructor will receive REST url and initialize StateMap
	UserStates(String url) {
		List<State> statesFromService = ClientService.getStates(url);
		initializeStateMap(statesFromService);
		this.url = url;
	}

	private void initializeStateMap(List<State> statesFromService) {

		statesFromService.stream().forEach(state -> {
			stateMap.put(state.getAbbr().toUpperCase(), state.getName().toUpperCase(), state);
		});
	}
	
	// The program run code.
	public void start() {
		System.out.println("-------------------------------");
		System.out.println("         W E L C O M E");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Given a REST service, this program will return the largest city");
		System.out.println("and capital based on user input for state abbreviation or state name.");
		System.out.println();
		System.out.println("The REST service consumed is: ");
		System.out.println(url);
		System.out.println();
		System.out.println("| Menu |");
		System.out.println("Enter 1 to search by abbreviation.");
		System.out.println("Enter 2 to search by name.");
		System.out.println("Enter 3 to print all available states.");
		System.out.println("Enter 4 to exit program");

		startHelper();
	}

	private void startHelper() {

		sc = new Scanner(System.in);

		while (true) {
			
			System.out.println();
			System.out.println("--------------------------");
			System.out.println("Please enter a command (1, 2, 3, or 4): ");

			int command = 0;

			try {
				command = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid command (only integers 1, 2, 3, and 4).");
				sc.nextLine();
				continue;
			}

			// get by abbreviation
			if (command == 1) {

				System.out.println("Enter state abbreviation: ");

				String abbr = sc.next().toUpperCase();
				State state = stateMap.getByAbbr(abbr);

				if (state == null) {
					System.out.println("The abbreviation '" + abbr + "' cannot be found.");
				} else {
					System.out.println("Largest City = " + state.getLargestCity());
					System.out.println("Capital City = " + state.getCapital());
				}

				// get by name
			} else if (command == 2) {

				System.out.println("Enter state name: ");

				sc.nextLine();
				
				String name = sc.nextLine().toUpperCase().trim();
				State state = stateMap.getByName(name);

				if (state == null) {
					System.out.println("The state '" + name + "' cannot be found.");
				} else {
					System.out.println("Largest City = " + state.getLargestCity());
					System.out.println("Capital City = " + state.getCapital());
				}

			}else if (command == 3){
				stateMap.printAll();
				// exit
			} else if (command == 4) {
				System.out.println("Thank you for using my program!");
				break;
			} else {
				System.out.println("Invalid command. Try again.");
			}
			
//			sc.nextLine();

		}
	}

}

//create a structure of hashmap with two keys.
final class StateMap<K1, K2, V> {
	private final Map<K1, V> byAbbr = new HashMap<K1, V>();
	private final Map<K2, V> byName = new HashMap<K2, V>();

	public V getByAbbr(K1 abbr) {
		return byAbbr.get(abbr);
	}

	public V getByName(K2 name) {
		return byName.get(name);
	}

	public void put(K1 key1, K2 key2, V value) {
		byAbbr.put(key1, value);
		byName.put(key2, value);
	}
	
	public void printAll(){
		byAbbr.keySet().stream().forEach(abbr -> {
			System.out.println(getByAbbr(abbr));		
		});
	}
}
