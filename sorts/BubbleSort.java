package sorts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import main.Main;

public class BubbleSort implements Sort {

	private Timer timer;

	@Override
	public void sort(JPanel drawPanel) {

		timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	if(Main.sorti == Main.barCount - 1) {

            		if(Main.sortj == Main.barCount - 1) {

            			Main.currentBar = -1;
                		Main.ghostBar = -1;
                		Main.lastBar = -1;
						Main.sorti = 0;
						Main.sortj = 0;
                		drawPanel.repaint();
                		timer.stop();

            		} else {

            			Main.ghostBar = Main.currentBar;
            			Main.currentBar = Main.sortj + 1;
            			drawPanel.repaint();
            			Main.sortj++;

            		}

            	} else {

            		if(Main.sortj == Main.barCount - Main.sorti - 1) {

            			Main.lastBar = Main.barCount - Main.sorti - 1;
            			Main.sortj = 0;
            			Main.sorti++;

            		} else {

            			Main.ghostBar = Main.currentBar;
            			Main.currentBar = Main.sortj + 1;

            			if(Main.barHeights[Main.sortj] > Main.barHeights[Main.sortj + 1]) {

        					int temp = Main.barHeights[Main.sortj];
        					Main.barHeights[Main.sortj] = Main.barHeights[Main.sortj + 1];
        					Main.barHeights[Main.sortj + 1] = temp;

        				}
						
            			drawPanel.repaint();
            			Main.sortj++;

            		}

            	}
            	
            }
        });
        timer.start();

	}

}