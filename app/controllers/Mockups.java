package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.mockups.buySupplies;
import views.html.mockups.dashboard;
import views.html.mockups.futureRaceDetail;
import views.html.mockups.futureRaceOverview;
import views.html.mockups.horseDetail;
import views.html.mockups.horseMarket;
import views.html.mockups.pastRaceDetail;

@SuppressWarnings("UnusedDeclaration")
public class Mockups extends Controller {

    public static Result dashboard() {
        return ok(dashboard.render());
    }

    public static Result buySupplies() {
        return ok(buySupplies.render());
    }

    public static Result futureRaceDetail() {
        return ok(futureRaceDetail.render());
    }

    public static Result futureRaceOverview() {
        return ok(futureRaceOverview.render());
    }

    public static Result horseDetail() {
        return ok(horseDetail.render());
    }

    public static Result horseMarket() {
        return ok(horseMarket.render());
    }

    public static Result pastRaceDetail() {
        return ok(pastRaceDetail.render());
    }


}
