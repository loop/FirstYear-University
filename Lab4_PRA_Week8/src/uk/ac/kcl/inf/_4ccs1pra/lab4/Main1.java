package uk.ac.kcl.inf._4ccs1pra.lab4;

import uk.ac.kcl.inf._4ccs1pra.lab4.maze.DoorWall;
import uk.ac.kcl.inf._4ccs1pra.lab4.maze.Maze;
import uk.ac.kcl.inf._4ccs1pra.lab4.maze.Room;
import uk.ac.kcl.inf._4ccs1pra.lab4.maze.Wall;

/**
 * A simple console-based maze game. This uses the Maze class to create a new maze and then prints it.
 * 
 * @author Steffen Zschaler
 */
public class Main1 {

	public static void main(String[] args) {
	    Maze aMaze = new Maze();
	    Room r1 = new Room (1);
	    Room r2 = new Room (2);
	    Room r3 = new Room (3);
	    Room r4 = new Room (4);
		DoorWall d  = new DoorWall (r1, r2);
		DoorWall d2 = new DoorWall (r3, r1);
		DoorWall d3 = new DoorWall (r4, r3);
		DoorWall d4 = new DoorWall (r4, r2);

		
	    aMaze.addRoom(r1);
	    aMaze.addRoom(r2);
	    aMaze.addRoom(r3);
	    aMaze.addRoom(r4);
	    
	    r1.setSide(Room.NORTH, new Wall());
	    r1.setSide(Room.EAST,  d);
	    r1.setSide(Room.SOUTH, d2);
	    r1.setSide(Room.WEST,  new Wall());
	    
	    r2.setSide(Room.NORTH, new Wall());
	    r2.setSide(Room.EAST,  new Wall());
	    r2.setSide(Room.SOUTH, d4);
	    r2.setSide(Room.WEST,  d);
	    
	    r3.setSide(Room.NORTH, d2);
	    r3.setSide(Room.EAST,  d3);
	    r3.setSide(Room.SOUTH, new Wall());
	    r3.setSide(Room.WEST,  new Wall());	  
	    
	    r4.setSide(Room.NORTH, d4);
	    r4.setSide(Room.EAST,  new Wall());
	    r4.setSide(Room.SOUTH, new Wall());
	    r4.setSide(Room.WEST,  d3);	 
	    
	    aMaze.print();
	}
}