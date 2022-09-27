import java.util.Scanner;

public class Game {
    private boolean run = true;
    private boolean fastMode;
    private boolean firstLaunch = true;
    private Map map = new Map();
    private int[] NbPAlived = new int[map.getNumberOfEquipe()];
    private int NbEquipeAlived;

    public void GameRun() {
        Scanner enter = new Scanner(System.in);
        while (run) {
            if (firstLaunch) {
                System.out.println("Voulez-vous une démo automatique ? true, false");
                fastMode = enter.nextBoolean();
                firstLaunch = false;
                Map map = new Map();
                map.updateMap();
                map.drawMap();
            } else {
                if (fastMode) {
                    do {
                        map.mouv();
                        map.updateMap();
                        map.drawMap();
                        // Remise des compteurs à 0
                        NbEquipeAlived = map.getNumberOfEquipe();
                        for (int i = 0; i < map.getNumberOfEquipe(); i++) {
                            NbPAlived[i] = 0;
                        }

                        // Compte le nombre de survivants dans chaques équipes
                        for (int i = 0; i < map.getNumberOfP(); i++) {
                            if (map.getPersons().get(i).getVie() > 0) {
                                NbPAlived[map.getPersons().get(i).getEquipe()] += 1;
                            }
                        }

                        // Compte le nombre d'équipes survivantes
                        for (int i = 0; i < map.getNumberOfEquipe(); i++) {
                            if (NbPAlived[i] == 0) {
                                NbEquipeAlived--;
                            }
                        }
                    } while (NbEquipeAlived > 1);
                    System.out.println("La partie est terminée");
                    System.out.println("L'équipe " + map.getPersons().get(0).getEquipe() + " a gagné");
                    run = false;
                } else {
                    do {
                        map.mouv();
                        map.updateMap();
                        map.drawMap();
                        // Remise des compteurs à 0
                        NbEquipeAlived = map.getNumberOfEquipe();
                        for (int i = 0; i < map.getNumberOfEquipe(); i++) {
                            NbPAlived[i] = 0;
                        }

                        // Compte le nombre de survivants dans chaques équipes
                        for (int i = 0; i < map.getNumberOfP(); i++) {
                            if (map.getPersons().get(i).getVie() > 0) {
                                NbPAlived[map.getPersons().get(i).getEquipe()] += 1;
                            }
                        }

                        // Compte le nombre d'équipes survivantes
                        for (int i = 0; i < map.getNumberOfEquipe(); i++) {
                            if (NbPAlived[i] == 0) {
                                NbEquipeAlived--;
                            }
                        }
                        System.out.println("Voulez-vous continuer la démo ? 1 : true, 0 : false");
                        run = enter.nextBoolean();
                    } while (run && NbEquipeAlived > 1);
                }
            }
        }
        enter.close();
    }
}
