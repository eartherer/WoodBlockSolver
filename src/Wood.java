import java.util.Arrays;

public class Wood {
	private int dimensionRow,dimensionColumn;
	private int[][] dimension;
	
	public Wood(int dimensionRow, int dimensionColumn) {
		super();
		this.dimensionRow = dimensionRow;
		this.dimensionColumn = dimensionColumn;
		dimension = new int[dimensionRow][dimensionColumn];
	}
	
	public Wood(int dimensionRow, int dimensionColumn, int[] data){
		this(dimensionRow, dimensionColumn);
		this.setDataByIntArray(data);
	}
	
	private void setDataByIntArray(int[] data) {
		if(data.length != (dimensionRow*dimensionColumn))
			throw new IllegalArgumentException(String.format("Data length : %d not match row %d x column %d", data.length, dimensionRow, dimensionColumn));
		int readDataIdx = 0;
		for (int i = 0; i < dimensionRow; i++) {
			for (int j = 0; j < dimensionColumn; j++) {
				this.setActuallySize(i, j, data[readDataIdx++]);
			}			
		}
	}

	public void setActuallySize(int r, int c){
		setActuallySize(r,c,1);
	}
	
	public void setActuallySize(int r, int c,int value){
		if(r>= dimensionRow || c >= dimensionColumn){
			throw new IllegalArgumentException("Row : "+ r + " Column : " + c);
		}
		dimension[r][c] = value;
	}
	public void printWood(){
		for (int i = 0; i < dimensionRow; i++) {
			for (int j = 0; j < dimensionColumn; j++) {
				System.out.print((dimension[i][j] == 0 ? " " : "1") +" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public int getBlockStatusAtIndex(int r, int c){
		if(r>= dimensionRow || c >= dimensionColumn){
			throw new IllegalArgumentException("Row : "+ r + " Column : " + c);
		}
		return dimension[r][c];
	}

	public int getDimensionRow() {
		return dimensionRow;
	}

	public void setDimensionRow(int dimensionRow) {
		this.dimensionRow = dimensionRow;
	}

	public int getDimensionColumn() {
		return dimensionColumn;
	}

	public void setDimensionColumn(int dimensionColumn) {
		this.dimensionColumn = dimensionColumn;
	}

	public void setAllWood() {
		for (int i = 0; i < dimension.length; i++) {
			Arrays.fill(dimension[i], 1);			
		}
		
	}
	
	
}
