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
	
	private void move(int ii,int jj,MapElementsAbstract objOnMap, Map map)
	{
		map.mapa[i][j]=" ";  //stare miejsce na mapie danego obiektu
		
		
		objOnMap.x = ii;
		objOnMap.y = jj;
		
		//potrzebuje wyglad jednego elementu tablicy (danego typu), wiec moge wybrac np. pierwszy (oxygen[0])
		if(map.mapa[ii][jj]==map.oxygen[0].getAppearance()) {map.collectedO++; Toolkit.getDefaultToolkit().beep();} 
		if(map.mapa[ii][jj]==map.food[0].getAppearance()) {map.collectedF++; Toolkit.getDefaultToolkit().beep();}
		if(map.mapa[ii][jj]==map.water[0].getAppearance()) {map.collectedW++; Toolkit.getDefaultToolkit().beep();}
		
		map.mapa[ii][jj]=objOnMap.appearance;   
	}
	
	private boolean condition(int genNum,int num, int ii, int jj, Map map) //zeby nie powtarzac skladni warunku w funkcji find
	{   //krance mapy sa stale (ich wyglad sie nie bedzie zmienial)
		if(genNum == num && map.mapa[ii][jj]!=map.colony.getAstro().getAppearance() && map.mapa[ii][jj]!=map.rover.getAppearance() && ii!=0 && jj!=0 && ii!=map.n-1 && jj!=map.m-1 ) return true;  	
		else return false;
	}
	
	private void find(MapElementsAbstract objOnMap, Map map) 
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
