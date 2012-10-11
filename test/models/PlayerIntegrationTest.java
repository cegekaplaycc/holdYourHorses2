package models;

import com.avaje.ebean.Ebean;
import junit.framework.Assert;
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
    public void findByUsername_ExistingUser() {
        running(fakeApplication(), new Runnable() {
            public void run() {

                Player player = new Player("Matti", "lollige broek");
                player.save();

                assertThat(Player.findByUsername("Matti")).isEqualTo(player);
            }

        });
    }

    @Test(expected =  Exception.class)
    public void findByUsername_NonExistingUser_ThrowsException() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Player.findByUsername("Matti");
            }

        });
    }

    @Test
    public void canBePersisted() {
        running(fakeApplication(), new Runnable() {
            public void run() {

                Player player = new Player();
                player.username = "Matti";
                player.save();

                Player refreshedPlayer = Ebean.find(Player.class).findUnique();
                assertThat(refreshedPlayer.username).isEqualTo("Matti");
            }

        });
    }
}