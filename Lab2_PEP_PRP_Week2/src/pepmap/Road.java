package pepmap;

/**
 *
 * @author Martin
 */
public class Road {

  private Town townA;
  private Town townB;
  private int distance;
  
  public Road () {}
  
  /**
   * A Road linking two towns
   * @param townA Start town
   * @param townB Destination town
   * @param distance The distances between the towns
   */
  public Road (Town townA, Town townB, int distance) { 
    
    this.townA = townA;
    this.townB = townB;
    this.distance = distance;
    
  }
  
  public void setTownA(Town townA) {
    
    this.townA = townA;
    
  }
  
  public void setTownB(Town townB) {
    
    this.townB = townB;
    
  }
   
  public void setDistance(int distance) {
    
    this.distance = distance;
    
  }
  
  public Town getTownA() {
 
    return townA;
    
  }
      
  public Town getTownB() {
    
    return townB;
    
  }
  
  public int getDistance() {
    
    return distance;
    
  }
  
  @Override
  public String toString() {
    
    return "A road from " + townA + " to " + townB + " of distance " + distance; 
    
  }
  
}
