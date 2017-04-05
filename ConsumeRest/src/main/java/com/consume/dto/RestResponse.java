package com.consume.dto;

import java.io.Serializable;
import java.util.List;

public class RestResponse{

	private List<String> messages;
	private List<State> result;
	
	public RestResponse() {
		super();
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public List<State> getResult() {
		return result;
	}
	public void setResult(List<State> result) {
		this.result = result;
	}
	
	
	
}
