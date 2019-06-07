package project;

public class Colony implements IColony {
	
	private int numberOfA = 0,frequencyOfSpawn;  //frequencyOfSpawn - czestotliwosc z jaka pojawiaja sie nowi astronauci
	private int x,y;
	
	public Astronauts table[] = new Astronauts[100]; 
	
	public Colony(int spawnFrequency)
	{
		this.frequencyOfSpawn = spawnFrequency;
		table[0] = new Astronauts();       //iniciuje pierwszego astronaute, zeby mos korzystac (od samego poczatku) z jego wlasnosci (wygladu) w f. move
	}
	
	@Override
	public void addNewA(IMap map)
	{
		if(map.getDay() % frequencyOfSpawn == 0)  //sprawdzam czy dodac kolejnego astronaute
		{
			table[numberOfA] = new Astronauts();
			table[numberOfA].active = true;      //ewentualna eliminacja astronauty przez jakies zagrozenie, ktorego nie dodalismy do symulacji - brak aktywnosci gdyby byl martwy
			x = RandomCoord.getRandX(map);
			y = RandomCoord.getRandY(map);			
			table[numberOfA].x = x;
			table[numberOfA].y = y;

			numberOfA++;
		}
	}
	@Override
	public int getNumberOfA() { return numberOfA; } //zwraca liczbe astronautow
	@Override
	public Astronauts getPointedAstro(int i) { return table[i]; } // zwraca referencje do konkretnego astronauty
	@Override
	public int getFrequencyOfSpawn() {return frequencyOfSpawn; } // zwraca czestotliwosc spawnu

}
