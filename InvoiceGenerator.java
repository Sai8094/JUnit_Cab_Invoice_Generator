package com.cabinvoice;

public class InvoiceGenerator {

	int cost = 10;
	int minute = 1;
	double minimumPrice = 5.0;

	// Calaculate_Fare for single ride
	public double calculateFare(double distance, int time) {
		if (distance < 0 || time < 0)
			throw new IllegalArgumentException("Distance and Time cannot be negative");
		double fare = distance * cost + time * minute;
		return Math.max(fare, minimumPrice);
	}

	// Calaculate_Fare for Multiple_Rides
	public double calculateFare(Ride[] rides) {
		if (rides == null) {
			throw new IllegalArgumentException("Rides cannot be null");
		}
		double total = 0.0;
		for (Ride ride : rides)
			total += calculateFare(ride.distance, ride.time);
		return total;
	}

}
