package services;

import models.Player;

public class PlayerFactory {

	public void savePlayerMatti() {
		new Player("matti", "smatti").save();
	}
	
}
