package project;

public abstract class MapElementsAbstract implements IMapElements {
	
	public int x,y;
	
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
	public void setX(int x) {this.x = x;}
	@Override
	public int getY() { return this.y; }
	@Override
	public void setY(int y) {this.y = y;}
	@Override
	public String getAppearance() {return appearance ;}
	@Override
	public void setAppearance(String shape) {appearance = shape;}
	@Override
	public void makeMove(Map map){step.moveElement(this, map);}
}
