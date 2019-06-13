import java.util.Timer;
import java.util.TimerTask;

public class Game {
	
	public static void main(String[] args) {
		
		Team t = new FirstTeam();
		Team o  = new OpponnentTeam();
		Ball b = new Ball();
		Court c = new Court();
		t.spawn();
		o.spawn();
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		
			@Override
			public void run() {
				
				o.p1.readyToThrow(t, o, c, b);
				o.p2.readyToThrow(t, o, c, b);
				o.p3.readyToThrow(t, o, c, b);
				o.p4.readyToThrow(t, o, c, b);
				o.p5.readyToThrow(t, o, c, b);
				
				t.p1.readyToThrow(t, o, c, b);
				t.p2.readyToThrow(t, o, c, b);
				t.p3.readyToThrow(t, o, c, b);
				t.p4.readyToThrow(t, o, c, b);
				t.p5.readyToThrow(t, o, c, b);
				
				
				


				
				
				System.out.println("Team 1 :" + t.getScore());
				System.out.println("Player 1:" + t.p1.isHasBall()+"   "+ t.p1.getyPosition());
				System.out.println("Player 2:" + t.p2.isHasBall()+"   "+ t.p2.getyPosition());
				System.out.println("Player 3:" + t.p3.isHasBall()+"   "+ t.p3.getyPosition());
				System.out.println("Player 4:" + t.p4.isHasBall()+"   "+ t.p4.getyPosition());
				System.out.println("Player 5:" + t.p5.isHasBall()+"   "+ t.p5.getyPosition());

				System.out.println("Team 2 :"+o.getScore());
				System.out.println("Player 1:" + o.p1.isHasBall()+"   "+ o.p1.getyPosition());
				System.out.println("Player 2:" + o.p2.isHasBall()+"   "+ o.p2.getyPosition());
				System.out.println("Player 3:" + o.p3.isHasBall()+"   "+ o.p3.getyPosition());
				System.out.println("Player 4:" + o.p4.isHasBall()+"   "+ o.p4.getyPosition());
				System.out.println("Player 5:" + o.p5.isHasBall()+"   "+ o.p5.getyPosition());
				
				
				
				
				
			}
			
		};
		
		timer.scheduleAtFixedRate(task, 0,1000);

	}
}

		
		
		
		