import play.Application;
import play.GlobalSettings;
import play.api.Play;
import services.ServiceLocator;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application application) {
		if (!application.isTest()) {
			ServiceLocator.horseBreeder.breedAvailableHorses();
			ServiceLocator.playerFactory.savePlayerMatti();
		}
	}

}
