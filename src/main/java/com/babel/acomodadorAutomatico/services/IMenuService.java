package com.babel.acomodadorAutomatico.services;

import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;

import java.util.List;

public interface IMenuService {
	public void welcomeUser();

	public void printCurrentStaceCinema(List<SeatOfAvailableGroups> firstAvailableSeats);

	public int askUserNumberOfSeatsToPurchase();
}
