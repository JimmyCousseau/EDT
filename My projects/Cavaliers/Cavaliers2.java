import scite.*;

public class Cavaliers2 {
    public static void main(String[] args) {
        Piece e = new Piece();
        do {
            Ecran.afficherln("Voulez-vous jouer à 1, 2, 3 ou 4 joueurs ?");
            e.nb_cavalier = Clavier.saisirInt();
        } while (e.nb_cavalier < 1 && e.nb_cavalier > 4);
        e = definitions();
        plateau(e);
    }

    // Création d'une classe avec les variables nécessaires pour le fonctionnement
    // du jeu

    static class Piece {
        // L'emplacement des pièges
        int vague;
        int trou1;
        int trou2;
        int mortOuVif;
        ////////////////////////////////
        int nb_cavalier;
        int[] totaldées = {1,1,1,1}; // Stock l'avancement du cavalier
        int dées; // Les dées tirés
        int[] attente = {0,0,0,0}; // Stock l'attente d'un cavalier avant de pouvoir jouer si il est tombé sur un trou
        int turn; // Défini le tour pour savoir à qui c'est de jouer
        int totalturn; // Stock le nombre de tours pour savoir si le cavalier a gagné ou pas (mode solo)
        //défini un caractère pour chaques cavaliers
        String[] lettre = {"\u001B[31m" + "R" + "\u001B[0m", "\u001B[34m" + "B" + "\u001B[0m","\u001B[32m" + "V" + "\u001B[0m", "\u001B[33m" + "J" + "\u001B[0m"};
        int taille; //Taille du plateau
    }
    ////////////////////////////////

    // Définis les valeurs de départ de chaques variables
    static Piece definitions() {
        Piece e = new Piece();
        do {
            Ecran.afficherln("Quelle dimension du plateau voulez-vous (entre 6 et 10)");
            e.taille = Clavier.saisirInt();
        } while (e.taille < 6 || e.taille > 10);
        e.vague = (int) (Math.random() * (e.taille - 2) + 2);
        e.trou1 = (int) (Math.random() * (2 * (e.taille - 2)) + e.taille + 2);
        e.trou2 = (int) (Math.random() * (2 * (e.taille - 2)) + e.taille + 2);
        e.mortOuVif = (int) (Math.random() * (e.taille - 2) + e.taille * 3 - 1);
        while (e.trou1 == e.trou2) {
            e.trou2 = (int) (Math.random() * (2 * (e.taille - 2)) + e.taille + 2);
        }
        e.turn = e.nb_cavalier - 1;
        return e;
    }
    ////////////////////////////////

    // Fait l'affichage du plateau
    static void plateau(Piece e) {
        // Stocke chaques cases dans une liste pour pouvoir les identifiers
        String[] haut = new String[e.taille * 4 - 1];
        for (int i = 0; i < haut.length; i++) {
            haut[i] = "___";
        }
        ////////////////////////////////
        haut[e.taille + 1] = "_A_"; // Point à atteindre pour finir la course
        haut[1] = "_D_"; // Point de départ de la course
        // Place les pièges
        haut[e.vague] = "_~_";
        haut[e.trou1] = "_O_";
        haut[e.trou2] = "_O_";
        haut[e.mortOuVif] = "OXO";
        ////////////////////////////////

        remisePlateau(e); // Remet le plateau dans l'ordre des chiffres, sens horaire.

        for (int i = 0; i < e.nb_cavalier; i++) {
            haut[e.totaldées[e.turn]] = "_" + e.lettre[i] + "_";
        }
        ////////////////////////////////

        // L'affichage du reste du plateau avec les variables prisent en compte
        // Pour faire la ligne du haut du plateau :
        Ecran.afficher(" ");
        for (int i = 0; i <= e.taille * 4 - 2; i++) {
            Ecran.afficher("_");
        }
        Ecran.afficherln("");
        ////////////////////////////////

        for (int i = 0; i < haut.length; i++) {
            if (i == 0 || i == 3 * e.taille - 4) {
                Ecran.afficher("|");
            } else if (i >= e.taille + 1 && i < 3 * e.taille - 4) {
                Ecran.afficherln("");
                Ecran.afficher("|" + haut[i] + "|");
                for (int x = 0; x <= e.taille * 4 - 10; x++) {
                    Ecran.afficher(" ");
                }
                i++;
                Ecran.afficher("|" + haut[i] + "|");
            } else if (i == 3 * e.taille - 3) {
                Ecran.afficherln("");
                Ecran.afficher("|" + haut[i] + "|");
                for (int x = 0; x <= e.taille * 4 - 10; x++) {
                    Ecran.afficher("_");
                }
                i++;
                Ecran.afficher("|" + haut[i] + "|");
                Ecran.afficherln("");
                Ecran.afficher("|");
            } else {
                Ecran.afficher(haut[i] + "|");
            }
        }
        ////////////////////////////////
        if (e.totaldées[e.turn] == e.trou1 || e.totaldées[e.turn] == e.trou2) {
            Ecran.afficherln("\nLe joueur " + (e.turn + 1) + " est tombé dans le trou");
        }
        askToPlay(e);
    }

