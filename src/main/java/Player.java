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
		
		if((yPosition>2 && yPosition<39) && (xPosition>2 && yPosition<29))
		 {
			yPosition+=rand.nextInt(2);
			xPosition+=rand.nextInt(2)-1;
		 }
		  if (yPosition<=2)
		 {
			 yPosition+=4;
		 }
		  if(yPosition>=39)
		 {
			 yPosition-=4;
		 }
		  if (xPosition<=2)
		 {
			 xPosition+=4;
		 }
		  if(xPosition>=29)
		 {
			 xPosition-=4;
		 }
		
	}
	@Override
	public int distanceFromPlayer(Player p) {
		
		return Math.abs(xPosition-p.getxPosition()+Math.abs(yPosition-p.getyPosition()));
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
	public int checkPosition(Court c) {
		
		if(c.coordinates[yPosition][xPosition]==1)
		{
			return 1;
		}
		else 
			return 0;
	}
	
	@Override
	public void throwBall(Team t, OpponnentTeam o, Court c, Ball b) {
		
		if(checkPosition(c)==1)
		{
			if(twoPointsThrow + rand.nextInt(6)>10)
			{
				t.setScore(t.getScore()+2);
				t.newWinAction();
				o.newLooseAction();
			}
			else
			{
				b.rebound(o,this);
			}
		}
		else if(checkPosition(c)==0) 
		{
			if(threePointsThorw+rand.nextInt(6)>10)
			{
				t.setScore(t.getScore()+3);
				t.newWinAction();
				o.newLooseAction();
			}
			else
			{
				b.rebound(o,this);
			}
		}
		
		
	}
	@Override
	public void readyToThrow(Team t, OpponnentTeam o, Court c, Ball b) {
		
		moving();
		if(yPosition>20)
		{
			if(hasBall)
			{
				throwBall(t, o, c, b);
			}
			else
			{
				moving();
				b.reclaimBall(t, o);
			}
			
		}
		
	}
}
