package models;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import util.TheNewAbstractIntegrationTestCase;

import com.avaje.ebean.Ebean;

public class PlayerIntegrationTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void canBePersisted() {
		Player player = new Player();
		player.username = "Matti";
		player.save();

		Player refreshedPlayer = Ebean.find(Player.class).findUnique();
		assertThat(refreshedPlayer.username).isEqualTo("Matti");
	}

	@Test
	public void exists_ReturnsTrueWhenUserWithSameUsernameAndPasswordExists() {
		Player player = new Player("matti", "lollie");
		player.save();
		assertThat(new Player("matti", "lollie").doesPlayerWithSameUsernameAndPasswordExist()).isTrue();
	}

	@Test
	public void exists_ReturnsFalseWhenNoUsernameDoesntMatch() {
		Player player = new Player("matti", "lollie");
		player.save();
		assertThat(new Player("smatsi", "lollie").doesPlayerWithSameUsernameAndPasswordExist()).isFalse();
	}

	@Test
	public void exists_ReturnsFalseWhenPasswordDoesntMatch() {
		Player player = new Player("matti", "lollie");
		player.save();
		assertThat(new Player("matti", "sjmollie").doesPlayerWithSameUsernameAndPasswordExist()).isFalse();
	}
}