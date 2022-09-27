import java.util.Random;
import scite.*;

public class random3 {
    public static void main(String[] args) {
        int min = 10;
        int max = 50;
        Random random = new Random();
        int value1 = random.nextInt(max + min) + min;
        int value2 = random.nextInt(max + min) + min;
        char operand;
        int total, reponse;

        Ecran.afficher("Voulez-vous multiplier '*', diviser '/', additionner '+' ou soustraire '-' ? ");
        operand = Clavier.saisirChar();

        switch (operand) {
            case '+':
                total = value1 + value2;
                Ecran.afficher("Quelle est le résultat de : " + value1 + operand + value2);
                reponse = Clavier.saisirInt();
                if (total == reponse) {
                    Ecran.afficherln("Bravo !");
                } else {
                    Ecran.afficherln("Faux, c'était : " + total);
                }
                break;
            case '-':
                total = value1 - value2;
                Ecran.afficher("Quelle est le résultat de : " + value1 + operand + value2);
                reponse = Clavier.saisirInt();
                if (total == reponse) {
                    Ecran.afficherln("Bravo !");
                } else {
                    Ecran.afficherln("Faux, c'était : " + total);
                }
                break;
            case '*':
                total = value1 * value2;
                Ecran.afficherln("Quelle est le résultat de : " + value1 + operand + value2);
                reponse = Clavier.saisirInt();
                if (total == reponse) {
                    Ecran.afficherln("Bravo !");
                } else {
                    Ecran.afficherln("Faux, c'était : " + total);
                }
                break;
            case '/':
                total = value1 / value2;
                Ecran.afficher("Quelle est le résultat de : " + value1 + operand + value2);
                reponse = Clavier.saisirInt();
                if (total == reponse) {
                    Ecran.afficherln("Bravo !");
                } else {
                    Ecran.afficherln("Faux, c'était : " + total);
                }
                break;
            default:
                Ecran.afficherln("Erreur : opération impossible");
                break;
        }
    }
}