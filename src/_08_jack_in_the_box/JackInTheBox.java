package _08_jack_in_the_box;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JackInTheBox {
	final String IMAGE_FILE_NAME = "jackInTheBox.png";
	final String SOUND_FILE_NAME = "homer-woohoo.wav";
	final int SURPRISE_THRESHOLD_NUM = 5;
	
	int timesClicked = 0;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Surprise");
	
	public void run() {
		frame.add(panel);
		panel.add(button);
		
		button.addActionListener(new AbstractAction() { // AbstractAction implements ActionListener 

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton buttonClicked = (JButton) e.getSource();
				if(buttonClicked == button) {
					timesClicked++;
					if (timesClicked >= SURPRISE_THRESHOLD_NUM) {
						showPicture(IMAGE_FILE_NAME);
						playSound(SOUND_FILE_NAME);
					}
				}
				
				
			}
			
		});
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void showPicture(String fileName) {
	     try {
	          JLabel imageLabel = createLabelImage(fileName);
	          JFrame frame = new JFrame();
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private JLabel createLabelImage(String fileName) {
	     try {
	          URL imageURL = getClass().getResource(fileName);
	          if (imageURL == null) {
	               System.err.println("Could not find image " + fileName);
	               return new JLabel();
	          } else {
	               Icon icon = new ImageIcon(imageURL);
	               JLabel imageLabel = new JLabel(icon);
	               return imageLabel;
	          }
	     } catch (Exception e) {
	          System.err.println("Could not find image " + fileName);
	          return new JLabel();
	     }
	}
	
	private void playSound(String soundFile) {
	     try {
	          AudioClip sound = JApplet.newAudioClip(getClass().getResource(soundFile));
	          sound.play();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
}
