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

public class RaceCreatorIntegrationTest extends TheNewAbstractIntegrationTestCase {

	private ActorSystem actorSystem;

	private TestActorRef<RaceCreator> actorRef;

	@Before
	public void initActor() {
		actorSystem = ActorSystem.apply();
		actorRef = TestActorRef.apply(new Props(RaceCreator.class), actorSystem);
	}

	@Test
	public void wanneerDeSchedulerGetriggerdIsWordtErEenRaceAangemaaktMetStartdatumEenWeekInDeToekomst() {
		actorRef.tell("tick");
		assertThat(Race.find.findUnique().startDate).isEqualTo(now().plusWeeks(1));
	}

	@After
	public void shutdownActorSystem() {
		actorSystem.shutdown();
	}
}