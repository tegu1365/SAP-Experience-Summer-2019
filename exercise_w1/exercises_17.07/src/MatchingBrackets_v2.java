import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_v2 {
	static String expression;
	static ArrayDeque<String> brackets = new ArrayDeque<String>();
	static ArrayDeque<Integer> indexes = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		input();
		findBrackets();
		output();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		expression = scan.nextLine();
	}

	static void output() {
		System.out.println(brackets);
	}

	static void findBrackets() {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				indexes.push(i);
			}
			if (expression.charAt(i) == ')') {
				brackets.push((String) expression.subSequence(indexes.pop(), i + 1));
			}
		}
	}
}
