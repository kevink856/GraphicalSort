package sorts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import main.Main;
import panels.Gui;

public class InsertionSort implements Sort {

	private Timer timer;

	private int i, j, min;
	private boolean done;

	public SelectionSort() {

		this.i = 0;
		this.j = 0;
		this.min = 0;
		this.done = false;

	}

	@Override
	public void sort(JPanel drawPanel) {

		timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	if(i == Main.barCount - 1) {

					if(!done) {
						j = 0;
					}
            		if(j == Main.barCount - 1) {

            			Main.currentBar = -1;
                		Main.ghostBar = -1;
                		Main.lastBar = -1;
						i = 0;
						j = 0;
						min = 0;
						done = false;
                		drawPanel.repaint();
						Gui.runButton.setEnabled(true);
                		timer.stop();

            		} else {

						done = true;
            			Main.ghostBar = Main.currentBar;
            			Main.currentBar = j + 1;
            			drawPanel.repaint();
            			j++;

            		}

            	} else {

            		if(j == Main.barCount) {

						if(i != min) {

							int temp = Main.barHeights[i];
        					Main.barHeights[i] = Main.barHeights[min];
        					Main.barHeights[min] = temp;

						}

            			Main.lastBar = i;
            			i++;
						j = i;
						min = i;

            		} else {

            			Main.ghostBar = min;
            			Main.currentBar = j - 1;

            			if(Main.barHeights[j] < Main.barHeights[min]) {

							min = j;

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
