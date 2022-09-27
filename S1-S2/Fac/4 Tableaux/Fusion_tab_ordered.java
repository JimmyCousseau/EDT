public class Fusion_tab_ordered {
    public static void main(String[] args) {
        int[] tab = getRandSortedTab(10, 0, 10);
        int[] tab2 = getRandSortedTab(10, 0, 10);
        int[] tab3 = Fusion_tab_order(tab, tab2);
        affichage(tab);
        affichage(tab2);
        affichage(tab3);

    }

    public static void affichage(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(tab[i] + " ");
        }
    }


    public static int[] Fusion_tab_order(int[] tab, int[] tab2) {
        int[] tab3 = new int[tab.length + tab2.length - 1];
        int i = 0;
        int j = 0;
        if (tab.length != 0 && tab2.length != 0) {
            for (int y = 0; y < tab3.length - 1; y++) {
                if (tab[i] > tab2[j] && j < tab2.length - 1) {
                    tab3[j + i] = tab2[j];
                    j++;
                } else {
                    if (i < tab.length - 1) {
                        tab3[j + i] = tab[i];
                        i++;
                    }
                    else {
                        tab3[j + i] = tab2[j];
                        j++;
                    }
                }
            }
        }


        return tab3;
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
}
