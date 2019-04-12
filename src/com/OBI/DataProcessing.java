package com.OBI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DataProcessing {

	private String procName;

	private HashMap<Airport, ArrayList<Schedule>> destAirportSch = new HashMap<Airport, ArrayList<Schedule>>();
	private ArrayList<Schedule> scheduleListNest = new ArrayList<Schedule>();
	private LocalDate startOfSchedule = LocalDate.parse("2019-01-01");
	private final LocalDate stopOfSchedule = LocalDate.parse("2019-12-31");
	private ArrayList<LocalDate> allDaysOfWeek = new ArrayList<LocalDate>();
	private HashMap<String, Airport> airportMapByCity = new HashMap<String, Airport>();

	private Queue<Passenger> queue = new LinkedList<Passenger>();
	private HashMap<Flight, ArrayList<Ticket>> ticketToFlight = new HashMap<Flight, ArrayList<Ticket>>();
	private ArrayList<Ticket> ticketListNest = new ArrayList<Ticket>();

	public LocalDate userDate() {
		System.out.println("Podaj datê YYYY-MM-DD");
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			String userDateTmp = sc.nextLine();
			LocalDate userDate = LocalDate.parse(userDateTmp);
			sc.close();
			return userDate;
		} else
			return null;
	}

	public String userAirport() {
		System.out.println("Podaj lotnisko docelowe");
		Scanner sca = new Scanner(System.in);
		if (sca.hasNextLine()) {
			String userAirport = sca.nextLine();

			return userAirport;
		} else
			return null;
	}

	public LocalDate addAllDayOfWeek(DayOfWeek dayOfWeek) {
		LocalDate nextOrSameDay = getStartOfSchedule().with(TemporalAdjusters.nextOrSame(dayOfWeek));
		// Loop while we have a friday in hand (non-null) AND that friday is not after
		// our stop date (isBefore or isEqual the stop date).
		while ((null != nextOrSameDay) & (!nextOrSameDay.isAfter(stopOfSchedule))) {
			allDaysOfWeek.add(nextOrSameDay); // Remember this friday.
			nextOrSameDay = nextOrSameDay.plusWeeks(1); // Move to the next Friday, setting up for next iteration
														// of this loop.
		}
		LocalDate dateOfFlight = allDaysOfWeek.get(0);
		return dateOfFlight;
	}

	public DataProcessing(String procName) {
		this.procName = procName;
	}

	public LocalDate getStartOfSchedule() {
		return startOfSchedule;
	}

	public void setStartOfSchedule(LocalDate startOfSchedule) {
		this.startOfSchedule = startOfSchedule;
	}

	@Override
	public String toString() {
		return Arrays.toString(allDaysOfWeek.toArray());
	}

	public void addToAirportMap(String city, Airport airport) {
		if (airportMapByCity.containsKey(city) == false) {
			airportMapByCity.put(city, airport);
		} else {
			System.out.println("Lotnisko ju¿ jest na liscie");
		}
	}

	public Airport searchAirportByCity(String city) {
		if (airportMapByCity.containsKey(city) == true) {
			return airportMapByCity.get(city);
		} else {
			System.out.println("Brak lotniska w tym miescie");
			return null;
		}
	}

	public void addDestAirportSch(Airport airport, Schedule schedule) {
		if (destAirportSch.containsKey(airport) == false) {
			scheduleListNest.add(schedule);
			destAirportSch.put(airport, scheduleListNest);
		} else {
			System.out.println("Lotnisko ju¿ jest na liscie");
		}
	}

	public ArrayList<Schedule> searchDestAirportSch(Airport airport) {
		if (destAirportSch.containsKey(airport) == true) {
			scheduleListNest = destAirportSch.get(airport);
			for (int i = 0; i == scheduleListNest.size() ;i++) {
				if (scheduleListNest.get(i).getRoute().getTo().getCity() == airport.getCity()) {
					return scheduleListNest;
				} else {
					return null;
				}
			}
			return scheduleListNest;
		} else {
			System.out.println("Lotnisko " + airport + "nie jest obs³ugiwane.");
			return null;
		}
		
	}

	public void addTicketToFlight(Flight flight, Ticket ticket) {
		if (ticketToFlight.containsKey(flight) == false) {
			ticketListNest.add(ticket);
			ticketToFlight.put(flight, ticketListNest);

		}
	}

	public String displayTicketToFlight() {
		return Arrays.toString(ticketToFlight.entrySet().toArray());
	}

	public void lackOfTickets(Passenger passenger, Flight flight) {
		queue.add(passenger);
		System.out.println("Brak biletow na wybrany lot. Zostales dodany do listy oczekujacych.");
	}

}
