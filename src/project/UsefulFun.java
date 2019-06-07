package project;

public class UsefulFun {
	
	public static void sleep(int howLong)   //howLong ile czasu w milisekundach
	{
		try                                //Source: stack, zatrzymuje program na 'x'  s
		{
			Thread.sleep(howLong);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	
	public static void clearScreen() {                //"czyszczenie konsoli" 
		
		for(int k=0;k<100;k++)System.out.print("\n");
		
	}
	
	public static boolean end(IMap firstMap)  //sprawdzam czy warunki zakonczenia sa spelnione
	{
		if(firstMap.getNecessaryF() <= firstMap.getCollectedF() && firstMap.getNecessaryW() <= firstMap.getCollectedW() && firstMap.getNecessaryO() <= firstMap.getCollectedO() )
		{
			System.out.println("               Symulacja zakonczona! Astronauci ukonczyli zbieranie materiałów.");  
			for(int i=0;i<20;i++)
			{
				if(i==4) System.out.println("          Liczba dni: "+firstMap.getDay());
				if(i==5) System.out.println("          Liczba astronautow ostatniego dnia: "+firstMap.getColonyInfo().getNumberOfA());
				else System.out.println();
			}
		}
		else return false;
		return true;
	}
}
