package controllers;

import models.Horse;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.horseDetail;

public class HorseDetail extends Controller {

	 public static Result showHorse(Long horseId) {
	        return ok(horseDetail.render(Horse.findById(horseId)));
	    }
	
}
