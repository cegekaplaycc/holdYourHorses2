package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Race extends Model {

	private static Finder<Long, Race> find = new Finder<Long, Race>(Long.class,
			Race.class);

	@Id
	public Long id;

	public static List<Race> findAll() {
		return find.all();
	}

}
