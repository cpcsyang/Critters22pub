import java.awt.*;  // Color

public class Lion extends Critter{
    private final int MAX_STEPS = 3;
    private int steps = MAX_STEPS;
    private Color currentColor = Color.RED;

    // Infect if an enemy is in front; otherwise if a wall is in front or to the right,
    // turn left; otherwise if a fellow Lion is in front, turn right; otherwise hop
    //    type Neighbor  : WALL, EMPTY, SAME, OTHER
    //    type Action    : HOP, LEFT, RIGHT, INFECT
    public Action getMove(CritterInfo info) {
        if(info.getFront().equals(Neighbor.OTHER)) {
            return Action.INFECT;
        } else {
            if(info.getFront().equals(Neighbor.WALL) || info.getRight().equals(Neighbor.WALL)) {
                return Action.LEFT;
            } else if(info.getFront().equals(Neighbor.SAME)) {
                return Action.RIGHT;
            } else {
                return Action.HOP;
            }
        }
    }

    // Randomly pick one of Color.RED, Color.GREEN, or Color.BLUE and
    // use that color for three moves, then randomly pick one of those colors
    // again for the next three moves, then randomly pick one of those colors for
    // the next three moves, and so on
    public Color getColor() {
        steps--;
        if (steps <= 0) {
            if (currentColor.equals(Color.RED)) currentColor = Color.GREEN;
            else if (currentColor.equals(Color.GREEN)) currentColor = Color.BLUE;
            else currentColor = Color.RED;
            steps = MAX_STEPS;
        }
        return currentColor;
    }

    // bear has the symbol "L"
    public String toString() {
        return "L";
    }
}
