import java.util.ArrayList;
import java.util.List;

class Bowler {
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
}

class BowlerChoose {
	private PriorityQueue priority;
	private int totalbowler;
	private int viratplayed;
	private Bowler bowler[];
	private int quota[];

	BowlerChoose(int totalbowler, int viratplayed, List<Bowler> bowler) {
		this.totalbowler = totalbowler;
		this.viratplayed = viratplayed;
		this.bowler = new Bowler[totalbowler];
		for (int i = 0; i < bowler.size(); i++) {
			this.bowler[i] = bowler.get(i);
		}
		this.quota = new int[totalbowler];
		for (int i = 0; i < totalbowler; i++) {
			quota[i] = bowler.get(i).getBowledLeft();
		}
		this.priority = new PriorityQueueHeap(totalbowler);
		add();
	}

	/**
	 * Add The bowler into the priority queue
	 */
	private void add() {
		for (int i = 0; i < totalbowler; i++) {
			priority.enQueue(quota[i]);
		}
	}

	/**
	 * Find the order of bolwer
	 * @return the bowler into the order
	 */
	public List<Bowler> getOrder() {
		List<Bowler> bowlerorder = new ArrayList<>();
		for (int i = 0; i < totalbowler; i++) {
			int bowlerpriority = priority.deQueue();
			for (int j = 0; j < bowler.length; j++) {
				if (bowler[j] != null) {
					if (bowlerpriority == bowler[j].getBowledLeft()) {
						bowlerorder.add(bowler[j]);
						bowler[j] = null;
						break;
					}
				}
			}
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
		BowlerChoose b = new BowlerChoose(5, 10, bowler);
		List<Bowler> order = b.getOrder();
		for (int i = 0; i < order.size(); i++) {
			System.out.println("Name=" + order.get(i).getName()
					+ " Bowled left=" + order.get(i).getBowledLeft());
		}

	}

}
