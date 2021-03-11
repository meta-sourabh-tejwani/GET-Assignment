class MultiPolynomial {

	private LinkedList<LinkedList<String>> polynomial = new LinkedList<>();

	/*
	 * constructor add degree of multipolynomial in nested list manner
	 */
	MultiPolynomial(String multipoly) {
		LinkedList<String> variable = new LinkedList<>();
		int i = 0;
		while (i < multipoly.length()) {
			if (multipoly.charAt(i) >= 'A' && multipoly.charAt(i) <= 'Z'
					|| multipoly.charAt(i) >= 'a' && multipoly.charAt(i) <= 'z') {
				String object = "" + multipoly.charAt(i);
				int number = 1;
				i++;
				String degree = "";
				while (i < multipoly.length()
						&& (multipoly.charAt(i) >= '0' && multipoly.charAt(i) <= '9')) {
					degree += multipoly.charAt(i);
						number =Integer.parseInt(degree);
					i++;
				}
				variable.addElement(object);
				variable.addElement(String.valueOf(number));
				if (i >= multipoly.length())
					polynomial.addElement(variable);
			}

			if (i < multipoly.length()
					&& (multipoly.charAt(i) >= '0' && multipoly.charAt(i) <= '9')) {
				int number = 1;
				while (i < multipoly.length()
						&& (multipoly.charAt(i) >= '0' && multipoly.charAt(i) <= '9')) {
					String degree = "";
					while (i < multipoly.length()
							&& (multipoly.charAt(i) >= '0' && multipoly.charAt(i) <= '9')) {
						degree += multipoly.charAt(i);
							number =Integer.parseInt(degree);
						i++;
					}
				}
				variable.addElement(String.valueOf(number));
				if (i >= multipoly.length())
					polynomial.addElement(variable);
			}

			if (i < multipoly.length()) {
				if ((multipoly.charAt(i) == '+' || multipoly.charAt(i) == '-')
						|| i == multipoly.length() - 1) {
					polynomial.addElement(variable);
					variable = new LinkedList<>();
					i++;
				}
			}

		}
	}

	/*
	 * method return the max degree by visualized nested linked list which store
	 * degree of polynomial
	 */
	public int maxDegree() {
		Node<LinkedList<String>> linkedlist = polynomial.head;
		int max = 0;
		while (linkedlist != null) {
			LinkedList<String> nestedlinkedlist = linkedlist.getValue();
			Node<String> nestedlinkedhead = nestedlinkedlist.head;
			int sum = 0;
			while (nestedlinkedhead != null) {
				System.out.print(nestedlinkedhead.getValue() + "-->");
				char check = nestedlinkedhead.getValue().charAt(0);
				if ((check >= 'A' && check <= 'Z')
						|| (check >= 'a' && check <= 'z')) {
					sum += Integer.parseInt(nestedlinkedhead.getNext()
							.getValue());
				}
				nestedlinkedhead = nestedlinkedhead.getNext();
			}
			System.out.println();
			if (sum > max)
				max = sum;
			linkedlist = linkedlist.getNext();
		}
		System.out.println("End");
		return max;
	}
}
