// // CSE 142 Critters
// // Authors: Frank Yang
// //
// // Husky objects are displayed as H
// //
// //
// import java.awt.*;
// import java.util.*;

// public class Husky2 extends Critter{
// 	private int steps;
// 	private final String NORMAL = "2";
// 	private final String THREATENED = "T";
// 	private String icon = NORMAL;
// 	Color color;

// 	public Husky2(){
// 		steps = 0;
// 		Random r = new Random();
// 		List<Color> possibleColors = Arrays.asList(Color.YELLOW, Color.BLUE);
// 		// List<String> possibleColors = Arrays.asList({"white", "tabby", "ginger", "black"});
// 		color = possibleColors.get(r.nextInt(possibleColors.size()));
// 	}

// 	// infect someone in front; if no one is in front and is empty, hop to it
// 	// otherwise, turn left
// 	//    type Neighbor  : WALL, EMPTY, SAME, OTHER
// 	//    type Action    : HOP, LEFT, RIGHT, INFECT
// 	//    type Direction : NORTH, SOUTH, EAST, WEST
//     public Action getMove(CritterInfo info) {
// 		steps++;
// 		if(info.frontThreat() || info.backThreat() ||
// 				info.leftThreat() || info.rightThreat()) icon = THREATENED;
// 		else icon = NORMAL;
// 		if(info.frontThreat() || info.getFront().equals(Neighbor.OTHER)) {
// 			return Action.INFECT;
// 		} else {
// 			if(info.getFront().equals(Neighbor.EMPTY)) {
// 				return Action.HOP;
// 			} else {
// 				if(steps %2 == 0) return Action.RIGHT;
// 				else return Action.LEFT;
// 			}
// 		}
// 		// if(info.getFront().equals(Neighbor.OTHER)) {
// 		// 	return Action.INFECT;
// 		// } else if(info.getFront().equals(Neighbor.EMPTY)) {
// 		// 	return Action.HOP;
// 		// } else {
// 		// 	return Action.LEFT;
// 		// }
//     }

//     // color is alternating yellow and magenta
//     public Color getColor() {
// 		return color;
//         // return Color.MAGENTA;
// 		// if(steps % 2 == 0) {
// 		// 	return Color.YELLOW;
// 		// } else {
// 		// 	return Color.BLUE;
// 		// }
//     }

// 	// ascii(157) "¥"
// 	public String toString() {
// 		// return icon;
// 		return Character.toString((char) steps) + steps;
// 	}
// }



