package control;


import java.util.Random;

public class Grass extends Thread {
	
	public int nColumns;
	public int nRows;
	private double [][] cells;
	private Random rand;
	private static double MAX_GROWING_SPEED = 0.1;
	

	public Grass(int nRows , int nColumns) {
		super();
		this.rand = new Random();
		this.nColumns = nColumns;
		this.nRows = nRows;
		this.cells = new double [nRows][nColumns];
		for (int i=0;i<nRows;i++) {
			for(int j=0;j<nColumns;j++) 
			{
				cells[i][j] = rand.nextDouble();
				
			}
		}
	}
	
	public synchronized  double getCell(int i, int j) {
		return cells[i][j];
	}
	
	public void grow() {
		for (int i=0;i<nRows;i++) {
			for(int j=0;j<nColumns;j++) {
				cells[i][j]+=rand.nextDouble()*MAX_GROWING_SPEED;
//				if(cells[i][j]>1) {
//					cells[i][j]=1;
//				}
				cells[i][j]=(cells[i][j] > 1) ? 1 : cells[i][j]; // cai nay nhanh hon
			}
		}
	}
	
	public void run() {
		while(true) {
			try {
				grow();
				Thread.sleep(World.TIME_STEP);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public synchronized int getNumberRow() {
		return nRows;
	}
	public synchronized int getNumberColumn() {
		return nColumns;
	}
}