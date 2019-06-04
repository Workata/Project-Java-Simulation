package project;

public abstract class MapInformationsAbstract { //ewentualnie interfejs zamiast klasy abstrakcyjnej?
	
	public int n,m,day;
	public int numOfGenO, numOfGenF, numOfGenW;
	public int collectedO,collectedF,collectedW;
	public int necessaryO, necessaryF, necessaryW;

	
}

//TODO Usunac klase abstrakcyjna MapInfo, dodac interfejs IMap a w nim zadeklarowac funkcje, ktora zwraca wartosca pola talicy 2D
//TODO funkcje ta nadpisac w klasie Map
//TODO ogarnac system poruszania sie
