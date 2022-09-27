import scite.*;

public class fleche {
    public static void main(String[] args) {
        Ecran.afficherln("De quelle hauteur veux-tu que le flèche fasse ?");
        int ht = Clavier.saisirInt();
        if (ht >= 3) {
            for (int i = 0; i < ht; i++) {
                for (int j = 0; j < ht - i; j++) {
                    Ecran.afficher(" ");
                }
                for (int j = 0; j < i + 1 + i; j++) {
                    Ecran.afficher("*");
                }
                for (int j = 0; j < ht - i; j++) {
                    Ecran.afficher(" ");
                }
                Ecran.afficherln("");
            }
            for (int i = 0; i < ht; i++) {
                for (int j = 0; j < 3; j++) {
                    Ecran.afficher(" ");
                }
                for (int j = 0; j < 2 * ht - 5; j++) {
                    Ecran.afficher("*");
                }
                for (int j = 0; j < 3; j++) {
                    Ecran.afficher(" ");
                }
                Ecran.afficherln("");
            }
        } else {
            Ecran.afficherln("Erreur de saisie");
        }
    }
}
