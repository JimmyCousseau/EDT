import scite.*;

public class Tab_rand_sorted {
    public static void main(String[] args) {
        long startTime, endTime;
        startTime = System.currentTimeMillis();

        int[] tab = getRandSortedTab(500000000, 0, 10);

        endTime = System.currentTimeMillis();
        System.out.println("Temps de génération du tableau : " + (endTime - startTime) + " ms");

        // for (int i = 0; i < tab.length - 1; i++) {
        //     if (i % 10 == 0 && i > 0) {
        //         Ecran.afficherln(" " + tab[i]);
        //     } else {
        //         Ecran.afficher(" " + tab[i]);
        //     }
        // }

        Ecran.sautDeLigne();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            getValueInTab(tab, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution pour la méthode bourrine : " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            getValueInTabDicho(tab, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution pour la méthode fine : " + (endTime - startTime) + " ms");

    }

    public static int getRandInt(int low, int up) {
        return low + (int) ((up - low) * Math.random());
    }

    public static int[] getRandSortedTab(int size, int low, int gap) {
        if (size < 0) {
            return null;
        }
        int[] tab = new int[size];
        if (size == 0) {
            return tab;
        }
        tab[0] = getRandInt(low, low + gap);
        for (int i = 1; i < tab.length; i++) {
            tab[i] = getRandInt(tab[i - 1], tab[i - 1] + gap);
        }
        return tab;
    }

    public static int getValueInTab(int[] tab, int value) {
        if (tab.length == 0) {
            return -1;
        }
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == value) {
                return i + 1;
            }
        }
        return -1;
    }
    
    public static int getValueInTabDicho(int[] tab, int value) {
        int borne2 = tab.length - 1;
        int borne1 = 0;
        int calcul;
        if (tab.length == 0) {
            return -1;
        }
        for (int i = 0; i < tab.length; i++) {
            if (tab[borne2] == value || tab[borne1] == value) {
                if (tab[borne2] == value) {
                    return borne2 + 1;
                } else {
                    return borne1 + 1;
                }
            }
            else if (borne2 - 1 == borne1 || borne2 == borne1) {
                return -1;
            }
            else if (tab[borne2] > value) {
                calcul = (borne2 - borne1) / 2;
                if (tab[borne2 - calcul] >= value) {
                    borne2 -= calcul;
                } else {
                    borne1 += calcul;

                }
            }
        }
        return -1;
    }
}
