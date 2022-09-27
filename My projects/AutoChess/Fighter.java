import java.util.ArrayList;

public class Fighter {
    private Position position;
    private Direction direction;
    private String team;
    private String color;
    private String fighterSymbol;
    private Grid grid;

    private boolean isAlive;
    private int strength;
    private int skill;
    private int armor;
    private int dodge;
    private int health;

    Fighter(Position position, Direction direction, String team, Grid grid, String fighterSymbol, String color) {
        this.position = position;
        this.direction = direction;
        this.team = team;
        this.color = color;
        this.grid = grid;
        this.isAlive = true;
        this.fighterSymbol = fighterSymbol;
        this.strength = Utils.getRandomIntInRange(4, 6);
        this.skill = Utils.getRandomIntInRange(4, 6);
        this.armor = Utils.getRandomIntInRange(2, 5);
        this.dodge = Utils.getRandomIntInRange(4, 6);
        this.health = Utils.getRandomIntInRange(10, 20);
    }

    // move the player following the rules of the game
    public void move() {
        int gridWidth = grid.getWidth();
        int gridHeight = grid.getHeight();
        
        // calculate the next position of the player
        Position nextPosition = new Position(position.getX() + direction.getX(), position.getY() + direction.getY());

        // if the player enter in colision with a wall on the vertical direction, change his direction on the vertical direction
        // and change his next position 
        if ((nextPosition.getX() < 0) || (nextPosition.getX() >= gridHeight)) { 
            direction = new Direction(-direction.getX(), direction.getY());
            nextPosition = new Position(position.getX() + direction.getX(), position.getY() + direction.getY());
        }

        // if the player enter in colision with a wall on the horizontal direction, change his direction on the horizontal direction
        // and change his next position 
        if ((nextPosition.getY() < 0) || (nextPosition.getY() >= gridWidth)) { 
            direction = new Direction(direction.getX(), -direction.getY());
            nextPosition = new Position(position.getX() + direction.getX(), position.getY() + direction.getY());
        }

        // at this point the next position of the player is valid and the player has bounced on the wall if needed
        // now we can try to move the player at his new posistion
        if (grid.moveFighter(this, nextPosition)) { return; }

        // if we didn't returned yet it mean the next position was already taken by an other fighter
        // if the fighter is not in the same team we try to kill him.
        Fighter opponent = grid.getFighterOnGrid(nextPosition);
        if (team != opponent.getTeam())
        {
            opponent.receiveAttack(this);

            // if we killed our opponent
            if (!opponent.getIsAlive())
            {
                final String[] niceWord = {" is KO !", " has been killed !", " got demolished !", " got destroyed !", " has been annihilated !"};
                final String commentary = opponent.getFighterString() + niceWord[Utils.getRandomIntInRange(0, niceWord.length -1)];
                System.out.println(commentary);

                grid.removeFighter(nextPosition);
                grid.moveFighter(this, nextPosition);
            }

            // sleep a little so we can read the commentary
            Utils.sleep(2000);
        }

        // if we are still her it mean that the next position is still occupied,
        // we have to choose randomly a next position in the list of unoccupied adjacents cells 
        ArrayList<Position> emptyCells = grid.getEmptyAdjacentCells(position.getX(), position.getY());
        final int numberOfCells = emptyCells.size();
        if (numberOfCells > 0) {
            nextPosition = emptyCells.get(Utils.getRandomIntInRange(0, numberOfCells-1));
            direction = new Direction(nextPosition.getX() - position.getX(), nextPosition.getY() - position.getY());
            grid.moveFighter(this, nextPosition);
            return;
        }

        // if we are still there it mean there is no empty cell near by, so stay in place and change
        // the fighter direction randomly
        direction = new Direction(Utils.getRandomIntInRange(-1, 1), Utils.getRandomIntInRange(-1, 1));
    }

    public void receiveAttack(Fighter attacker) {
        // comment the attack
        final String attackerString = attacker.getFighterString();
        final String attackerTeam = attacker.getColoredTeam();
        final String thisString = this.getFighterString();
        final String thisTeam = this.getColoredTeam();
        String commentary = attackerString + " from the team "+  attackerTeam + " attack the fighter " + thisString + " of the team " + thisTeam + " !";
        System.out.println(commentary);

        final int attackerSkill = attacker.getSkill();

        // if the attacker miss, return
        if (!(attackerSkill > dodge - Utils.rollADice())) 
        {
            final String[] niceWord = {"what a loser !", "he's so bad !", "what a shame !", "ridiculous...", "nice one."};
            commentary = attackerString + " missed ! " + niceWord[Utils.getRandomIntInRange(0, niceWord.length -1)];
            System.out.println(commentary);
            return; 
        }

        final int damages = attacker.getStrength() + Utils.rollADice() - armor;
        
        // if the attack deal no damages, return
        if (damages <= 0) {
            final String[] niceWord = {"he's so weak !", "why his he even here ?", "feelsbad for him..."};
            commentary = attackerString + " hitted but did 0 damage... " + niceWord[Utils.getRandomIntInRange(0, niceWord.length -1)];
            System.out.println(commentary);
            return; 
        }

        // apply the damages
        health -= damages;

        final String[] niceWord = {"offf", "rude !", "nice one !", "great job !", "that's a lot of damages !"};
        commentary = attackerString + " hitted and did " + damages + " damages, " + niceWord[Utils.getRandomIntInRange(0, niceWord.length -1)];
        System.out.println(commentary);
        
        if (health <= 0) {
            isAlive = false;
            health = 0;
        }
    }

    public Position getPosition() { return position; }
    public Direction getDirection() { return direction; }
    public boolean getIsAlive() { return isAlive; }
    public int getStrength() { return strength; }
    public int getSkill() { return skill; }
    public int getArmor() { return armor; }
    public int getDodge() { return dodge; }
    public int getHealth() { return health; }
    public String getFighterString() {
        if (color == null) { return fighterSymbol; }
        return color + fighterSymbol + Utils.ANSI_RESET;
    }
    public String getTeam() { return team; }
    public String getColoredTeam() { 
        if (color == null) { return team; }
        return color + team + Utils.ANSI_RESET;
    }

    public void setPosition(Position position) { this.position = position; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public void setTeam(String team) { this.team = team; }
}
