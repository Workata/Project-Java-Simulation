package project;

import java.util.*;

public class Map extends MapInformationsAbstract  {
	
	public String[][] mapa ;
	Resources water[];
	Resources oxygen[];
	Resources food[];
	MarsRover rover;

	public Map()                                //domyslny konstruktor, bez parametrow
	{	
		numOfGenO = 20;
		numOfGenF = 20;
		numOfGenW = 20;
		collectedO = 0;
		collectedF = 0;
		collectedW = 0;
		necessaryO = 10;
		necessaryF = 10;
		necessaryW = 10;
		
		water= new Resources[numOfGenW];
		oxygen= new Resources[numOfGenO];
		food = new Resources[numOfGenF];
		mapa = new String[100][100];
		n=20;
		m=50;
		day = 1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(i==0 || i==n-1) mapa[i][j]="─";
				if(j==0 || j==m-1) mapa[i][j]="│";
				if(i!=0 && j!=0 && i!=n-1 && j!=m-1) mapa[i][j]=" ";
			}
		}
		
		mapa[0][0]="┌";        //skrajne punkty ramki
		mapa[n-1][m-1]="┘";
		mapa[0][m-1]="┐";
		mapa[n-1][0]="└";
		
		/*rover = new MarsRover();
		rover.x = RandomCoord.getRandX(this);
		rover.y = RandomCoord.getRandY(this);
		mapa[rover.x][rover.y]= rover.appearance; */
		
		for(int i=0;i<numOfGenW;i++) 
		{
			water[i] = new Resources();  //trzeba zainicjowac kazdy obiekt w talblicy, cholernie WAZNE !!!
			water[i].appearance = "W";
			water[i].x = RandomCoord.getRandX(this);
			water[i].y = RandomCoord.getRandY(this);
			mapa[water[i].x][water[i].y] = water[i].appearance;
		}
		
		for(int i=0;i<numOfGenO;i++)  
		{
			oxygen[i] = new Resources(); 
			oxygen[i].appearance = "O";
			oxygen[i].x = RandomCoord.getRandX(this);
			oxygen[i].y = RandomCoord.getRandY(this);
			mapa[oxygen[i].x][oxygen[i].y] = oxygen[i].appearance;
		}
		
		for(int i=0;i<numOfGenF;i++)  
		{
			food[i] = new Resources(); 
			food[i].appearance = "F";
			food[i].x = RandomCoord.getRandX(this);
			food[i].y = RandomCoord.getRandY(this);
			mapa[food[i].x][food[i].y] = food[i].appearance;
		}
	}
	
	public Map(int n, int m)                     //konstruktor z podanymi parametrami
	{
		//uzupelnic
	}
	
	public  void mapOutput(Colony colony)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(mapa[i][j]);
			}
			if(i==0) System.out.print("        Water: " + collectedW);
			if(i==1) System.out.print("        Oxygen: " + collectedO);
			if(i==2) System.out.print("        Food: " + collectedF);
			if(i==4) System.out.print("        Day: " + day);
			if(i==6) System.out.print("        Support coming in "+ (colony.frequencyOfSpawn - (day % colony.frequencyOfSpawn)) +" days");
			if(i==8) System.out.print("        Number of Astronauts: "+colony.numberOfA);
			System.out.print("\n");
		}
		System.out.print("\n");
	}

}
