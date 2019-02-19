import java.math.BigInteger;

public class Ejer1Algo2 {
	
	public static BigInteger euclides(BigInteger dividendo1, BigInteger divisor2){
		
		if((divisor2.compareTo(dividendo1) > 0)){			//Ordena los valores (numero1 mayor, numero 2 menor)
			BigInteger auxiliar = dividendo1;
			dividendo1 = divisor2;
			divisor2 = auxiliar;
		}
			
		BigInteger bigInt0 = new BigInteger("0");
		BigInteger bigInt1 = new BigInteger("1");
			
		if((divisor2.compareTo(bigInt0) == 0) || (dividendo1.compareTo(bigInt0) == 0)){	//Si cualquiera de los números es 0, su mcd es 0
			return bigInt0;
		}
			
		BigInteger cociente;		//Entero de mayor valor por el que se multiplica a numero2 cuyo resultado es menor que numero1
		BigInteger producto;							
		BigInteger resto = new BigInteger("1");		//Diferencia entre numero1 y el producto de la iteracción actual
	
		
		if (dividendo1.divide(divisor2).compareTo(bigInt1) == 0) {
			return dividendo1;		// Si el cociente de dividirlos inicialmente es 0 es que son el mismo número
		} else if (dividendo1.remainder(divisor2).compareTo(bigInt0) == 0){
			return divisor2;		// Si da división justa inicialmente es que son múltiplo y mcd el divisor
		}
		
		
		while(resto.compareTo(bigInt0) > 0){			//Número máximo de posibles iteraciones = la mitad del menor
			cociente = dividendo1.divide(divisor2);	//Dividie y trunca el valor entero del resultado
			producto = divisor2.multiply(cociente);
			resto = dividendo1.subtract(producto);	//Diferencia entre numero1 y el producto de numero2 por el entero de mayor
			dividendo1 = divisor2;
			
			if (resto.compareTo(bigInt0) == 0) {
				return divisor2;
			}
			
			divisor2 = resto;					
		}
		
		return divisor2;
	}
	
}