package pruebas;

import geometria.Punto;
import geometria.Rectangulo;

public class PruebaRectangulo {

	public static void main(String[] args) {
		Rectangulo azul = new Rectangulo(2, 5, new Punto(3, 1));
		printTestResults(azul);

		azul.desplazar(0, -7);
		printTestResults(azul);
		
		azul.escalar(50);
		printTestResults(azul);
		
	}

	private static void printTestResults(Rectangulo azul) {
		final String message =  String.format("Rectangulo azul: verticeII=(%s, %s | ladoX= %s | ladoY= %s", azul.getVerticeII().getX(), azul.getVerticeII().getY(), 
				azul.getLadoX(), azul.getLadoY());
		System.out.println(message);
	}

}
