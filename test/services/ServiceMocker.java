package services;

import org.junit.rules.ExternalResource;
import org.mockito.Mockito;

public class ServiceMocker extends ExternalResource {

	private HorseBreeder originalHorseBreeder;
	private PlayerFactory originalPlayerFactory;
	
	public static ServiceMocker create() {
		return new ServiceMocker();
	}
	
	@Override
	protected void before() throws Throwable {
		originalHorseBreeder = ServiceLocator.horseBreeder;
		originalPlayerFactory = ServiceLocator.playerFactory;
	}

	@Override
	protected void after() {
		ServiceLocator.horseBreeder = originalHorseBreeder;
		ServiceLocator.playerFactory = originalPlayerFactory;
	}
	
	public void mockHorseBreeder() {
		ServiceLocator.horseBreeder = Mockito.mock(HorseBreeder.class);
	}

	public void mockPlayerFactory() {
		ServiceLocator.playerFactory = Mockito.mock(PlayerFactory.class);
	}
	
}
