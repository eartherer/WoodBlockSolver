import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Field {
	private int row,column;
	int[][] field;
	private Map<Wood, RowAndColumn> fitPosition = new HashMap<>();
	
	public Field(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		field = new int[row][column];
	}
	
	public void setBlockOnField(int r, int c){
		if(r>= row || c >= column){
			throw new IllegalArgumentException("Row : "+ r + " Column : " + c);
		}
		field[r][c] = 1;
	}
	
	public List<RowAndColumn> findPossibleFitIndex(Wood wood){
		List<RowAndColumn> p = new ArrayList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(tryToFitAtIndex(wood,i,j)){
					p.add(new RowAndColumn(i, j));
					//System.out.print(String.format("(%d,%d)",i,j));
				}
			}
		}
		return p;
	}
	
			private boolean tryToFitAtIndex(Wood wood, int indexFieldRow, int indexFieldColumn){
				if(wood.getDimensionRow() + indexFieldRow > row)
					return false;
				if(wood.getDimensionColumn() + indexFieldColumn > column)
					return false;
				//Border Check Pass
				//Try to check actually dimension
				for (int i = 0; i < wood.getDimensionRow(); i++) {
					for (int j = 0; j < wood.getDimensionColumn(); j++) {
						int woodStatus = wood.getBlockStatusAtIndex(i, j);
						if(woodStatus == 0) // No wood at that index wood Block
							continue;
						else
							if(field[indexFieldRow+i][indexFieldColumn+j] == 1) //There is wood but field is not empty
								return false;
					}
				}
				
				return true;
			}
			
	public boolean fitWoodToIndex(Wood wood, int indexFieldRow, int indexFieldColumn){
		if(tryToFitAtIndex(wood,indexFieldRow, indexFieldColumn)){
			for (int i = 0; i < wood.getDimensionRow(); i++) {
				for (int j = 0; j < wood.getDimensionColumn(); j++) {
					int woodStatus = wood.getBlockStatusAtIndex(i, j);
					if(woodStatus == 0) // No wood at that index wood Block
						continue;
					else
						if(field[indexFieldRow+i][indexFieldColumn+j] == 0) //Field is empty so can fill block
							field[indexFieldRow+i][indexFieldColumn+j] = 1; // Fill Block
				}
			}
			fitPosition.put(wood, new RowAndColumn(indexFieldRow, indexFieldColumn));
			return true;
		}
		return false;
	}
	
	public void printField(){
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(field[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public Field clone(){
		Field tmpField = new Field(this.row, this.column);
		tmpField.fitPosition = this.fitPosition;
		for (int i = 0; i < field.length; i++) {
			tmpField.field[i] = Arrays.copyOf(field[i], field[i].length);
		}
		return tmpField;
	}

	public boolean isAllFill() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(field[i][j] == 0) //Found empty so not all fill
					return false;
			}			
		}
		return true;
	}

	public Map<Wood, RowAndColumn> getFitPosition() {
		return fitPosition;
	}
	
	
}
