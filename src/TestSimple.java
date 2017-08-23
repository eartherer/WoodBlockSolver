import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestSimple {

	//@Test
	public void test() {
		Field field = new Field(6, 3);
		field.setBlockOnField(3, 1);
		field.printField();
		
		Wood e1 = new Wood(2, 3);
		e1.setAllWood();
		e1.printWood();
		
		Wood e2 = new Wood(3, 3);
		e2.setActuallySize(0, 0);e2.setActuallySize(0, 1);e2.setActuallySize(0, 2);
		e2.setActuallySize(1, 0);
		e2.setActuallySize(2, 0);
		e2.printWood();
		
		Wood e3 = new Wood(2, 1);
		e3.setAllWood();
		e3.printWood();
		
		Wood e4 = new Wood(2, 3);
								 e4.setActuallySize(0, 1);
		e4.setActuallySize(1, 0);e4.setActuallySize(1, 1);e4.setActuallySize(1, 2);
		e4.printWood();
		
		List<Wood> woodList = Arrays.asList(e1,e3,e2,e4);
		
		
		field.printField();
		
		Field fieldSolve = findSolution(woodList, field, 0);
		assertNotNull(fieldSolve);
		Map<Wood, RowAndColumn> fitPos = fieldSolve.getFitPosition();
		for (Wood item : fitPos.keySet()) {
			RowAndColumn pos = fitPos.get(item);
			System.out.println("---------------------------------"+pos.toString());			
			item.printWood();
			System.out.println("---------------------------------");
		}
	}

	//@Test
	public void test108() {
		Field f = new Field(7, 8);
		f.setBlockOnField(0, 6);
		f.setBlockOnField(0, 7);		
		f.setBlockOnField(3, 0);
		f.setBlockOnField(3, 7);		
		f.setBlockOnField(5, 7);
		f.setBlockOnField(6, 2);
		f.printField();
		
		Wood w1 = new Wood(2, 2);
		w1.setAllWood();
		w1.setActuallySize(1, 0, 0);
		w1.printWood();
		
		Wood w2 = new Wood(3, 3);
		w2.setAllWood();
		w2.setActuallySize(0, 0, 0);
		w2.setActuallySize(1, 0, 0);
		w2.setActuallySize(0, 2, 0);
		w2.setActuallySize(1, 2, 0);
		w2.printWood();
		
		Wood w3 = new Wood(3, 2);
		w3.setAllWood();
		w3.setActuallySize(0, 0, 0);
		w3.setActuallySize(2, 1, 0);
		w3.printWood();
		
		Wood w4 = new Wood(2, 2);
		w4.setAllWood();
		w4.setActuallySize(0, 0, 0);		
		w4.printWood();
		
		Wood w5 = new Wood(2, 3);
		w5.setAllWood();
		w5.setActuallySize(0, 1, 0);		
		w5.setActuallySize(0, 2, 0);	
		w5.printWood();
		
		Wood w6 = new Wood(2, 3);
		w6.setAllWood();
		w6.setActuallySize(1, 0, 0);		
		w6.setActuallySize(0, 2, 0);	
		w6.printWood();
		
		Wood w7 = new Wood(1, 3);
		w7.setAllWood();
		w7.printWood();
		
		Wood w8 = new Wood(1, 5);
		w8.setAllWood();
		w8.printWood();
		
		Wood w9 = new Wood(2, 2);
		w9.setAllWood();
		w9.printWood();
		
		Wood w10 = new Wood(3, 3);
		w10.setAllWood();
		w10.setActuallySize(0, 0, 0);
		w10.setActuallySize(0, 1, 0);
		w10.setActuallySize(1, 0, 0);
		w10.setActuallySize(1, 1, 0);
		w10.printWood();
		
		Wood w11 = new Wood(3, 3);
		w11.setAllWood();
		w11.setActuallySize(1, 1, 0);
		w11.setActuallySize(1, 2, 0);
		w11.setActuallySize(2, 1, 0);
		w11.setActuallySize(2, 2, 0);
		w11.printWood();		
		
		Wood w12 = new Wood(2, 4);
		w12.setAllWood();
		w12.setActuallySize(0, 0, 0);
		w12.setActuallySize(1, 2, 0);
		w12.setActuallySize(1, 3, 0);	
		w12.printWood();
		
		List<Wood> woodList = Arrays.asList(w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12);
		
		Field tmpField = f.clone();
		Field fieldSolve = findSolution(woodList, f, 0);
		assertNotNull(fieldSolve);
		Map<Wood, RowAndColumn> fitPos = fieldSolve.getFitPosition();
		tmpField.printField();
		for (Wood item : fitPos.keySet()) {
			RowAndColumn pos = fitPos.get(item);
			System.out.println("---------------------------------"+pos.toString());			
			item.printWood();
			System.out.println("---------------------------------");
			tmpField.fitWoodToIndex(item, pos.getRow(), pos.getColumn());
			tmpField.printField();
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	public void testExpert132(){
		Field field = new Field(8, 7);
		field.setBlockOnField(7, 5);
		
		field.setBlockOnField(2, 4);
		field.setBlockOnField(3, 1);
		field.setBlockOnField(4, 5);
		field.setBlockOnField(5, 1);
		field.printField();
		
		Wood w1 = new Wood(4, 1);
		w1.setAllWood();
		w1.printWood();
		
		Wood w2 = new Wood(3, 1);
		w2.setAllWood();
		w2.printWood();
		
		Wood w3 = new Wood(2, 3);
		w3.setAllWood();
		w3.setActuallySize(0, 0, 0);
		w3.setActuallySize(0, 1, 0);
		w3.printWood();
		
		Wood w4 = new Wood(2, 4);
		w4.setAllWood();
		w4.setActuallySize(1, 0, 0);
		w4.setActuallySize(1, 1, 0);
		w4.setActuallySize(0, 3, 0);	
		w4.printWood();
		
		Wood w5 = new Wood(4, 2);
		w5.setAllWood();
		w5.setActuallySize(0, 1, 0);
		w5.setActuallySize(1, 1, 0);
		w5.setActuallySize(3, 1, 0);	
		w5.printWood();
		
		Wood w6 = new Wood(3, 3);
		w6.setAllWood();
		w6.setActuallySize(0, 1, 0);
		w6.setActuallySize(0, 2, 0);
		w6.setActuallySize(2, 1, 0);
		w6.setActuallySize(2, 2, 0);
		w6.printWood();	
		
		Wood w7 = new Wood(2, 2);
		w7.setAllWood();
		w7.setActuallySize(0, 1, 0);
		w7.printWood();
		
		Wood w9 = new Wood(2, 1);
		w9.setAllWood();
		w9.printWood();
		
		Wood w10 = new Wood(1, 3);
		w10.setAllWood();
		w10.printWood();
		
		Wood w11 = new Wood(4, 2);
		w11.setAllWood();
		w11.setActuallySize(0, 0, 0);
		w11.setActuallySize(2, 0, 0);
		w11.setActuallySize(3, 0, 0);	
		w11.printWood();
		
		Wood w12 = new Wood(1, 2);
		w12.setAllWood();
		w12.printWood();
		
		Wood w13 = new Wood(2, 4);
		w13.setAllWood();
		w13.setActuallySize(1, 0, 0);
		w13.setActuallySize(1, 2, 0);
		w13.setActuallySize(1, 3, 0);	
		w13.printWood();
		
		Wood w14 = new Wood(2, 4);
		w14.setAllWood();
		w14.setActuallySize(1, 0, 0);
		w14.setActuallySize(1, 1, 0);
		w14.setActuallySize(1, 3, 0);	
		w14.printWood();
		
		List<Wood> woodList = Arrays.asList(w1,w2,w3,w4,w5,w6,w7,w9,w10,w11,w12,w13,w14);
		
		Field tmpField = field.clone();
		Field fieldSolve = findSolution(woodList, field, 0);
		assertNotNull(fieldSolve);
		Map<Wood, RowAndColumn> fitPos = fieldSolve.getFitPosition();
		tmpField.printField();
		for (Wood item : fitPos.keySet()) {
			RowAndColumn pos = fitPos.get(item);
			System.out.println("---------------------------------"+pos.toString());			
			item.printWood();
			System.out.println("---------------------------------");
			tmpField.fitWoodToIndex(item, pos.getRow(), pos.getColumn());
			tmpField.printField();
			System.out.println("---------------------------------");
		}
	}
	
	private Field findSolution(List<Wood> woodList,Field field,int woodSequent){
		Wood woodTarget = woodList.get(woodSequent);		
		List<RowAndColumn> canFitIndex = field.findPossibleFitIndex(woodTarget);
		if(canFitIndex.size() == 0)
			return null;
		for (RowAndColumn fitIndex : canFitIndex) {
			Field tmpField = field.clone();
//			System.out.println("--------Before-----------");
//			tmpField.printField();
//			System.out.println("--------Apply With-----------");
//			woodTarget.printWood();
			tmpField.fitWoodToIndex(woodTarget, fitIndex.getRow(), fitIndex.getColumn());//Fit wood before process next wood
//			System.out.println("--------After-----------");
			//tmpField.printField();
			int nextWoodSeq = woodSequent + 1;
			if(nextWoodSeq >= woodList.size()){
				//The last wood have been fit so check field
				if(tmpField.isAllFill())
					return tmpField;
				else
					return null;
			}				
			Field nextField = findSolution(woodList, tmpField, nextWoodSeq);// If true break
				if(nextField != null)
					return nextField;
		}
		return field.isAllFill() ? field : null;
	}
}
