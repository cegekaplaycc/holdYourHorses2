package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Horse extends Model {

	@Id
	public Long id;

	public String name;

	public final Integer price;

	@ManyToOne
	public Player player;

	public Horse(Integer price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	private static Finder<Long, Horse> find = new Finder<Long, Horse>(Long.class, Horse.class);

	public static List<Horse> findAvailableHorses() {
		// TODO only available horses
		return find.all();
	}

	public static Horse refresh(Horse horse) {
		if (horse == null || horse.id == null) {
			throw new IllegalArgumentException("paard of id ontbreekt!");
		}

		Horse refreshedHorse = find.byId(horse.id);
		if (refreshedHorse == null) {
			throw new IllegalArgumentException("Kon het paard met id " + horse.id + " niet verversen");
		}
		return refreshedHorse;
	}

}
