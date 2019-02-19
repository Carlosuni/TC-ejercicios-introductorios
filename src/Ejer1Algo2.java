import java.math.BigInteger;

public class Ejer1Algo2 {
	
	public static BigInteger euclides(BigInteger numero1, BigInteger numero2){
		
		if((numero2.compareTo(numero1) > 0)){			//Ordena los valores (numero1 mayor, numero 2 menor)
			BigInteger auxiliar = numero1;
			numero1 = numero2;
			numero2 = auxiliar;
		}
			
		BigInteger bigInt0 = new BigInteger("0");
		BigInteger bigInt1 = new BigInteger("1");
		BigInteger bigInt2 = new BigInteger("2");
			
		if((numero2.compareTo(bigInt0) == 0) || (numero1.compareTo(bigInt0) == 0)){	//Si cualquiera de los números es 0, su mcd es 0
			return bigInt0;
		}
			
		BigInteger cociente;								//Entero de mayor valor por el que se multiplica a numero2 cuyo resultado es menor que numero1
		BigInteger producto;							
		BigInteger resto;							//Diferencia entre numero1 y el producto de la iteracción actual
		BigInteger restoAnterior = new BigInteger ("0");				//Diferencia entre numero1 y el producto de la iteracción previa a la actual
	
		for(BigInteger i = new BigInteger("0"); i.compareTo(numero2.divide(bigInt2)) == -1; i = i.add(bigInt1)){			//Número máximo de posibles iteraciones = la mitad del menor
			cociente = numero1.divide(numero2);	//Dividie y trunca el valor entero del resultado
			producto = numero2.multiply(cociente);
			resto = numero1.subtract(producto);	//Diferencia entre numero1 y el producto de numero2 por el entero de mayor
	
			if(resto.compareTo(bigInt0) == 0){ 
				if(restoAnterior.compareTo(bigInt0) == 0){ 
					return numero2;		//Si diferenciaAnterior es 0, la primera iteración nos da el mcd que es el propio valor de numero2
				} else {
					return restoAnterior;
				}
			} else {
				numero1 = numero2;
				numero2 = resto;		
			}
		}
		
		return restoAnterior;
	}
	
}