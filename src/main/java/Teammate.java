

public class Teammate extends Player{

	
	public Teammate()
	{
		super(rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),false);
		
	}
	/**
	 * Zmiany po³o¿enia zawodnika poprzez zmiany jego wspo³rzêdnych x i y

	 */
	
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
	/**
	 * Sprawdzanie czy zawodnik przekroczy³ po³owê boiska ¿eby móg³ wykonaæ rzut,
	 * jeœli nie dalsze poruszanie, podania
	 *	
	 */

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
		
	/**
	 * Metoda odpowiedzialna za rzut pi³k¹ sprawdza czy umiejêtnoœci 
	 * rzutu zawodnika i dolosowuje wspó³czynnik losowy. <br>
	 * Jeœli suma tych obu wartoœci jest wiêksza 10 to dru¿yna zdobywa punkty i nastêpuje ponowne rozmieszczenie zawodników na boisku, jeœli nie uruchamiana jest metoda zbiórki.
	 * 
	 *  
	 */

	@Override
	public void throwBall(Team t, Team o, Court c, Ball b) {
		if(checkPosition(c)==1)
		{
			if(getTwoPointsThrow() + rand.nextInt(15)>10)
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
			if(getThreePointsThorw()+rand.nextInt(5)>10)
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
