package sorts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import main.Main;

public class BubbleSort implements Sort {

	private Timer timer;
	private int i, j;

	public BubbleSort() {

		this.i = 0;
		this.j = 0;

	}

	@Override
	public void sort(JPanel drawPanel) {

		timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	if(i == Main.barCount - 1) {

            		if(j == Main.barCount - 1) {

            			Main.currentBar = -1;
                		Main.ghostBar = -1;
                		Main.lastBar = -1;
						i = 0;
						j = 0;
                		drawPanel.repaint();
                		timer.stop();

            		} else {

            			Main.ghostBar = Main.currentBar;
            			Main.currentBar = j + 1;
            			drawPanel.repaint();
            			j++;

            		}

            	} else {

            		if(j == Main.barCount - i - 1) {

            			Main.lastBar = Main.barCount - i - 1;
            			j = 0;
            			i++;

            		} else {

            			Main.ghostBar = Main.currentBar;
            			Main.currentBar = j + 1;

            			if(Main.barHeights[j] > Main.barHeights[j + 1]) {

        					int temp = Main.barHeights[j];
        					Main.barHeights[j] = Main.barHeights[j + 1];
        					Main.barHeights[j + 1] = temp;

        				}
						
            			drawPanel.repaint();
            			j++;

            		}

            	}
            	
            }
        });
        timer.start();

	}

}