package project;

/** Simulation
 * 
 * @author Jakub Tołściuk
 * @author Piotr Gralczyk
 * @author Michał Pijanowski
 * @version 3.6.8
 */


public class MainClass {  

	public static IMap firstMap;
	
	public static void main(String [] args)
	{
		firstMap = new Map();              //dostepny jest tez konstruktor z parametrami
		
		while(true)
		{
			for(int i=0;i<firstMap.getColonyInfo().getNumberOfA();i++) firstMap.getColonyInfo().getPointedAstro(i).makeMove(firstMap);
			for(int i=0;i<2;i++) firstMap.getRoverInfo().checkStatus(firstMap); //lazik robi aktualnie 2 ruchy dziennie
			
			if(UsefulFun.end(firstMap)) break;

			firstMap.getColonyInfo().addNewA(firstMap);
			
			firstMap.mapOutput();
			
			UsefulFun.sleep(1000); //dlugosc dnia to aktualnie 1s , bedzie mozna zmienic w parametrach symulacji
			
			firstMap.nextDay();
			
			UsefulFun.clearScreen();
			
		}
		
	}
	
}
