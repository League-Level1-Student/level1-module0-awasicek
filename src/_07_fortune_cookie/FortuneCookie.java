package _07_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Goal: Make a Swing program from scratch.
// The program will have a window (frame) with a button that gives one of five random fortunes when clicked.

public class FortuneCookie implements ActionListener {
	private JFrame frame = new JFrame();
	private JButton button = new JButton("Show Fortune");
	
	public void run() {
		showButton();
	}
	
	public void showButton() {
		frame.setVisible(true);
		frame.add(button);
		frame.pack();
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rand = new Random().nextInt(5);
		String fortune;

		switch(rand) {
			case 0:
				fortune = "A beautiful, smart, and loving person will be coming into your life.";
				break;
			case 1:
				fortune = "A dubious friend may be an enemy in camouflage.";
				break;
			case 2:
				fortune = "A faithful friend is a strong defense.";
				break;
			case 3:
				fortune = "A fresh start will put you on your way.";
				break;
			case 4:
				fortune = "A friend asks only for your time not your money.";
				break;
			default:
				fortune = "Oops, that was unexpected. Something went wrong.";
		}
		
		JOptionPane.showMessageDialog(null, fortune);
	}
}
