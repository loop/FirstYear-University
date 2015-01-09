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
public class Main3 {

	public static void main(String[] args) {
		Maze aMaze = new Maze();
		Room r1 = createRoom(1);
		Room r2 = createRoom(2);
		Room r3 = createRoom(3);
		Room r4 = createRoom(4);
		addDoor (r1, r2, Room.EAST);
		addDoor (r1, r3, Room.SOUTH);
		addDoor (r3, r4, Room.EAST);
		addDoor (r4, r2, Room.NORTH);

		aMaze.addRoom(r1);
		aMaze.addRoom(r2);
		aMaze.addRoom(r3);
		aMaze.addRoom(r4);

		aMaze.print();
	}

	private static Room createRoom(int id) {
		Room r = new Room(id);
		r.setSide(Room.NORTH, new Wall());
		r.setSide(Room.EAST, new Wall());
		r.setSide(Room.SOUTH, new Wall());
		r.setSide(Room.WEST, new Wall());
		return r;
	}

	private static void addDoor(Room from, Room to, int fromSide) {
		DoorWall d = new DoorWall(from, to);
		from.setSide(fromSide, d);
		to.setSide((fromSide + 2) % 4, d);
	}
}