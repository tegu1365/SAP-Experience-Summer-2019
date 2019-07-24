import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {

	static int num;
	static ArrayDeque<Integer> binary = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		input();
		decToBinary();
		output();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
	}

	static void decToBinary() {
		while (num > 0) {
			binary.push(num % 2);
			num /= 2;
		}
	}

	static void output() {
		int numOfElements = binary.size();
		for (int i = 0; i < numOfElements; i++) {
			System.out.print(binary.pop());
		}
	}
}
