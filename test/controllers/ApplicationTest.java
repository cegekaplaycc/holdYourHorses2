package controllers;

import com.google.common.collect.Maps;
import models.Player;
import org.apache.http.HttpStatus;
import org.fest.assertions.Assertions;
import org.junit.Test;
import play.Routes;
import play.data.Form;
import play.mvc.Result;
import play.test.Helpers;
import scala.App;

import javax.xml.ws.Response;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.UNAUTHORIZED;
import static play.test.Helpers.*;
import static play.test.Helpers.inMemoryDatabase;

public class ApplicationTest {

    @Test
    public void loginRedirectsToLoginIfUserNotFound() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                Map<String, String> submittedData = Maps.newHashMap();
                submittedData.put("username","kaatb");
                submittedData.put("password","kaatc");
                Result result = callAction(controllers.routes.ref.Application.login(), Helpers.fakeRequest().withFormUrlEncodedBody(submittedData));
                assertThat(status(result)).isEqualTo(UNAUTHORIZED);
            }
        });
    }

    @Test
    public void loginRedirectsToDashboardIfUserExists() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                Map<String, String> submittedData = Maps.newHashMap();
                submittedData.put("username","matti");
                submittedData.put("password","smatti");
                Result result = routeAndCall(fakeRequest(POST, "/login").withFormUrlEncodedBody(submittedData));
                //Result result = callAction(controllers.routes.ref.Application.login(), Helpers.fakeRequest().withFormUrlEncodedBody(submittedData));
                assertThat(status(result)).isEqualTo(OK);
                assertThat(Helpers.contentAsString(result)).contains("jeuj");
            }
        });
    }
}
