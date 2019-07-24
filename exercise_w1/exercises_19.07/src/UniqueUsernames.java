import java.util.*;

public class UniqueUsernames {
	static Set<String> usernamesLibrary = new HashSet<String>();
	static int n;

	public static void main(String[] args) {
		input();
		output();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		n = Integer.parseInt(scan.nextLine());
		while (n>0) {
			String username = scan.nextLine();
			usernamesLibrary.add(username);
			n--;
		}
	}

	static void output() {
		System.out.print(usernamesLibrary);
	}

}
