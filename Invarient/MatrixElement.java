public class MatrixElement implements Comparable<MatrixElement>{

	private final int row;
	private final int column;
	private final int element;

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getElement() {
		return element;
	}

	public MatrixElement(int row, int column, int element) {
		super();
		this.row = row;
		this.column = column;
		this.element = element;
	}

	@Override
	public int compareTo(MatrixElement com) {
		return ((Integer)row).equals(com.row)?((Integer)column).compareTo(com.column):((Integer)row).compareTo(com.row);
	
	}
	

}