    static void askToPlay(Piece e) {
        // Informe que tel ou tel cavalier est tombé sur une case spéciale
        if (e.totaldées[e.turn] == e.trou2 || e.totaldées[e.turn] == e.trou2) {
            Ecran.afficherln("\n" + e.lettre[e.turn] + " est tombé dans le trou");
        }
        if (e.totaldées[e.turn] == e.vague) {
            Ecran.afficherln("\n" + e.lettre[e.turn] + " est tombé dans la rivière");
        }
        if (e.totaldées[e.turn] == e.mortOuVif) {
            Ecran.afficherln("\n" + e.lettre[e.turn] + " est tombé sur la case Mort ou Vif");
        }
        ////////////////////////////////
        
        if (e.nb_cavalier == 1) {
            Ecran.afficherln("\nÀ ton tour");
        } else {
            if (e.turn == 0) {
                Ecran.afficherln("\nAu tour de " + e.lettre[e.turn + 1]);
            } else if (e.turn == e.nb_cavalier - 1) {
                if (e.totaldées[e.turn] == 1) {
                    Ecran.afficherln("\nAu tour de " + e.lettre[0]);
                } else {
                    Ecran.afficherln("\nAu tour de " + e.lettre[0]);
                }

            } else {
                Ecran.afficherln("\nAu tour de " + e.lettre[e.turn + 1]);
            }
        }

        Ecran.afficherln("\n\nAppuyez sur un caractère puis entrez pour lancer les dés");
        Ecran.afficherln("Si vous souhaitez arrêter la partie saisissez s");
        char valid = Clavier.saisirChar();
        if (valid != 's') {
            change(e);
        } else {
            Ecran.afficherln("Jeu arrêté");
        }
    }

    static void conditions(Piece e) {
        // Vérification si le cavalier est tombé dans un trou ou non
        if (e.totaldées[e.turn] == e.trou1 || e.totaldées[e.turn] == e.trou2) {
            if (e.attente[e.turn] != 2 && e.attente[e.turn] == 0) {
                Ecran.afficherln("Vous êtes tombé dans le trou, veuillez attendre 2 tours");
                e.attente[e.turn] = 2;
                e.totaldées[e.turn] = e.totaldées[e.turn]; // Situe le cavalier
                change(e);
            } else {
                e.attente[e.turn] -= 1;
                if (e.attente[e.turn] != 0) {
                    Ecran.afficherln("Vous êtes tombé dans le trou, veuillez attendre " + e.attente + "tours");
                    e.totaldées[e.turn] = e.totaldées[e.turn]; // Situe le cavalier
                    change(e);
                } else {
                    Ecran.afficherln("Vous êtes enfin libéré");
                    dées(e);
                }
            }
        }
        // Si les conditions sont bonnes, le cavalier peut lancer les dées
        else {
            dées(e);
        }
        ////////////////////////////////
    }

