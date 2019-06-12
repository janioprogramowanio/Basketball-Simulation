import java.util.Arrays;
import java.util.Random;

public class Player implements Moving,Distance,PlayerActions{

	Random rand = new Random();
	private int twoPointsThrow=rand.nextInt(10);
	private int threePointsThorw=rand.nextInt(10);
	private int pass=rand.nextInt(10);
	private int steal=rand.nextInt(10);
	private int rebound=rand.nextInt(10);
	private int xPosition;
	private int yPosition;
	private boolean hasBall=false;
	
	
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
	
	@Override
	public void moving() {
		
		if((this.yPosition>2 && this.yPosition<39) && (this.xPosition>2 && this.yPosition<29))
		 {
			this.yPosition+=rand.nextInt(2);
			this.xPosition+=rand.nextInt(2);
		 }
		 else if (this.yPosition<=2)
		 {
			 this.yPosition+=4;
		 }
		 else if(this.yPosition>=39)
		 {
			 this.yPosition-=4;
		 }
		 else if (this.xPosition<=2)
		 {
			 this.xPosition+=4;
		 }
		 else if(this.xPosition>=29)
		 {
			 this.xPosition-=4;
		 }
		
	}
	@Override
	public int distanceFromPlayer(Player p) {
		
		return Math.abs(this.xPosition-p.getxPosition()+Math.abs(this.yPosition-p.getyPosition()));
	}
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
	@Override
	public int chceckPosition(Court c) {
		
		if(c.coordinates[this.yPosition][this.xPosition]==1)
		{
			return 1;
		}
		else 
			return 0;
	}
	@Override
	public void readyToThrow(Team t, OpponnentTeam o, Court c, Ball b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void throwBall(Team t, Opponnent o, Court c, Ball b) {
		// TODO Auto-generated method stub
		
	}
}
