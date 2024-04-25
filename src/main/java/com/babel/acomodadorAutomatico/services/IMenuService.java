package com.babel.acomodadorAutomatico.services;

import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;

import java.util.List;

public interface IMenuService {
	public void welcomeUser();

	void printCurrentStaceCinema();

	public void printCurrentStaceCinema(List<SeatOfAvailableGroups> firstAvailableSeats);

	public int askUserNumberOfSeatsToPurchase();
}
