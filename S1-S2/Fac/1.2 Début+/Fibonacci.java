import scite.*;

public class Fibonacci {
    public static void main(String[] args) {
        float f0 = 0, f1 = 1, f2 = f1 + f0;
        float nombre;
        Ecran.afficherln("Combien de termes veux-tu que la suite comporte ?");
        nombre = Clavier.saisirInt();

        Ecran.afficherln(f0);
        Ecran.afficherln(f1);
        Ecran.afficherln(f2);
        for (int i = 3; i < nombre; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f1 + f0;
            Ecran.afficherln(f2);
        }
    }
}
