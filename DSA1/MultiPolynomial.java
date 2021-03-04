class MultiPolynomial {
	private LinkedList<LinkedList<Integer>> l = new LinkedList<>();

	MultiPolynomial(String s) {
		LinkedList<Integer> integer = new LinkedList<>();
		String val = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				val += s.charAt(i);
			} else if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= 'a'
					&& s.charAt(i) <= 'z')
					&& val.equals("") == false) {
				integer.addElement(Integer.parseInt(val));
				val = "";
			} else if ((s.charAt(i) == '+' || s.charAt(i) == '-')
					&& val.equals("") == false) {
				integer.addElement(Integer.parseInt(val));
				val = "";
				l.addElement(integer);
				integer = new LinkedList<>();
			}
		}
	}

	public int maxDegree() {
		Node<LinkedList<Integer>> temp = l.head;
		int max = 0;
		while (temp != null) {
			LinkedList<Integer> temp2 = temp.getValue();
			Node<Integer> n = temp2.head;
			int c = 0, sum = 0;
			while (n != null) {
				if (c == 1) {
					sum += n.getValue();
				} else {
					c = 1;
				}
				n = n.getNext();
			}
			if (max < sum) {
				max = sum;
			}
			temp = temp.getNext();
		}
		return max;
	}
}
