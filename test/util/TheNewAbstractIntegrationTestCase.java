package util;


import static org.joda.time.DateTime.now;
import static org.joda.time.DateTimeUtils.setCurrentMillisFixed;
import static org.joda.time.DateTimeUtils.setCurrentMillisSystem;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

import org.junit.After;
import org.junit.Before;
import play.test.FakeApplication;

public abstract class TheNewAbstractIntegrationTestCase {

	public final void test(Runnable testToRun) {
        running(fakeApplication(inMemoryDatabase()), testToRun);
	}

	@Before
	public void stopClock() {
		setCurrentMillisFixed(now().getMillis());
	}

	@After
	public void startClock() {
		setCurrentMillisSystem();
	}

}
