package pruebas;

import geometria.Circulo;
import geometria.Punto;

public class PruebaCirculo {

	public static void main(String[] args) {

		Punto punto1 = new Punto(2, 3);

		Circulo circulo1 = new Circulo(punto1, 3);
		printInfo(circulo1, 1);

		Circulo circulo2 = new Circulo();
		printInfo(circulo2, 2);

		Circulo circulo3 = new Circulo(circulo1);
		printInfo(circulo3, 3);

		circulo3.escalar(300);
		printInfo(circulo3, 3);
		
	}
	
	private static void printInfo(Circulo circulo, int number) {
		System.out.println(String.format("Circulo%d: centro=(%d, %d) | radio=%d | perimetre = %d", 
				number, circulo.getCentro().getX(), circulo.getCentro().getY(), circulo.getRadio(),
				circulo.getPerimetro()));
	}

}
