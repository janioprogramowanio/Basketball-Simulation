
public class OpponnentTeam extends Team{
	
	private int score=0;
	
	
	

	@Override
	public void spawn()
	{
		p1.setxPosition(rand.nextInt(25));
		p2.setxPosition(rand.nextInt(25));
		p3.setxPosition(rand.nextInt(25));
		p4.setxPosition(rand.nextInt(25));
		p5.setxPosition(rand.nextInt(25));
		
		p1.setyPosition(rand.nextInt(20)+20);
		p2.setyPosition(rand.nextInt(20)+20);
		p3.setyPosition(rand.nextInt(20)+20);
		p4.setyPosition(rand.nextInt(20)+20);
		p5.setyPosition(rand.nextInt(20)+20);
	}

}
