import objectdraw.*;

/*
 * A simple program to draw a rubber band line.
 * This version creates a single line segment and
 * the changes the end point each time the mouse moves.
 */
public class RubberBand extends WindowController {
    
    private Line line;          // the line being drawn
    
    public void onMousePress(Location pressedPoint) {
        line = new Line(pressedPoint, pressedPoint, canvas);
    }

    public void onMouseDrag(Location point) {
        line.setEnd(point);
    }
}