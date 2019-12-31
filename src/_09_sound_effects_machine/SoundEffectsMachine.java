package _09_sound_effects_machine;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffectsMachine implements ActionListener {
	private final String BUBBLE_SOUND_FILENAME = "bubbles.wav";
	private final String BONK_SOUND_FILENAME = "bonk.wav";
	private final String SMASH_SOUND_FILENAME = "smash.wav";
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JButton bubbleButton = new JButton("Bubbles");
	private JButton bonkButton = new JButton("Bonk");
	private JButton smashButton = new JButton("Smash");
	
	public void run() {
		frame.add(panel);
		panel.add(bubbleButton);
		panel.add(bonkButton);
		panel.add(smashButton);
		bubbleButton.addActionListener(this);
		bonkButton.addActionListener(this);
		smashButton.addActionListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void playSound(String fileName) {

	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName)); 

	    sound.play();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		
		if(buttonClicked == bubbleButton) {
			playSound(BUBBLE_SOUND_FILENAME);
			System.out.println("playing bubble noise");
		} else if (buttonClicked == bonkButton) {
			playSound(BONK_SOUND_FILENAME);
			System.out.println("playing bonk noise");
		} else if (buttonClicked == smashButton) {
			playSound(SMASH_SOUND_FILENAME);
			System.out.println("playing smash noise");
		}
		
	}
}
