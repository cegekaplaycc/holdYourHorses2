package models;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

import org.junit.Rule;
import org.junit.Test;

import services.ServiceMocker;

import com.avaje.ebean.Ebean;

/**
 * Created with IntelliJ IDEA.
 * Player: jefklak
 * Date: 11/10/12
 * Time: 09:57
 * To change this template use File | Settings | File Templates.
 */
public class PlayerIntegrationTest {

	@Rule
	public ServiceMocker serviceMocker = ServiceMocker.create();
	
    @Test
    public void canBePersisted() {
    	serviceMocker.mockPlayerFactory();
    	
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                Player player = new Player();
                player.username = "Matti";
                player.save();

                Player refreshedPlayer = Ebean.find(Player.class).findUnique();
                assertThat(refreshedPlayer.username).isEqualTo("Matti");
            }

        });
    }

    @Test
    public void exists_ReturnsTrueWhenUserWithSameUsernameAndPasswordExists() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                Player player = new Player("matti", "lollie");
                player.save();
                assertThat(new Player("matti", "lollie").exists()).isTrue();
            }
        });
    }

    @Test
    public void exists_ReturnsFalseWhenNoUsernameDoesntMatch() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                Player player = new Player("matti", "lollie");
                player.save();
                assertThat(new Player("smatsi", "lollie").exists()).isFalse();
            }
        });
    }

    @Test
    public void exists_ReturnsFalseWhenPasswordDoesntMatch() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            public void run() {
                Player player = new Player("matti", "lollie");
                player.save();
                assertThat(new Player("matti", "sjmollie").exists()).isFalse();
            }
        });
    }
}