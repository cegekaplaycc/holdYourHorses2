package services;

import com.avaje.ebean.Ebean;

import models.FoodType;
import models.Player;

public class PlayerFactory {

	public void savePlayerMatti() {
        Player player = new Player("matti", "smatti");
        player.stock.add(FoodType.CARROTS, 12);
        player.stock.add(FoodType.POWER_BISCUITS, 20);
        Ebean.saveAssociation(player, "stock");
        if(!player.doesPlayerWithSameUsernameAndPasswordExist()){
            player.save();
        }
	}
	
}
