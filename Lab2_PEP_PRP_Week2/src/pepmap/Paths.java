package pepmap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class Paths {

  private ArrayList<Road> roads = new ArrayList<Road>();
  
  private int distance = 0;
  private String path = "";
  private HashMap<String, Integer> paths = new HashMap<String, Integer>();
  
  /**
   * Recursively calculate all paths between towns.
   * @param X The start town
   * @param Y The destination town
   * @return A mapping of routes to distances
   */
  private HashMap<String, Integer> calculatePathLength( Town X, Town Y ) {
    
    if (X.townName() == Y.townName()) { return null; }
    
    for (Road road: roads) {
    
      if (road.getTownA().townName() ==  X.townName()) {

        distance += road.getDistance();
        path += road.getTownA() + "=>" + road.getTownB() + ", "; 
        calculatePathLength(road.getTownB(), Y);
        
        if (distance != 0) {
          
          paths.put(path, distance);
          path = "";
          distance = 0;
        
        }
        
      }
    
    }
    
    return paths;
    
  }
  
  public void run() {
  
    Town A = new Town(1);
    Town B = new Town(2);
    Town C = new Town(3);
    Town D = new Town(4);
    Town E = new Town(5);
  
    roads.add(new Road(A, B, 5));
    roads.add(new Road(B, D, 10));
    roads.add(new Road(A, C, 5));
    roads.add(new Road(C, D, 25));
    roads.add(new Road(D, E, 25));
    
    System.out.println(calculatePathLength(A, E).toString());
  
  }
  
  public static void main(String[] args) {

    new Paths().run();
    
  }
  
}