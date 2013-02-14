package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Food extends Model {
	
	@Id
	public Long id;
	
	private FoodType type;
	private int amount;
	
	public Food( FoodType type, int amount){
		this.type = type;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}

	public FoodType getType() {
		return type;
	}

	public void setType(FoodType type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
