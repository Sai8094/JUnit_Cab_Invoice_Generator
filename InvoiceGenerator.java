package com.cabinvoice;

public class InvoiceGenerator {

	int cost = 10;
	int minute = 1;
	double minimumPrice = 5.0;

	RideRepository repo = new RideRepository();

	// Adding rides
	public void addRides(String userId, Ride[] rides) {
		repo.addRides(userId, rides);
	}

	// Invoice Summary
	public InvoiceSummary getInvoiceSummary(String userId) {
		if (userId == null) {
			throw new IllegalArgumentException("user id cannot be null");
		}
		return calculateFareSummary(repo.getRides(userId));
	}

	// Calaculate_Fare for single ride
	public double calculateFare(double distance, int time, RideCategory category) {
		if(distance < 0 || time < 0) {
			throw new IllegalArgumentException("Distance and Time cannot be negative");
		}
		if(category == null) {
			throw new IllegalArgumentException("Category cannot be null");
		}
		double fare = distance * category.cost + time * category.minutes;
		return Math.max(fare, category.minimumPrice);
	}

	public double calculateFare(double distance, int time) {
		return calculateFare(distance, time, RideCategory.NORMAL);
	}

	public double calculateFare(Ride[] rides) {
		double total = 0.0;
		if (rides == null) {
			throw new IllegalArgumentException("Rides cannot be null");
		}
		for (Ride r : rides)
			total += calculateFare(r.distance, r.time, r.category);
		return total;
	}

	// Enhanced Invoice Summary
	public InvoiceSummary calculateFareSummary(Ride[] rides) {
		if (rides == null) {
			throw new IllegalArgumentException("Rides cannot be null");
		}
		if (rides.length == 0) {
			return new InvoiceSummary(0, 0.0);
		}
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

}
