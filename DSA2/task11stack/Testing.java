package task11stack;

import org.junit.Assert;
import org.junit.Test;
public class Testing {

	@Test
	public void testInfix()
	{
		Assert.assertEquals(12,InfixUsingStack.infixValue("2 * 3 * ( 12 / 6 )"));
		Assert.assertEquals(0,InfixUsingStack.infixValue(" 1 <= 0 && 2 >= 1"));
		Assert.assertEquals(1,InfixUsingStack.infixValue(" 1 <= 12 && 2 >= 1"));
		Assert.assertEquals(1,InfixUsingStack.infixValue(" ( ( 1 + 11 ) <= 12 ) && 2 * 9 >= 17"));
		Assert.assertEquals(8,InfixUsingStack.infixValue(" ( ( 1 + 11 ) * 12 ) / ( 2 * 9 )"));
		Assert.assertEquals(-11,InfixUsingStack.infixValue("1 - 12"));
	}
	
	@Test
	public void testQueue()
	{
		Queue queue=new Queue(5);
		Assert.assertEquals(true,queue.isEmpty());
		Assert.assertEquals(true,queue.enQueue(12));
		Assert.assertEquals(true,queue.enQueue(13));
		Assert.assertEquals(true,queue.enQueue(14));
		Assert.assertEquals(true,queue.enQueue(15));
		Assert.assertEquals(true,queue.enQueue(16));
		Assert.assertEquals(false,queue.enQueue(17));
		Assert.assertEquals(true,queue.isFull());
		Assert.assertEquals(12,queue.deQueue());
		Assert.assertEquals(13,queue.deQueue());
		Assert.assertEquals(true,queue.enQueue(17));
	}
}
