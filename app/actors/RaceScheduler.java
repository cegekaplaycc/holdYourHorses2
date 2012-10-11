package actors;

import models.Race;
import akka.actor.UntypedActor;

public class RaceScheduler extends UntypedActor {

	@Override
	public void onReceive(Object object) {
		Race.persistRaceForNextWeek();
	}

}
