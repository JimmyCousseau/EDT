import scite.*;

public class Tab_other {
    public static void main(String[] args) {
        int decision = 0;
        Ecran.afficherln(
                "Veux-tu afficher un tableau avec des valeurs Croissantes ? (False) ou \nAfficher un tableau avec des valeurs aléatoire ? (True)");
        decision = Clavier.saisirInt();
        if (decision == 1) {
            Ecran.afficherln("Insère la valeur maximale du tableau");
            int maxVal = Clavier.saisirInt() + 1;
            Ecran.afficherln("Insère la taille du tableau");
            int maxSize = Clavier.saisirInt() + 1;
            int[] tab = getRandTab(maxVal, maxSize);
            Ecran.afficherln(ConvertTabToString(tab));
        } else {
            Ecran.afficherln("Insère la valeur maximale de départ");
            int maxVal = Clavier.saisirInt();
            Ecran.afficherln("Insère la taille du tableau");
            int maxSize = Clavier.saisirInt();
            int[] tab = getRandTabCroissant(maxVal, maxSize);
            Ecran.afficherln(ConvertTabToString(tab));
        }
    }

    public static int[] getRandTab(int maxVal, int maxSize) {
        int[] randTab = new int[maxSize];
        for (int i = 0; i < randTab.length - 1; i++) {
            randTab[i] = (int) (Math.random() * maxVal);
        }
        return randTab;
    }

    public static int[] getRandTabCroissant(int maxVal, int maxSize) {
        int random = 0;
        int[] ranTabCroissant = new int[maxSize + 1];
        double interval = (maxVal / maxSize);
        for (int i = 0; i < ranTabCroissant.length; i++) {
            random = (int) (Math.random() * (interval) + interval * i);
            ranTabCroissant[i] = random;
        }
        return ranTabCroissant;
    }

    public static int[] getRandTabCroissant1(int maxVal, int maxSize) {
        int random;
        int[] ranTabCroissant = new int[maxSize];
        for (int i = 0; i < ranTabCroissant.length - 1; i++) {
            if (i != 0) {
                do {
                    random = (int) (Math.random() * (maxVal));
                } while (random < ranTabCroissant[i - 1]);
            } else {
                random = (int) (Math.random() * (maxVal));
            }
            ranTabCroissant[i] = random;
        }
        return ranTabCroissant;
    }

    public static String ConvertTabToString(int[] tab) {
        String str_tab = "";
        for (int i = 0; i < tab.length - 1; i++) {
            if (i % 10 == 0) {
                str_tab += "\n";
            }
            str_tab += "[" + tab[i] + "], ";
        }
        return str_tab;
    }
}
