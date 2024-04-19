package com.babel.acomodadorAutomatico.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Data
public class Cinema {
	private final int rows;
	private final int placesPerRow;
	private final boolean[][] emptySeats;
	private final List<Seat> reservedSeats;

	public Cinema(int rows, int placesPerRow) {
		this.rows = rows;
		this.placesPerRow = placesPerRow;
		this.emptySeats = new boolean[rows][placesPerRow];
		this.reservedSeats = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			Random random = new Random();
			for (int j = 0; j < placesPerRow; j++) {
				emptySeats[i][j] = random.nextBoolean();
			}
		}
	}
}
