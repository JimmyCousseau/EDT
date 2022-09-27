import scite.*;

public class aireperimetre{
	public static void main(String args[]){
		double rayon, aire, perimetre;
		Ecran.afficher("Saisir le rayon du cercle");
		rayon = Clavier.saisirDouble();
		aire = 3.14 * rayon * rayon;
		perimetre = 6.28 * rayon;
		System.out.print("L'aire est de " + aire + " et le perimetre est de " + perimetre);
	}
}