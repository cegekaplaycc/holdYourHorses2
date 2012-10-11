package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;

@Entity
public class Player extends Model {

    @Id
    public Long id;
    public String username;
    public String password;

    public Long getId() {
        return id;
    }

    public Player() {
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
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
