package controllers;

import static models.Horse.findAvailableHorses;

import java.util.List;

import models.Horse;
import models.Player;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.horseMarket;

public class HorseMarket extends Controller {

	public static Result show() {
		List<Horse> horses = findAvailableHorses();
		return ok(horseMarket.render(horses, form(Horse.class)));
	}

	public static Result buyHorse() {
		Form<Horse> horseForm = form(Horse.class);
		Horse horse = Horse.refresh(horseForm.bindFromRequest().get());

		Player loggedInPlayer = Player.findByUsername(session("loggedInUser"));
		loggedInPlayer.buyHorse(horse);

		// Ebean.saveAssociation(loggedInPlayer, "horses");
		horse.save();
		loggedInPlayer.save();

		// TODO redirect to detail page
		return TODO;
	}
}