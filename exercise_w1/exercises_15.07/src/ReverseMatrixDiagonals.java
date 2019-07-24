import java.util.Scanner;

public class ReverseMatrixDiagonals {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int r, c;

		r = input.nextInt();
		c = input.nextInt();

		int reverseMatrix[][] = new int[r][c];

		for (int i = r - 1; i >= 0; i--) {
			for (int j = c - 1; j >= 0; j--) {
				reverseMatrix[i][j] = input.nextInt();
			}
		}

		/*
		 * for (int i = r - 1; i >= 0; i--) { for (int j = c - 1; j >= 0; j--) {
		 * reverseMatrix[r - (i + 1)][c - (j + 1)] = matrix[i][j]; } }
		 */
		int max = Math.min(r, c);
		
		if (max == 1) {
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.printf("%d", reverseMatrix[i][j]);
					System.out.printf("\n");
				}
			}
		} 
		else {
			
			int br = 0;
			int a1 = 0;
			int b1 = 0;
			int a, b;
			
			while (br < max) {
				a = a1;
				b = b1;
				for (int i = 0; i <= br; i++) {
					System.out.printf("%d ", reverseMatrix[a + 1 * i][b - 1 * i]);
				}
				br++;
				b1++;
				System.out.printf("\n");
			}

			if (r == c) {
				br--;
			}

			while (br > 0) {
				if (b1 == c) {
					a1++;
					b1 = c - 1;
				}
				a = a1;
				b = b1;

				for (int i = 0; i < br; i++) {
					System.out.printf("%d ", reverseMatrix[a + 1 * i][b - 1 * i]);
				}

				br--;
				b1++;

				System.out.printf("\n");
			}
		}

	}
}
