// CSE 142 Critters
// Authors: Frank Yang
//
// Husky objects are displayed as H
//
//
import java.awt.*;

public class Husky1 extends Critter {
	private int steps;

	public Husky1() {
		steps = 0;
	}

	// infect someone in front; if no one is in front and is empty, hop to it
	// otherwise, turn left
	//    type Neighbor  : WALL, EMPTY, SAME, OTHER
	//    type Action    : HOP, LEFT, RIGHT, INFECT
	//    type Direction : NORTH, SOUTH, EAST, WEST
    public Action getMove(CritterInfo info) {
		steps++;
		if(info.getFront().equals(Neighbor.OTHER)) {
			return Action.INFECT;
		} else if(info.getFront().equals(Neighbor.EMPTY)) {
			return Action.HOP;
		} else {
			return Action.LEFT;
		}
    }

    // color is alternating yellow and purple
    public Color getColor() {
		return Color.YELLOW;
		// if(steps % 2 == 0) {
		// 	return Color.YELLOW;
		// } else {
		// 	return Color.BLUE;
		// }
    }

	// ascii(157) "¥"
	public String toString() {
		return "1";
		// return Character.toString((char) steps);
	}
}



