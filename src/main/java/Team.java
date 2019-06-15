import java.util.Random;

public abstract class Team {
	private int score=0;
	
	
	Player p1;
	Player p2;
	Player p3;
	Player p4;
	Player p5;
	
	Random rand = new Random();
	
	/**
	 * Rozmieszczenie zawodników na boisku poprzez przydzielenie im losowych wspó³rzêdnych
	 */
	public abstract void spawn();
	
	/**
	 * Rozmieszczenie zawodników na boisku
	 * i przydzielenie wartoœci false do posiadania pi³ki 
	 */
	public void newWinAction()
	{
		spawn();
		p1.setHasBall(false);
		p2.setHasBall(false);
		p3.setHasBall(false);
		p4.setHasBall(false);
		p5.setHasBall(false);
	}
	/**
	 * Rozmieszczenie zawodników na boisku
	 * i przydzielenie pi³ki pierwszemu zawodnikowi
	 */
	public void newLooseAction()
	{
		spawn();
		p1.setHasBall(true);
		p2.setHasBall(false);
		p3.setHasBall(false);
		p4.setHasBall(false);
		p5.setHasBall(false);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
}
