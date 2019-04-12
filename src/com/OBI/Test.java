package com.OBI;

import java.util.Arrays;
import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Test {

	public static void main(String[] args) {

		Airport airport1 = new Airport("VLC", "Valencia", "Aeropuerto de Valencia");
		Airport airport2 = new Airport("LCY", "London", "London City Airport");
		Airport airport3 = new Airport("OSL", "Oslo", "Oslo-Gardermoen");

		Passenger passenger1 = new Passenger("Piotr Kubica", "TRF690204", LocalDate.of(1991, Month.FEBRUARY, 19));
		Passenger passenger2 = new Passenger("Jerzy Kosiñski", "CYY369123", LocalDate.of(1995, Month.APRIL, 1));
		Passenger passenger3 = new Passenger("Anna Domagala", "SJC291498", LocalDate.of(1989, Month.MAY, 3));

		Plane plane1 = new Plane("Boeing", "747", 10);

		Route route1 = new Route(airport1, airport2);

		DataProcessing dp1 = new DataProcessing("System1");

		dp1.addToAirportMap(airport1.getCity(), airport1);
		dp1.addToAirportMap(airport2.getCity(), airport2);
		dp1.addToAirportMap(airport3.getCity(), airport3);
		// System.out.println(dp1.searchAirportByCity(dp1.userAirport()));

		Schedule schedule1 = new Schedule(LocalTime.parse("12:50"), DayOfWeek.TUESDAY, route1, plane1);

		dp1.addDestAirportSch(dp1.searchAirportByCity(dp1.userAirport()), schedule1);

		System.out.println(dp1.searchDestAirportSch(dp1.searchAirportByCity(dp1.userAirport())));

		dp1.setStartOfSchedule(dp1.userDate());
		System.out.println(dp1.addAllDayOfWeek(schedule1.getDayOfWeek()));

		Flight flight1 = new Flight(dp1.addAllDayOfWeek(schedule1.getDayOfWeek()), schedule1);
		Ticket ticket1 = new Ticket(flight1, passenger1,
				LocalDateTime.parse(dp1.addAllDayOfWeek(schedule1.getDayOfWeek()) + "T" + flight1.getTime()));
		dp1.addTicketToFlight(flight1, ticket1);
		System.out.println(dp1.displayTicketToFlight());
		dp1.lackOfTickets(passenger1, flight1);

		//DateSchedule dateSchedule1 = new DateSchedule();
		//Schedule schedule1 = new Schedule(dateSchedule1);
		//schedule1.getScheduleList().put(flight1, dateSchedule1.getAllDaysOfWeek());
		//System.out.println(Arrays.toString(schedule1.getScheduleList().entrySet().toArray()));
		//System.out.println(dateSchedule1.addAllDayOfWeek(flight1.getDayOfWeek()));
		//System.out.println(dateSchedule1);

	}

}
