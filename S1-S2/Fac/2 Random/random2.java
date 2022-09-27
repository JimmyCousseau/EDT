import java.util.Random;
import scite.*;

public class random2 {
    public static void main(String[] args) {
		int min = 10;
		int max = 50;
		Random random = new Random();
		int value1 = random.nextInt(max + min) + min;
        int value2 = random.nextInt(max + min) + min;
        char operand;
        int total;

        Ecran.afficher("Voulez-vous multiplier '*', diviser '/', additionner '+' ou soustraire '-' ? ");
        operand = Clavier.saisirChar();

        switch (operand) {
            case '+':
                total = value1 + value2;
                Ecran.afficher(total);
                break;
            case '-':
                total = value1 - value2;
                Ecran.afficher(total);
                break;
            case '*':
                total = value1 * value2;
                Ecran.afficher(total);
                break;
            case '/':
                total = value1 / value2;
                break;
            default:
                Ecran.afficher("Erreur : opération impossible");
                break;

        }
    }
}
