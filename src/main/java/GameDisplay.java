import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class GameDisplay extends JFrame implements ActionListener{
	
	
	JFrame frame = new JFrame();
	JLabel team1 = new JLabel("TEAM 1");
	JLabel team2 = new JLabel("TEAM 2");
	
	PlayerLabel p1t1,p2t1,p3t1,p4t1,p5t1,p1t2,p2t2,p3t2,p4t2,p5t2;
	

	JLabel scoreLabel = new JLabel("SCORE");
	JLabel score;
	JButton start;
	
	JPanel panelTeam1 = new JPanel();
	JPanel panelTeam2 = new JPanel();
	
	
	Team t;
	Team o;
	Ball b;
	Court c;
	Timer timer;
	
	
	
	public GameDisplay() {
		
		 t = new FirstTeam();
		 o  = new OpponnentTeam();
		 b = new Ball();
		 c = new Court();
		t.spawn();
		o.spawn();
		
		timer = new Timer();


		frame.setBounds(100,100,800,600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		
		p1t1 = new PlayerLabel("Player 1: ");
		p2t1 = new PlayerLabel("Player 2: ");
		p3t1 = new PlayerLabel("Player 3: ");
		p4t1 = new PlayerLabel("Player 4: ");
		p5t1 = new PlayerLabel("Player 5: ");
		
		p1t2 = new PlayerLabel("Player 1: ");
		p2t2 = new PlayerLabel("Player 2: ");
		p3t2 = new PlayerLabel("Player 3: ");
		p4t2 = new PlayerLabel("Player 4: ");
		p5t2 = new PlayerLabel("Player 5: ");
		
		team1.setFont(new FontUIResource("Arial",Font.BOLD , 30));
		team1.setForeground(Color.YELLOW);
		
		team2.setFont(new FontUIResource("Arial",Font.BOLD , 30));
		team2.setForeground(Color.YELLOW);
		
		scoreLabel.setFont(new FontUIResource("Arial",Font.BOLD , 40));
		scoreLabel.setForeground(Color.YELLOW);
		
		score = new JLabel(t.getScore()+":"+o.getScore());
		score.setFont(new FontUIResource("Arial",Font.BOLD , 70));
		score.setForeground(Color.white);
		
		scoreLabel.setBounds(320, 20, 200, 50);
		score.setBounds(340, 70, 200, 80);
		
		panelTeam1.setBackground(Color.black);
		panelTeam1.setBounds(140,160,200,600);
		panelTeam1.setLayout(new BoxLayout(panelTeam1, BoxLayout.Y_AXIS));
		panelTeam1.add(team1);
		panelTeam1.add(Box.createVerticalStrut(20));
		panelTeam1.add(p1t1);
		panelTeam1.add(Box.createVerticalStrut(10));
		panelTeam1.add(p2t1);
		panelTeam1.add(Box.createVerticalStrut(10));
		panelTeam1.add(p3t1);
		panelTeam1.add(Box.createVerticalStrut(10));
		panelTeam1.add(p4t1);
		panelTeam1.add(Box.createVerticalStrut(10));
		panelTeam1.add(p5t1);
		
		panelTeam2.setBackground(Color.black);
		panelTeam2.setBounds(500,160,200,600);
		panelTeam2.setLayout(new BoxLayout(panelTeam2, BoxLayout.Y_AXIS));
		panelTeam2.add(team2);
		panelTeam2.add(Box.createVerticalStrut(20));
		panelTeam2.add(p1t2);
		panelTeam2.add(Box.createVerticalStrut(10));
		panelTeam2.add(p2t2);
		panelTeam2.add(Box.createVerticalStrut(10));
		panelTeam2.add(p3t2);
		panelTeam2.add(Box.createVerticalStrut(10));
		panelTeam2.add(p4t2);
		panelTeam2.add(Box.createVerticalStrut(10));
		panelTeam2.add(p5t2);
	
		start = new JButton("START");
		start.setBounds(333, 450, 100, 50);
		start.setBackground(Color.yellow);
		start.setForeground(Color.black);
		start.addActionListener(this);
		
		frame.add(panelTeam1);
		frame.add(panelTeam2);
		frame.add(scoreLabel);
		frame.add(score);
		frame.add(start);
		
		
		
		frame.setVisible(true);
		
		
		
	}
	
	public void labelCreator (JLabel label ,String name)
	{
		label = new JLabel(name);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if(source.equals(start))
		{
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
					
					score.setText(t.getScore()+":"+o.getScore());
					p1t1.setText("Player 1: "+t.p1.getPts());
					p2t1.setText("Player 2: "+t.p2.getPts());
					p3t1.setText("Player 3: "+t.p3.getPts());
					p4t1.setText("Player 4: "+t.p4.getPts());
					p5t1.setText("Player 5: "+t.p5.getPts());
					
					p1t2.setText("Player 1: "+o.p1.getPts());
					p2t2.setText("Player 2: "+o.p2.getPts());
					p3t2.setText("Player 3: "+o.p3.getPts());
					p4t2.setText("Player 4: "+o.p4.getPts());
					p5t2.setText("Player 5: "+o.p5.getPts());
					

			
		}
		
	};
	timer.scheduleAtFixedRate(task, 0,500);


}
	}
}
