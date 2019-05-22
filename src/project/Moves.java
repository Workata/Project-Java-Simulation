package project;

import java.awt.Toolkit;
import java.util.*;  

public class Moves {
	
	private int i;
	private int j;
	
	
	public void moveElement(MapElementsAbstract objOnMap, Map map)  //polimorfizm bo moge przekazac astronaute lub lazik lub jakies zagrozenia 
	{
		i = objOnMap.getX();  //mozna samo .x ale z funkcja jest ciekawiej
		j = objOnMap.getY();  //wyglada bardziej profesjonalnie xdd
		find(objOnMap, map);
	}
	
		
	private void move(int ii,int jj,MapElementsAbstract objOnMap, Map map)
	{
		map.mapa[i][j]=" ";  //stare miejsce na mapie danego obiektu
		
		
		objOnMap.x = ii;
		objOnMap.y = jj;
		
		
		if(map.mapa[ii][jj]=="O") {map.collectedO++; Toolkit.getDefaultToolkit().beep();}
		if(map.mapa[ii][jj]=="F") {map.collectedF++; Toolkit.getDefaultToolkit().beep();}
		if(map.mapa[ii][jj]=="W") {map.collectedW++; Toolkit.getDefaultToolkit().beep();}
		
		map.mapa[ii][jj]=objOnMap.appearance;   
	}
	
	private boolean condition(int genNum,int num, int ii, int jj, Map map) //zeby nie powtarzac skladni warunku w funkcji find
	{
		if(genNum == num && map.mapa[ii][jj]!="+" && map.mapa[ii][jj]!="r" && map.mapa[ii][jj]!="R") return true;
		else return false;
	}
	
	private void find(MapElementsAbstract objOnMap, Map map)
	{
		Random rand = new Random();
		int liczba;
		
					if(i==1)
					{
						if(j==1)
						{
							liczba = rand.nextInt(3)+1;
							if(condition(liczba,1,i+1,j,map))
							{
								move(i+1,j,objOnMap,map);
								        
							}
							else if(condition(liczba,2,i+1,j+1,map))
							{
								move(i+1,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,3,i,j+1,map))
							{
								move(i,j+1,objOnMap,map);
								
							}
						}
						else if(j == map.m-2) //i=1
						{
							liczba = rand.nextInt(3)+1;                          //losowa liczba 1-3 rand.nextInt((max - min) + 1) + min
							if(condition(liczba,1,i+1,j,map))
							{
								move(i+1,j,objOnMap,map);
								
							}
							else if(condition(liczba,2,i,j-1,map))
							{
								move(i,j-1,objOnMap,map);
								
							}
							else if(condition(liczba,3,i+1,j-1,map))
							{
								move(i+1,j-1,objOnMap,map);
								
							}
						}
						else
						{
							liczba = rand.nextInt(5)+1;
							if(condition(liczba,1,i,j+1,map))
							{
								move(i,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,2,i+1,j+1,map))
							{
								move(i+1,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,3,i+1,j,map))
							{
								move(i+1,j,objOnMap,map);
								
							}
							else if(condition(liczba,4,i+1,j-1,map))
							{
								move(i+1,j-1,objOnMap,map);
								
							}
							else if(condition(liczba,5,i,j-1,map))
							{
								move(i,j-1,objOnMap,map);
								
							}
						}
					}	
					else if(j==1)
					{
						if(i==map.n-2) //j=1
						{
							liczba = rand.nextInt(3)+1; 
							if(condition(liczba,1,i-1,j,map))
							{
								move(i-1,j,objOnMap,map);
								
							}
							else if(condition(liczba,2,i-1,j+1,map))
							{
								move(i-1,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,3,i,j+1,map))
							{
								move(i,j+1,objOnMap,map);
								
							}
						}
						else
						{
							liczba = rand.nextInt(5)+1;
							if(condition(liczba,1,i-1,j,map))
							{
								move(i-1,j,objOnMap,map);
								
							}
							else if(condition(liczba,2,i-1,j+1,map))
							{
								move(i-1,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,3,i,j+1,map))
							{
								move(i,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,4,i+1,j+1,map))
							{
								move(i+1,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,5,i+1,j,map))
							{
								move(i+1,j,objOnMap,map);
								
							}
						}
					}
					else if(i==map.n-2)
					{
						if(j==map.m-2)
						{
							liczba = rand.nextInt(3)+1; 
							if(condition(liczba,1,i,j-1,map))
							{
								move(i,j-1,objOnMap,map);
								
							}
							else if(condition(liczba,2,i-1,j-1,map))
							{
								move(i-1,j-1,objOnMap,map);
								
							}
							else if(condition(liczba,3,i-1,j,map))
							{
								move(i-1,j,objOnMap,map);
								
							}
						}
						else
						{
							liczba = rand.nextInt(5)+1;
							if(condition(liczba,1,i,j-1,map))
							{
								move(i,j-1,objOnMap,map);
								
							}
							else if(condition(liczba,2,i-1,j-1,map))
							{
								move(i-1,j-1,objOnMap,map);
								
							}
							else if(condition(liczba,3,i-1,j,map))
							{
								move(i-1,j,objOnMap,map);
								
							}
							else if(condition(liczba,4,i-1,j+1,map))
							{
								move(i-1,j+1,objOnMap,map);
								
							}
							else if(condition(liczba,5,i,j+1,map))
							{
								move(i,j+1,objOnMap,map);
								
							}
						}
					}
					else if(j==map.m-2)
					{
						liczba = rand.nextInt(5)+1;
						if(condition(liczba,1,i-1,j,map))
						{
							move(i-1,j,objOnMap,map);
							
						}
						else if(condition(liczba,2,i-1,j-1,map))
						{
							move(i-1,j-1,objOnMap,map);
							
						}
						else if(condition(liczba,3,i,j-1,map))
						{
							move(i,j-1,objOnMap,map);
							
						}
						else if(condition(liczba,4,i+1,j-1,map))
						{
							move(i+1,j-1,objOnMap,map);
							
						}
						else if(condition(liczba,5,i+1,j,map))
						{
							move(i+1,j,objOnMap,map);
							
						}
					}
					else                                            //nie przy bandzie
					{
						liczba = rand.nextInt(8)+1;
						if(condition(liczba,1,i-1,j,map))
						{
							move(i-1,j,objOnMap,map);
							
						}
						else if(condition(liczba,2,i-1,j+1,map))
						{
							move(i-1,j+1,objOnMap,map);
							
						}
						else if(condition(liczba,3,i,j+1,map))
						{
							move(i,j+1,objOnMap,map);
							
						}
						else if(condition(liczba,4,i+1,j+1,map))
						{
							move(i+1,j+1,objOnMap,map);
							
						}
						else if(condition(liczba,5,i+1,j,map))
						{
							move(i+1,j,objOnMap,map);
							
						}
						else if(condition(liczba,6,i+1,j,map))
						{
							move(i+1,j-1,objOnMap,map);
							
						}
						else if(condition(liczba,7,i,j-1,map))
						{
							move(i,j-1,objOnMap,map);
							
						}
						else if(condition(liczba,8,i-1,j-1,map))
						{
							move(i-1,j-1,objOnMap,map);
							
						}
					}
		
	} //metoda
	
} //klasa
