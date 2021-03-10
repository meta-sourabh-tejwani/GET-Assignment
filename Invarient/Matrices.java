import java.util.Arrays;

class SparseMatrix {
	public MatrixElement elements[];
	public final int n;
	public final int m;

	public SparseMatrix(int row, int column, MatrixElement elements[]) {
		this.m = column;
		this.n = row;
		this.elements = Arrays.copyOf(elements, elements.length);
		Arrays.sort(this.elements);
	}

	// Return Transpose of Matrix
	public SparseMatrix transpose() {
		MatrixElement[] transpose = new MatrixElement[this.elements.length];
		for (int i = 0; i < elements.length; i++) {
			MatrixElement m = new MatrixElement(elements[i].getColumn(),
					elements[i].getRow(), elements[i].getElement());
			transpose[i] = m;
		}
		return new SparseMatrix(m, n, transpose);
	}

	// Check Symmetric or not
	public boolean checkSymetric() {
		int countsymmetric = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].getRow() == elements[i].getColumn()) {
				countsymmetric++;
				continue;
			}
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[i].getElement() == elements[j].getElement()
						&& elements[i].getRow() == elements[j].getColumn()
						&& elements[i].getColumn() == elements[j].getRow()) {
					countsymmetric += 2;
					break;
				}
			}
		}
		if (countsymmetric == elements.length)
			return true;
		else
			return false;
	}

	// add two matrix
	public static SparseMatrix addMatrix(SparseMatrix first, SparseMatrix second) {
		if (first.m != second.m || first.n != second.n)
			return null;
		else {
			int count = 0;
			MatrixElement matrix;
			MatrixElement sum[] = new MatrixElement[first.elements.length
					+ second.elements.length];
			int firstpos = 0, secondpos = 0, i = 0;
			while (firstpos < first.elements.length
					&& secondpos < second.elements.length) {
				if (first.elements[firstpos].getRow() < second.elements[secondpos]
						.getRow()) {
					matrix = new MatrixElement(
							first.elements[firstpos].getRow(),
							first.elements[firstpos].getColumn(),
							first.elements[firstpos].getElement());
					sum[i++] = matrix;
					firstpos++;
					count++;
				} else if (first.elements[firstpos].getRow() == second.elements[secondpos]
						.getRow()) {
					if (first.elements[firstpos].getColumn() < second.elements[secondpos]
							.getColumn()) {
						matrix = new MatrixElement(
								first.elements[firstpos].getRow(),
								first.elements[firstpos].getColumn(),
								first.elements[firstpos].getElement());
						sum[i++] = matrix;
						firstpos++;
						count++;
					} else if (first.elements[firstpos].getColumn() == second.elements[secondpos]
							.getColumn()) {
						matrix = new MatrixElement(
								first.elements[firstpos].getRow(),
								first.elements[firstpos].getColumn(),
								first.elements[firstpos].getElement()
										+ second.elements[secondpos]
												.getElement());
						sum[i++] = matrix;
						firstpos++;
						secondpos++;
						count++;
					} else {
						matrix = new MatrixElement(
								second.elements[secondpos].getRow(),
								second.elements[secondpos].getColumn(),
								second.elements[secondpos].getElement());
						sum[i++] = matrix;
						secondpos++;
						count++;
					}
				} else {
					matrix = new MatrixElement(
							second.elements[secondpos].getRow(),
							second.elements[secondpos].getColumn(),
							second.elements[secondpos].getElement());
					sum[i++] = matrix;
					secondpos++;
					count++;
				}
			}
			while (firstpos == first.elements.length
					&& secondpos < second.elements.length) {
				matrix = new MatrixElement(second.elements[secondpos].getRow(),
						second.elements[secondpos].getColumn(),
						second.elements[secondpos].getElement());
				sum[i++] = matrix;
				secondpos++;
				count++;
			}
			while (secondpos == second.elements.length
					&& firstpos < first.elements.length) {
				matrix = new MatrixElement(first.elements[firstpos].getRow(),
						first.elements[firstpos].getColumn(),
						first.elements[firstpos].getElement());
				sum[i++] = matrix;
				firstpos++;
				count++;
			}
			return new SparseMatrix(first.n, first.m, Arrays.copyOf(sum, count));
		}

	}

	// multiply two matrix
	public static SparseMatrix mulMatrix(SparseMatrix s1, SparseMatrix s2) {
		if (s1.m != s2.n) {
			return null;
		} else {
			int count = 0;
			MatrixElement ma;
			MatrixElement generate[] = new MatrixElement[s1.m + s2.n];
			int start = 0;
			s2 = s2.transpose();
			for (int i = 0; i < s1.elements.length;) {
				int r = s1.elements[i].getRow();
				for (int j = 0; j < s2.elements.length;) {
					int c = s2.elements[j].getRow();
					int tempa = i;
					int tempb = j;
					int sum = 0;
					while (tempa < s1.elements.length
							&& s1.elements[tempa].getRow() == r
							&& tempb < s2.elements.length
							&& s2.elements[tempb].getRow() == c) {
						if (s1.elements[tempa].getColumn() < s2.elements[tempb]
								.getColumn()) {
							tempa++;
						} else if (s1.elements[tempa].getColumn() > s2.elements[tempb]
								.getColumn()) {
							tempb++;
						} else {
							sum += s1.elements[tempa++].getElement()
									* s2.elements[tempb++].getElement();
						}
					}
					if (sum != 0) {
						ma = new MatrixElement(r, c, sum);
						generate[start++] = ma;
						count++;
					}
					while (j < s2.elements.length
							&& s2.elements[j].getRow() == c) {
						j++;
					}
				}
				while (i < s1.elements.length && s2.elements[i].getRow() == r) {
					i++;
				}
			}
			return new SparseMatrix(s1.m, s2.n, Arrays.copyOf(generate, count));
		}
	}

}
