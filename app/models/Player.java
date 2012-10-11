package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Player extends Model {

    private static final int INITIAL_CASH_AMOUNT = 5000;
    
	@Id
    public Long id;
    public String username;
    public String password;
    public int cashAmount;

    public Long getId() {
        return id;
    }

    public Player() {
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.cashAmount = INITIAL_CASH_AMOUNT;
    }

    public boolean doesPlayerWithSameUsernameAndPasswordExist() {
        Player player = new Finder<Long, Player>(Long.class, Player.class)
                .where().eq("username", username).eq("password", password)
                .findUnique();
        return player != null;
    }

    public static Player findByUsername(String username) {
        Player player = new Finder<Long, Player>(Long.class, Player.class)
                .where().eq("username", username)
                .findUnique();
        return player;
    }
}
