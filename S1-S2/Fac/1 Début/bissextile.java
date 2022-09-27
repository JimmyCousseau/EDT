import scite.*;

public class bissextile {
    public static void main(String[] args) {
        Ecran.afficher("Quelle est votre année ?");
        int annee = Clavier.saisirInt();
        if (annee % 400 == 0) {
            Ecran.afficher("L'année est bissextile");
        }
        else if (annee % 100 != 0 && annee % 4 == 0) {
            Ecran.afficher("L'année est bissextile");
        }
        else {
            Ecran.afficher("L'année n'est pas bissextile");
        }
    }
}
