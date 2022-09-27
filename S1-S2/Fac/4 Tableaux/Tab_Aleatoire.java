import scite.*;

public class Tab_Aleatoire {
    public static void main(String[] args) {
        int[] tableau = new int[100];
        for (int i = 0; i < tableau.length - 1; i++) {
            tableau[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < tableau.length - 1; i++) {
            if (i % 10 == 0 && i > 0) {
                Ecran.afficherln(" " + tableau[i]);
            } else {
                Ecran.afficher(" " + tableau[i]);
            }
        }
    }
}
