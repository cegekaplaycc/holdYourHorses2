package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.mockups.*;

public class Mockups extends Controller {

    public static Result dashboard() {
        return ok(dashboard.render());
    }


}
