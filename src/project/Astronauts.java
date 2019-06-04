package project;

public class Astronauts extends MapElementsAbstract {
	
	public boolean active;
	public int lives;         //zmienna pod katem rozszerzania projektu
	
	public Astronauts()
	{
		active = false;
		lives = 3;            
		appearance = "+";
	}
}
