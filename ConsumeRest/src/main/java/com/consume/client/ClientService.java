package com.consume.client;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.consume.dto.Response;
import com.consume.dto.State;
import com.google.gson.Gson;

public class ClientService {
	
	private static Logger log = Logger.getLogger(ClientService.class.getName());

	public static List<State> getStates(String url) {
		
		log.info("something here");
		
		//create client
		Client client = ClientBuilder.newClient();
		
		//set target to client
		WebTarget target = client.target(url);
		
		//get response
		String JSONResponseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		//using Gson to parse JSON data.
		Gson gson = new Gson();
		
		Response response = gson.fromJson(JSONResponseString, Response.class);
				
		return response.getRestResponse().getResult();

	}

}