import java.util.*;

public class SimpleTextEditor {
	static Scanner scan = new Scanner(System.in);
	static int n;
	static String command[] = new String[2];
	static StringBuilder text = new StringBuilder();
	static ArrayDeque<String> versions = new ArrayDeque<String>();

	public static void main(String[] args) {
		inputN();
		editor();
	}

	static void inputN() {
		n = scan.nextInt();
	}

	static void add(String newText) {
		versions.push(text.toString());
		text.append(newText);
		// System.out.println(text);
	}

	static void erase(int n) {
		versions.push(text.toString());
		text.delete(text.length() - n, text.length());
		// System.out.println(text);
	}

	static void editor() {
		while (n > 0) {
			command[0] = scan.next();
			switch (command[0]) {
			case "1":
				command[1] = scan.next();
				add(command[1]);
				break;
			case "2":
				command[1] = scan.next();
				erase(Integer.parseInt(command[1]));
				break;
			case "3":
				command[1] = scan.next();
				System.out.println(text.charAt(Integer.parseInt(command[1]) - 1));
				break;
			case "4":
				text = new StringBuilder(versions.pop());
				break;
			}
			n--;
			command = new String[2];
		}
	}
}
