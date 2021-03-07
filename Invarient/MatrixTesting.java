import org.junit.*;

public class MatrixTesting {

	static SparseMatrix s1;
	static SparseMatrix s2;
	static MatrixElement m1;
	static MatrixElement m2;

	@BeforeClass
	public static void setUp() {
		m1 = new MatrixElement(0, 0, 1);
		m2 = new MatrixElement(0, 1, 2);
		MatrixElement check[] = { m1, m2 };
		s1 = new SparseMatrix(2, 2, check);
		s2 = new SparseMatrix(2, 2, check);
	}

	@Test
	public void testTranspose() {
		int a[][] = { { 1, 0 }, { 2, 0 } };
		Assert.assertArrayEquals(a, s1.transpose());
	}

	@Test
	public void testSymmetric() {
		Assert.assertEquals(false, s1.checkSymetric());
	}

	@Test
	public void testAddMatrix() {
		int sum[][] = { { 2, 4 }, { 0, 0 } };
		Assert.assertArrayEquals(sum, SparseMatrix.addMatrix(s1, s2));
	}

	@Test
	public void testMulMatrix() {
		int mat[][] = { { 1, 2 }, { 0, 0 } };
		Assert.assertArrayEquals(mat, SparseMatrix.mulMatrix(s1, s2));
	}
}
