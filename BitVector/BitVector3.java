import java.util.Vector;
import java.util.Arrays;
public class BitVector3 {

    private boolean[] a;
    private int size;

    public BitVector3() {
	this(2);
    }

    public BitVector3(int capacity) {
	a = new boolean[capacity];
	size = 0;
    }

    public void add(boolean b) {
	this.add(size, b);
    }

    public void add(int i, boolean b) {
	boolean[] a1 = a;
	if(size == a.length) {
	    // resize if necessary and copy elements staying
	    // in their original position
	    a1 = new boolean[a.length * 2];
	    for(int j = 0; j < i; j++) a1[j] = a[j];
	}
	// shift everything after i down one
	for(int j=size-1; j>=i; j--) {
	    a1[j] = a[j-1];
	}
	
	// add the new element
	a1[i] = b;
	size++;

	// update a
	a = a1;
	
    }

    public boolean remove(boolean b) {
	for(int i=0; i<size; i++) {
	    if(a[i] == b) return remove(i);
	}
	// Cannot return null because booleans are primitives
	return false;
    }

    public boolean remove(int i) {
	if(i >= size) throw new ArrayIndexOutOfBoundsException();
	boolean b = a[i];
	for(int j=i; j<size-1; j++) {
	    a[j] = a[j+1];
	}
	size--;
	return b;
    }

    public boolean get(int i) {
	if(i >= size) throw new ArrayIndexOutOfBoundsException();
	return a[i];
    }

    public boolean set(int i, boolean b) {
	if(i >= size) throw new ArrayIndexOutOfBoundsException();
	return a[i] = b;
    }

    public String toString() {
	if (size==0) return "[]";
	String s = "[" + a[0];
	for(int i=1; i<size; i++) {
	    s+= "," + a[i];
	}
	return s + "]";
    }

    public static void main(String[] args) {
        BitVector3 b = new BitVector3();
        b.add(true);
        b.add(false);
        if(b.get(0)) System.out.println("Hello ");
        if(b.get(1)) System.out.println("World");
    }
}
