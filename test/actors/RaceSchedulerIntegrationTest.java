package actors;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;

public class RaceSchedulerIntegrationTest {

	private TestActorRef<RaceScheduler> actorRef;
	private ActorSystem actorSystem;

	@Before
	public void initActor() {
		actorSystem = ActorSystem.apply();
		actorRef = TestActorRef.apply(new Props(RaceScheduler.class),
				actorSystem);
	}

	@Test
	public void simpleActorTest() {
		running(fakeApplication(), new Runnable() {
			@Override
			public void run() {
				assertThat(actorRef.underlyingActor().testMe()).isTrue();
			}
		});
	}

	@After
	public void shutdownActorSystem() {
		actorSystem.shutdown();
	}
}