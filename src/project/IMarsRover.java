package project;

public interface IMarsRover extends IMapElements {
	public int getFuel();
	public int getBatteryStatus();
	public boolean isCharging();
	public void checkStatus(Map map);
}
