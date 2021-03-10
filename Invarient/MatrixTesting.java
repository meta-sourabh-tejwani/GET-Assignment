import org.junit.*;

public class MatrixTesting {

	static SparseMatrix s1;
	static SparseMatrix s2;
	static MatrixElement m1;
	static MatrixElement m2;

	@BeforeClass
	public static void setUp() {
		m1 = new MatrixElement(0, 0, 1);
		m2 = new MatrixElement(1, 1, 1);
		MatrixElement check[] = { m1, m2 };
		s1 = new SparseMatrix(2, 2, check);
		s2 = new SparseMatrix(2, 2, check);
	}

	@Test
	public void testTranspose() {
		int a[][] = { { 1, 0 }, { 0, 1 } };
		SparseMatrix s = s1.transpose();
		int b[][] = new int[2][2];
		for (int i = 0; i < s.elements.length; i++) {
			b[s.elements[i].getRow()][s.elements[i].getColumn()] = s.elements[i]
					.getElement();
		}
		Assert.assertArrayEquals(a, b);
	}

	@Test
	public void testSymmetric() {
		Assert.assertEquals(true, s1.checkSymetric());
	}

	@Test
	public void testAddMatrix() {
		int a[][] = { { 2, 0 }, { 0, 2 } };
		int b[][] = new int[2][2];
		SparseMatrix s = SparseMatrix.addMatrix(s1, s2);
		for (int i = 0; i < s.elements.length; i++) {
			if (s.elements[i] != null) {
				b[s.elements[i].getRow()][s.elements[i].getColumn()] = s.elements[i]
						.getElement();
			}
		}
		Assert.assertArrayEquals(a, b);
	}

	@Test
	public void testMulMatrix() {
		int mat[][] = { { 1, 0 }, { 0, 1 } };
		int b[][] = new int[2][2];
		SparseMatrix s = SparseMatrix.mulMatrix(s1, s2);
		for (int i = 0; i < s.elements.length; i++) {
			if (s.elements[i] != null) {
				b[s.elements[i].getRow()][s.elements[i].getColumn()] = s.elements[i]
						.getElement();
			}
		}
		Assert.assertArrayEquals(mat, b);
	}
}
