import java.util.Scanner;

public class PoisonousPlants {
	static int plants[];
	static int numOfPlants;
	static int days = 0;

	public static void main(String[] args) {
		input();
		killingPlants();
		output();
	}

	static void input() {
		Scanner scan = new Scanner(System.in);
		numOfPlants = scan.nextInt();
		plants = new int[numOfPlants];
		for (int i = 0; i < numOfPlants; i++) {
			plants[i] = scan.nextInt();
		}
	}

	static void output() {
		System.out.println(days);
	}

	static void killingPlants() {
		boolean deadPlants = false;
		do {
			deadPlants = false;
			for (int i = 1; i < numOfPlants; i++) {
				if (plants[i] != -1) {
					if (plants[i - 1] < plants[i]) {
						plants[i] = -1;
						deadPlants = true;
					}
				}
			}
			days++;
		} while (deadPlants);
	}

}