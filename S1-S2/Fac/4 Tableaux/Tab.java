import scite.*;

public class Tab {
    public static void main(String[] args) {
        int[] tableau = new int[100];
        int saisie = 1;
        for (int i = 0; i < tableau.length - 1; i++) {
            if (saisie < 0) {
                tableau[i] = -1;
            } else {
                Ecran.afficherln("Insère une nouvelle valeur > 0");
                saisie = Clavier.saisirInt();
                if (saisie < 0) {
                    tableau[i] = -1;
                } else {
                    tableau[i] = saisie;
                }
            }
        }
        for (int i = 0; i < tableau.length - 1; i++) {
            if (i % 10 == 0) {
                Ecran.afficherln(" " + tableau[i]);
            }
            else{
                Ecran.afficher(" " + tableau[i]);
            }
        }
    }
}
