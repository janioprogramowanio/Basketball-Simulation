import java.util.ArrayList;
import java.util.Random;

public class Ball implements BallActions{

		Random rand = new Random();
		
		/**
		 * Metoda odpowiedzialna za podawanie pi�ki mi�dzy zawodnikami. <br>
		 * Sprawdza czy zawodnik posiadza pi�k� p�zniej losuje zawodnka do kt�rego trafi podanie.
		 * 
		 */
	@Override
	public void passBall(Team t) {
		
		int randPlayer=rand.nextInt(5);
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(t.p1);
		playerList.add(t.p2);
		playerList.add(t.p3);
		playerList.add(t.p4);
		playerList.add(t.p5);
		
		playerList.get(checkBall(playerList)).setHasBall(false);
		if(randPlayer!=checkBall(playerList))
		{
			playerList.get(randPlayer).setHasBall(true);
		}
		else
		{
			randPlayer=rand.nextInt(5)+1;
		}
	
		
	}
	/**
	 * Metoda odpowiedzialna za odbi�r pi�ki.<br>
	 * Por�wnuje atrybuty podania zawodnika jednej dru�yny z atrybutami przechwytu zawododnika drugiej dru�yny i dolicza wsp�czynnik losowy. <br>
	 * W zale�no�ci od tego dzia�ania przypisuje pi�k� zawodnikowi o wi�kszej sumie tych atrybut�w.
	 */

	@Override
	public void reclaimBall(Team t, Team o) {
		
		int rand1=rand.nextInt(10);
		int rand2=rand.nextInt(10);
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(t.p1);
		playerList.add(t.p2);
		playerList.add(t.p3);
		playerList.add(t.p4);
		playerList.add(t.p5);
		playerList.add(o.p1);
		playerList.add(o.p2);
		playerList.add(o.p3);
		playerList.add(o.p4);
		playerList.add(o.p5);
		
		if(checkBall(playerList)<=4)
		{
			if(playerList.get(checkBall(playerList)).getPass()+rand1>
				playerList.get(checkBall(playerList)).nearestPlayer(o).getSteal()+rand2)
			{
				passBall(t);
			}
			else {
				playerList.get(checkBall(playerList)).setHasBall(false);	
				playerList.get(checkBall(playerList)).nearestPlayer(o).setHasBall(true);
				passBall(o);
			}
		}
		else
		{
			if(playerList.get(checkBall(playerList)).getPass()+rand1>
			playerList.get(checkBall(playerList)).nearestPlayer(t).getSteal()+rand2)
		{
			passBall(o);
		}
		else {
			playerList.get(checkBall(playerList)).setHasBall(false);	
			playerList.get(checkBall(playerList)).nearestPlayer(t).setHasBall(true);
			passBall(t);
		}
		}
		
		
	}
	/**
	 * Por�wnuje umiej�tono�ci zbi�rki dw�ch zawodnik�w i dolicza do nich wsp�czynnik losowy. <br>
	 * W zale�no�ci od wyniku przypisuje pi�k� zawodnikowi o wi�kszej sumie tych atruybut�w.
	 */
	
	@Override
	public void rebound(Team t , Player p) {
		if(p.getRebound()+rand.nextInt(10)>p.nearestPlayer(t).getRebound()+rand.nextInt(10))
		{
			p.nearestPlayer(t).setHasBall(false);
			p.setHasBall(true);
		

		}
		else
		{
			p.setHasBall(false);
			p.nearestPlayer(t).setHasBall(true);
		}
		
	}
	/**
	 * Sprawdza czy zawodnik jest w posiadaniu pi�ki
	 */

	@Override
	public int checkBall(ArrayList<Player> playerList) {
		
		for(int i=0 ;i<playerList.size() ;i++)
		{
			if(playerList.get(i).isHasBall())
			{
				return i;
			}
		}
		return 0;
	}

}
