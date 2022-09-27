import scite.*;

public class nombrepremier {
    public static void main(String[] args) {
        Ecran.afficher("Entre un nombre entier : ");
        int j = Clavier.saisirInt();
        boolean c = false;

        if (j == 2 || j == 1) {
            Ecran.afficherln("Le nombre est premier");
        }
        else if ( j % 2 == 0) {
            Ecran.afficherln("Le nombre n'est pas premier");
        }
        else {
            for (float i = 3; i < j; i = i + 2) {
                if (j % i == 0) {
                    c = true;
                }
            }
            if (c) {
                Ecran.afficherln("Le nombre n'est pas premier");
            }
            else {
                Ecran.afficherln("Le nombre est premier");
            }
        }
    }
}