package com.consume.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Response{
	
	@SerializedName("RestResponse")
	private RestResponse restResponse;

	public Response() {
		super();
	}

	public RestResponse getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(RestResponse restResponse) {
		this.restResponse = restResponse;
	}
	
}
