import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	int scoreT1, scoreT2;
	int scoreP1T1, scoreP2T1, scoreP3T1, scoreP4T1, scoreP5T1, scoreP1T2, scoreP2T2, scoreP3T2, scoreP4T2, scoreP5T2;
	
	
	
	
	
	public GameDisplay(int scoreT1, int scoreT2 ,int scoreP1T1, int scoreP2T1, int scoreP3T1,
			int scoreP4T1, int scoreP5T1, int scoreP1T2, int scoreP2T2,int scoreP3T2,int scoreP4T2, int scoreP5T2) {
		
		this.scoreT1=scoreT1;
		this.scoreT2=scoreT2;
		this.scoreP1T1=scoreP1T1;
		this.scoreP2T1=scoreP2T1;
		this.scoreP3T1=scoreP3T1;
		this.scoreP4T1=scoreP4T1;
		this.scoreP5T1=scoreP5T1;
		this.scoreP1T2=scoreP1T2;
		this.scoreP2T2=scoreP2T2;
		this.scoreP3T2=scoreP3T2;
		this.scoreP4T2=scoreP4T2;
		this.scoreP5T2=scoreP5T2;


		frame.setBounds(100,100,800,600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		
		p1t1 = new PlayerLabel("Player 1: "+scoreP1T1);
		p2t1 = new PlayerLabel("Player 2: "+scoreP2T1);
		p3t1 = new PlayerLabel("Player 3: "+scoreP3T1);
		p4t1 = new PlayerLabel("Player 4: "+scoreP4T1);
		p5t1 = new PlayerLabel("Player 5: "+scoreP5T1);
		
		p1t2 = new PlayerLabel("Player 1: "+scoreP1T2);
		p2t2 = new PlayerLabel("Player 2: "+scoreP2T2);
		p3t2 = new PlayerLabel("Player 3: "+scoreP3T2);
		p4t2 = new PlayerLabel("Player 4: "+scoreP4T2);
		p5t2 = new PlayerLabel("Player 5: "+scoreP5T2);
		
		team1.setFont(new FontUIResource("Arial",Font.BOLD , 30));
		team1.setForeground(Color.YELLOW);
		
		team2.setFont(new FontUIResource("Arial",Font.BOLD , 30));
		team2.setForeground(Color.YELLOW);
		
		scoreLabel.setFont(new FontUIResource("Arial",Font.BOLD , 40));
		scoreLabel.setForeground(Color.YELLOW);
		
		score = new JLabel(scoreT1+":"+scoreT1);
		score.setFont(new FontUIResource("Arial",Font.BOLD , 70));
		score.setForeground(Color.white);
		
		scoreLabel.setBounds(320, 20, 200, 50);
		score.setBounds(340, 70, 120, 80);
		
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
			
		}
		
	}

}
