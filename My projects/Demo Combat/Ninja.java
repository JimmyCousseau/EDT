public class Ninja extends Personnage {
    Ninja(Position pos, int equipe, Map map) {
        super(pos, equipe, map, "Ninja", 'N', 7, 2, 1, 7, 2, 1);
    }
    Ninja(Position pos, int equipe, Map map, String name, char symbol) {
        super(pos, equipe, map, name, symbol, 7, 2, 1, 7, 2, 1);
    }
}
