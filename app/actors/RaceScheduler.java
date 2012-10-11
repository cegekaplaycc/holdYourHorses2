package actors;

import akka.actor.UntypedActor;

public class RaceScheduler extends UntypedActor {

	@Override
	public void onReceive(Object arg0) {
		throw new UnsupportedOperationException("implement me!");
	}

	public boolean testMe() {
		return true;
	}

}
