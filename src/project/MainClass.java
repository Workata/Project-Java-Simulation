package project;


public class MainClass {  //Mozna zrobic klase "Symulacja" z funkcja main 

	public static void main(String [] args)
	{
		Map firstMap = new Map();              //w przyszlosci nie bedzie konstruktora domyslnego tylko z parametrami
		Colony firstColony = new Colony(10);  // (po ilu turach nowy astronauta)
		
		MarsRover rover;
		
		rover = new MarsRover();
		rover.x = RandomCoord.getRandX(firstMap);
		rover.y = RandomCoord.getRandY(firstMap);
		firstMap.mapa[rover.x][rover.y]= rover.appearance;
		
		while(true)
		{
			for(int i=0;i<firstColony.numberOfA;i++) firstColony.table[i].makeMove(firstMap);
			for(int i=0;i<2;i++) rover.checkStatus(firstMap); //lazik robi aktualnie 2 ruchy dziennie
			
			//wyrzucic z maina, sprawdza czy sa spelnione warunki zakonczenia symulacji
			if(firstMap.necessaryF <= firstMap.collectedF && firstMap.necessaryO <= firstMap.collectedO && firstMap.necessaryW <= firstMap.collectedW )
			{
				System.out.println("               Symulacja zakonczona! Astronauci ukonczyli zbieranie materiałów.");  
				for(int i=0;i<20;i++)
				{
					if(i==4) System.out.println("          Liczba dni: "+firstMap.day);
					if(i==5) System.out.println("          Liczba astronautow ostatniego dnia: "+firstColony.numberOfA);
					else System.out.println();
				}
				break;
			}
			// (up) wyrzucic z maina

			firstColony.addNewA(firstMap);
			
			firstMap.mapOutput(firstColony,rover);
			
			UsefulFun.sleep(1000); //dlugosc dnia to aktualnie 1s , bedzie mozna zmienic w parametrach symulacji
			
			firstMap.day++;
			
			UsefulFun.clearScreen();
			
		}
		
	}
	
}
