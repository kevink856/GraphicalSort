package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sorts.BubbleSort;
import sorts.SelectionSort;
import sorts.InsertionSort;
import sorts.MergeSort;
import sorts.QuickSort;

public class Gui {

	private JPanel drawPanel;

	public Gui(JPanel drawPanel) {
		this.drawPanel = drawPanel;
	}

	public void makeGui(JFrame guiFrame, JFrame settingsFrame, JFrame errorsFrame, List sortList, JPanel guiPanel, JPanel titlePanel) {

		guiFrame.setVisible(true);
		guiFrame.setSize(800, 800);
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setResizable(false);
	
		JButton button1 = new JButton("Run");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if(sortList.getSelectedItem() == null) {
	
					errorsFrame.setVisible(true);
	
				} else {
	
					switch(sortList.getSelectedItem()) {
	
					case("Bubble Sort"):
						new BubbleSort().sort(drawPanel);
						break;
					case("Selection Sort"):
						new SelectionSort().sort(drawPanel);
						break;
					case("Insertion Sort"):
						new InsertionSort().sort(drawPanel);
						break;
					case("Merge Sort"):
						new MergeSort().sort(drawPanel);
						break;
					case("Quick Sort"):
						new QuickSort().sort(drawPanel);
						break;
					}
	
				}
	
			}
		} );
	
		JButton button2 = new JButton("Settings");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				settingsFrame.setVisible(true);
				sortList.select(0);
	
			}
		} );
	
		guiPanel.setBackground(Color.CYAN);
		guiPanel.add(button1);
		guiPanel.add(button2);
	
		titlePanel.setBackground(Color.BLACK);
		drawPanel.setBackground(Color.BLACK);
	
		guiFrame.add(titlePanel);
		guiFrame.add(guiPanel, BorderLayout.NORTH);

	}
	
}
