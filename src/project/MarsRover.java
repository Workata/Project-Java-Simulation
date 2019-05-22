package project;

public class MarsRover extends MapElementsAbstract{
	
	public int fuel;
	
	public MarsRover()
	{
		fuel = 100;
		appearance = "R";
	}
	
	public void checkFuel(Map map)
	{
		if(fuel <= 0) 
		{
			appearance = "r";
			map.mapa[this.x][this.y] = "r";
		}
		else makeMove(map);
	}
	
	@Override
	public void makeMove(Map map)     //Tutaj mamy paliwo przy ruchu, wiec nadpisujemy funkcje ruchu
	{
		step.moveElement(this, map);
		fuel = fuel - 2;
	}
	
	

}
