package com.babel.acomodadorAutomatico.services;

import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;

import java.util.List;

public interface ISeatAllocatorService {

	public List<SeatOfAvailableGroups> findAvailableGroups(boolean[][] seats, int numSeats);

}
