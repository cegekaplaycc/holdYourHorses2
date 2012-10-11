package controllers;

import static models.Horse.findAllHorses;

import java.util.List;

import models.Horse;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.horseMarket;

public class HorseMarket extends Controller {

    public static Result show() {
    	List<Horse> horses = findAllHorses();
		return ok(horseMarket.render(horses));        
    }

}