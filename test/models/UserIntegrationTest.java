package models;

import com.avaje.ebean.Ebean;
import org.fest.assertions.Assertions;
import org.junit.Test;
import play.test.Helpers;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

/**
 * Created with IntelliJ IDEA.
 * User: jefklak
 * Date: 11/10/12
 * Time: 09:57
 * To change this template use File | Settings | File Templates.
 */
public class UserIntegrationTest {

    @Test
    public void canBePersisted() {
        running(fakeApplication(), new Runnable() {
            public void run() {

                User user = new User();
                user.name = "Matti";
                user.save();

                User refreshedUser = Ebean.find(User.class).findUnique();
                assertThat(refreshedUser.name).isEqualTo("Matti");
            }

        });
    }
}