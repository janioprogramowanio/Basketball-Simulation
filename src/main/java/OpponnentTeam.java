import java.util.Random;

public class OpponnentTeam extends Team{
	
	private int score=0;
	Random rand = new Random();
	
	
	public OpponnentTeam() {
		super.p1= new Opponnent();
		super.p2= new Opponnent();
		super.p3= new Opponnent();
		super.p4= new Opponnent();
		super.p5= new Opponnent();
	}


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
