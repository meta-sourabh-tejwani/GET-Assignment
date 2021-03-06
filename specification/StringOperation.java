class StringOperation {
	/**
	 * Compare two string return 1 if String match else return 0
	 * 
	 * @param first
	 *            represent string which is not null and case sensitive
	 * @param second
	 *            represent string which is not null and case sensitive
	 * @return 0 and 1 if match or not
	 */
	public int compareString(String first, String second) {
		if (first.length() != second.length()) {
			return 0;
		}
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				return 0;
			}
		}
		return 1;
	}

	/**
	 * reverse the String
	 * 
	 * @param string
	 *            must not be null and case sensitive
	 * @return reverse of string
	 */
	public String reverseString(String string) {
		String reverse = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			reverse += string.charAt(i);
		}
		return reverse;
	}

	/**
	 * convert lower case to upper case character and vice versa
	 * 
	 * @param string
	 *            must not be null and case sensitive
	 * @return string which change lower to upper case and upper to lower case
	 */
	public String replaceLowerUpper(String string) {
		String convert = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
				convert += (char) ((int) (string.charAt(i)) - 97 + 65);
			} else if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
				convert += (char) ((int) (string.charAt(i)) - 65 + 97);
			}
		}
		return convert;
	}

	/**
	 * Compare each word length and return max word if same then return last
	 * word
	 * 
	 * @param string
	 *            must be not null and case sensitive
	 * @return word which contain maximum length in the string
	 */
	public String largestWord(String string) {
		String maxword = "", checkword = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ' || i == string.length() - 1) {
				if (i == string.length() - 1 && string.charAt(i) != ' ') {
					checkword += string.charAt(i);
				}
				if (maxword.length() <= checkword.length()) {
					maxword = checkword;
				}
				checkword = "";
			} else {
				checkword += string.charAt(i);
			}
		}
		return maxword;
	}

}