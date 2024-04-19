package com.babel.acomodadorAutomatico.services.impl;

import com.babel.acomodadorAutomatico.models.SeatOfAvailableGroups;
import com.babel.acomodadorAutomatico.services.ISeatAllocatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatAllocatorService implements ISeatAllocatorService {

	private static void orderGroupsBasedOnCriteria(List<SeatOfAvailableGroups> availableGroups, int rows, int placesPerRow) {
		availableGroups.sort((group1, group2) -> {
			int rowComparison = Integer.compare(rows - 1 - group1.getRow(), rows - 1 - group2.getRow());
			if (rowComparison != 0) {
				return rowComparison;
			}
			int centerColumn = placesPerRow / 2;
			int distanceToCenter1 = Math.abs(group1.getSeat().get(group1.getSeat().size() / 2) - centerColumn);
			int distanceToCenter2 = Math.abs(group2.getSeat().get(group2.getSeat().size() / 2) - centerColumn);
			return Integer.compare(distanceToCenter1, distanceToCenter2);
		});
	}

	private static void removeGroupsSmallerThanUserRequirement(int requiredSeatsByUser, List<SeatOfAvailableGroups> availableGroups) {
		for (int i = 0; i < availableGroups.size(); i++) {
			SeatOfAvailableGroups group = availableGroups.get(i);
			if (group.getNumSeats() < requiredSeatsByUser) {
				availableGroups.remove(i);
				i--;
			}
		}
	}

	@Override
	public List<SeatOfAvailableGroups> findAvailableGroups(boolean[][] seats, int requiredSeatsByUser) {
		List<SeatOfAvailableGroups> availableGroups = new ArrayList<>();
		int rows = seats.length;
		int placesPerRow = seats[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < placesPerRow; j++) {
				if (!seats[i][j]) {
					if (j == 0 || seats[i][j - 1]) {
						SeatOfAvailableGroups group = new SeatOfAvailableGroups();
						group.addRow(i);
						group.addSeat(j + 1);
						availableGroups.add(group);
					} else {
						availableGroups.get(availableGroups.size() - 1).addSeat(j + 1);
					}
				}
			}
		}
		removeGroupsSmallerThanUserRequirement(requiredSeatsByUser, availableGroups);
		orderGroupsBasedOnCriteria(availableGroups, rows, placesPerRow);
		return availableGroups;
	}
}
