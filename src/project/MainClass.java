package project;

import java.util.*;

public class MainClass {  //Mozna zrobic klase "Symulacja" z funkcja main 

	public static void main(String [] args)
	{
		Map firstMap = new Map(); 
		Colony firstColony = new Colony(10);  // (po ilu turach nowy astronauta)
		
		while(true)
		{
			for(int i=0;i<firstColony.numberOfA;i++) firstColony.table[i].makeMove(firstMap);
			
			if(firstMap.necessaryF <= firstMap.collectedF && firstMap.necessaryO <= firstMap.collectedO && firstMap.necessaryW <= firstMap.collectedW )
			{
				System.out.println("Symulacja zakonczona! Astronauci ukonczyli zbieranie materiałów.");   //wyrzucic z maina
				break;
			}

			firstColony.addNewA(firstMap);
			
			firstMap.mapOutput(firstColony);
			
			UsefulFun.sleep(1000);
			
			firstMap.day++;
			
			UsefulFun.clearScreen();
			
		}
		
	}
	
}
