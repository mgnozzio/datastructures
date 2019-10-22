import java.io.*;
import java.util.Scanner;
public class FileReader {

  public static void main(String[] args){

    Scanner s;

    try {
      if(args.length > 0) {
        // Data should be read in from the file at args[0]
        File f = new File(args[0]);
        s = new Scanner(f);
      } else {
        s = new Scanner(System.in);
      }
      while(s.hasNextLine()) {
        System.out.println(s.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }
}
