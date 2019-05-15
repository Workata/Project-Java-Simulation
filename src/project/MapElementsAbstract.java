package project;

public abstract class MapElementsAbstract {
	
	public int x,y;
	public String appearance; //wyglad elementu na mapie
	
	public MapElementsAbstract()
	{
		this.x = 0;
		this.y = 0;
		this.appearance = "-";
	}
	
	public int getX() { return this.x; }
	
	public int getY() { return this.y; }

	public void makeMove(Map map)
	{
		Moves.moveElement(this, map);
	}
	

}
