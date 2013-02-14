package services;

import com.avaje.ebean.Ebean;

import models.FoodType;
import models.Horse;
import models.Player;

public class PlayerFactory {

	public void savePlayerMatti() {
        Player player = new Player("matti", "smatti");
        player.stock.add(FoodType.CARROTS, 12);
        player.stock.add(FoodType.POWER_BISCUITS, 20);
        Horse horse = new Horse(12);
        horse.save();
        Ebean.saveAssociation(player, "stock");
        if(!player.doesPlayerWithSameUsernameAndPasswordExist()){
        	player.buyHorse(horse);
            player.save();
        }
	}
	
}
