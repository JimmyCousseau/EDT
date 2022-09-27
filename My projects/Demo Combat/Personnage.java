import java.lang.Math;
import java.util.ArrayList;

public class Personnage {
    // Variables de la classe Personnage
    private int equipe;
    private Position pos;
    private Map map;
    private String name;
    private char symbol;
    private int habilete;
    private int force;
    private int armure;
    private int esquive;
    private int vie;
    private int resurrection;
    private int PAttacked;

    Personnage(Position pos, int equipe, Map map, String name, char symbol, int habilete, int force, int armure, int esquive, int vie, int resurrection) {
        this.pos = pos;
        this.equipe = equipe;
        this.name = name;
        this.symbol = symbol;
        this.habilete = habilete;
        this.force = force;
        this.armure = armure;
        this.esquive = esquive;
        this.vie = vie;
        this.resurrection = resurrection;
        this.map = map;
    }
    
    void attack(Personnage attaquant, Personnage defenseur) {
        if (attaquant.habilete > defenseur.esquive - (int) (Math.random() * 5 + 1)) {

            int attaque = attaquant.force + (int) (Math.random() * 5 + 1) - defenseur.armure;

            System.out.println(attaquant.name + " " + attaquant.symbol + " attaque " + defenseur.name + " "
                    + defenseur.symbol + " pour une valeur de " + Integer.toString(attaque) + " points de dégats");

            if (attaque > 0) {
                if (defenseur.vie - attaque <= 0) {

                    System.out.println(defenseur.name + " "
                            + defenseur.symbol + " est mort");

                    if (defenseur.resurrection > 0) {
                        defenseur.resurrection -= 1;
                        defenseur.vie = 2;
                        System.out.println("Mais il réssuscite et a désormais 2 points de vie");
                        
                    } else {
                        defenseur.vie -= attaque;
                    }

                } else {
                    defenseur.vie -= attaque;
                    System.out.println("Il lui reste " + defenseur.vie + " points de vie");
                }
            }
        }
        else {
            System.out.println(defenseur.name + " " + defenseur.symbol + " a esquivé l'attaque de " + attaquant.name + " " + attaquant.symbol);
        }
    }
    
    void Deplacement(ArrayList<Personnage> player_list) {
        int choose;
        Position pos;
        // Créé toutes les directions possibles pour éviter une boucle infinis sur le while et réduire les calculs
        ArrayList<Position> xy = new ArrayList<Position>();
        xy.add(new Position(1, 0));
        xy.add(new Position(1,1));
        xy.add(new Position(1, -1));
        xy.add(new Position(0,1));
        xy.add(new Position(0, -1));
        xy.add(new Position(-1, -1));
        xy.add(new Position(-1, 0));
        xy.add(new Position(-1, 1));
        
        
         // Génère une direction
         do {
            choose = (int) (Math.random() * xy.size());
            pos = xy.get(choose);

            // Si le personnage part dans la direction d'un coin alors il revient à son
            // origine donc on break le while
            if (isCollidingWallInX(pos.getX()) && isCollidingWallInY(pos.getY())) {
                pos = new Position(0, 0);
                System.out.println(this.name + " " + this.symbol + " a rebondit dans le coin du mur");
                break;
            }
            // Si il part dans la direction d'un mur sur l'axe des X alors il rebondit
            else if (isCollidingWallInX(pos.getX())) {
                pos = new Position(0, pos.getY());
                System.out.println(this.name + " " + this.symbol + " a rebondit sur le mur");

            }
            // Si il part dans la direction d'un mur sur l'axe des Y alors il rebondit
            else if (isCollidingWallInY(pos.getY())) {
                pos = new Position(pos.getX(), 0);
                System.out.println(this.name + " " + this.symbol + " a rebondit sur le mur");

            }
            xy.remove(choose); // On enlève l'attribut pour éviter de retomber sur des cas similaires
            // Si la liste est vide alors le personnage ne peut pas bouger, on casse donc la boucle.
            if (xy.size() == 0) {
                pos = new Position(0, 0);
                break;
            }
        } while ((pos.getX() == 0 && pos.getY() == 0) || isCollidingSomeoneOfHisTeam(pos.getX(), pos.getY(), player_list));
        
        // Maintenant qu'il a sa direction définit la fonction ci-dessous
        // permet de savoir si il y a un ennemi en face                                 
        if (isCollidingSomeoneElse(pos.getX(), pos.getY(), player_list)) {
            attack(this, player_list.get(PAttacked)); // Si il y a un ennemi, celui-ci est attaqué
            if (!isCollidingSomeoneElse(pos.getX(), pos.getY(), player_list)) { // Si il est tué, il prend sa place, sinon il ne bouge pas
                this.pos = new Position(this.pos.getX() + pos.getX(), this.pos.getY() + pos.getY());
            }
        }
        else { // Si il ne croise personne, il continu sa route
            this.pos = new Position(this.pos.getX() + pos.getX(), this.pos.getY() + pos.getY());
        }

    }


    boolean isCollidingWallInX(int x) {
        if (this.pos.getX() + x < 0 || this.pos.getX() + x >= map.getMapWidth()) {
            return true;
        }
        return false;
    }

    boolean isCollidingWallInY(int y) {
        if (this.pos.getY() + y < 0 || this.pos.getY() + y >= map.getMapHeight()) {
            return true;
        }
        return false;
    }

    boolean isCollidingSomeoneOfHisTeam(int x, int y, ArrayList<Personnage> player_list) {
        for (int i = 0; i < player_list.size(); i++) { 
            if (player_list.get(i).getEquipe() == this.equipe &&  // Vérifie si ils sont dans la même équipe
                    player_list.get(i).getVie() > 0 &&                 // Vérifie si le joueur est vivant
                    player_list.get(i).pos.getX() == x + this.pos.getX() &&    // Vérifie si ils ont la même position sur X
                    player_list.get(i).pos.getY() == y + this.pos.getY())      // Vérifie si ils ont la même position sur Y
            {
                return true;
            }
        }
        return false;
    }

    boolean isCollidingSomeoneElse(int x, int y, ArrayList<Personnage> player_list) {
        for (int i = 0; i < player_list.size(); i++) { 
            if (player_list.get(i).getEquipe() != this.equipe &&       // Vérifie si ils sont dans la même équipe
                    player_list.get(i).getVie() > 0 &&                 // Vérifie si le joueur est vivant
                    player_list.get(i).pos.getX() == x + this.pos.getX() &&    // Vérifie si ils ont la même position sur X
                    player_list.get(i).pos.getY() == y + this.pos.getY())      // Vérifie si ils ont la même position sur Y
            {
                PAttacked = i;
                return true;
            }
        }
        return false;
    }

    
    // Getters
    int getEquipe() { return this.equipe; }
    char getSymbol() { return this.symbol; }
    int getVie() { return this.vie; }
    Position getPosition() { return this.pos; }
}
