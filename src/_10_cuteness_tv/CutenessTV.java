package _10_cuteness_tv;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//1. Make a user interface with 3 buttons that will play different videos depending on which button is clicked.
//If you need help, take a look at the instructions for the Fortune Cookie recipe.

public class CutenessTV implements MouseListener {
	// 1. Make a user interface with 3 buttons that will play different videos depending on which button is clicked.
	// If you need help, take a look at the instructions for the Fortune Cookie recipe.
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton duckButton = new JButton("Ducks");
	JButton frogButton = new JButton("Frogs");
	JButton unicornButton = new JButton("Unicorns");
	
	public void run() {
		frame.add(panel);
		panel.add(duckButton);
		panel.add(frogButton);
		panel.add(unicornButton);
		duckButton.addMouseListener(this);
		frogButton.addMouseListener(this);
		unicornButton.addMouseListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	// 2. Use the methods below to play the cutest videos ever.

	void showDucks() {
		playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}
	
	void showFrog() {
		playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}
	
	void showFluffyUnicorns() {
		playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}
	
	void playVideo(String videoID) {
		try {
		    URI uri = new URI(videoID);
		    java.awt.Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == frogButton) {
			showFrog();
		} else if (buttonPressed == unicornButton) {
			showFluffyUnicorns();
		} else if (buttonPressed == duckButton) {
			showDucks();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
