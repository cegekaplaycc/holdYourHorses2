package controllers;

import models.Player;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(form(Player.class)));
    }

    public static Result login() {
        Form<Player> playerForm = form(Player.class);
        Form<Player> boundForm = playerForm.bindFromRequest();
        Player player = boundForm.get();
        if(player.exists()) {
            return dashboard();
        }
       return unauthorized(index.render(boundForm));
    }

    public static Result dashboard() {
        return ok(dashboard.render());
    }

}