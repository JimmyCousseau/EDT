import scite.*;

public class Tab_Type_agrege {
    public static void main(String[] args) {
        Ecran.afficherln("Saisissez les coordonnées max et minimum");
        int max = Clavier.saisirInt();
        int min = Clavier.saisirInt();
        int taille = 20;
        int[][] tab = new int[max][3];
        Point3D p = new Point3D();
        Point3D pmax = new Point3D();
        Point3D pmin = new Point3D();
        for (int i = 0; i < taille; i++) {
            p = getRandPoint3D(min, max);
            tab[i][0] = p.x;
            tab[i][1] = p.y;
            tab[i][2] = p.z;
            /* Ecran.afficherln("x : " + p.x + " y : " + p.y + " z : " + p.z); */
        }
        Point3D barycentre = new Point3D();
        barycentre = Barycentre(tab);
        Ecran.afficherln("Le barycentre :");
        Ecran.afficherln("x : " + barycentre.x + " y : " + barycentre.y + " z : " + barycentre.z);
        Ecran.afficherln("Les valeurs maximales du tableau sont :");
        pmax = BorneMax(tab);
        Ecran.afficherln("x : " + pmax.x + " y : " + pmax.y + " z : " + pmax.z);
        Ecran.afficherln("Les valeurs maximales du tableau sont :");
        pmin = BorneMin(tab);
        Ecran.afficherln("x : " + pmin.x + " y : " + pmin.y + " z : " + pmin.z);
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 4; i++) {
                p = getRandPoint3D(min, max);
                tab[i][0] = p.x;
                tab[i][1] = p.y;
                tab[i][2] = p.z;
                /* Ecran.afficherln("x : " + p.x + " y : " + p.y + " z : " + p.z); */
            }
        }
    }

    static class Point3D {
        int x;
        int y;
        int z;
    }

    public static Point3D getRandPoint3D(int min, int max) {
        Point3D p = new Point3D();
        p.x = (int) (Math.random() * max + min);
        p.y = (int) (Math.random() * max + min);
        p.z = (int) (Math.random() * max + min);
        return p;
    }

    public static Point3D Barycentre(int[][] tab) {
        Point3D p = new Point3D();
        p.x = 0;
        p.y = 0;
        p.z = 0;
        for (int i = 0; i < tab.length; i++) {
            p.x += tab[i][0];
            p.y += tab[i][1];
            p.z += tab[i][2];
        }
        p.x /= tab.length;
        p.y /= tab.length;
        p.z /= tab.length;
        return p;
    }
    
    public static Point3D BorneMax(int[][] tab) {
        Point3D p = new Point3D();
        p.x = tab[0][0];
        p.y = tab[0][1];
        p.z = tab[0][2];
        for (int i = 1; i < tab.length; i++) {
            if (p.x < tab[i][0]) {
                p.x = tab[i][0];
            }
            if (p.y < tab[i][1]) {
                p.y = tab[i][1];
            }
            if (p.z < tab[i][2]) {
                p.z = tab[i][2];
            }
        }
        return p;
    }
    
    public static Point3D BorneMin(int[][] tab) {
        Point3D p = new Point3D();
        p.x = tab[0][0];
        p.y = tab[0][1];
        p.z = tab[0][2];
        for (int i = 1; i < tab.length; i++) {
            if (p.x > tab[i][0]) {
                p.x = tab[i][0];
            }
            if (p.y > tab[i][1]) {
                p.y = tab[i][1];
            }
            if (p.z > tab[i][2]) {
                p.z = tab[i][2];
            }
        }
        return p;
    }

    public static Point3D Intersection(int[][] tab) {
        Point3D p = new Point3D();
        for (int i = 0; i < 4; i++) {
            
        }

        return p;
    }
}
