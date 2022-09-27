import scite.*;

public class racinecarreentiere {
    public static void main(String[] args) {
        Ecran.afficherln("Saisi un nombre entier");
        int n = Clavier.saisirInt();
        double r = Math.sqrt(n);
        double a = r % 1;
        double b = r - a;
        Ecran.afficherln(b);
    }
}
