package practica01;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import practica01.ListaDeReproduccion;

public class ListaDeReproduccionTest {
	private ListaDeReproduccion lr1;
	private ListaDeReproduccion lr2;
	private final File FIC_TEST1 = new File( "test/res/No del grupo.mp4" ); 
	private final File FIC_TEST2 = new File( "test/res/Fichero erroneo Pentatonix.mp4" ); 
	
	@Before
	public void setUp() throws Exception {
		lr1 = new ListaDeReproduccion();
		lr2 = new ListaDeReproduccion();
		lr2.add( FIC_TEST1 );
	 } 
	
	@After
	public void tearDown() {
		lr2.clear();
	} 
	
	// Chequeo de error por getFic(índice) por encima de final
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet_Exc1() {
		lr1.getFic(0); // Debe dar error porque aún no existe la posición 0
	}

	// Chequeo de error por get(índice) por debajo de 0
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet_Exc2() {
		lr2.getFic(-1); // Debe dar error porque aún no existe la posición -1
	}

	// Chequeo de funcionamiento correcto de get(índice)
	@Test public void testGet() {
		assertEquals( FIC_TEST1, lr2.getFic(0) ); // El único dato es el fic-test1
	} 
	
	// Chequeo de intercambio de elementos
	@Test
	public void testIntercambia(){
		lr1.add(FIC_TEST1); //0
		lr1.add(FIC_TEST2); //1
		lr1.intercambia(0, 1);
		assertEquals(FIC_TEST2, lr1.getFic(0));
			
	}
	
	// Chequeo de añadido y borrado de elementos
	@Test
	public void testAddRemove(){
		// Añadimos el fichero a la lista lr1 que en principio está vacía
		lr1.add(FIC_TEST1);
		// Comprobamos que el tamaño de la lista es 1
		assertEquals(1, lr1.size());
		// Comprobamos que lr1 y lr2 tienen el mismo tamaño
		assertEquals(lr1.size(), lr2.size());
		lr1.removeFic(0);
		lr2.removeFic(0);
		assertEquals(0, lr1.size());
		assertEquals(0, lr2.size());
		assertEquals(lr1.size(), lr2.size());
		
	}
	// Chequeo de tamaño
	@Test
	public void testSize(){
		// Como lr1 está vacía y lr2 tiene 1 elemento, restamos 1 a lr2 y el tamaño 
		// de ambas listas es el mismo
		assertEquals(lr1.size(), lr2.size()-1);
	}
	
	@Test 
	public void addCarpetaTest() {
		String carpetaTest = "test/res/";
		String filtroTest = "*Pentatonix*.mp4"; 
		
		ListaDeReproduccion lr = new ListaDeReproduccion();
		lr.add( carpetaTest, filtroTest );
		fail( "Método sin acabar" );
	} 

	
}
