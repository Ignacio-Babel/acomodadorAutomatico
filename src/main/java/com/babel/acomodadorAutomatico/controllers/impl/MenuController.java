package com.babel.acomodadorAutomatico.controllers.impl;

import com.babel.acomodadorAutomatico.controllers.IMenuController;
import com.babel.acomodadorAutomatico.models.Cinema;
import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;
import com.babel.acomodadorAutomatico.services.IMenuService;
import com.babel.acomodadorAutomatico.services.ISeatAllocatorService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MenuController implements IMenuController {
	IMenuService menuService;
	ISeatAllocatorService seatAllocatorService;
	Cinema cinema;

	public MenuController(IMenuService menuService, ISeatAllocatorService seatAllocatorService, Cinema cinema) {
		this.menuService = menuService;
		this.seatAllocatorService = seatAllocatorService;
		this.cinema = cinema;
	}

	@Override
	public void welcomeUser() {
		menuService.welcomeUser();
		int numberOfSeatsToPurchase = askUserNumberOfSeatsToPurchase();
		List<SeatOfAvailableGroups> bestAvailableSeats = seatAllocatorService.findAvailableGroups(cinema.getEmptySeats(), numberOfSeatsToPurchase);
		printCurrentStaceCinema(bestAvailableSeats);
		for (SeatOfAvailableGroups item : bestAvailableSeats) {
			int row = item.getRow() + 1;
			item.setRow(row);
			System.out.println(item);
		}
	}

	@Override
	public void printCurrentStaceCinema(List<SeatOfAvailableGroups> bestAvailableSeats) {
		menuService.printCurrentStaceCinema(bestAvailableSeats);
	}

	public int askUserNumberOfSeatsToPurchase() {
		return menuService.askUserNumberOfSeatsToPurchase();
	}
}
