package com.consume.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.consume.dto.Response;
import com.consume.dto.State;
import com.google.gson.Gson;

public class ClientService {
	
	private static Logger log = LogManager.getLogger(ClientService.class);;
	
	public static List<State> getStates(String url) {
		
		log.info("something here");
		
		//create client
		Client client = ClientBuilder.newClient();
		
		//set target to client
		WebTarget target = client.target(url);
		
		//get response
		String JSONResponseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		log.debug("Response is received.");
		
		//using Gson to parse JSON data.
		Gson gson = new Gson();
		
		Response response = gson.fromJson(JSONResponseString, Response.class);
						
		return response.getRestResponse().getResult();

	}

}