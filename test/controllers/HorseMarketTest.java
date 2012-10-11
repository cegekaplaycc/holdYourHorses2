package controllers;

import static controllers.routes.ref.HorseMarket;
import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.callAction;
import static play.test.Helpers.status;

import org.junit.Test;

import play.mvc.Result;
import util.TheNewAbstractIntegrationTestCase;

public class HorseMarketTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void show() {
		test(new Runnable() {
			public void run() {
				Result result = callAction(HorseMarket.show());
				assertThat(status(result)).isEqualTo(200);
			}
		});
	}

}
