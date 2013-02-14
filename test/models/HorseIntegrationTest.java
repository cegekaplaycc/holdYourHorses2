package models;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import util.TheNewAbstractIntegrationTestCase;

import com.avaje.ebean.Ebean;

public class HorseIntegrationTest extends TheNewAbstractIntegrationTestCase {

	private static final int PRICE_1000 = 1000;
	private static final String JOLLY_JUMPER = "Jolly Jumper";

	@Test
	public void canBePersisted() {
		Horse horse = new Horse(PRICE_1000);
		horse.name = JOLLY_JUMPER;
		horse.save();

		List<Horse> horses = Ebean.find(Horse.class).findList();
		assertThat(horses).hasSize(1);
		assertThat(horses.get(0).name).isEqualTo(JOLLY_JUMPER);
		assertThat(horses.get(0).price).isEqualTo(PRICE_1000);
	}

	@Test
	public void refreshHorse() {
		Horse persistedHorse = new HorseBuilder().withName("boe").build();
		persistedHorse.save();

		Horse staleHorse = new HorseBuilder().withId(persistedHorse.getId()).build();
		Horse refreshedHorse = Horse.refresh(staleHorse);

		assertThat(refreshedHorse.getId()).isEqualTo(persistedHorse.getId());
		assertThat(refreshedHorse.name).isEqualTo("boe");
	}

	@Test(expected = IllegalArgumentException.class)
	public void refreshHorseDatNietBestaat() {
		Horse.refresh(new HorseBuilder().withId(123456789L).build());
	}

	@Test(expected = IllegalArgumentException.class)
	public void refreshHorseZonderId() {
		Horse.refresh(new HorseBuilder().withId(null).build());
	}

	@Test(expected = IllegalArgumentException.class)
	public void refreshHorseNull() {
		Horse.refresh((Horse) null);
	}

	@Test
	public void findAvailableHorses() {
		Horse horse1 = new Horse(20);
		horse1.save();
		Horse horse2 = new Horse(20);
		horse2.save();
		List<Horse> actual = Horse.findAvailableHorses();
		assertThat(actual).containsOnly(horse1, horse2);
	}
}
