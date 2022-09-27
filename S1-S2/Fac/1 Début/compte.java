import scite.*;

public class compte {
    public static void main(String[] args) {
        float nombre, argent = 500;
        String choix = "bam";
        while (choix != "0") {
            Ecran.afficher("\nVous avez " + argent + "€ sur votre compte bancaire\n entrez 'r' pour faire un retrait");
            Ecran.afficher("Entrez 'd' pour faire un dépôt ou '0' pour arrêter le programme");
            choix = Clavier.saisirString();
            switch (choix) {
                case "r" :
                    Ecran.afficher("Combien d'euros voulez-vous retirer ?");
                    nombre = Clavier.saisirFloat();
                    argent = argent - nombre;
                    Ecran.afficher("Il vous reste " + argent + " sur votre compte bancaire");
                    break;
                case "d" :
                    Ecran.afficher("Combien d'euros voulez-vous déposer ?");
                    nombre = Clavier.saisirFloat();
                    argent = nombre + argent;
                    Ecran.afficher("Il vous reste" + argent + "sur votre compte bancaire");
                    break;
                case "0" :
                    Ecran.afficher("Le programme est arrêté, vous avez "+ argent + "sur votre compte bancaire");
                    choix = "0";
                    break;
                default :
                    Ecran.afficher("Erreur");
                    break;
            }
        }
    }
}
