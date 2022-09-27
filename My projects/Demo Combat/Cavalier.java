public class Cavalier extends Personnage {
    Cavalier(Position pos, int equipe, Map map) {
        super(pos, equipe, map, "Cavalier", 'C', 3, 3, 5, 1, 4, 1);
    }
    
    Cavalier(Position pos, int equipe, Map map, String name, char symbol) {
        super(pos, equipe, map, name, symbol, 3, 3, 5, 1, 4, 1);
    }
}
