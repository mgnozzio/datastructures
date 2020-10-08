public class Window {
    
    public static final int SIZE = 4;
    
    public static void main(String[] args) {
        row('+', '=');
        bottom();
        bottom();
    }
    
    public static void row(char c1, char c2){
        System.out.print(c1);
        for(int i=0; i<SIZE; i++) {
            System.out.print(c2);
        }
        System.out.print(c1);
        for(int i=0; i<SIZE; i++) {
            System.out.print(c2);
        }
        System.out.println(c1);
    }
    
    public static void bottom() {
        row('|', ' ');
        row('|', ' ');
        row('|', ' ');
        row('+', '=');
    }
}