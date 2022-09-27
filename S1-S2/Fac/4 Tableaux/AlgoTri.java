import scite.*;
import java.lang.Math;

public class AlgoTri {

    static class Point2D {
        double x = Math.random() * 100;
        double y = Math.random() * 100;
    }

    public static void main(String[] args) {
        int[] tableau = new int[10000];

        for (int i = 0; i < tableau.length - 1; i++) {
            tableau[i] = (int) (Math.random() * 100);
        }
        double startTime = System.currentTimeMillis();
        TriBubbleSort(tableau);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    static void triBulle(int[] t) {
        int n = t.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (t[j] > t[j + 1]) {
                    int aux = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = aux;
                }
            }
        }
    }

    static void triBulleOptimise(int[] t) {
        boolean permutation;
        int np = t.length - 1;
        do {
            permutation = false;
            for (int j = 0; j < np; j++) {
                if (t[j] > t[j + 1]) {
                    int aux = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = aux;
                    permutation = true;
                }
            }
            np--;
        } while (permutation);
    }

    public static void affichage(int[] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            if (i % 10 == 0 && i > 0) {
                Ecran.afficherln(" " + tableau[i]);
            } else {
                Ecran.afficher(" " + tableau[i]);
            }
        }
    }
    
    public static int[] TriBubbleSort(int[] tableau) {
        int echange;
        for (int i = 0; i < tableau.length - 1; i++) {
            if (tableau[i] > tableau[i + 1]) {
                for (int j = i; j >= 0; j--) {
                    if (tableau[j] > tableau[j + 1]) {
                        echange = tableau[j + 1];
                        tableau[j + 1] = tableau[j];
                        tableau[j] = echange;
                    } else {
                        break;
                    }
                }
            }
        }
        return tableau;
    }

    ////////////////////////////////////////////////////////////////

    public static int[] TriInsertion(int[] tableau) {
        for (int i = 1; i < tableau.length; i++) {
            int p = positionInsertion(tableau[i], i, tableau);
            if (p != i) {
                int v = tableau[i];
                decalage(p, i - 1, tableau);
                tableau[p] = v;
            }
        }
        return tableau;
    }
    
    static int positionInsertion(int v, int n, int[] t) {
        int p = n;
        do {
            p--;
        } while ((p >= 0) && (v > t[p]));
        return p + 1;
    }

    static void decalage(int indi, int indf, int[] t) {
        for (int i = indf; i >= indi; i--) {
            t[i + 1] = t[i];
        }
    }

    ////////////////////////////////////////////////////////////////


    static void TriRapide(int[] tableau, int premier, int dernier) {
        int nbVal = dernier - premier + 1;
        if (nbVal > 1) {
            if (nbVal == 2) {
                if (tableau[dernier] < tableau[premier]) {
                    int echange = tableau[premier];
                    tableau[premier] = tableau[dernier];
                    tableau[dernier] = echange;
                }
            } else {
                int pivot = premier + dernier >> 1;
                int iMedian = Partitionner(tableau, premier, dernier, pivot);
                TriRapide(tableau, premier, iMedian - 1);
                TriRapide(tableau, iMedian + 1, dernier);
            }
        }
    }

    static int Partitionner(int[] tableau, int premier, int dernier, int pivot) {
        int echange = tableau[pivot];
        tableau[pivot] = tableau[dernier];
        tableau[dernier] = echange;
        int j = premier;
        for (int i = premier; i < dernier; i++) {
            if (tableau[i] <= tableau[dernier]) {
                if (i != j) {
                    echange = tableau[i];
                    tableau[i] = tableau[j];
                    tableau[j] = echange;
                }
                j++;
            }
        }
        if (dernier != j) {
            echange = tableau[dernier];
            tableau[dernier] = tableau[j];
            tableau[j] = echange;
        }
        return j;
    }

    ////////////////////////////////////////////////////////////////

    static void TriSelection(int[] tableau) {
        if (tableau.length > 1) {
            int taille = tableau.length;
            int[] select = new int[2];
            do {
                select[0] = tableau[0];
                select[1] = 0;
                for (int i = 1; i < taille; i++) {
                    if (tableau[i] > select[0]) {
                        select[0] = tableau[i];
                        select[1] = i;
                    }
                }
                int echange = tableau[taille - 1];
                tableau[taille - 1] = select[0];
                tableau[select[1]] = echange;
                taille--;
            } while (taille > 1);
        }
    } 


    static double distance(Point2D p1, Point2D p2) {
        double dist = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
        return dist;
    }

    static int compare(Point2D p1, Point2D p2) {
        return 1;
    }



}
