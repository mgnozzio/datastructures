import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import structure5.*;

/**
 * This class exports the methods necessary to display the creatures on the
 * screen. You should not change this class. You should have the following as
 * the first line of your main:
 * 
 * <pre>
 *  createWorldMap(x, y); </pre>
 * 
 * 
 * Only the Creature code should need to call the displaySquare method.
 */
public class WorldMap {

	/**
	 * Uses the inst pattern. This is the map to be operated on by the rest of
	 * the program.
	 */
	static protected WorldMapImpl map = null;

	/**
	 * Initialize the world map to have size (x,y) and create the Window for it.
	 * This must be called once and only once.
	 */
	static public void createWorldMap(int x, int y) {
		Assert.pre(map == null, "map already created");
		map = new WorldMapImpl(x, y);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
	}

	/**
	 * Update the contents of the square indicated by pos. If c is ' ', then the
	 * square is cleared, and dir and color are ignored.
	 * 
	 * @pre pos is a valid position @pre
	 * <p>
	 * c is the character to be put into the square @pre
	 * <p>
	 * dir is Position.NORTH,Position.SOUTH,Position.EAST,or Position.WEST (dir
	 * is ignore if c is ' ') @pre
	 * <p>
	 * color is "black", "red", "gray", "dark gray", "pink", "orange", "yellow",
	 * "green", "magenta", "cyan", "blue" (color is ignore if c is ' ').
	 */
	static public void displaySquare(
		Position pos,
		char c,
		int dir,
		String color) {
		Assert.pre(
			map != null,
			"Map not created yet.  Be sure to call WorldMap.createWorldMap");
		map.displaySquareInst(pos, c, dir, color);
	}

