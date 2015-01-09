package pepmap;

/**
 *
 * @author Martin
 */
public class Town {
  
   int name;
 
   /**
    * Simple class representing a Town with a given name
    * @param name 
    */
   public Town(int name) {
     
     this.name = name;
     
   }
   
   public int townName() {
     
     return name;
     
   }
   
   @Override
   public String toString() {
     
     return "Town " + name;
      
   }
   
}
  
