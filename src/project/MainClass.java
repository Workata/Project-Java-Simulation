package project;

import java.util.*;

public class MainClass {

	public static void main(String [] args)
	{
		Map firstMap = new Map(); 
		Colony firstColony = new Colony(10);  // (po ilu turach nowy astronauta)
		
		firstMap.mapOutput(firstColony);
		
		while(true)
		{
			for(int i=0;i<firstColony.numberOfA;i++) firstColony.table[i].makeMove(firstMap);

			firstColony.addNewA(firstMap);
			
			firstMap.mapOutput(firstColony);
			
			UsefulFun.sleep(1000);
			
			firstMap.day++;
			
			UsefulFun.clearScreen();
			
		}
		
	}
	
}
