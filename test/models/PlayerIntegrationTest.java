package models;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import util.TheNewAbstractIntegrationTestCase;
import com.avaje.ebean.Ebean;

public class PlayerIntegrationTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void canBePersisted() {
		test(new Runnable() {
			@Override
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
		test(new Runnable() {
			@Override
			public void run() {
				Player player = new Player("matti", "lollie");
				player.save();
				assertThat(new Player("matti", "lollie").doesPlayerWithSameUsernameAndPasswordExist()).isTrue();
			}
		});
	}

	@Test
	public void exists_ReturnsFalseWhenNoUsernameDoesntMatch() {
		test(new Runnable() {
			@Override
			public void run() {
				Player player = new Player("matti", "lollie");
				player.save();
				assertThat(new Player("smatsi", "lollie").doesPlayerWithSameUsernameAndPasswordExist()).isFalse();
			}
		});
	}

	@Test
	public void exists_ReturnsFalseWhenPasswordDoesntMatch() {
		test(new Runnable() {
			@Override
			public void run() {
				Player player = new Player("matti", "lollie");
				player.save();
				assertThat(new Player("matti", "sjmollie").doesPlayerWithSameUsernameAndPasswordExist()).isFalse();
			}
		});
	}
}