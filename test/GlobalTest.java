import static org.mockito.Mockito.verify;
import static services.ServiceLocator.horseBreeder;

import org.junit.Rule;
import org.junit.Test;

import services.ServiceMocker;

public class GlobalTest {

	@Rule
	public ServiceMocker serviceMocker = ServiceMocker.create();
	
	@Test
	public void onStart_BreedsAvailableHorses() {
		serviceMocker.mockRandomHorseBreeder();
		
		new Global().onStart(null);
		
		verify(horseBreeder).breedAvailableHorses();
	}
}
