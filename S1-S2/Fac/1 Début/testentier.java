import scite.*;

public class testentier {
    public static void main(String[] args) {
        int nb = saisieStrictPositif();
        saisiePair(nb);
    }

    static int saisieStrictPositif() {
        int nb;
        Ecran.afficher("Saisir un nombre entier strictement positif : ");
        nb = Clavier.saisirInt();
        while (nb <= 0) {
            Ecran.afficherln("ERREUR de saisie ! ");
            Ecran.afficher("Saisir un nombre entier strictement positif : ");
            nb = Clavier.saisirInt();
        }
        return nb;
    }
    static int saisiePair(int nb) {
        if (nb % 2 == 0) {
            Ecran.afficherln("L'entier est pair");
        } else {
            Ecran.afficherln("L'entier est impair");
        }
        Ecran.afficherln(nb);
        return nb;
    }
}