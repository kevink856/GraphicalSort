package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TitlePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public TitlePanel() {
		setPreferredSize(new Dimension(800,800));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.BOLD, 150));
		g.drawString("Sorting", 155, 300);
		g.drawString("Simulator", 75, 450);

		g.setFont(new Font("Impact", Font.PLAIN, 50));
		g.drawString("By: Kevin Kim", 260, 600);
	}
	
}