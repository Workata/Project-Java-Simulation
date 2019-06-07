package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoverTest {  //testy jednostkowe
	
	@Test
	public void marsRoverFuelTest() {
		MarsRover marsRover = new MarsRover();
		int fuel = marsRover.getFuel();
		assertEquals(100, fuel);		
	}
	
	@Test
	public void marsRoverBatteryStatusTest() {
		MarsRover marsRover = new MarsRover();
		int batteryStatus = marsRover.getBatteryStatus();
		assertEquals(0, batteryStatus);		
	}
	
	@Test
	public void marsRoverChargingTest() {
		MarsRover marsRover = new MarsRover();
		boolean charging = marsRover.isCharging();
		assertEquals(false, charging);		
	}
	
	@Test
	public void marsRoverMovingTest() {
		Map map = new Map();
		MarsRover marsRover = new MarsRover();
		
		
		while (marsRover.getFuel() != 0)
		try {
			marsRover.makeMove(map);
		} catch (Exception e) {
		}
		
		marsRover.checkStatus(map);
		
		int batteryStatus = marsRover.getBatteryStatus();
		assertEquals(5, batteryStatus);	
		
		boolean charging = marsRover.isCharging();
		assertEquals(true, charging);	
		
	}

}
