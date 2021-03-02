import org.junit.*;

public class Testing {
	
	@Test
	public void checkNQueen()
	{
		QueenProblem q=new QueenProblem();
		int board[][]=new int[4][4];
		Assert.assertEquals(true,q.nQueen(board,0,4));
		Assert.assertEquals(false,q.nQueen(new int[2][2],0,2));
	}
	
	@Test
	public void checkMathematic()
	{
		LcmHcf l=new LcmHcf();
		Assert.assertEquals(12,l.getLowestCommomFactor(2, 12));
		Assert.assertEquals(2,l.getHighestCommonFactor(2, 12));
	}
	
	@Test
		public void checkSearch()
		{
			Search s=new Search();
			int a[]={1,2,3,4,5,6};
			Assert.assertEquals(2,s.linearSearch(6,a,3));
			Assert.assertEquals(2,s.binarySearch(a,3,0,5));
		}
	}

