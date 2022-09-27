package pruebas;

import geometria.Punto;

public class PruebaPunto {
	public static void main(String[] args) {
		//Declara la variable local punto1 y asigna un objeto Punto en las coordenadas (1, 3). 
		Punto punto1 = new Punto(1,3);
		//Muestra el valor de las propiedades x e y por la consola.
		printInfo(punto1, 1);
		
		//Declara la variable punto2 y asigna un objeto Punto construido a partir del constructor sin parámetros. 
		Punto punto2 = new Punto();
		//Muestra por la consola el valor de sus propiedades.
		printInfo(punto2, 2);
		
		//Declara la variable punto3 y asigna un objeto Punto construido a partir del punto1 (constructor de copia). 
		Punto punto3 = new Punto(punto1);
		//Muestra sus propiedades por la consola
		printInfo(punto3, 3);
		
		//Declara la variable punto4 y asígnale la variable punto2.
		Punto punto4 = punto2;
		
		//Modifica las coordenadas de punto2 y 
		punto2.desplazar(2, 1);
		//muestra el valor de las propiedades por la consola. 
		printInfo(punto2, 2);
		//Muestra también el valor de las propiedades del punto4. Observa que tienen los mismos valores porque son referencias al mismo objeto (aliasing).
		printInfo(punto4, 4);
	}

	private static void printInfo(Punto punto, int number) {
		final String message = String.format("punto%d: (x=%d, y=%d)", number, punto.getX(), punto.getY());
		System.out.println(message);

	}
}
