import java.util.Random;
import scite.*;

public class allumettes {
    public static void main(String[] args) {
        int min = 1, max = 3;
        int allumettes = 17;
        int choice;
        Random random = new Random();
        int round = 0;

        while (allumettes > 0) {
            if (round == 0) {
                Ecran.afficherln("Il reste actuellement : ");
                for (int i = 0; i < allumettes; i++) {
                    Ecran.afficher("|");
                }
                Ecran.afficherln("allumettes dans le jeu");
                Ecran.afficherln("C'est votre tour\nCombien d'allumettes voulez-vous enlever ? 1 ? 2 ? ou 3 ?");
                choice = Clavier.saisirInt();
                round = 1;
                Ecran.afficherln("C'est au tour de l'ordinateur de jouer");
            } else {
                choice = random.nextInt(max + min);
                round = 0;
            }

            switch (choice) {
                case 1:
                    allumettes -= 1;
                    break;
                case 2:
                    allumettes -= 2;
                    break;
                case 3:
                    allumettes -= 3;
                    break;
                default:
                    if (round == 0) {
                        round = 1;
                    }
                    else {
                        Ecran.afficherln("La valeur est fausse, recommence");
                        round = 0;
                    }
                    break;
            }
            if (allumettes <= 0) {
                if (round == 0) {
                    Ecran.afficherln("C'est l'ordinateur qui a gagné");
                } else {
                    Ecran.afficherln("Ah bah non, tu viens de gagner la partie !");
                }
                Ecran.afficherln("Voulez-vous rejouer ? Oui : 1 ; Non ; 0");
                round = Clavier.saisirInt();
                if (round == 1) {
                    round = 0;
                    allumettes = 17;
                }
            }
        }
    }
}