package project;


public class Map extends MapInformationsAbstract implements IMap  {
	
	private String[][] mapa ;
	private IMapElements water[]; 
	private IMapElements oxygen[];
	private IMapElements food[];
	IMarsRover rover;
	IColony colony;
	
	@Override
	public int getWidth() {return n;}  //podaje szerokosc mapy
	@Override
	public int getHeight() {return m;}  //podaje wysokosc mapy
	@Override
	public IMapElements getInfoWater() {return water[0];} //zwraca obiekt (wystarczy jeden), zeby sie dostac do jego informacji
	@Override
	public IMapElements getInfoFood() {return food[0];} //jak wyzej
	@Override
	public IMapElements getInfoOxygen() {return oxygen[0];}	//jak wyzej
	@Override
	public String getMapValue(int x, int y) {return mapa[x][y];} //zwraca String mapy polozony na konkretnym punkcie
	@Override
	public void addOxyToCollected() {collectedO++;} 
	@Override
	public void addFooToCollected() {collectedF++;}
	@Override
	public void addWatToCollected() {collectedW++;}
	@Override
	public void setMapValue(int x, int y, String shape) { mapa[x][y] = shape; } //zmienia wyglad mapy w danym punkcie
	@Override
	public int getDay() { return day;}			//zwraca dzien
	@Override
	public void nextDay() { day++; }            //ustawia kolejny dzien
	@Override
	public IColony getColonyInfo() { return colony; } // zwraca obiekt kolonii, zeby sie dostac do jego informacji
	@Override
	public IMarsRover getRoverInfo() {return rover;} // to samo tylko, ze z lazikiem
	@Override
	public int getCollectedO() { return collectedO;}  //zwraca liczbe zdobytego 
	@Override
	public int getCollectedF() { return collectedF;}
	@Override
	public int getCollectedW() { return collectedW;}
	@Override
	public int getNecessaryO() { return necessaryO;}
	@Override
	public int getNecessaryF() { return necessaryF;}
	@Override
	public int getNecessaryW() { return necessaryW;}
	
	private int ComparingNumbers(int a,int b)
	{
		if(a<b) return b;
		else return a;
	}
	
	private void ResourceSpawner(int NumToGen,String apperance, IMapElements[] type)
	{	
			if(NumToGen==0)
			{
				type[0]= new Resources();
				type[0].setAppearance(apperance);	
			}
			else
			{
				for(int i=0;i<NumToGen;i++)
				{
					type[i] = new Resources();  
					type[i].setAppearance(apperance);
					type[i].setX(RandomCoord.getRandX(this));
					type[i].setY(RandomCoord.getRandY(this));
					mapa[type[i].getX()][type[i].getY()] = type[i].getAppearance();
				}
		}
	}
	
	
	
	private void creating(int numOfGenW,int numOfGenO,int numOfGenF,int n, int m) {
		
		water= new Resources[ComparingNumbers(numOfGenW,0)+1];
		oxygen= new Resources[ComparingNumbers(numOfGenO,0)+1];
		food = new Resources[ComparingNumbers(numOfGenF,0)+1];
		
		
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
	ResourceSpawner(numOfGenO,"O",oxygen);
	ResourceSpawner(numOfGenW,"W",water);     
	ResourceSpawner(numOfGenF,"F",food);

}	
	public Map()         //domyslny konstruktor, bez parametrow
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
	public Map(int numOfGenW, int numOfGenO, int numOfGenF, int necessaryW, int necessaryO, int necessaryF, int n, int m)    //konstruktor z podanymi parametrami
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
	
	

}