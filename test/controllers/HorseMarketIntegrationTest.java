package controllers;

import static controllers.routes.ref.HorseMarket;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.callAction;
import static play.test.Helpers.status;

import java.util.HashMap;
import java.util.Map;

import models.Horse;
import models.HorseBuilder;
import models.Player;

import org.junit.Test;

import play.mvc.Result;
import play.test.Helpers;
import util.TheNewAbstractIntegrationTestCase;

import com.avaje.ebean.Ebean;

public class HorseMarketIntegrationTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void buyHorses() {
		new Player("tim", "bla").save();
		Horse horse = new HorseBuilder().withDefaults().build();
		horse.save();

		Map<String, String> data = new HashMap<String, String>();
		data.put("id", horse.id + "");

		callAction(HorseMarket.buyHorse(), Helpers.fakeRequest()
				.withSession("loggedInUser", "tim")
				.withFormUrlEncodedBody(data));

		Player fetchedPlayer = Player.findByUsername("tim");
		assertThat(fetchedPlayer.horses).containsOnly(horse);
		assertThat(fetchedPlayer.cashAmount).isEqualTo(4900);

		Horse fetchedHorse = Ebean.find(Horse.class, horse.id);
		assertThat(fetchedHorse.player).isEqualTo(fetchedPlayer);
	}

	@Test
	public void show() {
		Result result = callAction(HorseMarket.show());
		assertThat(status(result)).isEqualTo(200);
	}

}
