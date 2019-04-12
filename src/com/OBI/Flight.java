package com.OBI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {

	private LocalDate date;
	private LocalTime time;
	private DayOfWeek dayOfWeek;
	private Route route;
	private Plane plane;
	
	
	// Constructor
	public Flight(LocalTime time, DayOfWeek dayOfWeek, Route route, Plane plane) {
		this.time = time;
		this.dayOfWeek = dayOfWeek;
		this.route = route;
		this.plane = plane;
	}
	public Flight(LocalDate date, Schedule schedule) {
		this.date = date;
		this.time = schedule.getTime();
		this.dayOfWeek = schedule.getDayOfWeek();
		this.route = schedule.getRoute();
		this.plane = schedule.getPlane();
	}
	
	//Getters and Setters
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	
	@Override
	public String toString() {
		return this.date + " , " + this.time + " , " + this.dayOfWeek + " , " + this.route + " , "
				+ this.plane;
	}
	
	
	
}
