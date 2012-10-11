package models;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

import org.junit.Test;

import com.avaje.ebean.Ebean;

public class RaceIntegrationTest {

	@Test
	public void canBePersisted() {
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			@Override
			public void run() {

				Race race = new Race();
				race.save();

				Race refreshedRace = Ebean.find(Race.class).findUnique();
				assertThat(refreshedRace.id).isEqualTo(race.id);
			}

		});
	}

	@Test
	public void weKunnenAlleRacesOphalen() {
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			@Override
			public void run() {
				saveRaces(12);
				assertThat(Race.findAll()).hasSize(12);
			}

		});
	}

	private void saveRaces(int number) {
		for (int i = 0; i < number; i++) {
			new Race().save();
		}
	}

}
