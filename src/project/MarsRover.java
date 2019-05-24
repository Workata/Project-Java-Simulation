package project;

public class MarsRover extends MapElementsAbstract{
	
	public int fuel;
	public boolean charging = false;
	public int batteryStatus = 0;
	
	public MarsRover()
	{
		fuel = 100;
		appearance = "R";
	}
	
	private void charge(Map map)
	{
		charging = true;
		if(batteryStatus == 100)
		{
			appearance = "R";
			map.mapa[this.x][this.y] = appearance;
			charging = false;
			fuel = 100;
			batteryStatus = 0;
		}
		else batteryStatus += 5;
	}
	
	public void checkStatus(Map map)
	{
		if (charging) charge(map);
	    else if(fuel <= 0) 
		{
			appearance = "r";
			map.mapa[this.x][this.y] = appearance;
			charge(map);
		}
		else makeMove(map);
	}
	
	@Override
	public void makeMove(Map map)     //Tutaj mamy paliwo przy ruchu, wiec nadpisujemy funkcje ruchu
	{
		step.moveElement(this, map);
		fuel -= 2;
	}
	
	

}
