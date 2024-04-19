package com.babel.acomodadorAutomatico.controllers;

import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;

import java.util.List;

public interface ISeatAllocatorController {

	public List<SeatOfAvailableGroups> findAvailableGroups(boolean [][] seats, int numSeats);
}
