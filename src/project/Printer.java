package project;

public class Printer {

	public static void MapOutPut(IMap map)  //Drukuje mape
	{
		for(int i=0;i<map.getWidth();i++)
		{
			for(int j=0;j<map.getHeight();j++)
			{
				System.out.print(map.getMapValue(i, j));
			}
			if(i==0) System.out.print("        Water: " + map.getCollectedW() + " / " + map.getNecessaryW());
			if(i==1) System.out.print("        Oxygen: " + map.getCollectedO() + " / " + map.getNecessaryO());
			if(i==2) System.out.print("        Food: " + map.getCollectedF() + " / " + map.getNecessaryF());
			if(i==4) System.out.print("        Day: " + map.getDay());
			if(i==5) System.out.print("        Support coming in "+ (map.getColonyInfo().getFrequencyOfSpawn() - (map.getDay() % map.getColonyInfo().getFrequencyOfSpawn())) +" days");
			if(i==7 && map.getRoverInfo().isCharging() ==false) System.out.print("        Fuel: " + map.getRoverInfo().getFuel());
			if(i==7 && map.getRoverInfo().isCharging() ==true) System.out.print("        Charging: " + map.getRoverInfo().getBatteryStatus() +"%");
			if(i==8) System.out.print("        Number of Astronauts: "+map.getColonyInfo().getNumberOfA());
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
