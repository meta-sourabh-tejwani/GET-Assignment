import java.util.Arrays;

class SparseMatrix {
	private MatrixElement elements[];
	private final int n;
	private final int m;

	public SparseMatrix(int row, int column, MatrixElement elements[]) {
		this.m = column;
		this.n = row;
		this.elements = Arrays.copyOf(elements, elements.length);
		Arrays.sort(this.elements);
	}

	// Return Transpose of Matrix
	public int[][] transpose() {
		int[][] transpose = new int[m][n];
		for (int i = 0; i < elements.length; i++) {
			transpose[elements[i].getColumn()][elements[i].getRow()] = elements[i]
					.getElement();
		}
		return Arrays.copyOf(transpose, transpose.length);
	}

	// Check Symmetric or not
	public boolean checkSymetric() {
		int a[][] = transpose();
		for (int i = 0; i < elements.length; i++) {
			try {
				if (elements[i].getElement() != a[elements[i].getRow()][elements[i]
						.getColumn()]) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}

		}
		return true;
	}

	// add two matrix
	public static int[][] addMatrix(SparseMatrix s1, SparseMatrix s2) {
		int a[][] = new int[s1.n][s1.m];
		for (int i = 0; i < s1.elements.length; i++) {
			a[s1.elements[i].getRow()][s1.elements[i].getColumn()] += s1.elements[i]
					.getElement();
		}
		for (int i = 0; i < s2.elements.length; i++) {
			a[s2.elements[i].getRow()][s2.elements[i].getColumn()] += s2.elements[i]
					.getElement();
		}
		return Arrays.copyOf(a, a.length);
	}

	// multiply two matrix
	public static int[][] mulMatrix(SparseMatrix s1, SparseMatrix s2) {
		int a[][] = new int[s1.n][s2.m];
		int first[][] = new int[s1.n][s1.m];
		for (int i = 0; i < s1.elements.length; i++) {
			first[s1.elements[i].getRow()][s1.elements[i].getColumn()] = s1.elements[i]
					.getElement();
		}
		int second[][] = new int[s2.n][s2.m];
		for (int i = 0; i < s2.elements.length; i++) {
			second[s2.elements[i].getRow()][s2.elements[i].getColumn()] = s2.elements[i]
					.getElement();
		}
		for (int i = 0; i < s1.n; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = 0;
				for (int k = 0; k < a[i].length; k++) {
					a[i][j] += first[i][k] * second[k][j];
				}
			}
		}
		return Arrays.copyOf(a, a.length);
	}

}
