# Critters21
Critters 2021

## Objectives
This assignment will assess your mastery of the following objectives:
Write a class to define objects with specified behavior.
Use fields to store state necessary for a class's operation.
Practice good object-oriented design, including abstraction and encapsulation.
Utilize inheritance and choose an appropriate base class for each new class.
Follow prescribed conventions for spacing, indentation, naming, and comments.

See the rest of the project description:
https://courses.cs.washington.edu/courses/cse142/21au/assessments.html#assessment8critters

## Objectives
This assignment will assess your mastery of the following objectives:

Write a class to define objects with specified behavior.
Use fields to store state necessary for a class's operation.
Practice good object-oriented design, including abstraction and encapsulation.
Utilize inheritance and choose an appropriate base class for each new class.
Follow prescribed conventions for spacing, indentation, naming, and comments.

## Program Behavior
You are provided with several client program classes that implement a graphical simulation of a 2D world of animals and other creatures, called "critters". You will write classes that define the behavior of those critters. Critters move and behave in different ways. In this world, critters propagate their species by infecting other critters with their DNA, which transforms the other critter into the infecting critter's species. You will write classes to define the unique behaviors for each critter.

For this assignment you will be given a lot of supporting code that runs the simulation. You are only defining the individual critters that wander around this world trying to infect each other. While it is running, the simulation will look like the image below.

