package main;

import java.util.ArrayList;

import control.Animal;
import control.Grass;
import control.Sheep;
import control.World;

public class Main_Name {
	
	private static void display(Grass grass) {
		for(int i=0;i<grass.nRows;i++) {
			for(int j=0;j<grass.nColumns;j++) {
				
				System.out.print(String.format("%.2f ", grass.getCell(i, j)));
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String args[]) {
		Grass grass = new Grass(5,7);
		World world = new World();
		world.grass = grass;
		ArrayList<Animal> animals = new ArrayList<>();
		Sheep sheep = new Sheep(0, 0);
		
		
		grass.start();// goi den ham run
		while(true) {
			System.out.println("////////////////");
			display(grass);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}


}