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
	
	public static List<Horse> findAllHorses() {				
		return find.all();
	}

}
