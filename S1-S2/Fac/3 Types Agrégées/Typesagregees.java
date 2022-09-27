import java.lang.Math;
import scite.*;

public class Typesagregees {
    public static void main(String[] args) {
        int xSup = 799, ySup = 599;
        Ecran.afficherln("Renseigner les valeurs de l'abscisse et l'ordonné du point");
        point p3 = pthasard(xSup, ySup);
        point p2 = pthasard(xSup, ySup);
        point p1 = coordonnées(xSup, ySup);
        affichage(p1, p2, p3);
    }
    static class point {
        int y, x;
    }
    public static point coordonnées(int xSup, int ySup) {
        int x = Clavier.saisirInt();
        while (x < 0 || x > xSup) {
            Ecran.afficherln("L'abscisse n'a pas la bonne valeur");
            x = Clavier.saisirInt();
        }
        int y = Clavier.saisirInt();
        while (y < 0 || y > ySup) {
            Ecran.afficherln("L'ordonnée n'a pas la bonne valeur");
            y = Clavier.saisirInt();
        }
        point p = new point();
        p.x = x;
        p.y = y;
        return p;
    }
    public static point pthasard(int xSup, int ySup) {
        int x = (int)(Math.random()*(xSup++));
        int y = (int)(Math.random()*(ySup++));
        point p = new point();
        p.x = x;
        p.y = y;
        return p;
    }
    public static void affichage(point p1, point p2, point p3) {
        int dx, dy, dx1, dy1;
        int d, d1;
        Ecran.afficherln("Le point 1 a pour coordonnées ("+p1.x+";"+p1.y+")");
        Ecran.afficherln("Le point 2 a pour coordonnées ("+p2.x+";"+p2.y+")");
        Ecran.afficherln("Le point 3 a pour coordonnées ("+p3.x+";"+p3.y+")");
        dx = p1.x - p2.x;
        dy = p2.y - p1.y;
        dx1 = p3.x - p1.x;
        dy1 = p3.y - p1.y;
        d = (int)Math.sqrt(dx*dx+dy*dy);
        d1 = (int)Math.sqrt(dx1*dx1+dy1*dy1);
        if (d > d1) {Ecran.afficherln("le troisième point est dans le cercle");}
        else if (d == d1) {Ecran.afficherln("Le troisième point est sur le rayon du cercle");}
        else {Ecran.afficherln("Le troisième point est en dehors du cercle");}
        Ecran.afficherln(d + " " + d1);
    }
}