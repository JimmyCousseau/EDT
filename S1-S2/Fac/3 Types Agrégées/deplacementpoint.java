import scite.*;

public class deplacementpoint {
    public static void main(String[] args) {
        Ecran.afficherln("Rentrez les positions du point x et y");
        point pt = new point();
        pt.x = Clavier.saisirInt();
        pt.y = Clavier.saisirInt();
        deplacement(pt.x, pt.y);
    }

    static class point {
        int x, y;
    }

    static void deplacement(int x, int y) {
        Ecran.afficherln("Voici les coordonnées : (" + x + ";" + y + ")");
        char c = Clavier.saisirChar();
        switch (c) {
        case 'e':
            if (x + 10 > 799) {
                Ecran.afficherln("Erreur, sortie de l'écran");
            } else {
                x += 10;
            }
            deplacement(x, y);
            break;

        case 'o':
            if (x - 10 < 0) {
                Ecran.afficherln("Erreur, sortie de l'écran");
            } else {
                x -= 10;
            }
            deplacement(x, y);
            break;

        case 'n':
            if (y + 10 > 599) {
                Ecran.afficherln("Erreur, sortie de l'écran");
            }
            else {
                y += 10;
            }
            deplacement(x, y);
            break;

        case 's':
            if (y - 10 < 0) {
                Ecran.afficherln("Erreur, sortie de l'écran");
            }
            else {
                y = y - 10;
            }
            deplacement(x, y);
            break;

        default:
            Ecran.afficherln("Erreur de saisie de lettre, recommencez");
            deplacement(x, y);
            break;
        }
    }
}
