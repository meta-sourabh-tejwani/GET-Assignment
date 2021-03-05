class MultiPolynomial {
	private LinkedList<LinkedList<Integer>> completeListOfDegree = new LinkedList<>();

	/*
	 * constructor add degree of multivariable in nested list manner
	 */
	MultiPolynomial(String s) {
		boolean cofficient = true;
		LinkedList<Integer> degreeOfVariableList = new LinkedList<>();
		String val = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9' && cofficient == false) {
				val += s.charAt(i);
			} else if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					|| (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				cofficient = false;
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
						val = "";
						continue;
					} else {
						val = "1";
					}
				} else {
					val = "1";
					degreeOfVariableList.addElement(Integer.parseInt(val));
					completeListOfDegree.addElement(degreeOfVariableList);
					break;
				}
				degreeOfVariableList.addElement(Integer.parseInt(val));
				val = "";
			}
			if (((s.charAt(i) == '+' || s.charAt(i) == '-') || i == s.length() - 1)
					&& val.equals("") == false) {
				degreeOfVariableList.addElement(Integer.parseInt(val));
				cofficient = true;
				completeListOfDegree.addElement(degreeOfVariableList);
				degreeOfVariableList.display();
				degreeOfVariableList = new LinkedList<>();
				val = "";
			}

		}
	}

	/*
	 * method return the max degree by visualized nested linked list which store
	 * degree of polynomial
	 */
	public int maxDegree() {
		Node<LinkedList<Integer>> linkedlist = completeListOfDegree.head;
		int max = 0;
		while (linkedlist != null) {
			LinkedList<Integer> nestedlinkedlist = linkedlist.getValue();
			Node<Integer> nestedlinkednead = nestedlinkedlist.head;
			int sum = 0;
			while (nestedlinkednead != null) {
				sum += nestedlinkednead.getValue();
				nestedlinkednead = nestedlinkednead.getNext();
			}
			if (max < sum) {
				max = sum;
			}
			linkedlist = linkedlist.getNext();
		}
		return max;
	}
}
