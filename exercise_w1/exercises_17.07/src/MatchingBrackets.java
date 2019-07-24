import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

	static char[] expression;
	static ArrayDeque<Integer> bracketsIndexes = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		input();
		findBrackets();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		expression = scan.nextLine().toCharArray();
	}

	static void findBrackets() {
		for (int i = 0; i < expression.length; i++) {
			if (expression[i] == '(') {
				bracketsIndexes.push(i);
			}
			if (expression[i] == ')') {
				for (int j = bracketsIndexes.pop(); j <= i; j++) {
					System.out.print(expression[j]);
				}
				System.out.print("\n");
			}
		}
	}
}
