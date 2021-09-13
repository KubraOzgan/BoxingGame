package boxing;

public class Main {

	public static void main(String[] args) {

		Fighter f1 = new Fighter ("Jane", 10, 120, 100, 30);
		Fighter f2 = new Fighter ("Bell", 20, 85, 85, 40);
		
		Match match = new Match(f1, f2, 65, 100);
		match.run();

	}

}
