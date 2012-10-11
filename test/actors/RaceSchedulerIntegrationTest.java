package actors;

import static org.fest.assertions.Assertions.assertThat;
import static org.joda.time.DateTime.now;
import models.Race;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.TheNewAbstractIntegrationTestCase;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;

public class RaceSchedulerIntegrationTest extends
		TheNewAbstractIntegrationTestCase {

	private RaceScheduler raceScheduler;
	private ActorSystem actorSystem;

	@Before
	public void initActor() {
		actorSystem = ActorSystem.apply();
		TestActorRef<RaceScheduler> actorRef = TestActorRef.apply(new Props(
				RaceScheduler.class), actorSystem);
		raceScheduler = actorRef.underlyingActor();
	}

	@Test
	public void wanneerDeSchedulerGetriggerdIsWordtErEenRaceAangemaaktMetStartdatumEenWeekInDeToekomst() {
		test(new Runnable() {

			@Override
			public void run() {
				raceScheduler.onReceive("tick");

				assertThat(Race.find.findUnique().startDate).isEqualTo(
						now().plusWeeks(1));
			}
		});
	}

	@After
	public void shutdownActorSystem() {
		actorSystem.shutdown();
	}
}