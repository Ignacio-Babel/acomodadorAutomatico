package com.babel.acomodadorAutomatico.services.impl;

import com.babel.acomodadorAutomatico.models.Cinema;
import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;
import com.babel.acomodadorAutomatico.services.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;


@Service
public class MenuService implements IMenuService {
	private final Cinema cinema;

	Scanner scanner = new Scanner(System.in);

	public MenuService(Cinema cinema) {
		this.cinema = cinema;
	}

	private static void printXCoordinates(int placesPerRow) {
		System.out.print("   ");
		for (int i = placesPerRow % 2 == 0 ? placesPerRow - 1 : placesPerRow; i >= 1; i -= 2) {
			System.out.print(i + "   ");
		}
		System.out.print("2   ");
		for (int i = 4; i <= placesPerRow; i += 2) {
			System.out.print(i + "   ");
		}
		System.out.println();
	}

	@Override
	public void welcomeUser() {
		System.out.println("Welcome to this cinema!");
	}


	@Override
	public void printCurrentStaceCinema() {
		printCurrentStaceCinema(null);
	}

	@Override
	public void printCurrentStaceCinema(List<SeatOfAvailableGroups> firstAvailableSeats) {
		System.out.println("This is the current state of the cinema.");
		System.out.println("The 'o' represent available places, the 'x' represent unavailable places, and '*' represent the first available seats for purchase.");
		SeatOfAvailableGroups firstGroup = (firstAvailableSeats != null && !firstAvailableSeats.isEmpty()) ? firstAvailableSeats.get(0) : null;
		boolean[][] emptySeats = cinema.getEmptySeats();
		int rows = cinema.getRows();
		int placesPerRow = cinema.getPlacesPerRow();
		printXCoordinates(placesPerRow);
		for (int i = 0; i < rows; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < placesPerRow; j++) {
				if (firstGroup != null && firstGroup.getRow() == i && firstGroup.getSeat().contains(j + 1)) {
					System.out.print("[*] ");
				} else if (!emptySeats[i][j]) {
					System.out.print("[o] ");
				} else {
					System.out.print("[x] ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	@Override
	public int askUserNumberOfSeatsToPurchase() {
		System.out.println("How many seats would you like to purchase?");
		return scanner.nextInt();
	}
}
