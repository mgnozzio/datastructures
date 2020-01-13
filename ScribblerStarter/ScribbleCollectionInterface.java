import objectdraw.*;

/*
 * The methods supported by all scribble collection classes/
 */
public interface ScribbleCollectionInterface {

  // pre:
  // post: returns the scribble that contains the point;
  //    if none contain it, returns an empty scribble
  ScribbleInterface scribbleSelected(Location point);

  // pre:
  // post: returns the first scribble in the list;
  //   returns null if the list is empty.
  ScribbleInterface getFirst();

  // pre:
  // post: returns the list of scribbles excluding the first.
  //   returns null if the list is empty.
  ScribbleCollectionInterface getRest();
}