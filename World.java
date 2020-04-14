import java.awt.Color;
import java.util.ArrayList;

import acm.util.RandomGenerator;

public class World {

	private int width;
	private int height;
	private ArrayList<LifeForm> creatureList;

	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<LifeForm>();
	}

	public void letTimePass(){

		//		makeNewCreatures();
		checkAround();
		moveCreatures();

		//eatThings();
		creaturesGetOlder();
		purgeTheDead();		
	}

	/*	public void makeNewCreatures() {

		int currentSizeOfCreatureList = creatureList.size();
		System.out.println("size of list is "+currentSizeOfCreatureList);
		for(int i=0; i< currentSizeOfCreatureList; i++) {
			creatureList.get(i).reproduce();
		}
	}
	 */	
	public void moveCreatures() {
		for(int i=0; i< creatureList.size(); i++) {
			creatureList.get(i).move(i);
		}
	}

	public void checkAround() {
		boolean x2 = false;
		boolean y2 = false;
		for(int index=0; index<creatureList.size(); index++) {
			int x=creatureList.get(index).getMyLocation().getX();			
			int y=creatureList.get(index).getMyLocation().getY();
			int level=creatureList.get(index).getLevel();
			for (int plus=0; plus<creatureList.size();plus++) {
				if(creatureList.get(plus).getMyLocation().getX()==x && creatureList.get(plus).getMyLocation().getY()==y) {

				} else {
					for (int xVal = -1 ; xVal <= 1 ;xVal++) {	
						for(int yVal = -1 ; yVal <= 1; yVal++) {
							if(creatureList.get(plus).getMyLocation().getX()==x+xVal) {
								x2=true;
							}
							if(creatureList.get(plus).getMyLocation().getY()==y+yVal) {
								y2=true;
							}
							if( x2 == true && y2 == true) {
								spreadDisease(level, plus);
							}
						}
					}
				}
			}
		}
	}



	public void spreadDisease(int level,  int plus) {
		 
        if(creatureList.get(plus).getLevel()<level) {
                        creatureList.add(new aysmptomatic(creatureList.get(plus).getMyLifeSpan(),new Location(creatureList.get(plus).getMyLocation().getX(),creatureList.get(plus).getMyLocation().getY()), Color.BLUE, WorldController.theWorld, level));
                        
        } //color needs to change and level
        purgeTheDead();
}


	public void purgeTheDead(){
		int i=0;
		while(i<creatureList.size()){
			if(creatureList.get(i).isDead())
				creatureList.remove(i);
			else
				i++;
		}	
	}

	public void creaturesGetOlder(){
		for(LifeForm l:creatureList){
			l.age(1);
		}
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}
	public void setCreatureList(ArrayList<LifeForm> creatureList) {
		this.creatureList = creatureList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
