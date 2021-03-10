import java.util.*;

public class Unique {
	public static Map<String, Integer> repeat = new HashMap<>();

	/**
	 * find unique character
	 * 
	 * @param string
	 *            must be contain alphabet
	 * @return number of unique character
	 */
	public static int uniqueCharacter(String string) {
		try {
			return repeat.get(string);
		} catch (Exception e) {
			Map<Character, Character> sameword = new HashMap<>();
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				char eachcharacter = string.charAt(i);
				try {
					if (eachcharacter == sameword.get(eachcharacter)) {
						continue;
					}
				} catch (Exception e1) {
					count++;
					sameword.put(eachcharacter, eachcharacter);
				}
			}
			repeat.put(string, count);
			return count;
		}
	}
}
