package practica04.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import practica04.main.Recursividad;

public class RecursividadTest {

	@Test
	public void invertirFraseTest() {
		assertEquals("aloH", Recursividad.invertirFrase("Hola"));
	}

	
}
