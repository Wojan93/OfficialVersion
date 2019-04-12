package com.OBI;

public class Route {

	private Airport from;
	private Airport to;
	
	public Route (Airport from, Airport to) {
		this.from = from;
		this.to = to;
	}
	
	public Airport getFrom() {
		return from;
	}
	public void setFrom(Airport from) {
		this.from = from;
	}
	public Airport getTo() {
		return to;
	}
	public void setTo(Airport to) {
		this.to = to;
	}
	
	@Override
	public String toString() {
		return this.from + " , " + this.to;
	}
}
