package models;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import util.TheNewAbstractIntegrationTestCase;

import com.avaje.ebean.Ebean;

public class StockIntegrationTest extends TheNewAbstractIntegrationTestCase {

	@Test
	public void canBePersisted() {
		Stock stock = new Stock();
		stock.save();

		List<Stock> stocks = Ebean.find(Stock.class).findList();
		assertThat(stocks).hasSize(1);
	}

	@Test
	public void foodCanBePersisted() {
		Stock stock = new Stock();
		stock.getFoodItems().add(new Food(FoodType.CARROTS, 14));
		stock.save();

		List<Stock> stocks = Ebean.find(Stock.class).findList();
		assertThat(stocks).hasSize(1);
		assertThat(stocks.get(0).getFoodItems().iterator().next().getAmount()).isEqualTo(14);
	}
}
