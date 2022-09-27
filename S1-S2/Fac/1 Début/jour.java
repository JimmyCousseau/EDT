import scite.*;

public class jour {
    public static void main(String[] args) {
        int j = 0, n = 0;
        while (j < 1 || j > 7 || n < 0) {
            Ecran.afficherln("Ecrit le chiffre correspondant à ton jour (1 = lundi, etc.");
            j = Clavier.saisirInt();
            if (j < 1 || j > 7 || n < 0) {
                Ecran.afficherln("Erreur, entrée incorrect");
            } else {
                Ecran.afficherln("Combien de jours suivant ce jour ?");
                n = Clavier.saisirInt();
                j = (j + n) % 7;
                if (n < 0) {
                    Ecran.afficherln("Erreur, entrée incorrect");
                }
            }
        }
        switch (j) {
            case 1:
                Ecran.afficherln("Lundi");
                break;
            case 2:
                Ecran.afficherln("Mardi");
                break;
            case 3:
                Ecran.afficherln("Mercredi");
                break;
            case 4:
                Ecran.afficherln("Jeudi");
                break;
            case 5:
                Ecran.afficherln("Vendredi");
                break;
            case 6:
                Ecran.afficherln("Samedi");
                break;
            default:
                Ecran.afficherln("Dimanche");
                break;
        }
    }
}