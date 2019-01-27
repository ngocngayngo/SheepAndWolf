package control;

import java.util.Random;

public class Sheep extends Animal implements IAnimal{

	public  Sheep(double energy, int speed) {
		this.energy = energy;
		this.speed = speed;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object die(Object o1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object move(Object o1) {
		Grass grass = (Grass) o1;
//		int x = this.rand.nextInt();
//		int d = 2*this.speed + 1;
//		int y = x % d;
//		int z = y - this.speed;
		
		currentRow += this.rand.nextInt()%(2*this.speed+1) - this.speed;
		currentColumn += this.rand.nextInt()%(2*this.speed+1) - this.speed;
//		if(currentRow >= grass.getNumberRow()) {
//			currentRow = 0;
//			
//		}
		currentRow = (currentRow>= grass.getNumberRow()) ? 0 : currentRow;
		currentRow = (currentRow < 0) ? (grass.getNumberRow()-1) : currentRow;
		
		currentColumn = (currentColumn>= grass.getNumberColumn()) ? 0 : currentColumn;
		currentColumn = (currentColumn < 0) ? (grass.getNumberColumn()-1) : currentColumn;
		return null;
	}

	@Override
	public Object drain_energy(Object o1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object mate(Object o1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void run() {
		
		while(true) {
			try {
				
				move(world.grass);
				Thread.sleep(World.TIME_STEP);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	

}