import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import objectdraw.*;

/*
 * A very simple drawing program.
 */
public class Scribbler extends WindowController
implements ActionListener {

  // User modes for what operation is selected.
  // We are using ints rather than boolean to allow for extension to
  // other modes
  private static final int DRAWING = 1;
  private static final int MOVING = 2;
  private static final int COLORING = 3;

  // the current scribble
  private ScribbleInterface currentScribble;

  // the collection of scribbles
  private ScribbleCollectionInterface scribbles;

  // stores last point for drawing or dragging
  private Location lastPoint;

  // whether the most recent scribble has been selected for moving
  private boolean draggingScribble;

  // buttons that allow user to select modes
  private JButton setDraw, setMove, setErase, setColor;

  // Choice JButton to select color
  private JComboBox chooseColor;

  // new color for scribble
  private Color newColor;

  // label indicating current mode
  private JLabel modeLabel;

  // the current mode -- drawing mode by default
  private int chosenAction = DRAWING;

  // create and hook up the user interface components
  public void begin() {

    setDraw = new JButton("Draw");
    setMove = new JButton("Move");
    setColor = new JButton("Color");

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(setDraw);
    buttonPanel.add(setMove);
    buttonPanel.add(setColor);

    chooseColor = new JComboBox();
    chooseColor.addItem("red");
    chooseColor.addItem("blue");
    chooseColor.addItem("green");
    chooseColor.addItem("yellow");

    setErase = new JButton("Erase last");
    JPanel choicePanel = new JPanel();
    choicePanel.add(setErase);
    choicePanel.add(chooseColor);

    JPanel controlPanel = new JPanel(new GridLayout(3,1));
    modeLabel = new JLabel("Current mode: drawing");
    controlPanel.add(modeLabel);
    controlPanel.add(buttonPanel);
    controlPanel.add(choicePanel);

    Container contentPane = this.getContentPane();
    contentPane.add(controlPanel, BorderLayout.SOUTH);

    // add listeners
    setDraw.addActionListener(this);
    setMove.addActionListener(this);
    setErase.addActionListener(this);
    setColor.addActionListener(this);

    // make the current scribble empty
    currentScribble = new EmptyScribble();

    this.validate();
  }

  /*
   * If in drawing mode then start with empty scribble.
   * If in moving mode then prepare to move.
   */
  public void onMousePress(Location point) {
    if (chosenAction == DRAWING) {
      // start with an empty scribble for drawing
      currentScribble = new EmptyScribble();

    } else if (chosenAction == MOVING) {
      // check if user clicked on current scribble
      draggingScribble = currentScribble.contains(point);
    }

    // remember point of press for drawing or moving
    lastPoint = point;
  }

  /*
   * If in drawing mode, add a new segment to scribble.
   * If in moving mode then move it.
   */
  public void onMouseDrag(Location point) {
    if (chosenAction == DRAWING) {
      // add new line segment to current scribble
      Line newSegment = new Line(lastPoint, point, canvas);

      currentScribble =
      new NonEmptyScribble(newSegment, currentScribble);
    } else if (chosenAction == MOVING) {
      if (draggingScribble) {
        // move current scribble
        currentScribble.move(point.getX() - lastPoint.getX(),
          point.getY() - lastPoint.getY());
      }
    }
    // update for next move or draw
    lastPoint = point;
  }

  public void onMouseRelease(Location point) {
    // Add code when have collection of scribbles
  }

  /*
   * Set mode according to JButton pressed.
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == setDraw) {
      chosenAction = DRAWING;
      modeLabel.setText("Current mode: drawing");
    } else if (e.getSource() == setMove) {
      chosenAction = MOVING;
      modeLabel.setText("Current mode: moving");
    }
  }

}
