package project;

/** Simulation
 * 
 * @author Jakub Tołściuk
 * @author Piotr Gralczyk
 * @author Michał Pijanowski
 * @version 3.6.8
 */

public class MainClass {  
	
	public static void main(String [] args)
	{
		IMap firstMap = new Map(1,2,3,4,4,4,20,50);              //dostepny jest tez konstruktor z parametrami
		
		while(true)
		{
			for(int i=0;i<firstMap.getColonyInfo().getNumberOfA();i++) firstMap.getColonyInfo().getPointedAstro(i).makeMove(firstMap);
			for(int i=0;i<2;i++) firstMap.getRoverInfo().checkStatus(firstMap); //lazik robi aktualnie 2 ruchy dziennie
			
			if(UsefulFun.end(firstMap)) break;

			firstMap.getColonyInfo().addNewA(firstMap);
			
			Printer.MapOutPut(firstMap);
			
			UsefulFun.sleep(1000); //dlugosc dnia to aktualnie 1s , bedzie mozna zmienic w parametrach symulacji
			
			firstMap.nextDay();
			
			UsefulFun.clearScreen();	
		}
	}
}
