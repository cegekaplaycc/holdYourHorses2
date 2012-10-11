import actors.RaceScheduler;
import akka.actor.ActorRef;
import akka.actor.DeadLetter;
import akka.actor.EmptyLocalActorRef;
import akka.actor.Props;
import org.junit.Test;
import play.libs.Akka;
import util.TheNewAbstractIntegrationTestCase;

import static org.fest.assertions.Assertions.assertThat;


public class GlobalIntegrationTest extends TheNewAbstractIntegrationTestCase {


    @Test
    public void ensureRaceSchedulerRegisteredInAkkaSystem() {
        test(new Runnable() {
            @Override
            public void run() {
                new Global().executeOnStart();
                ActorRef raceActorRef = Akka.system().actorFor("/user/race");
                //assertThat(raceActorRef.getClass()).isNotEqualTo(EmptyLocalActorRef.class);
            }
        });
    }

}
