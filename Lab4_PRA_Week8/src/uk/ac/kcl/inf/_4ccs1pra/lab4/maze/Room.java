package uk.ac.kcl.inf._4ccs1pra.lab4.maze;

/**
 * A single room in a maze.
 * 
 * @author Steffen Zschaler
 */
public class Room {

	/**
	 * Flag indicating the north wall of a room.
	 */
	public static final int NORTH = 0;

	/**
	 * Flag indicating the north wall of a room.
	 */
	public static final int EAST = 1;

	/**
	 * Flag indicating the north wall of a room.
	 */
	public static final int SOUTH = 2;

	/**
	 * Flag indicating the north wall of a room.
	 */
	public static final int WEST = 3;

	private int id;

	private Wall[] walls = new Wall[4];

	public Room(int id) {
		this.id = id;
	}

	/**
	 * Set the given side of the room to the given wall.
	 * 
	 * @param direction
	 *            one of {@link Room#NORTH}, {@link Room#EAST},
	 *            {@link Room#SOUTH}, or {@link Room#WEST}.
	 * 
	 * @param wall
	 *            the wall to be set for the specified side
	 */
	public void setSide(int direction, Wall wall) {
		walls[direction] = wall;
	}

	/**
	 * Prints this room.
	 */
	public void print() {
		System.out.println ("Room # " + id);
		
		System.out.println ("North wall is " + walls[NORTH] + ".");
		System.out.println ("East  wall is " + walls[EAST]  + ".");
		System.out.println ("South wall is " + walls[SOUTH] + ".");
		System.out.println ("West  wall is " + walls[WEST]  + ".");
	}

	/**
	 * Get the id of this room.
	 * 
	 * @return
	 */
	public int getID() {
		return id;
	}
}