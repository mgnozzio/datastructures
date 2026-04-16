// A class for representing a HexAPawn board.
// (c) 2000, 2001 duane a. bailey

import structure5.*;
import java.util.Random;
import java.util.Iterator;

public class HexBoard
{
    protected int board[];
    protected int rows, cols;
    protected Vector<HexMove> whiteMoves, blackMoves;
    public final static char WHITE = 'o';
    public final static char BLACK = '*';
    public final static char SPACE = ' ';

    public HexBoard()
    // post: constructs a standard hexapawn board
    {
        this(3,3);
    }

    public HexBoard(int r, int c)
    // pre: r, c >= 3 (shape of board)
    // post: constructs a hexapawn board, white on top, black on bottom
    {
        rows = r;
        cols = c;
        board = new int[rows*cols];
        for (int pos = 0; pos < rows*cols; pos++)
        {
            if (pos < cols) board[pos] = WHITE;
            else if (pos >= (rows-1)*cols) board[pos] = BLACK;
            else board[pos] = SPACE;
        }
        whiteMoves = blackMoves = null;
    }

    public HexBoard(HexBoard orig, HexMove m)
    // pre: orig is valid, move m is meaningful
    // post: constructs a new hexapawn board derived from orig after m
    {
        rows = orig.rows;
        cols = orig.cols;
        whiteMoves = blackMoves = null;
        board = new int[rows*cols];
        for (int i = 0; i < rows*cols; i++) board[i] = orig.board[i];
        board[m.to()] = board[m.from()];
        board[m.from()] = SPACE;
    }

    public static char opponent(char m)
    // pre: m is WHITE or BLACK
    // post: returns opponent
    {
        return (m == WHITE)? BLACK: WHITE;    
    }

    public boolean win(char m)
    // pre: m is WHITE or BLACK
    // post: returns true if m is in a winning position
    {   
        if (m == WHITE)
        {
            for (int pos = (rows-1)*cols; pos < rows*cols; pos++)
            {
                if (board[pos] == WHITE) return true;
            }
            return 0 == moves(BLACK).size();
        } else {
            for (int pos = 0; pos < cols; pos++)
            {
                if (board[pos] == BLACK) return true;
            }
            return 0 == moves(WHITE).size();
        }
    }

    public Vector<HexMove> moves(char m)
    // pre: m is BLACK or WHITE
    // post: returns a vector of possible hexapawn moves from this
    //       position, provided m moves next
    {
        if (m == WHITE)
        {
            if (whiteMoves != null) return whiteMoves;
            whiteMoves = new Vector<HexMove>();
            for (int pos = 0; pos < (rows-1)*cols; pos++)
            {
                if (board[pos] == WHITE)
                {
                    if (board[pos+cols] == SPACE)
                    {
                        whiteMoves.addElement(new HexMove(pos,pos+cols,cols));
                    }
                    if ((pos%cols)!=0 &&
                        board[pos+(cols-1)] == BLACK)
                    {
                        whiteMoves.addElement(new HexMove(pos,pos+cols-1,cols));
                    }
                    if ((pos%cols)!=(cols-1) &&
                        board[pos+cols+1] == BLACK)
                    {
                        whiteMoves.addElement(new HexMove(pos,pos+cols+1,cols));
                    }
                }
            }
            return whiteMoves;
        } else {
            if (blackMoves != null) return blackMoves;
            blackMoves = new Vector<HexMove>();
            for (int pos = cols; pos < rows*cols; pos++)
            {
                if (board[pos] == BLACK)
                {
                    if (board[pos-cols] == SPACE)
                    {
                        blackMoves.addElement(new HexMove(pos,pos-cols,cols));
                    }
                    if ((pos%cols)!=0 &&
                        board[pos-cols-1] == WHITE)
                    {
                        blackMoves.addElement(new HexMove(pos,pos-cols-1,cols));
                    }
                    if ((pos%cols)!=cols-1 &&
                        board[pos-cols+1] == WHITE)
                    {
                        blackMoves.addElement(new HexMove(pos,pos-cols+1,cols));
                    }
                }
            }
            return blackMoves;
        }
    }

    public String toString()
    // post: returns a printable version of the board.
    {
        String result = "-";
        for (int pos = 0; pos < cols; pos++) result += "--";
        result += "\n";
        for (int pos = 0; pos < rows*cols; pos++)
        {
            result += " "+((char)board[pos]);
            if ((cols-1) == (pos%cols)) result += '\n';
        }
        for (int pos = 0; pos < cols; pos++) result += "--";
        result += "-\n\n";
        return result;
    }


    // An example of how to use this class: play a game of hexapawn
    public static void main(String[] args)
    {
        HexBoard b = new HexBoard(3,3); // change me!
        Vector<HexMove> moves;
        ReadStream r = new ReadStream();
        int yourMove;
        int myMove;
        Random gen = new Random();
        System.out.println(b);

        do
        {
            // white to play (human): print moves
            moves = b.moves(WHITE);
            Iterator i = moves.iterator();
            int j = 0;
            while (i.hasNext())
            {
                System.out.println(j+". "+i.next());
                j++;
            }
            // read move from keyboard
            yourMove = r.readInt();

            // construct a new board, based on move
            b = new HexBoard(b,(HexMove)moves.elementAt(yourMove));
            System.out.println(b);

            // if WHITE won, claim the victory and leave.
            if (b.win(WHITE)) { System.out.println("You win!"); break; }

            // black's move (compute): move randomly, but legally
            // get moves
            moves = b.moves(BLACK);
            // pick one
            myMove = Math.abs(gen.nextInt()) % moves.size();
            // construct new board
            b = new HexBoard(b,(HexMove)moves.elementAt(myMove));
            System.out.println("I "+moves.elementAt(myMove));
            System.out.println(b);
            // claim victory, if true
            if (b.win(BLACK)) { System.out.println("I win!"); break; }
        } while (true);
    }
}
