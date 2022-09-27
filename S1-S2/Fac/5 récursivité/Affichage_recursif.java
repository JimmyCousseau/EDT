public class Affichage_recursif {
    public static void main(String[] args) {
        affichage_croiss(0, 10);
    }

    static void affichage_dec(int x) {
        if (x == 0) {
            System.out.print("0 ");
        } else {
            System.out.print((x + " "));
            affichage_dec(x - 1);
        }
    }
    
    static void affichage_croiss(int y, int x) {
        if (y == x) {
            System.out.print(y + " ");
        } else {
            System.out.print((y + " "));
            affichage_croiss(y + 1, x);
        }
    }
}
