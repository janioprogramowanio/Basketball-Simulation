import java.util.Random;

public class Teammate extends Player{

	static Random rand = new Random();
	
	public Teammate()
	{
		super(rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),false);
		
	}
	
	@Override
	public void moving() {
		
		if((getyPosition()>1 && getyPosition()<40) && (getxPosition()>1 && getxPosition()<29))
		 {
			setyPosition(getyPosition() + rand.nextInt(2));
			setxPosition(getxPosition() + rand.nextInt(2)-1);
		 }
		  if (getyPosition()<=1)
		 {
			 setyPosition(getyPosition() + 4);
		 }
		  if(getyPosition()>=40)
		 {
			 setyPosition(getyPosition() - 4);
		 }
		  if (getxPosition()<=1)
		 {
			 setxPosition(getxPosition() + 4);
		 }
		  if(getxPosition()>=29)
		 {
			 setxPosition(getxPosition() - 4);
		 }
		
	}

	@Override
	public void readyToThrow(Team t, Team o, Court c, Ball b) {
		
		this.moving();
		if(getyPosition()>20)
		{
			if(isHasBall())
			{
				throwBall(t, o, c, b);
			}
			else
			{
				moving();
				b.reclaimBall(t, o);
			}
			
		}
		this.moving();
		
	}
		
	

	@Override
	public void throwBall(Team t, Team o, Court c, Ball b) {
		if(checkPosition(c)==1)
		{
			if(getTwoPointsThrow() + rand.nextInt(6)>10)
			{
				t.setScore(t.getScore()+2);
				this.setPts(getPts()+2);
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
			if(getThreePointsThorw()+rand.nextInt(6)>10)
			{
				t.setScore(t.getScore()+3);
				this.setPts(getPts()+3);
				t.newWinAction();
				o.newLooseAction();
			}
			else
			{
				b.rebound(o,this);
			}
		}
		
	}

}
