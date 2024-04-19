package com.babel.acomodadorAutomatico.models;

import lombok.Data;

@Data
public class Seat {
	private final int row;
	private final int seat;

	public Seat(int row, int seat){
		this.row = row;
		this.seat = seat;
	}
}
