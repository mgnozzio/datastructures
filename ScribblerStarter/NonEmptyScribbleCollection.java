import objectdraw.*;

public class NonEmptyScribbleCollection implements ScribbleCollectionInterface {

  public NonEmptyScribbleCollection(ScribbleInterface addedScribble,
                                    ScribbleCollectionInterface theRest) {
  }

  // pre:
  // post: returns the scribble that contains the point;
  //    if none contain it, returns an empty scribble
  public ScribbleInterface scribbleSelected(Location point) {
    return null;  // change if necessary!
  }

  // pre:
  // post: returns the first scribble in the list;
  //   returns null if the list is empty.
  public ScribbleInterface getFirst() {
    return null;   // change if necessary!
  }

  // pre:
  // post: returns the list of scribbles excluding the first.
  //   returns an empty scribble collection if the list is empty.
  public ScribbleCollectionInterface getRest() {
    return null;   // change if necessary!
  }
}