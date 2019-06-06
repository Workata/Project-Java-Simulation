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
	public int getDay();
	public void nextDay();
	public int getCollectedO();
	public int getCollectedF();
	public int getCollectedW();
	public int getNecessaryO();
	public int getNecessaryF();
	public int getNecessaryW();
	public IColony getColonyInfo();
	public IMarsRover getRoverInfo();

}
