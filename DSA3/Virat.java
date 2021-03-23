import java.util.ArrayList;
import java.util.List;

class Bowler implements Comparable<Bowler>{
	String name;
	int bowledleft;

	Bowler(String name, int bowledleft) {
		this.name = name;
		this.bowledleft = bowledleft;
	}

	public String getName() {
		return name;
	}

	public int getBowledLeft() {
		return bowledleft;
	}

	@Override
	public int compareTo(Bowler b1) {
		return this.getBowledLeft()-b1.getBowledLeft();
	}
}

class BowlerChoose<T extends Comparable<T>>{
	private PriorityQueue<T> priority;
	private int totalbowler;
	private int viratplayed;
	private T bowler[];

	@SuppressWarnings("unchecked")
	BowlerChoose(int totalbowler, int viratplayed, List<T> bowler) {
		this.totalbowler = totalbowler;
		this.viratplayed = viratplayed;
		this.bowler = (T[]) new Comparable[totalbowler];
		for (int i = 0; i < bowler.size(); i++) {
			this.bowler[i] = (T) bowler.get(i);
		}
		this.priority = new PriorityQueueHeap<T>(totalbowler);
		add();
	}

	/**
	 * Add The bowler into the priority queue
	 */
	private void add() {
		for (int i = 0; i < totalbowler; i++) {
			priority.enQueue(bowler[i]);
		}
	}

	/**
	 * Find the order of bolwer
	 * @return the bowler into the order
	 */
	public List<Bowler> getOrder() {
		List<Bowler> bowlerorder = new ArrayList<>();
		for (int i = 0; i < totalbowler; i++) {
			bowlerorder.add((Bowler) priority.deQueue());
		}
		return bowlerorder;
	}

}

class Virat {
	public static void main(String... k) {
		List<Bowler> bowler = new ArrayList<>();
		bowler.add(new Bowler("ajay", 17));
		bowler.add(new Bowler("rahul", 10));
		bowler.add(new Bowler("mayank", 8));
		bowler.add(new Bowler("mohit", 12));
		bowler.add(new Bowler("sourabh", 17));
		BowlerChoose<Bowler> b = new BowlerChoose<Bowler>(5, 10, bowler);
		List<Bowler> order = b.getOrder();
		for (int i = 0; i < order.size(); i++) {
			System.out.println("Name=" + order.get(i).getName()
					+ " Bowled left=" + order.get(i).getBowledLeft());
		}

	}

}
