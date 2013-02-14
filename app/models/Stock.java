package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import play.db.ebean.Model;

@Entity
public class Stock extends Model {

	@Id
	public Long id;

	@OneToMany(cascade=CascadeType.ALL)
	private Set<Food> foodItems = new HashSet<Food>();
	
	public Long getId() {
		return id;
	}

	public Set<Food> getFoodItems() {
		return foodItems;
	}
	
	public void setFoodItems(Set<Food> food) {
		this.foodItems = food;
	}

	public void add(FoodType type, int amount) {
		for (Food singleFood: foodItems) {
			if(singleFood.getType().equals(type)){
				singleFood.setAmount(singleFood.getAmount() + amount);
				return;
			}
		}
		foodItems.add(new Food(type, amount));
	}
	
}
