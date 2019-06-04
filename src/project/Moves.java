package project;

import java.awt.Toolkit;
import java.util.*;  

public class Moves implements IMoves{
	
	private int i,j;
	
	@Override
	public void moveElement(MapElementsAbstract objOnMap, Map map)  //polimorfizm bo moge przekazac astronaute lub lazik lub jakies zagrozenia 
	{
		i = objOnMap.getX();  
		j = objOnMap.getY();  
		find(objOnMap, map);
	}
	
	private void move(int ii,int jj,MapElementsAbstract objOnMap, IMap map)
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
	
	private boolean condition(int genNum,int num, int ii, int jj, Map map) //zeby nie powtarzac skladni warunku w funkcji find
	{   //krance mapy sa stale (ich wyglad sie nie bedzie zmienial)
		if(genNum == num && map.getMapValue(ii,jj)!=map.colony.getAstro().getAppearance() && map.getMapValue(ii,jj)!=map.rover.getAppearance()
		&& ii!=0 && jj!=0 && ii!=map.getWidth()-1 && jj!=map.getHeight()-1 )
		return true;  	
		else return false;
	}
	
	private void find(MapElementsAbstract objOnMap, Map map) //zmieniony system ruchu
	{                                                       
		Random rand = new Random();
		int liczba; 
		
		liczba = rand.nextInt(8)+1; //losowa liczba 1-8 rand.nextInt((max - min) + 1) + min
		
		if(condition(liczba,1,i-1,j,map)) { move(i-1,j,objOnMap,map);}
		else if(condition(liczba,2,i-1,j+1,map)) { move(i-1,j+1,objOnMap,map); }
		else if(condition(liczba,3,i,j+1,map)) { move(i,j+1,objOnMap,map);}
		else if(condition(liczba,4,i+1,j+1,map)) { move(i+1,j+1,objOnMap,map); }
		else if(condition(liczba,5,i+1,j,map)) {move(i+1,j,objOnMap,map); }
		else if(condition(liczba,6,i+1,j-1,map)) {move(i+1,j-1,objOnMap,map);}
		else if(condition(liczba,7,i,j-1,map)) {move(i,j-1,objOnMap,map);}
		else if(condition(liczba,8,i-1,j-1,map)) {move(i-1,j-1,objOnMap,map);}					
		
	} 
	
} 
