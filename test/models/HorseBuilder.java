package models;

public class HorseBuilder {

	private Integer price;
	private Long id;
	private Player player;
	private String name;

	public Horse build() {
		Horse horse = new Horse(price);
		horse.id = id;
		horse.player = player;
		horse.name = name;
		return horse;
	}

	public HorseBuilder withDefaults() {
		this.price = 100;
		return this;
	}

	public HorseBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public HorseBuilder withPrice(Integer price) {
		this.price = price;
		return this;
	}

	public HorseBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public HorseBuilder withPlayer(Player player) {
		this.player = player;
		return this;
	}

}
