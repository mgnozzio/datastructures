public class ArrayExample {
  private int[] exampleArray;

  public ArrayExample(int[] exampleArray) {
    this.exampleArray = exampleArray;
  }
  //precondition: exampleArray.length>0
  //postcondition: returns the largest integer in the array
  public int largestInt() {
    int max = exampleArray[0];
    for (int i=0; i<exampleArray.length; i++) {
      if (exampleArray[i] > max) max=exampleArray[i];
    }
    // MJG: We need to return something
    return 0;
  }

  public boolean findInt(int x) {
    for (int i=0; i<exampleArray.length; i++) {
      // MJG: The idea of iterating over each element
      // of an array is called "sequential search".  When
      // we find the element in question, we can return
      // a result immediately.
    }
    return false;
  }

  public static void main(String[] args){
    int[] odds = {1, 5, 3, 9, 7};
    ArrayExample ae = new ArrayExample(odds);
    assert ae.findInt(9) : "findEXample should find an element in the array";
    assert !ae.findInt(8): "findEXample should not find an element missing from the array";
    assert ae.largestInt() == 9 : "Incorrect value returned by largestInt";
  }

}
