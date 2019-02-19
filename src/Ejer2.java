import java.math.BigInteger;


public class Ejer2 {

	public static boolean compruebaPrimo(BigInteger numero1) {		
		boolean esPrimo = true;
		BigInteger bigInt0 = new BigInteger("0");
		BigInteger bigInt1 = new BigInteger("1");
		BigInteger bigInt2 = new BigInteger("2");
		
		for (BigInteger j = new BigInteger("2"); j.compareTo(numero1.divide(bigInt2)) == -1; j = j.add(bigInt1)) {
			BigInteger resto = numero1.remainder(j);				
			if (resto.compareTo(bigInt0)  == 0) {
				esPrimo = false;						
			}
		}	
		return esPrimo;
	}
	
}
