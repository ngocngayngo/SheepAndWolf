package control;

import java.util.ArrayList;

public class World {
	public Grass grass;
	public ArrayList<Animal> animals;
	public static long TIME_STEP = 1000;
	public String display() {
		String s="";
		double [][] cells = 
				new double 
				[grass.getNumberRow()][grass.getNumberColumn()];
		
		for(int i=0; i<grass.getNumberRow(); i++) {
			for(int j=0; j<grass.getNumberColumn();j++) {
				cells[i][j] = grass.getCell(i, j);
			}
		}
		for(Animal a : animals) {
			cells[a.currentRow][a.currentColumn] = 2;
		}
		for(int i=0; i<grass.getNumberRow(); i++) {
			for(int j=0; j<grass.getNumberColumn();j++) {
				cells[i][j] = grass.getCell(i, j);
				s = s + String.format("%.2f ", cells[i][j]); 	
			}
			s = s + "\n";
		}
		return s;
	}

}