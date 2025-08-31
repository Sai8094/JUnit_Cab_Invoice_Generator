package com.cabinvoice;

public class InvoiceSummary {

	int numberOfRides;
	double totalFare;
	double averageFare;

	public InvoiceSummary(int numberOfRides, double totalFare) {
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare = totalFare / numberOfRides;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		InvoiceSummary invoice = (InvoiceSummary) object;
		return this.numberOfRides == invoice.numberOfRides && Double.compare(this.totalFare, invoice.totalFare) == 0
				&& Double.compare(this.averageFare, invoice.averageFare) == 0;
	}
}
