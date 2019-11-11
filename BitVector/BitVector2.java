import java.util.Vector;

public class BitVector2 {

    private Vector<Boolean> v;

    public BitVector2() {
	v = new Vector<Boolean>();
    }

    public BitVector2(int capacity) {
	v = new Vector<Boolean>(capacity);
    }

    public void add(boolean b) {
	v.add(b);
    }

    public void add(int i, boolean b) {
	v.add(i, b);
    }

    public boolean remove(boolean b) {
	return v.remove(b);
    }

    public boolean remove(int i) {
	return v.remove(i);
    }

    public boolean get(int i) {
	return v.get(i);
    }

    public boolean set(int i, boolean b) {
	return v.set(i, b);
    }

    public static void main(String[] args) {
        BitVector2 b = new BitVector2();
        b.add(true);
        b.add(false);
        if(b.get(0)) System.out.println("Hello ");
        if(b.get(1)) System.out.println("World");
    }
}
