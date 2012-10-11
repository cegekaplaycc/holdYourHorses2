package services;

import com.avaje.ebean.Ebean;
import models.Player;

public class PlayerFactory {

	public void savePlayerMatti() {
        Player player = new Player("matti", "smatti");
        if(!player.exists()){
            player.save();
        }
	}
	
}
