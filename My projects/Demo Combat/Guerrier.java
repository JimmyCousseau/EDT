public class Guerrier extends Personnage {
    Guerrier(Position pos, int equipe, Map map) {
        super(pos, equipe, map, "Guerrier", 'G', 1, 5, 6, 1, 5, 1);
    }
    
    Guerrier(Position pos, int equipe, Map map, String name, char symbol) {
        super(pos, equipe, map, name, symbol, 1, 5, 6, 1, 5, 1);
    }
}
