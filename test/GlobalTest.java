import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static services.ServiceLocator.horseBreeder;
import static services.ServiceLocator.playerFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import play.Application;
import services.ServiceMocker;

@RunWith(MockitoJUnitRunner.class)
public class GlobalTest {

	@Rule
	public ServiceMocker serviceMocker = ServiceMocker.create();
	
	@Mock
	private Application application;
	
	@Before
	public void setUp() {
		serviceMocker.mockHorseBreeder();
		serviceMocker.mockPlayerFactory();
	}
	
	@Test
	public void onStart_BreedsAvailableHorses() {
		new Global().onStart(application);
		
		verify(horseBreeder).breedAvailableHorses();
	}
	
	@Test
	public void onStart_WhenInTestMode_DoenstDoAnyStartupStuff() {
		when(application.isTest()).thenReturn(true);
		
		new Global().onStart(application);
		
		Mockito.verifyZeroInteractions(horseBreeder, playerFactory);
	}

}
