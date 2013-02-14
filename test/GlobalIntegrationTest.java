import static java.util.concurrent.TimeUnit.SECONDS;
import models.Race;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import scala.runtime.AbstractFunction0;
import util.TheNewAbstractIntegrationTestCase;
import akka.actor.ActorSystem;
import akka.testkit.TestProbe;
import akka.util.Duration;

public class GlobalIntegrationTest extends TheNewAbstractIntegrationTestCase {

	private TestProbe testProbe;
	private ActorSystem system;

	@Before
	public void initProbe() {
		system = ActorSystem.apply();
		testProbe = TestProbe.apply(system);
	}

	@After
	public void shutdownAkka() {
		system.shutdown();
	}

	@Test
	public void ensureRaceSchedulerRegisteredInAkkaSystem() {
		new Global().executeOnStart();
		assert1RaceIsScheduled();

	}

	private void assert1RaceIsScheduled() {
		testProbe.awaitCond(new AbstractFunction0<Object>() {

			@Override
			public Boolean apply() {
				return Race.findAll().size() == 1;
			}
		}, Duration.create(5, SECONDS), Duration.create(1, SECONDS));
	}

}
