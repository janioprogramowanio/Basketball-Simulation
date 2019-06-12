
public class Game {
	
	public static void main(String[] args) {
		
		OpponnentTeam o = new OpponnentTeam();
		Ball b = new Ball();
		
		o.p3.setHasBall(true);
		b.passBall(o);
		
	}
}
