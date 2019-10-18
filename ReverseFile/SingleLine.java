import java.util.Scanner;
import java.util.ArrayList; //outrage
public class SingleLine {


    public static void main(String[] args) {

      Scanner s = new Scanner(System.in);
      String finalLine = "";
      String temp = "";
      ArrayList<String> a = new ArrayList<String>();

      int i = 0;
      while (s.hasNextLine()) {
        temp = s.nextLine();
        if (i % 2==0) {
          a.add(temp);
        }
        i++;
      }
      //a.add(1);

      //char[] ca = {'a', 'b', 'c', 'd'};
      String s1 = a.get(1);
      System.out.print(s1.substring(0,3));
    }
}
