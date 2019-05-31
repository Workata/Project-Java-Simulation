package project;

/** Simulation
 * 
 * @author Jakub Tołściuk
 * @author Piotr Gralczyk
 * @author Michał Pijanowski
 * @version 2.5.1
 */


public class MainClass {  //Mozna zrobic klase "Symulacja" z funkcja main 

	public static void main(String [] args)
	{
		Map firstMap = new Map();              //w przyszlosci nie bedzie konstruktora domyslnego tylko z parametrami
		//Colony firstColony = new Colony(10);  // (po ilu turach nowy astronauta)

		while(true)
		{
			for(int i=0;i<firstMap.colony.getNumberOfA();i++) firstMap.colony.getPointedAstro(i).makeMove(firstMap);
			for(int i=0;i<2;i++) firstMap.rover.checkStatus(firstMap); //lazik robi aktualnie 2 ruchy dziennie
			
			//wyrzucic z maina, sprawdza czy sa spelnione warunki zakonczenia symulacji
			if(firstMap.necessaryF <= firstMap.collectedF && firstMap.necessaryO <= firstMap.collectedO && firstMap.necessaryW <= firstMap.collectedW )
			{
				System.out.println("               Symulacja zakonczona! Astronauci ukonczyli zbieranie materiałów.");  
				for(int i=0;i<20;i++)
				{
					if(i==4) System.out.println("          Liczba dni: "+firstMap.day);
					if(i==5) System.out.println("          Liczba astronautow ostatniego dnia: "+firstMap.colony.getNumberOfA());
					else System.out.println();
				}
				break;
			}
			// (up) wyrzucic z maina

			firstMap.colony.addNewA(firstMap);
			
			firstMap.mapOutput(firstMap.colony,firstMap.rover);
			
			UsefulFun.sleep(1000); //dlugosc dnia to aktualnie 1s , bedzie mozna zmienic w parametrach symulacji
			
			firstMap.day++;
			
			UsefulFun.clearScreen();
			
		}
		
	}
	
}
