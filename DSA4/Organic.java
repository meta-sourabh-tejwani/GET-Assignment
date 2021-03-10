import java.util.*;

public class Organic {
	public static Map<Character, Integer> mass = new HashMap<>();
	static {
		mass.put('C', 12);
		mass.put('O', 16);
		mass.put('H', 1);
	}

	/**
	 * Calculate Compound mass
	 * 
	 * @param compound
	 *            contain compound
	 * @return value of mass
	 */
	public static int returnMass(String compound) {
		int i = 0, sum = 0;
		while (i < compound.length()) {
			if (compound.charAt(i) == 'C' || compound.charAt(i) == 'H'
					|| compound.charAt(i) == 'O') {
				char object = compound.charAt(i);
				int number = 1;
				i++;
				while (i < compound.length()
						&& (compound.charAt(i) >= '0' && compound.charAt(i) <= '9')) {
					String degr = "";
					degr += compound.charAt(i);
					if (degr.length() == 1) {
						number = number * Integer.parseInt(degr);
					} else {
						number = number * 10 * Integer.parseInt(degr);
					}
					i++;
				}
				sum += mass.get(object) * number;
			}

			if (i < compound.length()) {
				if (compound.charAt(i) == '(') {
					String need = "";
					i++;
					while (i < compound.length() && compound.charAt(i) != ')') {
						need += compound.charAt(i);
						i++;
					}
					int number = 1;
					i++;
					while (i < compound.length()
							&& (compound.charAt(i) >= '0' && compound.charAt(i) <= '9')) {
						String degr = "";
						degr += compound.charAt(i);
						if (degr.length() == 1) {
							number = number * Integer.parseInt(degr);
						} else {
							number = number * 10 * Integer.parseInt(degr);
						}
						i++;
					}
					int under = returnMass(need);
					sum += under * number;
				}
			}
		}
		return sum;
	}

}
