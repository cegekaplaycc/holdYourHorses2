import models.Player;
import play.Application;
import play.GlobalSettings;
import services.ServiceLocator;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application application) {
		ServiceLocator.horseBreeder.breedAvailableHorses();
		
        new Player("matti", "smatti").save();
	}

}
