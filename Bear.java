import java.awt.*;  // to use Color

public class Bear extends Critter{
    // whether or not bear is a polar bear
    private boolean polar;

    private String icon = "\\";

    public Bear(boolean polar) {
        this.polar = polar;
    }

    // Infect if an enemy is in front; otherwise hop if empty in front;
    // otherwise turn left
    //    type Neighbor  : WALL, EMPTY, SAME, OTHER
    //    type Action    : HOP, LEFT, RIGHT, INFECT
    public Action getMove(CritterInfo info) {
        if(info.getFront().equals(Neighbor.OTHER)) {
            return Action.INFECT;
        } else {
            if(info.getFront().equals(Neighbor.EMPTY)) {
                return Action.HOP;
            } else {
                return Action.LEFT;
            }
        }
    }

    // Color.WHITE for a polar bear (when polar is true),
    // Color.BLACK otherwise (when polar is false)
    public Color getColor() {
        if(polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }

    }

    // Alternate on each move between a forward slash ("/") and
    // a backslash ("\") starting with a forward slash ("/")
    public String toString() {
        if(icon.equals("\\")) {
            icon = "/";
        } else {
            icon = "\\";
        }
        return icon;
    }
}
