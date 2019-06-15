

public class Opponnent extends Player {
	
	
	public Opponnent() {
		super(rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),rand.nextInt(10),false);
		
	}

	/**
	 * Zmiany po³o¿enia zawodnika poprzez zmiany jego wspo³rzêdnych x i y

	 */
	
	@Override
	public void moving()
	{
		
		if((getyPosition()>1 && getyPosition()<40) && (getxPosition()>1 && getxPosition()<29))
		 {	
			
			setyPosition(getyPosition() - rand.nextInt(2));
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
	 * Metoda odpowiedzialna za rzut pi³k¹ sprawdza czy umiejêtnoœci 
	 * rzutu zawodnika i dolosowuje wspó³czynnik losowy. <br>
	 * Jeœli suma tych obu wartoœci jest wiêksza 10 to dru¿yna zdobywa punkty i nastêpuje ponowne rozmieszczenie zawodników na boisku, jeœli nie uruchamiana jest metoda zbiórki.
	 * 
	 *  
	 */
	
	@Override
	public void throwBall(Team t, Team o, Court c, Ball b) {
	
		if(this.checkPosition(c)==1)
		{
			if(this.getTwoPointsThrow() + rand.nextInt(15)>10)
			{
				o.setScore(o.getScore()+2);
				this.setPts(getPts()+2);
				o.newWinAction();
				t.newLooseAction();
			}
			else
			{
				b.rebound(t,this);
			}
		}
		else if(this.checkPosition(c)==0) 
		{
			if(this.getThreePointsThorw()+rand.nextInt(5)>10)
			{
				o.setScore(o.getScore()+3);
				this.setPts(getPts()+3);
				o.newWinAction();
				t.newLooseAction();
			}
			else
			{
				b.rebound(t,this);
			}
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
		if(this.getyPosition()<20)
		{
			if(this.isHasBall())
			{
				this.throwBall(t, o, c, b);
				
			}
			else
			{
				this.moving();
				b.reclaimBall(t, o);
			}
			
		}
			this.moving();
		
	}

}
