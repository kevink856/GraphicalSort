package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.SplittableRandom;
import java.awt.List;
import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import main.Main;

public class Settings {

	private JSpinner sortSpinner;
	private JFrame settingsFrame;

	public Settings(JSpinner sortSpinner, JFrame settingsFrame) {

		this.sortSpinner = sortSpinner;
		this.settingsFrame = settingsFrame;

	}

	public void makeSettings(JFrame guiFrame, List sortList, JPanel guiPanel, JPanel titlePanel, JPanel drawPanel) {

		settingsFrame.setVisible(false);
		settingsFrame.setSize(400, 400);
		settingsFrame.setLocationRelativeTo(null);
		settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		settingsFrame.setResizable(false);

		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				drawBars(sortSpinner, drawPanel);
				settingsFrame.dispose();
				guiFrame.remove(titlePanel);
				guiFrame.add(drawPanel);
				guiFrame.validate();

			}
		} );

		JPanel smallPanel = new JPanel();
		smallPanel.add(button);

		sortList.add("Bubble Sort");
		sortList.add("Selection Sort");
		sortList.add("Insertion Sort");
		sortList.add("Merge Sort");
		sortList.add("Quick Sort");

		JLabel titleLabel = new JLabel("Sorting Algorithm");
		JLabel descrLabel = new JLabel("Number of Values (10-800)");

		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(titleLabel)
				.addComponent(sortList))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(descrLabel)
				.addComponent(sortSpinner))
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(titleLabel)
				.addComponent(descrLabel))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(sortList)
				.addComponent(sortSpinner))
		);

		settingsFrame.add(panel);
		settingsFrame.add(smallPanel, BorderLayout.SOUTH);

	}

	private static void drawBars(JSpinner sortSpinner, JPanel drawPanel) {

		SplittableRandom rand = new SplittableRandom();

		Main.barCount = (Integer) sortSpinner.getValue();
		Main.barWidth = 800 / Main.barCount;
		Main.barHeights = new int[Main.barCount];

		for(int i=0; i<Main.barCount; i++) {
			Main.barHeights[i] = rand.nextInt(1, 751);
		}

    	drawPanel.repaint();

	}

}
