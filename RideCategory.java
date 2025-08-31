package com.cabinvoice;

public enum RideCategory {
	NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

	double cost;
	int minutes;
	double minimumPrice;

	RideCategory(double cost, int minutes, double minimumPrice) {
		this.cost = cost;
		this.minutes = minutes;
		this.minimumPrice = minimumPrice;
	}
}