    static void dées(Piece e) {

        e.dées = (int) (Math.random() * 6 + 1); // Tire les dés
        Ecran.afficherln("Dées tiré : " + e.dées);
        if (e.totaldées[e.turn] == e.mortOuVif) {
            if (e.dées % 2 == 0) {
                Ecran.afficherln(
                        "Vous êtes tombé sur la case Mort ou Vif\nEt vous avez fait un nombre pair, vous multipliez donc\nvotre vitesse par 3 pour ce tour-ci");
                e.dées = e.dées * 3;
            } else {
                Ecran.afficherln(
                        "Vous êtes tombé sur la case Mort ou Vif\nEt vous avez fait un nombre impair\nRetournez à la case départ");
                e.totaldées[e.turn] = 1;
                plateau(e);
            }
        }
        if (e.totaldées[e.turn] == e.vague) {
            Ecran.afficherln(
                    "Vous êtes dans la rivière, vous ne pouvez pas sortir tant que vous ne faites pas un chiffre pair");
            if (e.dées % 2 == 0) {
                Ecran.afficherln("Vous pouvez sortir de la rivière, vous avez fait un nombre pair");
            } else {
                Ecran.afficherln("Vous n'avez pas fait de nombre pair, vous restez bloqué dans la rivière");
                change(e);
            }
        }
        e.totaldées[e.turn] += e.dées; // Stocke la somme des dées tirés tout au long de la partie pour situer

        // Si un cavalier tombe sur un autre cavalier il recule
        for (int i = 0; i <= e.nb_cavalier - 1; i++) {
            if (e.totaldées[e.turn] == e.totaldées[i] && e.turn != i) {
                e.totaldées[e.turn] -= e.taille / 2;
                if (e.totaldées[e.turn] <= 0) {
                    e.totaldées[e.turn] = 1;
                }
            }
        }
        ////////////////////////////////

        if (e.totaldées[e.turn] == e.taille*4 - 4) {
            if (e.nb_cavalier == 1) {
                if (e.totalturn <= e.taille*4 - 2) {
                    Ecran.afficherln(
                            "\n\n\nFin de la partie,\nBravo !\nTu as parcouru le plateau en moins de tours que la dimension du plateau !\n\n\n");
                } else {
                    Ecran.afficherln(
                            "\n\n\nFin de la partie,\nPerdu  :(\nTu as parcouru le plateau en faisant plus de tours que la dimension du plateau !\n\n\n");
                }
            } else {
                Ecran.afficherln("\n\n\nFin de la partie le joueur " + (e.turn + 1) + " a gagné !\n\n\n");
            }
        } else if (e.totaldées[e.turn] > e.taille*4 - 4) {
            e.totaldées[e.turn] = e.taille*4 - 4 - (e.totaldées[e.turn] - e.taille*4 - 4);
            plateau(e);
        } else {
            plateau(e);
        }
    }

    static void change(Piece e) {
        // Change les valeurs du cavalier précédent pour faire place au nouveau cavalier
        // Fait la transition entre les cavaliers
        if (e.turn + 1 >= e.nb_cavalier) {
            e.turn = 0;
        } else if (e.nb_cavalier == 1 || e.turn + 1 < e.nb_cavalier) {
            e.turn += 1;
            e.totalturn += e.turn;
        }
        ////////////////////////////////
        conditions(e);
        ////////////////////////////////
    }

    static void remisePlateau(Piece e) {
        // Le plateau n'a pas le même sens de lecture que nous (le sens horaire), nous
        // avons donc
        // repris tous les numéros de cases pour les remettres dans le bonne ordre
        ////////////////////////////////
        // Côté droit du plateau
        if (2 * e.taille - 1 > e.totaldées[e.turn] && e.totaldées[e.turn] > e.taille) {
            for (int i = 0; i <= e.taille - 2; i++) {
                if (e.totaldées[e.turn] == e.taille + i) {
                    e.totaldées[e.turn] = (e.totaldées[e.turn] - e.taille) * 2 + e.taille;
                    i = e.taille - 1;
                }
            }
        }
        ////////////////////////////////
        // Côté bas du plateau
        else if (3 * e.taille - 1 > e.totaldées[e.turn] && e.totaldées[e.turn] > 2 * e.taille - 2) {
            for (int i = 0; i <= e.taille; i++) {
                if (e.totaldées[e.turn] == e.taille * 2 - 1 + i) {
                    e.totaldées[e.turn] = 3 * e.taille - 4 - (i - e.taille);
                    i = e.taille + 1;
                }
            }
        }
        ////////////////////////////////
        // Côté gauche du plateau
        else if (4 * e.taille - 3 > e.totaldées[e.turn] && e.totaldées[e.turn] > 3 * e.taille - 2) {
            for (int i = 0; i <= e.taille - 2; i++) {
                if (e.totaldées[e.turn] == 3 * e.taille - 1 + i) {
                    e.totaldées[e.turn] = 3 * e.taille - 5 - 2 * i;
                    i = e.taille + 1;
                }
            }
        }
    }
}
