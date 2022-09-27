import java.util.Random;
import scite.*;

public class jeu1 {
    public static void main(String[] args) {
        final int min = 10, max = 50, min2 = 1, max2 = 9;
        Random random = new Random();
        int nb_to_reach = random.nextInt(max - min) + min;
        int nb1 = random.nextInt(max2 - min2) + min2;
        int nb2 = random.nextInt(max2 - min2) + min2;
        char operande;
        for (int nb_operations = 1; nb_operations <= 5; nb_operations++) {
            Ecran.afficherln("Nombre à approcher : " + nb_to_reach);
            Ecran.afficherln("Opération numéro : " + nb_operations + " / 5");
            Ecran.afficherln("Voici les deux opérandes : n1 = " + nb1 + " et n2 = " + nb2);
            Ecran.afficherln(
                    "A vous de jouer \nChoisissez une des quatres opérations \nen tapant un de ces caractères : + - * /");
            operande = Clavier.saisirChar();

            switch (operande) {
            case '+':
                nb1 = nb1 + nb2;
                break;
            case '-':
                nb1 = nb1 - nb2;
                break;
            case '*':
                nb1 = nb1 * nb2;
                break;
            case '/':
                nb1 = nb1 / nb2;
                break;
            default:
                nb1 = nb1 + nb2;
                break;
            }
            if (nb1 == nb_to_reach) {
                Ecran.afficherln("Bravo !");
            }
        }
        if (nb_to_reach != nb1) {
            Ecran.afficherln("Perdu");
        }
    }
}