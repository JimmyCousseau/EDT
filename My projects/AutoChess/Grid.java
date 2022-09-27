import java.util.ArrayList;

public class Grid {
    final private int WIDTH = 5;
    final private int HEIGHT = 10;
    private Fighter[][] grid = new Fighter[HEIGHT][WIDTH];

    Grid() { }

    // return a list of position of every cells who are unocupied around a given position
    public ArrayList<Position> getEmptyAdjacentCells(int cellX, int cellY) {
        ArrayList<Position> emptyCells = new ArrayList<Position>();
        for (int x = -1; x < 1; ++x) {
            for (int y = -1; y < 1; ++y) {

                // continue if the cell ins't inside the grid
                int newCellx = cellX + x;
                if ((newCellx < 0) || (newCellx >= HEIGHT)) { continue; }
                int newCelly = cellY + y;
                if ((newCelly < 0) || (newCelly >= WIDTH)) { continue; }

                // if the grid is empty add it to the list
                if (grid[newCellx][newCelly] == null)
                {
                    emptyCells.add(new Position(newCellx, newCelly));
                }
            }
        }

        return emptyCells;
    }

    public boolean insertFighter(Fighter fighter) {
        Position fighterPosition = fighter.getPosition();
        assert this.isPositionPartOfTheGrid(fighterPosition);

        // if the place is already taken
        if (this.hasAFighterOnPosition(fighterPosition)) { return false; }

        grid[fighterPosition.getX()][fighterPosition.getY()] = fighter;

        return true;
    }

    public void removeFighter(Position position) {
        assert this.isPositionPartOfTheGrid(position);
        grid[position.getX()][position.getY()] = null;
    }

    public boolean moveFighter(Fighter fighter, Position newPosition) {
        Position fighterPosition = fighter.getPosition();
        assert this.isPositionPartOfTheGrid(newPosition);

        // in the first place verrify that the fighter is really on the position he claim to be
        // if not doesn't dont move the fighter and retrun false
        if (fighter != this.getFighterOnGrid(fighterPosition)) { return false; }

        // if the place is already taken dont move the fighter and return false
        if (this.hasAFighterOnPosition(newPosition)) { return false; }

        // remove the fighter from his last position
        grid[fighterPosition.getX()][fighterPosition.getY()] = null;

        // place the fighter on his new position
        grid[newPosition.getX()][newPosition.getY()] = fighter;

        // update the fighter position
        fighter.setPosition(newPosition);

        return true;
    }

    public String getGridString() {

        // create the horizontal wall string
        String horizontalLine = "+";
        for (int i = 0; i < WIDTH; ++i) { horizontalLine += "---"; }
        horizontalLine += "+\n";

        String gridString = horizontalLine;

        for (int row = 0; row < HEIGHT; ++row) {
            gridString += "|";
            for (int col = 0; col < WIDTH; ++col) {
                if (grid[row][col] == null) { gridString += " . "; }
                else { gridString += " " + grid[row][col].getFighterString() + " "; }
            }
            gridString += "|\n";
        }

        gridString += horizontalLine;
        return gridString;
    }

    public void printGrid()
    {
        System.out.print(this.getGridString());
    }

    public boolean hasAFighterOnPosition(Position position) {
        assert this.isPositionPartOfTheGrid(position);
        return !(grid[position.getX()][position.getY()] == null);
    }
    
    public Fighter getFighterOnGrid(Position position) {
        assert this.isPositionPartOfTheGrid(position);
        return grid[position.getX()][position.getY()];
    }

    public boolean isPositionPartOfTheGrid(Position position) {
        return !((position.getX() < 0) || (position.getX() >= HEIGHT) || (position.getY() < 0) || (position.getY() >= WIDTH));
    }

    public int getWidth() { return WIDTH; }
    public int getHeight() { return HEIGHT; }
}
