package com.OBI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {

	private LocalTime time;
	private DayOfWeek dayOfWeek;
	private Route route;
	private Plane plane;

	public Schedule(LocalTime time, DayOfWeek dayOfWeek, Route route, Plane plane) {
		this.setTime(time);
		this.setDayOfWeek(dayOfWeek);
		this.setRoute(route);
		this.setPlane(plane);
	}

	private HashMap<Flight, ArrayList<LocalDate>> scheduleList = new HashMap<Flight, ArrayList<LocalDate>>();

	public HashMap<Flight, ArrayList<LocalDate>> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(HashMap<Flight, ArrayList<LocalDate>> scheduleList) {
		this.scheduleList = scheduleList;
	}

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
		return this.time + " , " + this.dayOfWeek + " , " + this.route + " , " + this.plane;
	}

}
