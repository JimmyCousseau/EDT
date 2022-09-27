package geometria;

import java.lang.Math;

public class Circulo {
	
	public static final int RADIO_POR_DEFECTO = 5;
	
	private Punto centro;
	private int radio;
	
	
	public Circulo(Punto centro, int radio) {
		this.centro = new Punto(centro);
		this.radio = radio;
	}
	
	public Circulo() {
		this(new Punto(), RADIO_POR_DEFECTO);
	}
	
	public Circulo(Circulo circulo) {
		this(circulo.getCentro(), circulo.getRadio());
	}
	
	
	// Métodos de consulta
	
	public void desplazar(int incrementoX, int incrementoY) {
		this.centro.desplazar(incrementoX, incrementoY);
	}
	
	public void escalar(double porcentaje) {
		this.radio *= porcentaje / 100;
	}
	
	public double getPerimetro() {
		return 2*Math.PI*radio;
	}
	public Punto getCentro() {
		return centro;
	}
	public void setCentro(Punto centro) {
		this.centro = centro;
	}
	public int getRadio() {
		return radio;
	}
	public void setRadio(int radio) {
		this.radio = radio;
	}
	
}
