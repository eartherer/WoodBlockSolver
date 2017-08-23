
public class RowAndColumn {
	private int row,column;

	public RowAndColumn(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)", row, column);
	}
}
