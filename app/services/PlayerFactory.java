package services;

import models.Player;

public class PlayerFactory {

	public void savePlayerMatti() {
        Player player = new Player("matti", "smatti");
        if(!player.doesPlayerWithSameUsernameAndPasswordExist()){
            player.save();
        }
	}
	
}
