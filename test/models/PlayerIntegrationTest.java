package models;

import com.avaje.ebean.Ebean;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

/**
 * Created with IntelliJ IDEA.
 * Player: jefklak
 * Date: 11/10/12
 * Time: 09:57
 * To change this template use File | Settings | File Templates.
 */
public class PlayerIntegrationTest {

    @Test
    public void canBePersisted() {
        running(fakeApplication(), new Runnable() {
            public void run() {

                Player player = new Player();
                player.name = "Matti";
                player.save();

                Player refreshedPlayer = Ebean.find(Player.class).findUnique();
                assertThat(refreshedPlayer.name).isEqualTo("Matti");
            }

        });
    }
}