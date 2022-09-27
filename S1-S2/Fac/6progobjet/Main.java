public class Main {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 5, 0, 0);
        // Ou alors on peut :
        Point2D p = new Point2D(0, 0);
        rect = new Rectangle(5, 5, p);

        rect.dessinePlein();
        System.out.println();
        rect.dessineVide();
        
        System.out.println();
        Losange losange = new Losange(7, 2, 1);
        losange.dessinePlein();
    }
}
