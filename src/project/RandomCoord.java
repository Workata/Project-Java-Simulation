package project;

import java.util.Random;

public class RandomCoord {
	
	private static int x,y;
	
	public static int getRandX(IMap map)
	{
		random(map);
		return x;
	}
	
	public static int getRandY(IMap map)
	{
		random(map);
		return y;
	}
	
	private static void random(IMap map)
	{
		Random rand = new Random();
		
		for(int i=0;i<1;i++)
		{
			x = rand.nextInt(map.getWidth()-2)+1;
			y = rand.nextInt(map.getHeight()-2)+1;
			if(map.getMapValue(x,y)!=" ") { i--; continue;}
		}
	}

}
