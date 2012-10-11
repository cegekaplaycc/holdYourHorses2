package models;

import com.avaje.ebean.Ebean;
import org.apache.commons.lang3.StringUtils;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Player: jefklak
 * Date: 11/10/12
 * Time: 09:51
 * To change this template use File | Settings | File Templates.
 */
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

    public boolean passwordMatches(String password) {
        return StringUtils.equals(password, this.password);
    }

    public static Player findByUsername(String username) {
        Player player = new Finder<Long, Player>(Long.class, Player.class).where().eq("username", username).findUnique();
        if(player == null) {
            throw new RuntimeException("Ongeldige user: " + username);
        }

        return player;
    }

}
