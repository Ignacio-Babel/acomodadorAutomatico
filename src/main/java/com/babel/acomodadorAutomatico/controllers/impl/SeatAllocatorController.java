package com.babel.acomodadorAutomatico.controllers.impl;

import com.babel.acomodadorAutomatico.controllers.ISeatAllocatorController;
import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;
import com.babel.acomodadorAutomatico.services.ISeatAllocatorService;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class SeatAllocatorController implements ISeatAllocatorController {
	ISeatAllocatorService seatAllocatorService;

	public SeatAllocatorController(ISeatAllocatorService seatAllocatorService) {
		this.seatAllocatorService = seatAllocatorService;
	}

	@Override
	public List<SeatOfAvailableGroups> findAvailableGroups(boolean[][] seats, int numSeats) {
		return seatAllocatorService.findAvailableGroups(seats, numSeats);
	}
}
