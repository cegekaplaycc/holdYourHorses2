package models;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Iterator;

import org.junit.Test;

import exceptions.HoldYourHorsesException;

public class StockTest {

	@Test
	public void add_ShouldAddNewFoodTypeIfFoodTypeNotInStockList() {
		Stock stock = new Stock();
		stock.add(FoodType.CARROTS, 12);

		assertThat(stock.getFoodItems().iterator().next().getAmount()).isEqualTo(12);
	}

	@Test
	public void add_ShouldAddAmountToExistingFoodTypeIfFoodTypeAlreadyInStockList() {
		Stock stock = new Stock();
		stock.add(FoodType.CARROTS, 12);
		stock.add(FoodType.CARROTS, 13);

		assertThat(stock.getFoodItems()).hasSize(1);
		assertThat(stock.getFoodItems().iterator().next().getAmount()).isEqualTo(25);
	}

	@Test
	public void add_ShouldBeAbleToAddDifferentTypeOfFood() {
		Stock stock = new Stock();
		stock.add(FoodType.CARROTS, 12);
		stock.add(FoodType.POWER_BISCUITS, 13);
		
		assertThat(stock.getFoodItems()).hasSize(2);
	}
}
