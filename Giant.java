import java.awt.*;  // Color

public class Giant extends Critter {
    private final int MAX_STEPS = 6;
    private int steps = MAX_STEPS;
    private String icon = "fee";

    // Infect if an enemy is in front; otherwise hop if empty in front; otherwise
    // turn right
    //    type Neighbor  : WALL, EMPTY, SAME, OTHER
    //    type Action    : HOP, LEFT, RIGHT, INFECT
    public Action getMove(CritterInfo info) {
        if(info.getFront().equals(Neighbor.OTHER)) {
            return Action.INFECT;
        } else if(info.getFront().equals(Neighbor.EMPTY)){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    // giant is always gray
    public Color getColor() {
        return Color.GRAY;
    }

    // "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves,
    // then "fum" for 6 moves, then repeat
    public String toString() {
        steps--;
        if (steps <= 0) {
            if (icon.equals("fee")) icon = "fie";
            else if (icon.equals("fie")) icon = "foe";
            else if (icon.equals("foe")) icon = "fum";
            else icon = "fee";
            steps = MAX_STEPS;
        }
        return icon;
    }
}
