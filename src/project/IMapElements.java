package project;

public interface IMapElements {
	
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	public String getAppearance();
	public void setAppearance(String shape);
	public void makeMove(IMap map);	
}
