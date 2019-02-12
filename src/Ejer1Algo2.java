public class Ejer1Algo2 {
	
		public int euclides(int numero1, int numero2){
			
		if(numero2>numero1){			//Ordena los valores (numero1 mayor, numero 2 menor)
			int auxiliar=numero1;
			numero1=numero2;
			numero2=auxiliar;
		}
		
		if(numero2!=0 || numero1!=0 ){	//Si cualquiera de los números es 0, su mcd es 0
			return 0;
		}
		
		int numero;						//Entero de mayor valor por el que se multiplica a numero2 cuyo resultado es menor que numero1
		int diferencia;					//Diferencia entre numero1 y el producto de la iteracción actual
		int diferenciaAnterior = 0;		//Diferencia entre numero1 y el producto de la iteracción previa a la actual

		for(int i=numero2/2; i>0; i++){	//Número máximo de posibles iteraciones = la mitad del menor
				numero=numero1/numero2;	//Dividie y trunca el valor entero del resultado
				diferencia=numero1-numero2*numero;	//Diferencia entre numero1 y el producto de numero2 por el entero de mayor
				if(diferencia==0){
					if(diferenciaAnterior==0){
						return numero2;	//Si diferenciaAnterior es 0, la primera iteración nos da el mcd que es el propio valor de numero2
					} else {
						return diferenciaAnterior;
					}
				} else {
					numero1=numero2;
					numero2=diferencia;		
				}
		}
		
	}

}