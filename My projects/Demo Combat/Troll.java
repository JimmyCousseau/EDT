public class Troll extends Personnage {
    Troll(Position pos, int equipe, Map map) {
        super(pos, equipe, map, "Troll", 'T', 3, 3, 3, 3, 3, 2);
    }
    
    Troll(Position pos, int equipe, Map map, String name, char symbol) {
        super(pos, equipe, map, name, symbol, 3, 3, 3, 3, 3, 2);
    }
}
