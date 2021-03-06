import java.math.BigInteger;

/**
 * 
 */

/**
 * @author Carlos Dumont & Luis Monge
 *
 */
public class MainLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		System.out.println("--=TEORÍA AVANZADA DE LA COMPUTACIÓN: EJERCICIOS INTRODUCTORIOS=--");		
		System.out.println("- EJERCICIO PRÁCTICO 1:");
		BigInteger numero1 = new BigInteger(args[0]);
		BigInteger numero2 = new BigInteger(args[1]);
		BigInteger bigInt0 = new BigInteger("0");
		
		System.out.println("Cálculo de común divisor entre " + numero1 + " y " + numero2);
		System.out.println("-- ALGORITMO 1:");
		BigInteger maxComDiv1 = Ejer1Algo1.calcMaxComDiv(numero1, numero2);
		System.out.println("El máximo común divisor mediante el Algoritmo 1 (primos) es: " + maxComDiv1);
					
		System.out.println("-- ALGORITMO 2:");
		BigInteger maxComDiv2 = Ejer1Algo2.euclides(numero1, numero2);
		System.out.println("El máximo común divisor mediante el Algoritmo 2 (Euclides) es: " + maxComDiv2);
		
		System.out.println("- EJERCICIO PRÁCTICO 2:");
		if((numero1.compareTo(bigInt0) == 0)){	//Si el número introducido es 9 no tiene sentido el primo
			System.out.println("El número introducido (" + numero1.toString() + ") es cero");
		} else {
			boolean esPrimo = Ejer2.compruebaPrimo(numero1);
			if (esPrimo) {
				System.out.println("El número introducido (" + numero1.toString() + ") es primo");
			}else {
				System.out.println("El número introducido (" + numero1.toString() + ") no es primo");
			}
		}
	}

}