![image](https://user-images.githubusercontent.com/25167086/193921342-00d69f33-b1b7-418f-98b5-0c714cef46e6.png)

This assignment may be confusing at first, because you will not write the main method of the executed program; your code is not in control of the overall execution. Instead, your objects are part of a larger system. You might want your critters make several moves at once using a loop, but you can't. The only way a critter can move is to wait for the simulator to ask it for a single move and return that move. This is typical of object-oriented programming, though it might be frustrating at first.

## Running the Simulation
You will need to download support files in order to properly run the simulation. These files are available on the course website individually and in a zip file called critters.zip. All of these files will need to be in the same folder as your critter files. You **should not** modify any of the provided files, except as described below.

To run the simulation, compile and run CritterMain.java. Within that file, you will notice several lines of code of this form:
```
 // frame.add(30, Lion.class);
```
You should uncomment the line of code for any critters you wish to include in the simulation and comment out all other lines. For example, if you want to run with only bears, leave all lines except `frame.add(30, Bear.class)` commented. If you want all types of critters included, uncomment all lines. You should not make any other modifications to CritterMain.java or any of the other provided files.

## Critter Implementation
Each of your critter classes should extend a base class called Critter. So, each of your critter classes will start like this:

```
public class SomeCritter extends Critter
```
The "extends" clause in the header of this class establishes an inheritance relationship. This is discussed in Chapter 9 of the textbook, although you don't need a deep understanding of the concept for this assignment. The main point to understand is that the Critter class has several methods and constants defined for you. By extending this class, you inherit these methods and constants. Inheritance makes it easier for our code to talk to your critter classes, and it helps us be sure that all your critter classes will implement all the methods we need. You should then give new definitions to certain methods to define the behavior of your critters.

There are three key methods in the Critter class that you will redefine (override) in your own classes. When you override these methods, you must use exactly the same method header as what you see below. The three methods you may override for each Critter class are:

```
public Action getMove(CritterInfo info)
    Each round, the client calls this method on your critter to find out what action it should take on this turn. 
    (See below for more information on CritterInfo and Action.)
public Color getColor()
    Each round, the client calls this method on your critter to find out what color it should appear.
public String toString()
```

Each round, the client calls this method on your critter to find out what text it should be displayed as.
By extending Critter as shown above, you receive a default version of these methods. The default behavior is to always turn left (a move of Action.LEFT), to use the color black, and to display as a "?". If you don't want these defaults, rewrite (override) the necessary methods in your class with your own behavior.

The getMove method will return one of the four Action constants described below. The getColor method will return whatever color you want the simulator to use when drawing your critter. And the toString method will return whatever text you want the simulator to use when displaying your critter (usually but not always a single character).

Each class will also begin with an import declaration for the package java.awt.* to enable usage of the Color class.

For example, below is a definition for a critter called Food. Food always infects and displays itself as a green letter F:

Sample critter class:
```
import java.awt.*;
public class Food extends Critter {
    public Action getMove(CritterInfo info) {
        return Action.INFECT;
    }

    public Color getColor() {
        return Color.GREEN;
    }
    
    public String toString() {
        return "F";
    }
}
```

## Critter Movement
On each round of the simulation, the simulator asks each critter object what action it wants to perform (by calling the getMove method). Each round, a critter will take one of the following actions:

| Action constant	| Description |
|-----------------|----------------------------------------------------------|
| Action.HOP	| Move forward one square in the critter's current direction |
| Action.LEFT	| Turn left (rotate 90 degrees counter-clockwise) |
| Action.RIGHT	| Turn right (rotate 90 degrees clockwise) |
| Action.INFECT	| Infect the critter in front of you |

The getMove method is passed an object of type CritterInfo. This is an object that provides you information about the current status of the critter. It includes eight methods for asking about surrounding neighbors, plus a method to find out the current direction the critter is facing. Below are the methods of the CritterInfo class. (You will not necessarily use all of these methods in your critters.)

| CritterInfo method	| Description |
|--------------------|---------------------------------------------------|
| public Direction getDirection()	| returns the direction you are facing |
| public Neighbor getFront()	     | returns the neighbor in front of you |
| public Neighbor getBack()	      | returns the neighbor in back of you |
| public Neighbor getLeft()	      | returns the neighbor to your left |
| public Neighbor getRight()	     | returns the neighbor to your right |
| public boolean frontThreat()	   | returns whether or not there is an enemy facing you in front of you |
| public boolean backThreat()	    | returns whether or not there is an enemy facing you in back of you |
| public boolean leftThreat()	    | returns whether or not there is an enemy facing you to your left |
| public boolean rightThreat()	   | returns whether or not there is an enemy facing you to your right |

The getDirection method returns what direction you are facing as one of four Direction constants. The next group of four CritterInfo methods (the "get" methods) return one of four Neighbor constants to represent the different kind of neighbors you might encounter. Below are the values of these constants:

| Direction constant	| Description |
|--------------------|-------------|
| Direction.NORTH	| Facing north (up) |
| Direction.SOUTH	| Facing south (down) |
| Direction.EAST	| Facing east (right) |
| Direction.WEST | Facing west (left) |

| Neighbor constant	| Description |
|-------------------|-------------|
| Neighbor.WALL	| The neighbor in that direction is a wall (the edge of the world) |
| Neighbor.EMPTY	| The neighbor in that direction an empty space |
| Neighbor.SAME	| The neighbor in that direction is a critter of your species |
| Neighbor.OTHER	| The neighbor in that direction is a critter of another species (an "enemy") | 

Notice that you are only told whether critters are of your species or some other species; you cannot find out exactly what species they are. The final group of four methods (the "threat" methods) tell you whether there is an enemy in each direction that is facing you (which means they could potentially infect you). An enemy is a critter of a different species.

## Required Critters
You will implement the following four critters for this assessment. Each critter will have one constructor, which must accept exactly the parameters shown below. (Any changes to the constructor will cause the client to not compile.) For any behavior described as random, all possibilities should be equally likely, and random values should be generated using a Randomobject.

## Bear
| Item | Description |
|------------|--------------------------|
|constructor	|public Bear(boolean polar)|
|getColor	|Color.WHITE for a polar bear (when polar is true), Color.BLACK otherwise (when polar is false)|
|toString	|Alternate on each move between a forward slash ("/") and a backslash ("\") starting with a forward slash ("/")|
|getMove	|Infect if an enemy is in front; otherwise hop if empty in front; otherwise turn left|

The Bear constructor accepts a parameter indicating whether or not the bear is a polar (white) bear. When the parameter is true, the resulting bear will be white. When the parameter is false, the resulting bear will be black. The simulator deals with deciding whether each bear will be white or black; your class just needs to ensure that you create the right color bear based on the parameter.


## Lion
```
constructor	public Lion()
getColor	Randomly pick one of Color.RED, Color.GREEN, or Color.BLUE and use that color for three moves, then randomly pick one of those colors again for the next three moves, then randomly pick one of those colors for the next three moves, and so on
toString	"L"
getMove	Infect if an enemy is in front; otherwise if a wall is in front or to the right, turn left; otherwise if a fellow Lion is in front, turn right; otherwise hop
```

## Giant
```
constructor	public Giant()
getColor	Color.GRAY
toString	"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat
getMove	Infect if an enemy is in front; otherwise hop if empty in front; otherwise turn right
```

## Husky
```
constructor	public Husky()
getColor	your choice
toString	your choice
getMove	your choice
```

Your Husky may have any behavior you like, as long as it does not exactly duplicate any example critter you have been shown in class (lecture, section, or lab) or any of the three required critters (Bear, Lion, Giant). In addition you may use advanced material if you choose, as long as it does not break or attempt to "hack" the simulation. Your Husky will only contribute to the Behavior dimension grade. It will not factor in to grading on the other dimensions.

Unlike on most assignments, your Husky can use advanced material you happen to know in Java (with some restrictions). If you wish to use particularly complex material in your Husky, contact your TA or instructor to make sure it will be compatible with our system.

On the last day of class, we will hold a competition pitting students' Husky critters against each other. More details about the tournament and how to participate will be released later. The tournament will be for fun, and participation will be entirely optional—your grade will not be affected by your participation or performance in the tournament.

## Development Strategy and Hints
