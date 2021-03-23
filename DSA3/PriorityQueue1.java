interface PriorityQueue<T extends Comparable<T>>{
	public boolean enQueue(T value);

	public T deQueue();

	public void display();

}

class PriorityQueueHeap<T extends Comparable<T>> implements PriorityQueue<T> {
	private T data[];
	private int rear;
	private int front;

	@SuppressWarnings("unchecked")
	PriorityQueueHeap(int size) {
		this.data = (T[]) new Comparable[size];
	}

	/**
	 * Insert The Data into The Priority Queue By using max heap
	 */
	@Override
	public boolean enQueue(T value) {
		if (rear == data.length)
			return false;
		this.data[rear] = value;
		int child = rear + 1;
		int parent = (rear + 1) / 2;
		while (child != 1) {
			if (data[parent - 1].compareTo(data[child - 1])<0) {
				T temp = data[parent - 1];
				data[parent - 1] = data[child - 1];
				data[child - 1] = temp;

			} else {
				break;
			}
			child = parent;
			parent = parent / 2;
		}
		rear++;
		return true;
	}

	public void display() {
		for (int i = 0; i < rear; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Delete the max node and return that node by using max heap
	 */
	@Override
	public T deQueue() {
		rear--;
		T prority = data[front];
		data[front] = data[rear];
		data[rear] = null;
		int parent = front + 1;
		int child1 = 2 * parent;
		int child2 = 2 * parent + 1;
		while (data[child1 - 1] != null || data[child2 - 1] != null) {
			if ((data[child1 - 1] != null && data[child2 - 1] == null)
					|| data[child1 - 1].compareTo(data[child2 - 1])>=0) {
				if (data[parent - 1].compareTo(data[child1 - 1])<0) {
					T temp = data[child1 - 1];
					data[child1 - 1] = data[parent - 1];
					data[parent - 1] = temp;
				}
				parent = child1;
				child1 = 2 * parent;
				child2 = 2 * parent + 1;
			} else {
				T temp = data[child2 - 1];
				data[child2 - 1] = data[parent - 1];
				data[parent - 1] = temp;
				parent = child2;
				child1 = 2 * parent;
				child2 = 2 * parent + 1;
			}
			if (child1 > rear && child2 > rear) {
				break;
			}
		}
		return prority;

	}

}

public class PriorityQueue1
{
	public static void main(String...k)
	{
		PriorityQueue<Integer> queue=new PriorityQueueHeap<>(6);
		queue.enQueue(12);
		queue.enQueue(2);
		queue.enQueue(6);
		queue.enQueue(18);
		queue.enQueue(14);
		queue.enQueue(20);
		for(int i=0;i<6;i++)
		{
			System.out.print(queue.deQueue()+" ");
		}
	}
}
