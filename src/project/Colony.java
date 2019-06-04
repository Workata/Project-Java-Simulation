package project;

public class Colony implements IColony {
	
	private int numberOfA = 0,frequencyOfSpawn;
	private int x,y;
	
	public Astronauts table[] = new Astronauts[100];
	
	public Colony(int spawnFrequency)
	{
		this.frequencyOfSpawn = spawnFrequency;
		table[0] = new Astronauts(); //iniciuje pierwszego astronaute, zeby mos korzystac (od samego poczatku) z jego wlasnosci (wygladu) w f. move
	}
	
	@Override
	public void addNewA(Map map)
	{
		if(map.getDay() % frequencyOfSpawn == 0)
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
	@Override
	public int getNumberOfA()
	{
		return numberOfA;
	}
	@Override
	public Astronauts getPointedAstro(int i)
	{
		return table[i];
	}
	@Override
	public int getFrequencyOfSpawn()
	{
		return frequencyOfSpawn;
	}
}
