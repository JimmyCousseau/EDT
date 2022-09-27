import scite.*;

public class echelle {
    public static void main(String[] args) {
        Ecran.afficherln("De combiens de points de largeur veut-tu ton échelle ?");
        int n = Clavier.saisirInt();
        Ecran.afficherln("De combiens de hauteur veut-tu que ton échelle fasse ?");
        int h = Clavier.saisirInt();
        for (int i = 0; i < h; i++) {
            Ecran.afficher("*");
            for (int y = 0; y < n; y++) {
                Ecran.afficher(".");
            }
            Ecran.afficherln("*");
        }
    }
}
