
import objectdraw.*;

/*
 * A class to represent a non-empty scribble
 */
public class NonEmptyScribble implements ScribbleInterface {

  // an edge line of the scribble
  private Line first;        

  // the rest of the scribble
  private ScribbleInterface rest; 

  public NonEmptyScribble(Line segment, ScribbleInterface theRest) {
    first = segment;
    rest = theRest;
  }

  /*
   * Returns true iff the scribble contains the point.
   */
  public boolean contains(Location point) {
    return (first.contains(point) || rest.contains(point));
  }

  /*
   * Move the scribble by xOffset in the x direction
   *    and yOffset in the y direction
   */
  public void move(double xOffset, double yOffset) {
    first.move(xOffset, yOffset);
    rest.move(xOffset, yOffset);
  }

}
