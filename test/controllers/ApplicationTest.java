package controllers;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.mvc.Http.Status.UNAUTHORIZED;
import static play.test.Helpers.POST;
import static play.test.Helpers.callAction;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.routeAndCall;
import static play.test.Helpers.running;
import static play.test.Helpers.status;

import java.util.Map;

import models.Player;

import org.junit.Ignore;
import org.junit.Test;

import play.mvc.Result;
import play.test.Helpers;

import com.google.common.collect.Maps;

public class ApplicationTest {

	@Test
	public void loginRedirectsToLoginIfUserNotFound() {
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			public void run() {
				Map<String, String> submittedData = Maps.newHashMap();
				submittedData.put("username", "kaatb");
				submittedData.put("password", "kaatc");
				Result result = callAction(
						controllers.routes.ref.Application.login(),
						Helpers.fakeRequest().withFormUrlEncodedBody(
								submittedData));
				assertThat(status(result)).isEqualTo(UNAUTHORIZED);
			}
		});
	}

	@Test
	@Ignore
	// TODO unignore this test!
	public void loginRedirectsToDashboardIfUserExists() {
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			public void run() {
				new Player("matti", "smatti").save();
				Map<String, String> submittedData = Maps.newHashMap();
				submittedData.put("username", "matti");
				submittedData.put("password", "smatti");
				Result result = routeAndCall(fakeRequest(POST, "/login")
						.withFormUrlEncodedBody(submittedData));
				assertThat(status(result)).isEqualTo(OK);
				assertThat(Helpers.contentAsString(result)).contains("jeuj");
			}
		});
	}
}
