import java.awt.Color;
import java.util.ArrayList;

import acm.util.RandomGenerator;

public class Cow extends Animals {

	public Cow(int life, Location l, Color BLACK, World w, int level) {
		
		super(2, l, BLACK, w, level);
		myColor= Color.BLACK;
		
	}
	public void reproduce() {
		// this is silly code really, but as an example
		int newX = (int)(Math.random()*200);
		int newY = (int)(Math.random()*200); 
//		if () {
//			
//		}	
		myWorld.getCreatureList().add(new Cow(1,new Location(newX,newY), myColor, myWorld, 2));
	}
	
	public void move(int i) { 
		boolean move=true;	
		
		int x= myWorld.getCreatureList().get(i).getMyLocation().getX();
		x += rgen.nextInt(-1, 1);
		
		int y= myWorld.getCreatureList().get(i).getMyLocation().getY();
		y += rgen.nextInt(-1, 1);
		
		for (int plus=0; plus<myWorld.getCreatureList().size();plus++) {	
			if( (myWorld.getCreatureList().get(plus).getMyLocation().getX())==x 
				&& (myWorld.getCreatureList().get(plus).getMyLocation().getY())==y) {					x += rgen.nextInt(-1, 1);
				move= false;
				if (move==false) {
					break;
				}
			}
		}
		if (move==true) {
			myWorld.getCreatureList().get(i).getMyLocation().setX(x);
			myWorld.getCreatureList().get(i).getMyLocation().setY(y);
		}
	}
	private RandomGenerator rgen = RandomGenerator.getInstance();


}
