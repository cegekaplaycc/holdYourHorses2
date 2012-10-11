import play.Application;
import play.GlobalSettings;
import services.ServiceLocator;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application application) {
		if (!application.isTest()) {
			executeOnStart();
		}
	}

	void executeOnStart() {
		ServiceLocator.horseBreeder.breedAvailableHorses();
		ServiceLocator.playerFactory.savePlayerMatti();
		ServiceLocator.raceScheduler.scheduleWeeklyRace();
	}

}
