import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

public class PlayerLabel extends JLabel{
	
	public PlayerLabel(String name) {
		
		setText(name);
		setFont(new FontUIResource("Arial",Font.BOLD , 20));
		setForeground(Color.WHITE);
		
	}

}
