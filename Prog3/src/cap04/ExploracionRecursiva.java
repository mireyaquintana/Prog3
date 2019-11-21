package cap04;

public class ExploracionRecursiva {

	private static String nombre = "Prueba";
	
	public static void main(String[] args) {
		prueba1();
		factorial();
		factorial2();
		prodConSuma();
		aLaLuna();
		System.out.println(fibonacci(5));
		//hanoi();
		busquedaBinaria();
	}
	
	private static void busquedaBinaria() {
		int[] v = {1, 2, 10, 11, 15, 17, 21, 43, 57, 83, 84, 85, 86, 87, 89, 110};
		int donde = busq(v, 87, 0, v.length-1);
		System.out.println(donde);
	}
	
	// Busca el valor valorBuscado en el vector v entre las posiciones ini y fin, ambas inclusive
	// Devuelve la posición del valor si existe, -1 si no existe
	// Funcionamiento: 
	// 		Calculamos la mitad
	//		Comparamos el valor buscado con el que hay en la mitad
	//			a) Son iguales - caso base: se devuelve
	//			b) El de la mitad es menor: buscar recursivsmente en la mitad superior
	//			c) El de la mitad es mayor: buscar recursivamente en la mitad inferior
	//		Caso base:
	private static int busq(int[] v, int valorBuscado, int ini, int fin) {
		if(ini>fin) {
			return -1;
		} else {
			int mitad = (ini + fin) / 2; // int devulve un entero (centro lig. a la izquierda)
			if(v[mitad]==valorBuscado) {
				// Caso base encontrado
				return mitad;
			} else if (v[mitad]<valorBuscado) {
				return busq(v, valorBuscado, mitad+1, fin);
			} else {
				return busq(v, valorBuscado, ini, mitad-1);
			}
		}
		
	}
	
	// fib(n) = fib(n-1) + fib(n-2)
	// si n=1 fib(1) = 1
	// si n=2 fib(2) = 1
	private static int fibonacci(int n) {
		if(n==1) {
			return 1;
		} else if(n==2) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	private static void hanoi() {
		// Resolver por ejemplo tamaño 3
		hanoiRec(3, 'a', 'c', 'b');
	}
	
	private static void hanoiRec(int tam, char origen, char destino, char auxiliar) {
		if(tam==1) { // Caso base
			
		}
		//Caso recursivo
		hanoiRec(tam-1, origen, auxiliar, destino);
		System.out.println("Muevo disco " + tam + " de " + origen + " a " + destino);
		hanoiRec(tam-1, auxiliar, destino, origen);
	}
	
	private static void aLaLuna() {
		calcDobleces(0.0001, 384400000.0, 0); // grosor de folios, distancia a la Luna, numero de dobleces
		
	}
	
	private static void calcDobleces(double grosor, double distancia, int numDobleces) {
		if(grosor>=distancia) {
			System.out.println(numDobleces);
		} else {
			calcDobleces(grosor*2, distancia, numDobleces+1);
		}
	}
	
	public static void prodConSuma() {
		System.out.println(producto(6, 5));
	}
	
	//Calcula el producto de m y n utilizando solo sumas
	// Definición: m*n = m + m*(n-1)	producto(m,n) = m + producto(m,n-1)
	//	0 si n==0
	private static int producto(int m, int n) {
		if(n==0) {
			return 0;
		} else {
			return m + producto(m, n-1);
		}
	}
	
	private static void prueba1() {
		int n = 5;
		
		f(1);
		
	}
	// Recursividad
	private static void f(int n) {
		if(n<1000) {
			System.out.println("antes " + n);
			f(n+1); 
			System.out.println("después " + n);
		}
	}
	// Iterativo
	private static void fIterativo(int n) {
		while(n<1000) {
			System.out.println(n);
			n = n + 1;
		}
	}
	
	public static void factorial2() {
		fact2(0, 2, 6);
	}
	
	private static void fact2(int nInicial, long valorInicial, int nFinal) {
		if(nInicial==nFinal) {
			System.out.println(valorInicial);
		} else {
			fact2(nInicial+1, valorInicial*(nInicial+1), nFinal);
		}
	}
	public static void factorial() {
		System.out.println(fact(15));
	}
	
	private static long fact(int n) {
		if(n==0) {
			return 1;
		} else {
			return n * fact(n-1);
		}
	}
}
