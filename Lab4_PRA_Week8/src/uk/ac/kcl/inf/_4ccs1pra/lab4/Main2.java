package uk.ac.kcl.inf._4ccs1pra.lab4;

import uk.ac.kcl.inf._4ccs1pra.lab4.maze.DoorWall;
import uk.ac.kcl.inf._4ccs1pra.lab4.maze.Maze;
import uk.ac.kcl.inf._4ccs1pra.lab4.maze.Room;
import uk.ac.kcl.inf._4ccs1pra.lab4.maze.Wall;

/**
 * A simple console-based maze game. This uses the Maze class to create a new
 * maze and then prints it.
 * 
 * @author Steffen Zschaler
 */
public class Main2 {

	public static void main(String[] args) {
		Maze aMaze = new Maze();
		Room r1 = new Room(1);
		Room r2 = new Room(2);
		Room r3 = new Room(3);
		Room r4 = new Room(4);
		DoorWall d = new DoorWall(r1, r2);
		DoorWall d2 = new DoorWall(r3,r1);
		DoorWall d3 = new DoorWall(r4,r3);
		DoorWall d4 = new DoorWall(r4,r2);

		aMaze.addRoom(r1);
		aMaze.addRoom(r2);
		aMaze.addRoom(r3);
		aMaze.addRoom(r4);

		setWallsFor(r1, new Wall(), d, d2, new Wall());
		setWallsFor(r2, new Wall(), new Wall(), d4, d);
		setWallsFor(r3, d2, d3, new Wall(), new Wall());
		setWallsFor(r4, d4, new Wall(), new Wall(), d3);
		

		aMaze.print();
	}

	private static void setWallsFor(Room r, Wall north, Wall east, Wall south,
			Wall west) {
		r.setSide(Room.NORTH, north);
		r.setSide(Room.EAST, east);
		r.setSide(Room.SOUTH, south);
		r.setSide(Room.WEST, west);
	}
}