import java.math.BigInteger;
import java.util.Vector;

import auxClasses.DivisorAlgo1;

public class Ejer1Algo1_backup {

	public static BigInteger calcMaxComDiv(BigInteger numero1, BigInteger numero2) {
		BigInteger maxComDivisor = new BigInteger("1");
		
		Vector<BigInteger> primos1 = new Vector<BigInteger>();
		primos1 = calcPrimos(numero1);			
		System.out.println("Números primos posibles divisores del primer número (" + numero1 + "):");
		printBigIntVec(primos1);
		
		Vector<DivisorAlgo1> factores1 = new Vector<DivisorAlgo1>(); 
		factores1 = calcFactores(numero1, primos1);
		System.out.println("Factores del primer número (" + numero1 + "):");
		printDivAlgo1(factores1);
	
		Vector<BigInteger> primos2 = new Vector<BigInteger>();
		primos2 = calcPrimos(numero2);	
		System.out.println("Números primos posibles divisores del segundo número (" + numero2 + "):");
		printBigIntVec(primos2);
	
		Vector<DivisorAlgo1> factores2 = new Vector<DivisorAlgo1>(); 
		factores2 = calcFactores(numero2, primos2);
		System.out.println("Factores del segundo número (" + numero2 + "):");
		printDivAlgo1(factores2);
				
		maxComDivisor = calcComDiv(numero1, numero2, factores1, factores2);
		
		return maxComDivisor;
	}


	public static Vector<BigInteger> calcPrimos(BigInteger numero1) {
		Vector<BigInteger> primos = new Vector<BigInteger>();
		
		for (int i = 2; i < (numero1.intValue() / 2); ++i ) {
			if (primos.size() == 0) {
				primos.add(BigInteger.valueOf(i));
			} else {
				boolean esPrimo = true;
				
				for (int j = 0; j < primos.size(); ++j) {
					int resto = i % primos.get(j).intValue();				
					if (resto  == 0) {
						esPrimo = false;						
					}
				}
				
				if (esPrimo) primos.add(BigInteger.valueOf(i));
			}		
		}
	
		return primos;
	}
	
	
	private static Vector<DivisorAlgo1> calcFactores(BigInteger numero, Vector<BigInteger> primos) {
		Vector<DivisorAlgo1> factores = new Vector<DivisorAlgo1>();
		factores.add(new DivisorAlgo1());
		BigInteger auxDiv = BigInteger.valueOf(numero.intValue());
		
		for (int i = 0; i < primos.size(); ++i) {
			BigInteger primo = primos.get(i);
			BigInteger resto = auxDiv.remainder(primo);		
//			System.out.println("Probando factores con primo " + primo + " y número " + numero);

			while (resto.equals(BigInteger.valueOf(0))) {
				factores.add(new DivisorAlgo1(primo, false));
				auxDiv = auxDiv.divide(primo);
				resto = auxDiv.remainder(primo);
			}			
		}	
		
		return factores;
	}
	
	
	private static BigInteger calcComDiv(BigInteger numero1, BigInteger numero2, Vector<DivisorAlgo1> factores1,
			Vector<DivisorAlgo1> factores2) {
		BigInteger maxComDiv = new BigInteger("1");
		
		for (int i = 0; i < factores1.size(); ++i) {
			for (int j = 0; j < factores2.size(); ++j) {
				if (factores1.get(i).getValor().intValue() == factores2.get(j).getValor().intValue() && 
						!factores1.get(i).isUsado() && !factores2.get(j).isUsado()) {
					maxComDiv = maxComDiv.multiply(factores1.get(i).getValor());
					factores1.get(i).setUsado(true);
					factores2.get(j).setUsado(true);
				}
			}			
		}
				
		return maxComDiv;
	}

	
	private static void printBigIntVec (Vector<BigInteger> bigIntVec) {
		for (int i = 0; i < bigIntVec.size(); ++i) {
			System.out.println(bigIntVec.get(i).intValue());
		}		
	}
	
	private static void printDivAlgo1 (Vector<DivisorAlgo1> bigIntVec) {
		for (int i = 0; i < bigIntVec.size(); ++i) {
			System.out.println(bigIntVec.get(i).getValor().intValue());
		}		
	}
	
}