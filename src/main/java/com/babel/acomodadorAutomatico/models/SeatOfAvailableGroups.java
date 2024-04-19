package com.babel.acomodadorAutomatico.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SeatOfAvailableGroups {
	private int row;
	private List<Integer> seats;

	public SeatOfAvailableGroups() {
		seats = new ArrayList<>();
	}

	public void addRow(int row) {
		this.row = row;
	}

	public void addSeat(int seat) {
		this.seats.add(seat);
	}

	public List<Integer> getSeat() {
		return this.seats;
	}

	public int getNumSeats() {
		return this.seats.size();
	}
}




