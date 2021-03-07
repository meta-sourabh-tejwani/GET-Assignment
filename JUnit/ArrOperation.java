class ArrOperation {

	/**
	 * find the size of mirror element
	 * 
	 * @param element
	 *            contain no. of element
	 * @return size of mirror element
	 */
	public static int maxMirror(int element[]) {
		int total = element.length;
		assert total >= 1 : "Not valid";
		int find = 1;
		int dynamic[][] = new int[total + 1][total + 1];
		for (int i = 1; i <= total; i++) {
			for (int j = 1; j <= total; j++) {
				if (element[i - 1] == element[total - j]) {
					dynamic[i][j] = dynamic[i - 1][j - 1] + 1;
				}
				find = Math.max(dynamic[i][j], find);
			}
		}

		return find;
	}

	/**
	 * count the total number of two or more alternate element
	 * 
	 * @param element
	 *            contain no. of element
	 * @return total count
	 */
	public static int clump(int element[]) {
		assert element.length >= 1 : "Not valid";
		int count = 0, check = 0;
		int i = 0;
		while (i < element.length - 1) {
			if (element[i] == element[i + 1]) {
				if (check == 0) {
					check = 1;
					count++;
				}
			} else {
				check = 0;
			}
			i++;
		}
		return count;
	}

	/**
	 * change the y to the successor of x in element
	 * 
	 * @param element
	 *            contain no. of element
	 * @param x
	 *            contain predecessor
	 * @param y
	 *            contain successor
	 * @return element after changing
	 */
	public static int[] fixXY(int element[], int x, int y) {
		assert element.length >= 1 : "Not valid";
		int countX = 0, countY = 0;
		for (int i = 0; i < element.length; i++) {
			if (i != element.length - 1) {
				assert (element[i] == x && element[i + 1] == y) : "Not valid";
			} else {
				assert (element[i] == x) : "Not valid";
			}
			if (element[i] == x)
				countX++;
			if (element[i] == y)
				countY++;
		}
		assert (countX != countY) : "Not valid";
		int j = 0;
		for (int i = 0; i < element.length; i++) {
			if (element[i] == x && element[i + 1] != y) {
				while (element[j] != y || (j != 0 && element[j - 1] == 4)) {
					j++;
				}
				element[j] = element[i + 1];
				element[i + 1] = y;
			}
		}
		return element;
	}

	/**
	 * check where the two sub array sum is equal
	 * 
	 * @param element
	 *            contain no. of element
	 * @return index where the sub array found else return -1
	 */
	public static int splitArray(int element[]) {
		assert (element.length >= 1) : "Not valid";
		int counta = 0, countb = 0;
		for (int i = 0; i < element.length; i++) {
			counta += element[i];
		}
		for (int i = 0; i < element.length; i++) {
			countb += element[i];
			counta -= element[i];
			if (counta == countb)
				return i + 1;
		}
		return -1;
	}

}
