import scite.*;

class Age {
// calcul de l'age a partir de l'annee de naissance
	public static void main (String args[]) {
		// Declaration des donnees
		int AUJOURDHUI = 2021;
		String prenom;
		int naissance;
		// Declaration des resultats
		int age;
		
		// saisie des donnees (on suppose que les donnees sont valides)
		Ecran.afficher("Quel est votre prenom ? ");
		prenom = Clavier.saisirString();
		System.out.println("Quelle est votre annee de naissance ? ");
		naissance = Clavier.saisirInt();
		
		// Calcul des resultats
		age = AUJOURDHUI-naissance;
		
		//affichage des resultats
		System.out.print("Bonjour " + prenom + ".\n");
		System.out.print("Vous avez " + age + " an(s) cette annee.");
	}
}
