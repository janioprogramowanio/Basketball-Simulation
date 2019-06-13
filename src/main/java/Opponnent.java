import java.util.Random;

public class Opponnent extends Player {
	
	Random rand = new Random();
	private int twoPointsThrow=rand.nextInt(10);
	private int threePointsThorw=rand.nextInt(10);
	private int pass=rand.nextInt(10);
	private int steal=rand.nextInt(10);
	private int rebound=rand.nextInt(10);
	private int xPosition;
	private int yPosition;
	private boolean hasBall=false;
	
	@Override
	public void moving()
	{
		if((this.yPosition>2 && yPosition<39) && (xPosition>2 && yPosition<29))
		 {
			yPosition-=rand.nextInt(2);
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
	public void throwBall(Team t, OpponnentTeam o, Court c, Ball b) {
	
		if(checkPosition(c)==1)
		{
			if(twoPointsThrow + rand.nextInt(6)>10)
			{
				o.setScore(o.getScore()+2);
				o.newWinAction();
				t.newLooseAction();
			}
			else
			{
				b.rebound(t,this);
			}
		}
		else if(checkPosition(c)==0) 
		{
			if(threePointsThorw+rand.nextInt(6)>10)
			{
				o.setScore(o.getScore()+3);
				o.newWinAction();
				t.newLooseAction();
			}
			else
			{
				b.rebound(t,this);
			}
		}


	}
	
	@Override
	public void readyToThrow(Team t, OpponnentTeam o, Court c, Ball b) {
		
		moving();
		if(yPosition<20)
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
