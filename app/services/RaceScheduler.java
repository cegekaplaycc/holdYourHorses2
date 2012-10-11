package services;

import static java.util.concurrent.TimeUnit.DAYS;
import play.libs.Akka;
import actors.RaceCreator;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.util.Duration;

public class RaceScheduler {

	public void scheduleWeeklyRace() {
		ActorRef actorRef = Akka.system().actorOf(new Props(RaceCreator.class));
		Akka.system()
				.scheduler()
				.schedule(Duration.Zero(), Duration.create(7, DAYS), actorRef,
						"tick");
	}

}
