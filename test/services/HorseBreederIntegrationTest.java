package services;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import models.Horse;

import org.junit.Test;

import util.TheNewAbstractIntegrationTestCase;

import com.avaje.ebean.Ebean;

public class HorseBreederIntegrationTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void givenNoAvailableHorses_WhenBreedingAvailableHorses_ThenMaxAmountOfHorsesShouldBeAvailable() {
		new HorseBreeder().breedAvailableHorses();

		List<Horse> result = Ebean.find(Horse.class).findList();
		assertThat(result).hasSize(HorseBreeder.MAX_AVAILABLE_HORSES);
	}

	@Test
	public void givenSomeAvailableHorses_WhenBreedingAvailableHorses_ThenMaxAmountOfHorsesShouldBeAvailable() {
		new Horse(580).save();

		new HorseBreeder().breedAvailableHorses();

		List<Horse> result = Ebean.find(Horse.class).findList();
		assertThat(result).hasSize(HorseBreeder.MAX_AVAILABLE_HORSES);
	}

}
