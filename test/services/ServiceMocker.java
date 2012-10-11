package services;

import org.junit.rules.ExternalResource;
import org.mockito.Mockito;

public class ServiceMocker extends ExternalResource {

	private HorseBreeder originalHorseBreeder;
	
	public static ServiceMocker create() {
		return new ServiceMocker();
	}
	
	@Override
	protected void before() throws Throwable {
		originalHorseBreeder = ServiceLocator.horseBreeder;
	}

	@Override
	protected void after() {
		ServiceLocator.horseBreeder = originalHorseBreeder;
	}
	
	public void mockRandomHorseBreeder() {
		ServiceLocator.horseBreeder = Mockito.mock(HorseBreeder.class);
	}
	
}
