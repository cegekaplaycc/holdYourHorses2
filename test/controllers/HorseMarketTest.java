package controllers;

import static controllers.routes.ref.HorseMarket;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.callAction;
import static play.test.Helpers.status;

import org.junit.Test;

import play.mvc.Result;

public class HorseMarketTest {

	@Test
	public void show() {
		Result result = callAction(HorseMarket.show());
		assertThat(status(result)).isEqualTo(200);
	}
}
