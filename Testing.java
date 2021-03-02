import org.junit.*;

public class Testing {

	static Zone<Mammal> z1;
	static Lion l1;
	static Tiger t1;
	static Lion l2;
	static Zone<Reptile> z2;
	static Crocodile c1;
	static Crocodile c2;

	@BeforeClass
	public static void setUp() {
		z1 = new Zone<Mammal>(2, 1, true, false);
		l1 = new Lion("Shera", 12, 70);
		t1 = new Tiger("Sht", 12, 67);
		l2 = new Lion("Sh12", 9, 50);
		z2 = new Zone<Reptile>(1, 1, false, true);
		c1 = new Crocodile("Croc1", 12, 23);
		c2 = new Crocodile("Croc2", 12, 53);
	}

	@Test
	public void checkHasCanteen() {
		Assert.assertEquals(true, z1.isHasCanteen());
		Assert.assertEquals(false, z2.isHasCanteen());
	}

	@Test
	public void checkHasPark() {
		Assert.assertEquals(false, z1.isHasPark());
		Assert.assertEquals(true, z2.isHasPark());
	}

	@Test
	public void checkAddanimal() {
		Assert.assertEquals(true, z1.addAnimal(t1));
		Assert.assertEquals(true, z1.addAnimal(l1));
		Assert.assertEquals(false, z1.addAnimal(l2));
		Assert.assertEquals(true, z2.addAnimal(c1));
		Assert.assertEquals(false, z2.addAnimal(c2));
	}

	@Test
	public void checkRemoveAnimal() {
		Assert.assertEquals(true, z1.removeAnimal(1));
		Assert.assertEquals(false, z1.removeAnimal(11));
	}
}
