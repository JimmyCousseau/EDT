import java.util.Random;
import scite.*;

public class jeulettre {
    public static void main(String[] args) {
        final int maxi = 3;
        boolean gagne = false;
        char lettre = (char) initialisationJeu();
        for (int i = 1; i <= maxi; i++) {
            gagne = essais(lettre);
            if (i == maxi || gagne == true) {
                conclureJeu(lettre);
            }
        }

    }

    static int initialisationJeu() {
        Ecran.afficherln(
                "A chaque essai l’utilisateur fait une proposition pour deviner la lettre et le jeu affiche :");
        Ecran.afficherln(
                "« plus  petit »  si  la  proposition  de  l’utilisateur  est  strictement  supérieure  à  la  lettre  à  deviner ; ");
        Ecran.afficherln(
                "« plus  grand »  si  la  proposition  de  l’utilisateur  est  strictement  inférieure  à  la  lettre  à  deviner ; ");
        Ecran.afficherln("« lettre trouvée » si la lettre proposée est égale à celle à deviner. ");
        Ecran.afficherln("Les comparaisons se font par rapport à l’ordre alphabétique");
        Random random = new Random();
        int c = random.nextInt(122 - 97) + 97;
        return c;
    }

    static boolean essais(char lettre) {
        char essai = Clavier.saisirChar();
        boolean trouve = false;
        if (essai < lettre) {
            Ecran.afficherln("La lettre que tu doit trouver est plus grande");
        } else if (essai > lettre) {
            Ecran.afficherln("La lettre que tu doit trouver est plus petite");
        } else {
            Ecran.afficherln("Trouvée");
            trouve = true;
        }
        return trouve;
    }

    static char conclureJeu(char lettre) {
        Ecran.afficherln("La lettre que tu devait trouver était " + lettre);
        return lettre;
    }
}