package com.OBI;

public class Plane {

	private String brand;
	private String model;
	private int numberOfSeats;
	
	public Plane(String brand,String model, int numberOfSeats ) {
		this.brand = brand;
		this.model = model;
		this.numberOfSeats = numberOfSeats;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	@Override
	public String toString() {
		return this.brand + " , " + this.model+ " , " + this.numberOfSeats;
	}
}
