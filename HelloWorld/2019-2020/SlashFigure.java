
public class SlashFigure {

	public static void main(String[] args) {
		for(int i=0; i<6; i++) {
			for(int j=0; j<2*i; j++) {
				System.out.print("\\");
			}
			for(int j=0; j<22-4*i; j++) {
				System.out.print("!");
			}
			for(int j=0; j<2*i; j++) {
				System.out.print("/");
			}
			System.out.println();
		}

	}

}
