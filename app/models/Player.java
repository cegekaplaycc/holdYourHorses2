package models;

import static javax.persistence.CascadeType.PERSIST;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.Lists;

import play.db.ebean.Model;
import exceptions.HoldYourHorsesException;

@Entity
public class Player extends Model {

	private static final int INITIAL_CASH_AMOUNT = 5000;

	@Id
	public Long id;
	public String username;
	public String password;
	public int cashAmount;

	@OneToMany(mappedBy = "player")
	public List<Horse> horses = Lists.newArrayList();

	@OneToOne(cascade = PERSIST)
	public Stock stock = new Stock();

	public Long getId() {
		return id;
	}

	public Player() {
	}

	public Player buyHorse(Horse horse) {
		if (!hasSufficientCash(horse.price)) {
			throw new HoldYourHorsesException("Insufficient cash to buy horse!");
		}

		horses.add(horse);
		// TODO cannot do this when horse already has player
		horse.player = this;

		cashAmount -= horse.price;

		return this;
	}

	private boolean hasSufficientCash(Integer moneyToPay) {
		return cashAmount >= moneyToPay;
	}

	public Player(String username, String password) {
		this.username = username;
		this.password = password;
		this.cashAmount = INITIAL_CASH_AMOUNT;
	}
	
	public int getBoxNumber(Horse horse){
		return horses.indexOf(horse) + 1;
	}

	public boolean doesPlayerWithSameUsernameAndPasswordExist() {
		Player player = new Finder<Long, Player>(Long.class, Player.class)
				.where().eq("username", username).eq("password", password)
				.findUnique();
		return player != null;
	}

	public static Player findByUsername(String username) {
		Player player = new Finder<Long, Player>(Long.class, Player.class)
				.where().eq("username", username).findUnique();
		return player;
	}
}
