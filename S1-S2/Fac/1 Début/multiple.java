import scite.*;

public class multiple {
    public static void main(String args[]) {
        int a,b;
        Ecran.afficher("Saisir a");
        a = Clavier.saisirInt();
        Ecran.afficher("Saisir b plus grand que a");
        b = Clavier.saisirInt();
        if (a <= b && b % a == 0) {
            Ecran.afficher("a est un multiple de b");
        }
        else {
            Ecran.afficher("a n'est pas un multiple de b");
        }
    }
}
