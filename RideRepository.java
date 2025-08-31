package com.cabinvoice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {

	Map<String, List<Ride>> userRides = new HashMap<>();

	public void addRides(String userId, Ride[] rides) {
		userRides.put(userId, Arrays.asList(rides));
	}

	public Ride[] getRides(String userId) {
		List<Ride> rides = userRides.get(userId);
		return (rides == null) ? new Ride[0] : rides.toArray(new Ride[0]);
	}

}
