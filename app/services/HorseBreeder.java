package services;

import models.Horse;

import com.avaje.ebean.Ebean;


public class HorseBreeder {
	
	static final int MAX_AVAILABLE_HORSES = 20;
	static final int INITIAL_PRICE = 1000;
	
	public void breedAvailableHorses() {
		final int numberOfHorsesToBreed = determineNumberOfHorsesToBreed();
		for (int i = 0; i < numberOfHorsesToBreed; i++) {
			new Horse(INITIAL_PRICE).save();
		}
	}

	private int determineNumberOfHorsesToBreed() {
		return MAX_AVAILABLE_HORSES - Ebean.find(Horse.class).findRowCount();
	}
}
