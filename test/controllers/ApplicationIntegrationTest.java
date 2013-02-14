package controllers;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.mvc.Http.Status.UNAUTHORIZED;
import static play.test.Helpers.POST;
import static play.test.Helpers.callAction;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.routeAndCall;
import static play.test.Helpers.status;

import java.util.Map;

import models.Player;

import org.junit.Ignore;
import org.junit.Test;

import play.mvc.Result;
import play.test.Helpers;
import util.TheNewAbstractIntegrationTestCase;

import com.google.common.collect.Maps;

public class ApplicationIntegrationTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void loginRedirectsToLoginIfUserNotFound() {
		Map<String, String> submittedData = Maps.newHashMap();
		submittedData.put("username", "kaatb");
		submittedData.put("password", "kaatc");
		Result result = callAction(controllers.routes.ref.Application.login(), Helpers.fakeRequest().withFormUrlEncodedBody(submittedData));
		assertThat(status(result)).isEqualTo(UNAUTHORIZED);
	}

	@Test
	@Ignore
	// TODO matti fix and unignore this test!
	public void loginRedirectsToDashboardIfUserExists() {
		new Player("matti", "smatti").save();
		Map<String, String> submittedData = Maps.newHashMap();
		submittedData.put("username", "matti");
		submittedData.put("password", "smatti");
		Result result = routeAndCall(fakeRequest(POST, "/login").withFormUrlEncodedBody(submittedData));
		assertThat(status(result)).isEqualTo(OK);
		assertThat(Helpers.contentAsString(result)).contains("jeuj");
	}
}
