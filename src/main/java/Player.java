import java.util.Arrays;
import java.util.Random;

public abstract class Player implements Moving,Distance,PlayerActions{

	static Random rand = new Random();
	private int twoPointsThrow;
	private int threePointsThorw;
	private int pass;
	private int steal;
	private int rebound;
	private int xPosition;
	private int yPosition;
	private boolean hasBall;
	private int pts=0;
	
	/**
	 * Konstruktor zawodników przypisuje losowe wartoœci ich atrybutom
	 * @param twoPointsThrow Rzut za 2 punkty
	 * @param threePointsThrow Rzut za 3 punkty 
	 * @param pass Podanie
	 * @param steal Przechwyt
	 * @param rebound Zbiórka 
	 * @param xPosition Wspó³rzêdna X
	 * @param yPosition Wspó³rzêdna Y
	 * @param hasBall Posiadanie pi³ki
	 */
	public Player(int twoPointsThrow, int threePointsThrow, int pass, int steal, int rebound, int xPosition, int yPosition, boolean hasBall)
	{
		this.twoPointsThrow=twoPointsThrow;
		this.threePointsThorw=threePointsThrow;
		this.pass=pass;
		this.steal=steal;
		this.rebound=rebound;
		this.xPosition=xPosition;
		this.yPosition=yPosition;
		this.hasBall=hasBall;
		
	}
	
	
	public int getTwoPointsThrow() {
		return twoPointsThrow;
	}
	public void setTwoPointsThrow(int twoPointsThrow) {
		this.twoPointsThrow = twoPointsThrow;
	}
	public int getThreePointsThorw() {
		return threePointsThorw;
	}
	public void setThreePointsThorw(int threePointsThorw) {
		this.threePointsThorw = threePointsThorw;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	public int getRebound() {
		return rebound;
	}
	public void setRebound(int rebound) {
		this.rebound = rebound;
	}
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public boolean isHasBall() {
		return hasBall;
	}
	public void setHasBall(boolean hasBall) {
		this.hasBall = hasBall;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	/**
	 * Oblicza dystans od innego zawodnika poprzez porównanie ich wspó³rzêdnych
	 */
	
	@Override
	public int distanceFromPlayer(Player p) {
		
		return Math.abs(xPosition-p.getxPosition()+Math.abs(yPosition-p.getyPosition()));
	}
	/**
	 * Zwraca najbli¿szego zawodnika od zawodnika który wykonuje t¹ metodê 
	 */
	
	@Override
	public Player nearestPlayer(Team t) {
		int [] distance = new int [5];
		distance[0]=distanceFromPlayer(t.p1);
		distance[1]=distanceFromPlayer(t.p2);
		distance[2]=distanceFromPlayer(t.p3);
		distance[3]=distanceFromPlayer(t.p4);
		distance[4]=distanceFromPlayer(t.p5);
		Arrays.sort(distance);
		int newDistance=distance[0];
		if(newDistance==distanceFromPlayer(t.p1))
		{
			
			return t.p1;
		}
		if(newDistance==distanceFromPlayer(t.p2))
		{
			
			return t.p2;
		}
		if(newDistance==distanceFromPlayer(t.p3))
		{
			
			return t.p3;
		}
		 if(newDistance==distanceFromPlayer(t.p4))
		{
			 
			return t.p4;
		}
		 if(newDistance==distanceFromPlayer(t.p5))
		{
			 
			return t.p5;
		}
		else
		return null;
		
	}
	/**
	 * Sprawdza w jakim obszarze boiska znajduje siê zawodnik. <br>
	 * Jeœli zwrócona jest 1 to jest pole rzutu za 2 punkty, dla 0 jest to pole rzutu za 3.
	 */
	
	@Override
	public int checkPosition(Court c) {
		
		if(c.coordinates[yPosition][xPosition]==1)
		{
			return 1;
		}
		else 
			return 0;
	}


	
	
	
}
