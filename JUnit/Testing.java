import org.junit.*;

public class Testing {
	@Test
	public void testMaxMirror() {
		int a[] = { 1, 2, 3, 8, 9, 3, 2, 1 };
		Assert.assertEquals(3, ArrOperation.maxMirror(a));
		int b[] = { 7, 1, 4, 9, 7, 4, 1 };
		Assert.assertEquals(2, ArrOperation.maxMirror(b));
		int c[] = { 1, 2, 1, 4 };
		Assert.assertEquals(3, ArrOperation.maxMirror(c));
		int d[] = { 1, 4, 5, 3, 5, 4, 1 };
		Assert.assertEquals(7, ArrOperation.maxMirror(d));
	}

	@Test
	public void testClump() {
		int a[] = { 1, 2, 2, 3, 4, 4 };
		Assert.assertEquals(2, ArrOperation.clump(a));
		int b[] = { 1, 1, 2, 1, 1 };
		Assert.assertEquals(2, ArrOperation.clump(b));
		int c[] = { 1, 1, 1, 1, 1 };
		Assert.assertEquals(1, ArrOperation.clump(c));
	}

	@Test
	public void testFixXY() {
		int a[] = { 5, 4, 9, 4, 9, 5 };
		int b[] = { 9, 4, 5, 4, 5, 9 };
		Assert.assertArrayEquals(b, ArrOperation.fixXY(a, 4, 5));
		int c[] = { 1, 4, 1, 5 };
		int d[] = { 1, 4, 5, 1 };
		Assert.assertArrayEquals(d, ArrOperation.fixXY(c, 4, 5));
		int e[] = { 1, 4, 1, 5, 5, 4, 1 };
		int f[] = { 1, 4, 5, 1, 1, 4, 5 };
		Assert.assertArrayEquals(f, ArrOperation.fixXY(e, 4, 5));
	}

	@Test
	public void testSplit() {
		int a[] = { 1, 1, 1, 2, 1 };
		Assert.assertEquals(3, ArrOperation.splitArray(a));
		int b[] = { 2, 1, 1, 2, 1 };
		Assert.assertEquals(-1, ArrOperation.splitArray(b));
		int c[] = { 10, 10 };
		Assert.assertEquals(1, ArrOperation.splitArray(c));
	}
}
