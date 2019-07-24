import java.util.Scanner;

public class Calculator {

	static String command = new String();
	static double num1, num2;

	public static void main(String[] args) {
		navigation();
	}

	static void inputCommand() {
		Scanner scan = new Scanner(System.in);
		System.out.println("input one of the following commands:\n 1.Add\n 2.Sub\n 3.Dev\n 4.Multi\n 5.End");
		command = scan.next();
	}

	static void inputNumbers() {
		Scanner scan = new Scanner(System.in);
		System.out.println("input a number:");
		num1 = scan.nextDouble();
		System.out.println("input a number:");
		num2 = scan.nextDouble();
	}

	static void output(double ans) {
		System.out.println(ans);
	}

	static void navigation() {
		inputCommand();
		if (!command.equals("End")) {
			inputNumbers();
			switch (command) {
			case "Add":
				output(add(num1, num2));
				break;
			case "Sub":
				output(sub(num1, num2));
				break;
			case "Dev":
				output(dev(num1, num2));
				break;
			case "Multi":
				output(multi(num1, num2));
				break;
			}
			navigation();
		}
	}

	static double add(double a, double b) {
		return a + b;
	}

	static double sub(double a, double b) {
		return a - b;
	}

	static double dev(double a, double b) {
		return a / b;
	}

	static double multi(double a, double b) {
		return a * b;
	}
}
