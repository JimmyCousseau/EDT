import java.util.ArrayList;

public class Map {
    // Variables de la classe Map
    private final int MAP_WIDTH = 5; // Largeur du plateau
    private final int MAP_HEIGHT = 5; // Hauteur du plateau
    private final int NUMBER_OF_EQUIPE = 5; // Nombre d'équipe dans le jeu, celui-ci doit-être supérieur ou égal au nombre véritable
    private char[][] plateau = new char[MAP_WIDTH][MAP_HEIGHT];
    private ArrayList<Personnage> player_list = new ArrayList<Personnage>();

    // Constructeur
    Map() {
        player_list.add(new Cavalier(new Position(0, 1), 0, this));
        player_list.add(new Troll(new Position(0, 2), 0, this));
        player_list.add(new Ninja(new Position(0, 3), 0, this));
        player_list.add(new Guerrier(new Position(0, 4), 0, this));

        player_list.add(new Cavalier(new Position(1, 0), 1, this, "Cavalier", 'c'));
        player_list.add(new Troll(new Position(2, 0), 1, this, "Troll", 't'));
        player_list.add(new Ninja(new Position(3, 0), 1, this, "Ninja", 'n'));
        player_list.add(new Guerrier(new Position(4, 0), 1, this, "Guerrier", 'g'));
    }

    void updateMap() {
        int x, y;
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                plateau[j][i] = '.';
            }
        }
        for (int i = 0; i < player_list.size(); i++) {
            if (player_list.get(i).getVie() > 0) {
                x = player_list.get(i).getPosition().getX();
                y = player_list.get(i).getPosition().getY();
                plateau[x][y] = player_list.get(i).getSymbol();
            }
        }
    }

    void drawMap() {
        hatPlateau();

        for (int i = 0; i < MAP_HEIGHT; i++) {
            for (int j = 0; j < MAP_WIDTH; j++) {
                if (j == 0) {
                    System.out.print("\n|");
                }

                System.out.print(plateau[j][i] + " ");
                if (j == MAP_WIDTH - 1) {
                    System.out.print("|");
                }
            }
        }
        
        hatPlateau();
        System.out.println();
    }

    void hatPlateau() { // Draw the top and the bottom of the board
        System.out.print("\n+");
        for (int i = 0; i < MAP_WIDTH; i++) {
            System.out.print("- ");
        }
        System.out.print("+");
    }

    void mouv() {
        for (int i = 0; i < player_list.size(); i++) {
            if (player_list.get(i).getVie() > 0) {
                player_list.get(i).Deplacement(player_list);
            }
            else {
                // Enlève le joueur si il n'a plus de vie
                player_list.remove(i);
            }
        }
    }

    // Getters 
    public int getNumberOfP() { return player_list.size(); }
    public ArrayList<Personnage> getPersons() { return player_list; }
    public int getNumberOfEquipe() { return NUMBER_OF_EQUIPE; }
    public int getMapHeight() { return MAP_HEIGHT; }
    public int getMapWidth() { return MAP_WIDTH; }
}
