package com.OBI;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {
	private Flight flight;
	private Passenger passenger;
	private LocalDateTime departureTime;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public Ticket(Flight flight, Passenger passenger, LocalDateTime departureTime) {
		this.setFlight(flight);
		this.setPassenger(passenger);
		this.setDepartureTime(departureTime);
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	@Override
	public String toString() {
		return this.flight + " , " + this.passenger + " , " + this.departureTime;
	}
	
}
