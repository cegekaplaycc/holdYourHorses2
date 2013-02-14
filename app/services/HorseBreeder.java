package services;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import models.Horse;

public class HorseBreeder {

	static final int MAX_AVAILABLE_HORSES = 20;
	static final int INITIAL_PRICE = 1000;

	public void breedAvailableHorses() {
		final int numberOfHorsesToBreed = determineNumberOfHorsesToBreed();
		for (int i = 0; i < numberOfHorsesToBreed; i++) {
			Horse horse = new Horse(INITIAL_PRICE);
			horse.name = "Horse " + randomAlphabetic(6);
			horse.save();
		}
	}

	private int determineNumberOfHorsesToBreed() {
		return MAX_AVAILABLE_HORSES - Horse.findAvailableHorses().size();
	}
}
