

public class FirstTeam extends Team{

	public FirstTeam()
	{
		p1=new Teammate();
		p2=new Teammate();
		p3=new Teammate();
		p4=new Teammate();
		p5=new Teammate();

	}
	/**
	 * 
	 */
	
	@Override
	public void spawn() {
		
		p1.setxPosition(rand.nextInt(25));
		p2.setxPosition(rand.nextInt(25));
		p3.setxPosition(rand.nextInt(25));
		p4.setxPosition(rand.nextInt(25));
		p5.setxPosition(rand.nextInt(25));
		
		p1.setyPosition(rand.nextInt(20));
		p2.setyPosition(rand.nextInt(20));
		p3.setyPosition(rand.nextInt(20));
		p4.setyPosition(rand.nextInt(20));
		p5.setyPosition(rand.nextInt(20));
		
	}

}
