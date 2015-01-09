package uk.ac.kcl.inf._4ccs1pra.lab4.maze;

/**
 * A door wall is a special wall with a door in it. It connects two rooms.
 * 
 * @author Steffen Zschaler
 */
public class DoorWall extends Wall {

	private Room r1;
	private Room r2;
	
	public DoorWall(Room r1, Room r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	/**
	 * Returns a description of this door wall.
	 */
	@Override
	public String toString() {
		return "a wall with a door connecting room # " + r1.getID() + " to room # " + r2.getID();
	}
}