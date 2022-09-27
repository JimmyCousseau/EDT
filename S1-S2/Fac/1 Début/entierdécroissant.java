import scite.*;

public class entierdécroissant {
    public static void main(String[] args) {
        Ecran.afficherln("Entrez n pour afficher l'intervale entre [1 ; n]");
        int n = Clavier.saisirInt();
        for (int i = 1; i <= n; i++) {
            Ecran.afficherln(n - i + 1);
        }
    }
}
