package geometria;

public class Punto {
	//ATRIBUTOS
	private int x;
	private int y;
	
	//Métodos de consulta y establecimiento
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//CONSTRUCTORES
	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Punto() {
		this(0,0);
	}
	
	public Punto(Punto punto) {
		this(punto.getX(), punto.getY());
	}
	
	//MÉTODOS
	public void desplazar(int desplX, int desplY) {
		x += desplX;
		y += desplY;
	}
	
}
