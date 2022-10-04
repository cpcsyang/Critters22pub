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
```
