package models;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.util.List;

import org.junit.Test;

import com.avaje.ebean.Ebean;

public class HorseIntegrationTest {

	private static final int PRICE_1000 = 1000;
	private static final String JOLLY_JUMPER = "Jolly Jumper";

	@Test
	public void canBePersisted() {
		running(fakeApplication(), new Runnable() {
			public void run() {
				Horse horse = new Horse();
				horse.name = JOLLY_JUMPER;
				horse.price = PRICE_1000;
				horse.save();

				List<Horse> horses = Ebean.find(Horse.class).findList();
				assertThat(horses).hasSize(1);
				assertThat(horses.get(0).name).isEqualTo(JOLLY_JUMPER);
				assertThat(horses.get(0).price).isEqualTo(PRICE_1000);
			}

		});
	}
}
