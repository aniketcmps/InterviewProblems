package arrays;

public class MatrixRotate {
	public int[][] rotate(int a[][]) {
		int r = a.length;
		int c = a[0].length;

		// Rotate 90 degree clockwise
		int result[][] = new int[c][r];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[j][r - i - 1] = a[i][j];
			}
		}

		// Rotate 180 degree clockwise
		int result1[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result1[r - i - 1][c - j - 1] = a[i][j];
			}
		}
		return result1;
	}

	public void printMatrix(int a[][]) {
		int r = a.length;
		int c = a[0].length;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		MatrixRotate m = new MatrixRotate();

		int image[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println("Original image");
		m.printMatrix(image);
		image = m.rotate(image);
		System.out.println("\nRotated image");
		m.printMatrix(image);

	}

}
