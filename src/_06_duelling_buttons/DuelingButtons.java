package _06_duelling_buttons;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DuelingButtons implements ActionListener {

	private JButton leftButton = new JButton();
	private JButton rightButton = new JButton();

	private Dimension BIG = new Dimension(400, 400);
	private Dimension SMALL = new Dimension(200, 200);

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();

	public void run() {

		// 1. Add the panel to the frame
		frame.add(panel);

		// 2. Make the frame visible
		frame.setVisible(true);

		// 3. Set the text of the leftButton to "Click me!"
		leftButton.setText("Click me!");

		// 4. Set the text of the rightButton to "Click me!"
		rightButton.setText("Click me!");

		// 5. Add an action listener to the leftButton
		leftButton.addActionListener(this);

		// 6. Add an action listener to the rightButton
		rightButton.addActionListener(this);

		// 7. Add the leftButton to the panel
		panel.add(leftButton);

		// 8. Add the rightButton to the panel
		panel.add(rightButton);

		// 9. Pack the frame
		frame.pack();

		// 10. Set the title of the frame to "Demanding Buttons"
		frame.setTitle("Demanding Buttons v1.0");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();

		/* If the buttonPressed was the leftButton.... */
		if (buttonPressed == leftButton) {
			// Set the text of the rightButton to "No, click Me!"
			// Set the PREFERRED size of the rightButton to BIG
			// Set the text of the leftButton to "Click Me!"
			// Set the PREFERRED size of the leftButton to SMALL
			rightButton.setText("No, click ME!");
			rightButton.setPreferredSize(BIG);
			leftButton.setText("Click me!");
			leftButton.setPreferredSize(SMALL);
		} else if (buttonPressed == rightButton) {
			/* If the buttonPressed was the rightButton, do the opposite. */
			leftButton.setText("No, click ME!");
			leftButton.setPreferredSize(BIG);
			rightButton.setText("Click me!");
			rightButton.setPreferredSize(SMALL);
		}
		
		frame.pack();
	}
}
