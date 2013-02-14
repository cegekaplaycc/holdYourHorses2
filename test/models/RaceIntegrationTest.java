package models;

import static org.fest.assertions.Assertions.assertThat;
import static org.joda.time.DateTime.now;

import org.junit.Test;

import util.TheNewAbstractIntegrationTestCase;

import com.avaje.ebean.Ebean;

public class RaceIntegrationTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void persistRaceForNextWeek() {
		Race.persistRaceForNextWeek();

		assertThat(Race.find.findUnique().startDate).isEqualTo(now().plusWeeks(1));
	}

	@Test
	public void canBePersisted() {
		Race race = new Race();
		race.save();

		Race refreshedRace = Ebean.find(Race.class).findUnique();
		assertThat(refreshedRace.id).isEqualTo(race.id);
	}

	@Test
	public void weKunnenAlleRacesOphalen() {
		saveRaces(12);
		assertThat(Race.findAll()).hasSize(12);
	}

	private void saveRaces(int number) {
		for (int i = 0; i < number; i++) {
			new Race().save();
		}
	}

}
