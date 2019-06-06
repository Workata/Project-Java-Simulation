package project;

public class Astronauts extends MapElementsAbstract {
	
	public boolean active;     //zmienne pod katem rozszerzania projektu
	public int lives;         
	
	public Astronauts()    
	{
		active = false;
		lives = 3;            
		appearance = "+";      //ustawienie wygladu obiektu
	}
}
