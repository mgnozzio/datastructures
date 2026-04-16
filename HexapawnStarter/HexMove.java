// A class for representing a HexAPawn move
// (c) 2000, 2001 duane a. bailey

public class HexMove
{
    protected int from;
    protected int to;
    protected int cols;

    public HexMove(int f, int t, int c)
    // post: construct a new move from position f to position t
    //       on a board with c cols
    {
        from = f;
        to = t;
        cols = c;
    }

    public int from()
    // post: get from position
    {
        return from;
    }

    public int to()
    // post: get to position
    {
        return to;
    }

    public String toString()
    // post: generates printable representation of move
    {
        return "Move from ["+(1+(from/cols))+","+(1+(from%cols))+"] "+
            "to ["+(1+(to/cols))+","+(1+(to%cols))+"].";
    }
}
