package project;

public interface IMap {
	
	public String getMapValue(int x, int y);
	public void setMapValue(int x, int y, String shape);
	public int getWidth();
	public int getHeight();
	public IMapElements getInfoWater();
	public IMapElements getInfoFood();
	public IMapElements getInfoOxygen();
	public void addOxyToCollected();
	public void addFooToCollected();
	public void addWatToCollected();

}
