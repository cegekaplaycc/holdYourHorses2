package controllers;

import models.Player;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(new Form(Player.class)));
    }

    public static Result login() {

        Form<Player> playerForm = form(Player.class);
        Player player = playerForm.bindFromRequest().get();

        return null;
    }

}