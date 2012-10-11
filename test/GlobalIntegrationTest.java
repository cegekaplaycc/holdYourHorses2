import org.junit.Test;

import play.libs.Akka;
import util.TheNewAbstractIntegrationTestCase;
import akka.actor.ActorRef;


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
