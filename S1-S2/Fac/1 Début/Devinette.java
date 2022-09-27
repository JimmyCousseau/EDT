import scite.*;

public class Devinette {
    public static void main(String[] args) {
        final char mystere = 'p';
        int i = 0;
        while (i < 100) {
            Ecran.afficherln("Choisissez une voyelle");
            char choix = Clavier.saisirChar();
            if (choix == mystere) {
                Ecran.afficherln("Bravo tu as trouvé");
                i = 3;
            }
            else {
                i += 1;
                if (i == 3) {
                    Ecran.afficherln("Tu as perdu, tu as dépassé les trois tentatives :o");
                }
                else {
                    Ecran.afficherln("Ce n'est pas ça");
                    Ecran.afficherln("Tu as fait " + i + "tentatives, si tu arrives à trois tu perds :o");
                }
            }
        }
    }
}
