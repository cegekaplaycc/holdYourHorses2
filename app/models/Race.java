package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.DateTime;

import play.db.ebean.Model;

@Entity
public class Race extends Model {

	public static final Finder<Long, Race> find = new Finder<Long, Race>(
			Long.class, Race.class);

	@Id
	public Long id;

	public DateTime startDate;

	public static Race persistRaceForNextWeek() {
		Race race = new Race();
		race.startDate = new DateTime().plusWeeks(1);
		race.save();
		return race;
	}

	public static List<Race> findAll() {
		return find.all();
	}

}
