package project;

public class MarsRover extends MapElementsAbstract implements IMarsRover {
	
	public int fuel,batteryStatus;
	public boolean charging;
	
	public MarsRover()
	{
		fuel = 100;
		charging = false;
		batteryStatus = 0;
		appearance = "R";
	}
	@Override
	public int getFuel() {return fuel;}
	@Override
	public int getBatteryStatus() {return batteryStatus;}
	@Override
	public boolean isCharging() {return charging;}
	
	private void charge(IMap map)
	{
		charging = true;
		if(batteryStatus == 100)
		{
			appearance = "R";
			map.setMapValue(this.x,this.y,appearance);
			charging = false;
			fuel = 100;
			batteryStatus = 0;
		}
		else batteryStatus += 5;
	}
	@Override
	public void checkStatus(IMap map)
	{
		if (charging) charge(map);
	    else if(fuel <= 0) 
		{
			appearance = "r";
			map.setMapValue(this.x,this.y,appearance);
			charge(map);
		}
		else makeMove(map);
	}
	
	@Override
	public void makeMove(IMap map)     //Tutaj mamy paliwo przy ruchu, wiec nadpisujemy funkcje ruchu
	{
		step.moveElement(this, map);
		fuel -= 2;
	}
	
	

}
