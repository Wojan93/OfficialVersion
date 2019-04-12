package com.OBI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Airport {

	private String code;
	private String city;
	private String name;
	
	
	public Airport(String code, String city, String name) {
		this.code = code;
		this.city = city;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.code + " , " + this.city + " , " + this.name;
	}
	
	
	
	

}
