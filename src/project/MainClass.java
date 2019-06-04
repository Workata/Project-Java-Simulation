package project;

/** Simulation
 * 
 * @author Jakub Tołściuk
 * @author Piotr Gralczyk
 * @author Michał Pijanowski
 * @version 3.6.4
 */


public class MainClass {  //Mozna zrobic klase "Symulacja" z funkcja main 

	public static void main(String [] args)
	{
		Map firstMap = new Map();              //dostepny jest tez konstruktor z parametrami
		
		while(true)
		{
			for(int i=0;i<firstMap.colony.getNumberOfA();i++) firstMap.colony.getPointedAstro(i).makeMove(firstMap);
			for(int i=0;i<2;i++) firstMap.rover.checkStatus(firstMap); //lazik robi aktualnie 2 ruchy dziennie
			
			if(UsefulFun.end(firstMap)) break;

			firstMap.colony.addNewA(firstMap);
			
			firstMap.mapOutput();
			
			UsefulFun.sleep(1000); //dlugosc dnia to aktualnie 1s , bedzie mozna zmienic w parametrach symulacji
			
			firstMap.nextDay();
			
			UsefulFun.clearScreen();
			
		}
		
	}
	
}
