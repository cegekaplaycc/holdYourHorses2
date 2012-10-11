package actors;

import models.Race;
import akka.actor.UntypedActor;

public class RaceCreator extends UntypedActor {

	@Override
	public void onReceive(Object object) {
		Race.persistRaceForNextWeek();
	}

}
