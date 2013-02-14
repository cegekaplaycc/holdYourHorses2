package util;

import static org.joda.time.DateTime.now;
import static org.joda.time.DateTimeUtils.setCurrentMillisFixed;
import static org.joda.time.DateTimeUtils.setCurrentMillisSystem;
import static play.test.Helpers.fakeApplication;

import org.junit.After;
import org.junit.Before;

import play.test.FakeApplication;
import play.test.Helpers;

public abstract class TheNewAbstractIntegrationTestCase {

	public static FakeApplication app;

	@Before
	public void stopClock() {
		setCurrentMillisFixed(now().getMillis());
	}

	@After
	public void startClock() {
		setCurrentMillisSystem();
	}

	@Before
	public void startApp() {
		app = fakeApplication(Helpers.inMemoryDatabase());
		Helpers.start(app);
	}

	@After
	public void stopApp() {
		Helpers.stop(app);
	}

}
