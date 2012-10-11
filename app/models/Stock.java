package models;

import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

import com.google.common.collect.Maps;

@Entity
public class Stock extends Model {

	@Id
	public Long id;

	public Map<FoodType, Integer> food = Maps.newHashMap();

	public Long getId() {
		return id;
	}

	public Stock add(FoodType foodType, Integer amount) {
		if (food.get(foodType) == null) {
			food.put(foodType, amount);
		} else {
			food.put(foodType, food.get(foodType) + amount);
		}
		return this;
	}
	
	public Set<FoodType> getFoodTypes(){
		return food.keySet();
	}

}
