import models.Player;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application application) {
        new Player("matti", "smatti").save();
	}

}
