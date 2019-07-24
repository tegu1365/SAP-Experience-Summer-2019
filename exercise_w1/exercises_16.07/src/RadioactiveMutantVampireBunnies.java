import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {

	static int n, m;
	static char lair[][];
	static char directions[];
	static int currentPositionN, currentPositionM;
	static StringBuilder status=new StringBuilder("No winner");

	public static void main(String[] args) {
		Input();
		PlayersMoves();
		Output();
	}

	static void Input() {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		lair = new char[n][m];
		for (int i = 0; i < n; i++) {
			char oneRow[] = input.next().toCharArray();

			for (int j = 0; j < m; j++) {
				lair[i][j] = oneRow[j];
			}
		}
		directions = input.next().toCharArray();
	}

	static void Output() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(lair[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println(status);
	}

	static void FindPlayerPosition() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (lair[i][j] == 'P') {
					currentPositionN = i;
					currentPositionM = j;
					lair[i][j] = '.';
					break;
				}
			}
		}
	}

	static void InfectWithBunnies() {
		char newLair[][] = new char[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newLair[i][j] = lair[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (lair[i][j] == 'B') {
					if (i + 1 != n) {
						newLair[i + 1][j] = 'B';
					}
					if (i - 1 >= 0) {
						newLair[i - 1][j] = 'B';
					}
					if (j + 1 != m) {
						newLair[i][j + 1] = 'B';
					}
					if (j - 1 >= 0) {
						newLair[i][j - 1] = 'B';
					}
				}
			}
		}
		/*
		 * for(int i=0;i<n;i++){ for(int j=0;j<m;j++) { System.out.print(newLair[i][j]);
		 * } System.out.print("\n"); } System.out.print("\n");
		 */
		lair = newLair;
	}

	static boolean Win(int i, int j) {
		boolean win = false;
		if (i < 0 || i == n || j < 0 || j == m) {
			status = new StringBuilder("won: " + currentPositionN + " " + currentPositionM);
			win = true;
		}
		return win;
	}

	static void PlayersMoves() {
		FindPlayerPosition();
		for (int i = 0; i < directions.length; i++) {
			if (lair[currentPositionN][currentPositionM] == 'B') {
				status = new StringBuilder("dead: " + currentPositionN + " " + currentPositionM);
				break;
			} else {
				switch (directions[i]) {
				case 'U':
					if (!Win(currentPositionN - 1, currentPositionM)) {
						currentPositionN -= 1;
					}
					break;
				case 'R':
					if (!Win(currentPositionN, currentPositionM + 1)) {
						currentPositionM += 1;
					}
					break;
				case 'L':
					if (!Win(currentPositionN, currentPositionM - 1)) {
						currentPositionM -= 1;
					}
					break;
				case 'D':
					if (!Win(currentPositionN + 1, currentPositionM)) {
						currentPositionN += 1;
					}
					break;
				}
				InfectWithBunnies();
			}

		}
	}
}
