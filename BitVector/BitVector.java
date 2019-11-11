import java.util.Vector;
public class BitVector<E extends Boolean> extends Vector<E> {

    public static void main(String[] args) {
	BitVector<Boolean> b = new BitVector<Boolean>();
	b.add(true);
	b.add(false);
	if(b.get(0)) System.out.println("Hello ");
	if(b.get(1)) System.out.println("World");
    }

}