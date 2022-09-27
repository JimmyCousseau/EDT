import scite.*;

public class entierpair {
    public static void main(String[] args) {
        Ecran.afficherln("Entrez n pour afficher l'intervale entre [1 ; n]");
        int n = Clavier.saisirInt();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                Ecran.afficherln(i);
            }
        }
    }
}
