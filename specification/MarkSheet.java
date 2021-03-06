import java.util.Arrays;

class MarkSheet {
	private int total;
	private float grades[];

	MarkSheet(int total, float grades[]) {
		this.total = total;
		this.grades = Arrays.copyOf(grades, total);
	}

	/**
	 * find average of total grade
	 * 
	 * @return average
	 */
	public float average() {
		float average = 0;
		for (int i = 0; i < grades.length; i++) {
			average += grades[i];
		}
		average = average / total;
		return (float) Math.round(average * 100) / 100;
	}

	/**
	 * find maximum of grade in total grades
	 * 
	 * @return maximum grade
	 */
	public float maximum() {
		float max = 0;
		for (int i = 0; i < grades.length; i++) {
			if (max < grades[i]) {
				max = grades[i];
			}
		}
		return (float) Math.round(max * 100) / 100;
	}

	/**
	 * find minimum of grade in total grades
	 * 
	 * @return minimum grade
	 */
	public float minimum() {
		float min = 100;
		for (int i = 0; i < grades.length; i++) {
			if (min > grades[i]) {
				min = grades[i];
			}
		}
		return (float) Math.round(min * 100) / 100;
	}

	/**
	 * find percentage of pass student which is above grade is 40
	 * 
	 * @return percentage
	 */
	public float passPercantage() {
		float percantage = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > 40) {
				percantage += 1;
			}
		}
		percantage = percantage / total * 100;
		return ((float) Math.round(percantage * 100) / 100);
	}
}
