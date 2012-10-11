package controllers;

import static models.Horse.findAllHorses;

import java.util.List;

import models.Horse;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.horseMarket;

public class HorseMarket extends Controller {

    public static Result show() {
    	List<Horse> horses = findAllHorses();
		return ok(horseMarket.render(horses, form(Horse.class)));        
    }

    public static Result buyHorse() {
        Form<Horse> horseForm = form(Horse.class);
        Horse horse = horseForm.bindFromRequest().get();

        // TODO controller / template test
        // TODO buy horse and redirect to detail page
        System.out.println(horse.id);
    	return TODO;        
    }

}