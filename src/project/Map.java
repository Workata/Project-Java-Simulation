package project;


public class Map implements IMap  {
	
	private String[][] mapa ;
	public int n,m,day;
	private int numOfGenO, numOfGenF, numOfGenW;
	public int collectedO,collectedF,collectedW;
	public int necessaryO, necessaryF, necessaryW;
	private IMapElements water[]; 
	private IMapElements oxygen[];
	private IMapElements food[];
	IMarsRover rover;
	IColony colony;
	
	@Override
	public int getWidth() {return n;}
	@Override
	public int getHeight() {return m;}
	@Override
	public IMapElements getInfoWater() {return water[0];}
	@Override
	public IMapElements getInfoFood() {return food[0];}
	@Override
	public IMapElements getInfoOxygen() {return oxygen[0];}	
	@Override
	public String getMapValue(int x, int y) {return mapa[x][y];}
	@Override
	public void addOxyToCollected() {collectedO++;}
	@Override
	public void addFooToCollected() {collectedF++;}
	@Override
	public void addWatToCollected() {collectedW++;}
	@Override
	public void setMapValue(int x, int y, String shape) { mapa[x][y] = shape; }
	
	private void creating(int numOfGenW,int numOfGenO,int numOfGenF,int n, int m) {
		
		water= new Resources[numOfGenW];
		oxygen= new Resources[numOfGenO];
		food = new Resources[numOfGenF];
		rover = new MarsRover();
		colony = new Colony(10);
	
	mapa = new String[n][m];
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
	
	rover.setX(RandomCoord.getRandX(this));
	rover.setY(RandomCoord.getRandY(this));
	mapa[rover.getX()][rover.getY()]= rover.getAppearance();
	
	for(int i=0;i<numOfGenW;i++) 
	{
		water[i] = new Resources();  //trzeba zainicjowac kazdy obiekt w talblicy, cholernie WAZNE !!!
		water[i].setAppearance("W");
		water[i].setX(RandomCoord.getRandX(this));
		water[i].setY(RandomCoord.getRandY(this));
		mapa[water[i].getX()][water[i].getY()] = water[i].getAppearance();
	}
	
	for(int i=0;i<numOfGenO;i++)  
	{
		oxygen[i] = new Resources(); 
		oxygen[i].setAppearance ("O");
		oxygen[i].setX(RandomCoord.getRandX(this));
		oxygen[i].setY(RandomCoord.getRandY(this));
		mapa[oxygen[i].getX()][oxygen[i].getY()] = oxygen[i].getAppearance();
	}
	
	for(int i=0;i<numOfGenF;i++)  
	{
		food[i] = new Resources(); 
		food[i].setAppearance("F");
		food[i].setX(RandomCoord.getRandX(this));
		food[i].setY(RandomCoord.getRandY(this)); 
		mapa[food[i].getX()][food[i].getY()] = food[i].getAppearance();
	}
}	
	
	public Map()                                //domyslny konstruktor, bez parametrow
	{	
		numOfGenO = 20;
		numOfGenF = 20;
		numOfGenW = 20;
		collectedO = 0;
		collectedF = 0;
		collectedW = 0;
		necessaryO = 6;
		necessaryF = 3;
		necessaryW = 7;
			
		n=20;
		m=50;
		creating(numOfGenW, numOfGenO,numOfGenF,n,m);
		
	}
	public Map(int numOfGenW, int numOfGenO, int numOfGenF, int necessaryW, int necessaryO, int necessaryF, int n, int m)                     //konstruktor z podanymi parametrami
	{
		this.numOfGenO = numOfGenO;
		this.numOfGenF = numOfGenF;
		this.numOfGenW = numOfGenW;
		collectedO = 0;
		collectedF = 0;
		collectedW = 0;
		this.necessaryO = necessaryO;
		this.necessaryF = necessaryF;
		this.necessaryW = necessaryW;
		this.n=n;
		this.m=m;
		creating(numOfGenW, numOfGenO,numOfGenF,n,m);
		
	}
	
	public void mapOutput()
	{
		for(int i=0;i<this.n;i++)
		{
			for(int j=0;j<this.m;j++)
			{
				System.out.print(mapa[i][j]);
			}
			if(i==0) System.out.print("        Water: " + collectedW + " / " + necessaryW);
			if(i==1) System.out.print("        Oxygen: " + collectedO + " / " + necessaryO);
			if(i==2) System.out.print("        Food: " + collectedF + " / " + necessaryF);
			if(i==4) System.out.print("        Day: " + day);
			if(i==5) System.out.print("        Support coming in "+ (colony.getFrequencyOfSpawn() - (day % colony.getFrequencyOfSpawn())) +" days");
			if(i==7 && rover.isCharging() ==false) System.out.print("        Fuel: " + rover.getFuel());
			if(i==7 && rover.isCharging() ==true) System.out.print("        Charging: " + rover.getBatteryStatus() +"%");
			if(i==8) System.out.print("        Number of Astronauts: "+colony.getNumberOfA());
			System.out.print("\n");
		}
		System.out.print("\n");
	}

}