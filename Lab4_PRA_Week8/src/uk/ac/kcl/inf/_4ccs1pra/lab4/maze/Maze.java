package uk.ac.kcl.inf._4ccs1pra.lab4.maze;

import java.util.ArrayList;
import java.util.List;

/**
 * A maze. A maze consists of rooms, with walls connecting individual rooms.
 * 
 * @author Steffen Zschaler
 */
public class Maze {

	private List<Room> rooms = new ArrayList<Room>();

	/**
	 * Add the specified room to this maze.
	 * 
	 * @param room
	 */
	public void addRoom(Room room) {
		rooms.add(room);
	}

	/**
	 * Prints the structure of this maze.
	 */
	public void print() {
		System.out.println("A Maze:");
		
		for (Room r : rooms) {
			r.print();
		}
	}
}