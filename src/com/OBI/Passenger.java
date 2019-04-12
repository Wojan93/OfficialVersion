package com.OBI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Passenger {

	private String name;
	private String document;
	private LocalDate bornDate;
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	private ArrayList<Ticket> passengerTickets = new ArrayList<Ticket>();

	// Constructor
	public Passenger(String name, String document, LocalDate bornDate) {
		this.name = name;
		this.document = document;
		this.bornDate = bornDate;
	}

	public void addPassengerToList(Passenger passenger) {
		if (passengerList.contains(passenger) == false) {
			passengerList.add(passenger);
		} else {
			System.out.println("Pasa¿er ju¿ istnieje");
		}
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	@Override
	public String toString() {
		return this.name + " , " + this.document + " , " + this.bornDate;
	}
}
