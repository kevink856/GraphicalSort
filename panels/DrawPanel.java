package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import main.Main;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public DrawPanel() {
		setPreferredSize(new Dimension(800,800));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(int i=0; i<Main.barCount; i++) {

			if(Main.currentBar == i) {
				g.setColor(Color.BLUE);
			} else if(Main.lastBar == i || Main.ghostBar == i) {
				g.setColor(Color.CYAN);
			} else {
				g.setColor(Color.WHITE);
			}
			g.fillRect(Main.barWidth*i, 751-Main.barHeights[i], Main.barWidth, Main.barHeights[i]);

		}
	}

}