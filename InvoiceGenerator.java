package com.cabinvoice;

public class InvoiceGenerator {

	int cost = 10;
	int minute = 1;
	double minimumPrice = 5.0;

	public double calculateFare(double distance, int time) {
		double fare = distance * cost + time * minute;
		return Math.max(fare, minimumPrice);
	}
}
