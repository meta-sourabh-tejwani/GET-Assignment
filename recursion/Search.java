class Search {
	public int linearSearch(int n, int element[], int number) {
		if (element[n - 1] == number) {
			return n - 1;
		} else if (n - 1 == 0) {
			return -1;
		} else {
			return linearSearch(--n, element, number);
		}
	}

	public int binarySearch(int element[], int number, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (element[mid] == number) {
				return mid;
			} else if (element[mid] < number) {
				return binarySearch(element, number, mid + 1, high);
			} else {
				return binarySearch(element, number, low, mid - 1);
			}
		}
		return -1;
	}
}
