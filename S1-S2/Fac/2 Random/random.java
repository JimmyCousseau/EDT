import java.util.Random;
import scite.*;

public class random {
    public static void main(String[] args) {
		int min = 10;
		int max = 50;

		Random random = new Random();

		int value = random.nextInt(max + min) + min;
		Ecran.afficher(value);
    }
}