	/**
	 * Pause for millis milliseconds. Call this atleast once in the main
	 * simulation loop so that the computer can process mouse / keyboard events.
	 *  
	 */
	static public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}

	/****************************************************************************
	 * Everything else below is the internal code to manage the window. You
	 * should not need to modify, understand, or even look at it.
	 ***************************************************************************/

	/**
	 * Inner class for the panel so that everything is encapsulated in the
	 * WorldMap class and not visible outside.
	 */
	static class WorldMapImpl extends JPanel {
	
		private static final long serialVersionUID = 1;

		// constants
		protected static final int SQUARE_SIZE = 22;
		protected static final int PENT_SIZE = 9;
		protected static final int INSET = 10;
		protected static final int CHAR_SIZE = 10;
		final int maxCharHeight = 15;

		protected int width, height; // size of board
		protected Cell board[][]; // the board

		protected static final Font font = new Font("Roman", 0, 10);

		/*
		 * class to store info about one cell on the board
		 */
		protected static class Cell {
			char c = ' ';
			int dir = 0;
			String color = "Black";
		}

		protected WorldMapImpl(int w, int h) {
			super(true);

			//Initialize drawing colors, border, opacity.
			setBackground(Color.white);
			setForeground(Color.black);

			Assert.pre(
				w <= 30 && h <= 30,
				"World Map only supports up to 30x30 worlds.");
			width = w;
			height = h;
			board = new Cell[w][h];
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					board[i][j] = new Cell();
				}
			}

			JFrame f = new JFrame("Darwin");
			f.setSize(
				new Dimension(
					2 * INSET + SQUARE_SIZE * (w + 1),
					2 * INSET + SQUARE_SIZE * (h + 1)));
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});

			f.getContentPane().add(this, BorderLayout.CENTER);
			f.setVisible(true);
			f.setResizable(false);
			repaint(0, 0, getWidth(), getHeight());
		}

		/*
		 * Use this to control synchronization between Darwin thread and AWT
		 * thread.
		 */
		final Object sem = new Object();

		/*
		 * Store the new info in the board, and generate a repaint event. This
		 * method will block until the repaint actually occurs.
		 */
		protected void displaySquareInst(
			Position pos,
			char c,
			int d,
			String color) {
			int x = pos.getX();
			int y = pos.getY();
			Assert.pre(
				0 <= x && x < width && 0 <= y && y < height,
				"Bad display square call");
			board[x][y].c = c;
			board[x][y].dir = d;
			board[x][y].color = color;

			// to make sure all updates are seen in a timely fashion, we
			// wait on sem here. sem is notified after the refresh has
			// occured.
			synchronized (sem) {
				// dont't repaint over grid lines
				repaint(
					INSET + x * SQUARE_SIZE + 1,
					INSET + y * SQUARE_SIZE + 1,
					SQUARE_SIZE - 2,
					SQUARE_SIZE - 2);
				try {
					// wait until repaint has occured.
					sem.wait(1000);
				} catch (Exception e) {
					// Should never get here, but just try to
					// keep going if anything goes wrong.
					return;
				}
			}
		}

		protected void drawGrid(Graphics g) {
			g.setColor(Color.black);
			for (int i = 0; i <= width; i++) {
				g.drawLine(
					INSET + i * SQUARE_SIZE,
					INSET,
					INSET + i * SQUARE_SIZE,
					INSET + height * SQUARE_SIZE);
			}
			for (int i = 0; i <= height; i++) {
				g.drawLine(
					INSET,
					INSET + i * SQUARE_SIZE,
					INSET + width * SQUARE_SIZE,
					INSET + i * SQUARE_SIZE);
			}
		}

		/**
		 * Supports the basic colors provided in the AWT. @pre s must be a valid
		 * color string.
		 */
		protected Color stringToColor(String s) {
			if (s.equals("black"))
				return Color.black;
			if (s.equals("red"))
				return Color.red;
			if (s.equals("gray"))
				return Color.gray;
			if (s.equals("dark gray"))
				return Color.darkGray;
			if (s.equals("pink"))
				return Color.pink;
			if (s.equals("orange"))
				return Color.orange;
			if (s.equals("yellow"))
				return Color.yellow;
			if (s.equals("green"))
				return Color.green;
			if (s.equals("magenta"))
				return Color.magenta;
			if (s.equals("cyan"))
				return Color.cyan;
			if (s.equals("blue"))
				return Color.blue;
			Assert.fail("Bad color: " + s);
			return Color.black;
		}

		/**
		 * Draw one cell on the grid. Pass in the x and y grid position and the
		 * contents of the cell.
		 */
		protected void drawSquare(Graphics g, int x, int y, Cell cell) {
			int sqX = INSET + x * SQUARE_SIZE + 1; // left edge of square
			int sqY = INSET + y * SQUARE_SIZE + 1; // right edge of square
			int fontX = 0;
			// x offset to put char in decent place for different dirs
			int fontY = 0;
			// y offset to put char in decent place for different dirs

			if (cell.c == ' ')
				return;

			g.setColor(stringToColor(cell.color));

			switch (cell.dir) {
				case Position.NORTH :
					{
						int x1Points[] =
							{ sqX + 10, sqX + 18, sqX + 18, sqX + 2, sqX + 2 };
						int y1Points[] =
							{ sqY + 2, sqY + 10, sqY + 18, sqY + 18, sqY + 10 };
						g.drawPolygon(x1Points, y1Points, x1Points.length);
						fontX = 1;
						fontY = 1;
						break;
					}
				case Position.WEST :
					{
						int x1Points[] =
							{ sqX + 2, sqX + 10, sqX + 18, sqX + 18, sqX + 10 };
						int y1Points[] =
							{ sqY + 10, sqY + 18, sqY + 18, sqY + 2, sqY + 2 };
						g.drawPolygon(x1Points, y1Points, x1Points.length);
						fontX = 4;
						fontY = 2;
						break;
					}
				case Position.SOUTH :
					{
						int x1Points[] =
							{ sqX + 10, sqX + 18, sqX + 18, sqX + 2, sqX + 2 };
						int y1Points[] =
							{ sqY + 18, sqY + 10, sqY + 2, sqY + 2, sqY + 10 };
						g.drawPolygon(x1Points, y1Points, x1Points.length);
						fontX = 1;
						fontY = 4;
						break;
					}
				case Position.EAST :
					{
						int x1Points[] =
							{ sqX + 18, sqX + 10, sqX + 2, sqX + 2, sqX + 10 };
						int y1Points[] =
							{ sqY + 10, sqY + 18, sqY + 18, sqY + 2, sqY + 2 };
						g.drawPolygon(x1Points, y1Points, x1Points.length);
						fontX = -1;
						fontY = 2;
						break;
					}
			}

			g.setFont(font);
			FontMetrics fm = g.getFontMetrics();
			int height = fm.getHeight() - fontY;
			int width = fm.charWidth(cell.c) - fontX;

			g.drawString(
				"" + cell.c,
				sqX + 10 - width / 2,
				sqY + 10 + height / 2);

		}

		/**
		 * Clear what will be repainted, redraw grid if needed, and then draw any
		 * squares in the clip area.
		 */
		protected void paintComponent(Graphics g) {

			// erase clip region
			super.paintComponent(g);

			// compute the grid squares that must be redrawn
			Shape rect = g.getClip();
			Rectangle bounds = rect.getBounds();
			int minX =
				Math.max(0, (int) ((bounds.getX() - INSET) / SQUARE_SIZE));
			int minY =
				Math.max(0, (int) ((bounds.getY() - INSET) / SQUARE_SIZE));
			int maxX =
				Math.min(
					width - 1,
					(int) ((bounds.getX() + bounds.getWidth() - INSET)
						/ SQUARE_SIZE));
			int maxY =
				Math.min(
					height - 1,
					(int) ((bounds.getY() + bounds.getHeight() - INSET)
						/ SQUARE_SIZE));

			// only redraw grid if clip overlaps one or more grid lines.
			if (minX != maxX || minY != maxY)
				drawGrid(g);

			for (int i = minX; i <= maxX; i++) {
				for (int j = minY; j <= maxY; j++) {
					drawSquare(g, i, j, board[i][j]);
				}
			}

			synchronized (sem) {
				// wake up Darwin thread.
				sem.notify();
			}

		}
	}

}
