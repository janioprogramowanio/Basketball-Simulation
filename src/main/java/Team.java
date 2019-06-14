import java.util.Random;

public abstract class Team {
	private int score=0;
	
	
	Player p1;
	Player p2;
	Player p3;
	Player p4;
	Player p5;
	
	Random rand = new Random();
	
	public abstract void spawn();
	
	
	public void newWinAction()
	{
		spawn();
		p1.setHasBall(false);
		p2.setHasBall(false);
		p3.setHasBall(false);
		p4.setHasBall(false);
		p5.setHasBall(false);
	}
	
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
