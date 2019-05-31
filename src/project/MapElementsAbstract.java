package project;

public abstract class MapElementsAbstract implements IMapElements {
	
	public int x,y,fuel,batteryStatus;
	public boolean charging;
	
	public  String appearance; //wyglad elementu na mapie
	public IMoves step = new Moves(); //kolejna agregacja "Mozliwosc ruchu nalezy do obiektow mapy"
	
	public MapElementsAbstract()
	{
		x = 0;
		y = 0;
		appearance = "-";
	}
	@Override
	public int getX() { return this.x; }
	@Override
	public int getY() { return this.y; }
	@Override
	public void makeMove(Map map)
	{
		step.moveElement(this, map);
	}
	@Override
	public void checkStatus(Map map) {}
	
	
}
