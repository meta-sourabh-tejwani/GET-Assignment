package task11stack;

class Queue {
	private int rear;
	private int front;
	private int data[];
	private int size;

	Queue(int size) {
		rear = -1;
		front = -1;
		data = new int[size];
		this.size = size;
	}

	/**
	 * Add data in Queue
	 * 
	 * @param value
	 *            contain integer data
	 * @return true if value add else false
	 */
	public boolean enQueue(int value) {
		if (rear == -1) {
			rear = 0;
			front = 0;
			data[rear] = value;
		} else if (isFull()) {
			return false;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			data[rear] = value;
		} else {
			rear = rear + 1;
			data[rear] = value;
		}
		return true;
	}

	/**
	 * remove the element in queue
	 * 
	 * @return value of remove element
	 */
	public int deQueue() {
		int number = -1;
		if (front == -1) {
			return number;
		}
		number = data[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else {
			front = front + 1;
		}
		return number;
	}

	/**
	 * find the queue is empty or not
	 * 
	 * @return true if queue is empty else false
	 */
	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

	/**
	 * check queue is full or not
	 * 
	 * @return true if queue is full else false
	 */
	public boolean isFull() {
		if ((front == 0 && rear == size - 1)
				|| rear == (front - 1) % (size - 1)) {
			return true;
		}
		return false;
	}

}