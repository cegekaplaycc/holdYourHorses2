package models;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import exceptions.HoldYourHorsesException;

public class PlayerTest {

	@Test
	public void buyHorse_HorseAndPlayerAreBidirectionallyLinked() {
		Player player = new Player();
		player.cashAmount = 666;
		Horse horse = new Horse(123);

		player.buyHorse(horse);

		assertThat(player.horses).containsOnly(horse);
		assertThat(horse.player).isSameAs(player);
	}

	@Test
	public void buyHorse_PlayerCashAmountIsReducedByHorsePrice() {
		Player player = new Player();
		player.cashAmount = 70;
		Horse horse = new Horse(50);

		player.buyHorse(horse);

		assertThat(player.cashAmount).isEqualTo(20);
	}
	
	@Test
	public void getBoxNumber_indexOfHorseInListPlus1(){
		Player player = new Player();
		Horse horse = new Horse(12);
		player.horses.add(horse);
		
		assertThat(player.getBoxNumber(horse)).isEqualTo(1);
	}

	@Test(expected = HoldYourHorsesException.class)
	public void buyHorse_ThrowsExceptionWhenPlayerCashAmountIsInsufficient() {
		Player player = new Player();
		player.cashAmount = 10;
		Horse horse = new Horse(50);

		player.buyHorse(horse);
	}

}
