import scite.*;

public class pyramides {
    public static void main(String[] args) {
        Ecran.afficherln("Saisissez le nombre de briques que vous avez");
        int nbbriquestot = Clavier.saisirInt();
        int restbriques = 0, hauteur = 0, nbbriquesut = 0;

        for (int i = 1; i < nbbriquestot; i++) {
            if (nbbriquestot > 0) {
                nbbriquestot = nbbriquestot - i * i;
                nbbriquesut += i * i;
                hauteur += 1;
            }
        }
        restbriques = nbbriquestot;
        Ecran.afficherln("Hauteur de la pyramide : " + hauteur);
        Ecran.afficherln("Nombre de briques utilisées : " + nbbriquesut);
        Ecran.afficherln("Nombre de briques restantes : " + restbriques);
    }
}