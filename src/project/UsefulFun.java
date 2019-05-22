package project;

public class UsefulFun {
	
	public static void sleep(int howLong)   //howLong ile czasu w milisekundach
	{
		try                                //To z neta jest, zatrzymuje program na 'x'  s
		{
			Thread.sleep(howLong);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	
	public static void clearScreen() {                //"czyszczenie konsoli" :)
		
		for(int k=0;k<100;k++)System.out.print("\n");
		
	}
}
