import java.util.ArrayList;

public class Game {
    private Grid grid;
    private ArrayList<Fighter> fighters;
    private ArrayList<String> teams;

    Game() {
        this.grid = new Grid();
        this.fighters = new ArrayList<Fighter>();
        this.teams = new ArrayList<String>();
        this.teams.add("blue");
        this.teams.add("red");
        this.fighters.add(new Fighter(new Position(0, 0), new Direction(1, 0), teams.get(0), grid, "a", Utils.ANSI_BLUE));
        this.fighters.add(new Fighter(new Position(0, 1), new Direction(1, 0), teams.get(0), grid, "b", Utils.ANSI_BLUE));
        this.fighters.add(new Fighter(new Position(0, 2), new Direction(1, 0), teams.get(0), grid, "c", Utils.ANSI_BLUE));
        this.fighters.add(new Fighter(new Position(0, 3), new Direction(1, 0), teams.get(0), grid, "d", Utils.ANSI_BLUE));
        this.fighters.add(new Fighter(new Position(0, 4), new Direction(1, 0), teams.get(0), grid, "e", Utils.ANSI_BLUE));
        this.fighters.add(new Fighter(new Position(9, 0), new Direction(-1, 0), teams.get(1), grid, "A", Utils.ANSI_RED));
        this.fighters.add(new Fighter(new Position(9, 1), new Direction(-1, 0), teams.get(1), grid, "B", Utils.ANSI_RED));
        this.fighters.add(new Fighter(new Position(9, 2), new Direction(-1, 0), teams.get(1), grid, "C", Utils.ANSI_RED));
        this.fighters.add(new Fighter(new Position(9, 3), new Direction(-1, 0), teams.get(1), grid, "D", Utils.ANSI_RED));
        this.fighters.add(new Fighter(new Position(9, 4), new Direction(-1, 0), teams.get(1), grid, "E", Utils.ANSI_RED));

        // add the fighters to the grid
        for (int i = 0; i < fighters.size(); ++i) { grid.insertFighter(fighters.get(i)); }

        // print the grid once
        grid.printGrid();
    }

    public void run() {
        int numberOfTeamAlive = getNumberOfTeaStillmAlive();

        // loop until a team (or none if cross kill) win
        while (numberOfTeamAlive > 1) {
            // move every fighter of each team
            for (int i = 0; i < teams.size(); ++i) {
                this.moveATeam(teams.get(i), 100);
            }

            // recount the number of team left
            numberOfTeamAlive = getNumberOfTeaStillmAlive();
        }

        if (numberOfTeamAlive == 0) { System.out.println("Nobody won everyone is dead, make love not war."); }

        // print the winner team
        String lastTeam = "";
        for (int i = 0; i < fighters.size(); ++i) { if (fighters.get(i).getIsAlive()) { lastTeam = fighters.get(i).getColoredTeam(); }}
        System.out.println("The team " + lastTeam + " won the game !");
    }

    public int getNumberOfTeaStillmAlive() {
        ArrayList<String> aliveTeams = new ArrayList<String>();

        for (int i = 0; i < fighters.size(); ++i) {

            // if the player is not alive continue
            if (!fighters.get(i).getIsAlive()) { continue; }

            // if the team hasn't been counted yet add it to the list
            final String fighterTeam = fighters.get(i).getTeam();
            if (!aliveTeams.contains(fighterTeam)) { aliveTeams.add(fighterTeam); }
        }

        return aliveTeams.size();
    }

    // this method call the "move" method on every fighters of a given team
    private void moveATeam(String teamName, int sleepBetweenMove) {
        for (int i = 0; i < fighters.size(); ++i) {
            final Fighter currentFighter =  fighters.get(i);

            // if the player is dead continue
            if (!currentFighter.getIsAlive()) { continue; }

            // if the player isn't a member of the team continue
            if (!teamName.equals(currentFighter.getTeam())) { continue; }

            // move the player
            currentFighter.move();

            Utils.sleep(sleepBetweenMove);

            // show the new grid
            grid.printGrid();
        }
    }
}
