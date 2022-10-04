//
// blank Husky objects are displayed as H
//
import java.awt.*;

public class Husky extends Critter {
	private int steps;

	public Husky() {}

	//    type Neighbor  : WALL, EMPTY, SAME, OTHER
	//    type Action    : HOP, LEFT, RIGHT, INFECT
	//    type Direction : NORTH, SOUTH, EAST, WEST
    public Action getMove(CritterInfo info) {
        return Action.HOP;
    }

    // color is used to display yourself
    public Color getColor() {
		return Color.WHITE;
    }

	// symbol to display yourself
	public String toString() {
		return "H";
	}
}



