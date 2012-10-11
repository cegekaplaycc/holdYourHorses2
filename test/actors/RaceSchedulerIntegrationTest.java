package actors;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.Future;
import akka.pattern.Patterns;
import akka.pattern.Patterns$;
import akka.testkit.TestActorRef;
import akka.util.Duration;
import models.Race;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.libs.Akka;
import scala.actors.threadpool.TimeUnit;
import util.TheNewAbstractIntegrationTestCase;

import static java.util.concurrent.TimeUnit.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.joda.time.DateTime.now;

public class RaceSchedulerIntegrationTest extends
        TheNewAbstractIntegrationTestCase {

    private ActorSystem actorSystem;

    private TestActorRef<RaceScheduler> actorRef;

    @Before
    public void initActor() {
        actorSystem = ActorSystem.apply();
        this.actorRef = TestActorRef.apply(new Props(
                RaceScheduler.class), actorSystem);
    }

    @Test
    public void wanneerDeSchedulerGetriggerdIsWordtErEenRaceAangemaaktMetStartdatumEenWeekInDeToekomst() {
        test(new Runnable() {

            @Override
            public void run() {
                actorRef.tell("");
                assertThat(Race.find.findUnique().startDate).isEqualTo(now().plusWeeks(1));
            }
        });
    }

    @After
    public void shutdownActorSystem() {
        actorSystem.shutdown();
    }
}