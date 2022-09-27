package geometria;

public class Rectangulo {

	private int ladoX;
	private int ladoY;
	private Punto verticeII;

	public Rectangulo(int ladoX, int ladoY, Punto origin) {
		this.ladoX = ladoX;
		this.ladoY = ladoY;
		this.verticeII = new Punto(origin);
	}
	
	public Rectangulo(Punto verticeII, Punto verticeSD) {
		this.ladoX = verticeSD.getX() - verticeII.getX();
		this.ladoY = verticeSD.getY() - verticeII.getY();
		this.verticeII = new Punto(verticeII);
	}
	
	public void desplazar(int x, int y) {
		verticeII.desplazar(x, y);
	}

	public void escalar(double porcentaje) {
		ladoX *= porcentaje / 100;
		ladoY *= porcentaje / 100;
	}
	
	
	public int getPerimetro() {
		return ladoX * ladoY;
	}
	public Punto getVerticeII() {
		return new Punto(verticeII);
	}
	public Punto getVerticeID() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY());
	}
	public Punto getVerticeSI() {
		return new Punto(verticeII.getX(), verticeII.getY() + ladoY);
	}
	public Punto getVerticeSD() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY() + ladoY);
	}
	public int getLadoX() {
		return ladoX;
	}
	
	public int getLadoY() {
		return ladoY;
	}
}
