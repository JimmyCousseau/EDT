import scite.*;

public class tabledemultiplication {
    public static void main(String[] args) {
        Ecran.afficher("Pour quel nombre veut-tu voir la table de multiplication ?");
        int nombre = Clavier.saisirInt();
        if (nombre < 10 && nombre > 1) {
            Ecran.afficherln("Table du " + nombre + " : ");
            for (int i = 1; i <= 10; i++) {
                Ecran.afficherln(nombre + " x " + i + " = " + nombre * i);
            }
        }
        else {
            Ecran.afficherln("Erreur de saisie, rentre un nombre compris entre 2 et 9");
        }
    }
}
