package project;

import java.util.Random;


public class Colony {
	
	public int numberOfA = 0,frequencyOfSpawn;
	private int x,y;
	
	public Astronauts table[] = new Astronauts[100];
	
	public Colony(int spawnFrequency)
	{
		this.frequencyOfSpawn = spawnFrequency;
	}
	
	public void addNewA(Map map)
	{
		if(map.day % frequencyOfSpawn == 0)
		{
			table[numberOfA] = new Astronauts();
			table[numberOfA].active = true;
			x = RandomCoord.getRandX(map);
			y = RandomCoord.getRandY(map);			
			table[numberOfA].x = x;
			table[numberOfA].y = y;

			numberOfA++;
		}
	
	}

}
