package com.consume.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class State{

	private String country;
	private String name;
	private String abbr;
	private String area;

	@SerializedName("largest_city")
	private String largestCity;
	private String capital;
	
	public State() {
		super();
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLargestCity() {
		return largestCity;
	}
	public void setLargestCity(String largestCity) {
		this.largestCity = largestCity;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getAbbr() + " - " + getName();
	}
}
