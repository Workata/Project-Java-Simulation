package project;

import java.awt.Toolkit;
import java.util.*;  

public class Moves implements IMoves{
	
	private int i,j;
	
	@Override
	public void moveElement(MapElementsAbstract objOnMap, IMap map)  //polimorfizm bo moge przekazac astronaute lub lazik lub jakies zagrozenia 
	{
		i = objOnMap.getX();                //pobierz wspolrzedne obiektu
		j = objOnMap.getY();  
		findPlaceToMove(objOnMap, map);
	}
	
	private void moveHere(int ii,int jj,MapElementsAbstract objOnMap, IMap map)
	{
		map.setMapValue(i,j," "); //stare miejsce na mapie danego obiektu
		
		objOnMap.setX(ii);
		objOnMap.setY(jj);
		
		//potrzebuje wyglad jednego elementu tablicy (danego typu), wiec moge wybrac np. pierwszy (oxygen[0])
		if(map.getMapValue(ii,jj)==map.getInfoOxygen().getAppearance()) {map.addOxyToCollected(); Toolkit.getDefaultToolkit().beep();} 
		if(map.getMapValue(ii,jj)==map.getInfoFood().getAppearance()) {map.addFooToCollected(); Toolkit.getDefaultToolkit().beep();}
		if(map.getMapValue(ii,jj)==map.getInfoWater().getAppearance()) {map.addWatToCollected(); Toolkit.getDefaultToolkit().beep();}
		
		map.setMapValue(ii,jj,objOnMap.getAppearance());   
	}
	
	private boolean canIMoveHere(int genNum,int num, int ii, int jj, IMap map) //zeby nie powtarzac skladni warunku w funkcji find
	{   
		if(genNum == num && ( map.getMapValue(ii,jj)==" " ||  map.getMapValue(ii,jj)==map.getInfoOxygen().getAppearance() || map.getMapValue(ii,jj)==map.getInfoFood().getAppearance() || map.getMapValue(ii,jj)==map.getInfoWater().getAppearance()))
		return true;  	
		else return false;
	}
	
	private void findPlaceToMove(MapElementsAbstract objOnMap, IMap map) //zmieniony system ruchu
	{                                                       
		Random rand = new Random();
		int liczba; 
		
		liczba = rand.nextInt(8)+1; //losowa liczba 1-8 rand.nextInt((max - min) + 1) + min
		
		if(canIMoveHere(liczba,1,i-1,j,map)) {moveHere(i-1,j,objOnMap,map);}
		else if(canIMoveHere(liczba,2,i-1,j+1,map)) { moveHere(i-1,j+1,objOnMap,map); }
		else if(canIMoveHere(liczba,3,i,j+1,map)) { moveHere(i,j+1,objOnMap,map);}
		else if(canIMoveHere(liczba,4,i+1,j+1,map)) { moveHere(i+1,j+1,objOnMap,map); }
		else if(canIMoveHere(liczba,5,i+1,j,map)) {moveHere(i+1,j,objOnMap,map); }
		else if(canIMoveHere(liczba,6,i+1,j-1,map)) {moveHere(i+1,j-1,objOnMap,map);}
		else if(canIMoveHere(liczba,7,i,j-1,map)) {moveHere(i,j-1,objOnMap,map);}
		else if(canIMoveHere(liczba,8,i-1,j-1,map)) {moveHere(i-1,j-1,objOnMap,map);}						
	} 
	
} 
