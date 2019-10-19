package cap01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUtilsString {
	
	@Test
	public void testQuitarTabsYSaltosLinea() {
		String prueba = "Hola\nEsto es un string con tres líneas\ny\tvarios\ttabuladores.";
		String prueba2 = "Hola#Esto es un string con tres líneas#y|varios|tabuladores.";
		assertEquals(prueba2, UtilsString.quitarTabsYSaltosLinea(prueba));
		/*if (prueba2.equals(UtilsString.quitarTabsYSaltosLinea(prueba))) {
			//System.out.println( "OK" );
			assertTrue(true);
		} else {
			System.out.println( "FAIL" );
			//fail();
		}*/
	}
	
	// Prueba de null de quitarTabsYSaltosLinea
		@Test
		public void testQuitarTabsYSaltosLineaNull() {
			assertNull( UtilsString.quitarTabsYSaltosLinea(null) );
		}

		// Pruebas básicas de wrapString
		@Test
		public void testWrapString() {
			assertEquals( "And...", UtilsString.wrapString( "Andoni", 3) );
			assertEquals( "Andoni", UtilsString.wrapString( "Andoni", 6) );
			assertEquals( "Andoni", UtilsString.wrapString( "Andoni", 8) );
			assertEquals( "", UtilsString.wrapString( "", 8) );
			assertEquals( "", UtilsString.wrapString( "", 0) );
			assertEquals( "...", UtilsString.wrapString( "Andoni", 0) );
		}
		
		// Pruebas de wrapString con valores extremos
		@Test
		public void testWrapString2() {
			assertEquals( null, UtilsString.wrapString( null, 3) );
			assertEquals( null, UtilsString.wrapString( null, -1) );
		}
			
		// Pruebas de excepción de wrapString (método 1)
		@Test
		public void testWrapStringExc() {
			try {
				// Si entra en el try estara mal porque tiene que saltar la excepcion
				UtilsString.wrapString( "Andoni", -5 );
				fail();
			} catch (IndexOutOfBoundsException e) {
				// Ok
			}
		}

		// Pruebas de excepción de wrapString (método 2)
		// Otra manera de probar excepción para wrapString (alternativa - hace lo mismo que la anterior, de otra manera)
		@Test(expected=IndexOutOfBoundsException.class)
		public void testWrapStringExc2() {
			UtilsString.wrapString( "Andoni", -5 );
		}


}
