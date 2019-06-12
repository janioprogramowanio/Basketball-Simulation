import java.util.Random;

public class Player implements Moving{

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
}
