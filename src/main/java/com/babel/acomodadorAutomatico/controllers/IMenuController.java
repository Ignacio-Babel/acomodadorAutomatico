package com.babel.acomodadorAutomatico.controllers;

import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMenuController {

	public void welcomeUser();

	public void printCurrentStaceCinema(List<SeatOfAvailableGroups> bestAvailableSeats);

}
