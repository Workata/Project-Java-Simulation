package project;

/** Simulation
 * 
 * @author Jakub Tołściuk
 * @author Piotr Gralczyk
 * @author Michał Pijanowski
 * @version 3.7.3
 */

public class MainClass {  
	
	public static void main(String [] args)
	{
		//IMap firstMap = new Map(20,20,20,4,5,6,20,50);   
		IMap firstMap = new Map(40,40,40,3,4,5,20,100);   

		while(true)
		{
			for(int i=0;i<firstMap.getColonyInfo().getNumberOfA();i++) firstMap.getColonyInfo().getPointedAstro(i).makeMove(firstMap); //wykonuje ruchy astronautami
			for(int i=0;i<2;i++) firstMap.getRoverInfo().checkStatus(firstMap); //lazik robi aktualnie 2 ruchy dziennie
			
			if(UsefulFun.end(firstMap)) break;  //sprawdza czy spelniony jest warunek zakonczenia symulacji

			firstMap.getColonyInfo().addNewA(firstMap); //dodaje nowego astronaute, jezeli jest odpowiedni dzien
			
			Printer.MapOutPut(firstMap);
			
			UsefulFun.sleep(1000); //dlugosc dnia to aktualnie 1s 
			
			firstMap.nextDay();  //zmienia na kolejny dzien
			
			UsefulFun.clearScreen();	 //czysci ekran
		}
	}
}
