package services;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.util.List;

import models.Horse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import services.HorseBreeder;

import com.avaje.ebean.Ebean;

public class HorseBreederIntegrationTest {

	@Test
	public void givenNoAvailableHorses_WhenBreedingAvailableHorses_ThenMaxAmountOfHorsesShouldBeAvailable() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				new HorseBreeder().breedAvailableHorses();

				List<Horse> result = Ebean.find(Horse.class).findList();
				assertThat(result).hasSize(HorseBreeder.MAX_AVAILABLE_HORSES);
			}
		});
	}

	@Test
	public void givenSomeAvailableHorses_WhenBreedingAvailableHorses_ThenMaxAmountOfHorsesShouldBeAvailable() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				new Horse(580).save();

				new HorseBreeder().breedAvailableHorses();

				List<Horse> result = Ebean.find(Horse.class).findList();
				assertThat(result).hasSize(HorseBreeder.MAX_AVAILABLE_HORSES);
			}
		});
	}

}
