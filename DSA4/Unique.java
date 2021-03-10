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
		if(repeat.containsKey(string)){
			return repeat.get(string);
		} else{
			Map<Character, Character> sameword = new HashMap<>();
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				char eachcharacter = string.charAt(i);
				if(sameword.containsKey(eachcharacter)){
						continue;
					}else{
					count++;
					sameword.put(eachcharacter, eachcharacter);
				}
			}
			repeat.put(string, count);
			return count;
		}
	}
}
