package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Errors {
	
	private JFrame errorsFrame;

	public Errors(JFrame errorsFrame) {

		this.errorsFrame = errorsFrame;

	}

	public void makeErrors() {

		errorsFrame.setVisible(false);
		errorsFrame.setSize(190, 200);
		errorsFrame.setLocationRelativeTo(null);
		errorsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		errorsFrame.setResizable(false);

		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				errorsFrame.dispose();

			}
		} );

		JPanel smallPanel = new JPanel();
		smallPanel.add(button);

		JLabel titleLabel = new JLabel("ERROR: Open Settings and");
		JLabel descrLabel = new JLabel("select a sorting algorithm");

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(titleLabel)
					.addComponent(descrLabel))
			);
			layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(titleLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(descrLabel))
			);

		errorsFrame.add(panel);
		errorsFrame.add(smallPanel, BorderLayout.SOUTH);
		
	}

}