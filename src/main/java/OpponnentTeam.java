

public class OpponnentTeam extends Team{
	
	private int score=0;

	
	
	public OpponnentTeam() {
		p1= new Opponnent();
		p2= new Opponnent();
		p3= new Opponnent();
		p4= new Opponnent();
		p5= new Opponnent();
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
			
			p1.setyPosition(rand.nextInt(20)+20);
			p2.setyPosition(rand.nextInt(20)+20);
			p3.setyPosition(rand.nextInt(20)+20);
			p4.setyPosition(rand.nextInt(20)+20);
			p5.setyPosition(rand.nextInt(20)+20);
		
	}

	

	

	
}
