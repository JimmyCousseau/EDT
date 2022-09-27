import java.util.Random;
import scite.*;

public class hasard {
    public static int moins = 80;

    public static void main(String[] args) {
        System.out.println("Choisissez le nombre de tirages");
        int nbtirages = Clavier.saisirInt();
        for (int i = 0; i < nbtirages; i++) {
            hasardImpair();
        }
        Ecran.afficherln("Nombre impair minimum parmi " + nbtirages + " tirages : " + moins + " moins");
    }

    static int hasardIntervalle(int result) {
        if (result % 2 == 0) {
            hasardImpair();
        }

        else {
            Ecran.afficherln(result);
            rangement(result);
        }
        return result;
    }

    static int hasardImpair() {
        int b1 = 55, b2 = 80;
        Random random = new Random();
        int result = random.nextInt(b2 - b1) + b1;
        hasardIntervalle(result);
        return result;
    }

    static void rangement(int l) {
        if (l <= moins) {
            moins = l;
        }
    }
}
