import java.util.Random;

public class Opponnent extends Player implements Moving{
	
	Random rand = new Random();
	private int twoPointsThrow=rand.nextInt(10);
	private int threePointsThorw=rand.nextInt(10);
	private int pass=rand.nextInt(10);
	private int steal=rand.nextInt(10);
	private int rebound=rand.nextInt(10);
	private int xPosition;
	private int yPosition;
	private boolean hasBall=false;
	
	public void moving()
	{
		if((this.yPosition>2 && this.yPosition<39) && (this.xPosition>2 && this.yPosition<29))
		 {
			this.yPosition-=rand.nextInt(2);
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
