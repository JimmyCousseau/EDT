import scite.Clavier;
import scite.Ecran;

public class search_char_in_text {
    public static void main(String[] args) {
        System.out.println("Ecrit ton texte :");
        String text = Clavier.saisirString();
        System.out.println("Ecrit le character à chercher");
        char letter = Clavier.saisirChar();
        System.out.println("Ecrit le character à remplacer");
        char newLetter = Clavier.saisirChar();
        char[] tab = text.toCharArray();
        System.out.println(appear(tab, letter));
        System.out.println(find(tab, letter));
        System.out.println(findAndReplace(tab, letter, newLetter));
    }

    public static boolean appear(char[] tab, char letter) {
        for (int i = 0; i < tab.length; i++) {
            if (letter == tab[i]) {
                return true;
            }
        }
        return false;
    }

    public static int find(char[] tab, char letter) {
        for (int i = 0; i < tab.length; i++) {
            if (letter == tab[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int findAndReplace(char[] tab, char letter, char newLetter) {
        int nbRepl = 0;
        for (int i = 0; i < tab.length; i++) {
            if (letter == tab[i]) {
                nbRepl++;
                tab[i] = newLetter;
            }
            System.out.print(tab[i]);
        }
        Ecran.sautDeLigne();
        return nbRepl;
    }
}
