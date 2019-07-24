import java.util.Scanner;

public class ReverseMatrixDiagonals_v2 {
	static int r, c;
	static int reverseMatrix[][];

	public static void main(String[] args) {
		FillMatrix();
		DiagonalsPrint();
	}

	static void FillMatrix() {
		Scanner input = new Scanner(System.in);
		r = input.nextInt();
		c = input.nextInt();
		reverseMatrix = new int[r][c];
		for (int i = r - 1; i >= 0; i--) {
			for (int j = c - 1; j >= 0; j--) {
				reverseMatrix[i][j] = input.nextInt();
			}
		}
	}

	static void DiagonalsPrint() {
		int sum = 0;
		while (sum <= (r - 1) + (c - 1)) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i + j == sum) {
						System.out.printf("%d ", reverseMatrix[i][j]);
					}
				}
			}
			sum++;
			System.out.println();
		}
	}

}