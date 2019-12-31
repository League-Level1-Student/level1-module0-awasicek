package _03_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() throws Exception {

		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
		// This will make sure the program exits when you close the window
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image Address”)
		String imageAddress = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzaG-OtpYZEtWRO-CdocWQWWxIBf6obcdu3ebneZXuLKDnHGHq&s";

		// 2. create a variable of type "Component" that will hold your image
		Component imageHolder;

		// 3. use the "createImage()" method below to initialize your Component
		imageHolder = createImage(imageAddress);

		// 4. add the image to the quiz window
		quizWindow.add(imageHolder);

		// 5. call the pack() method on the quiz window
		quizWindow.pack();

		// 6. ask a question that relates to the image
		String userAnswer = JOptionPane.showInputDialog("Philosopher or tiger?");

		// 7. print "CORRECT" if the user gave the right answer
		if (userAnswer.equalsIgnoreCase("tiger")) {
			JOptionPane.showMessageDialog(null, "Correct!");
		} else {
			// 8. print "INCORRECT" if the answer is wrong
			JOptionPane.showMessageDialog(null, "Incorrect!");
		}

		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(imageHolder);

		// 10. find another image and create it (might take more than one line
		// of code)
		String otherImageAddress = "https://comicvine1.cbsistatic.com/uploads/scale_small/0/9116/620154-calvin2.jpg";
		Component otherImageHolder = createImage(otherImageAddress);

		MouseAdapter adapter = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Hey. Don't click me!");
			}
			public void mouseMoved(MouseEvent e) {
				System.out.println("x: " + e.getX() + ", y: " + e.getY());
			}
		};
		
		otherImageHolder.addMouseListener(adapter);
		
		otherImageHolder.addMouseMotionListener(adapter);
		
		// 11. add the second image to the quiz window
		quizWindow.add(otherImageHolder);

		// 12. pack the quiz window
		quizWindow.pack();

		// 13. ask another question
		userAnswer = JOptionPane.showInputDialog("Friend or food for the tiger?");


		// 14+ check answer, say if correct or incorrect, etc.
		if (userAnswer.equalsIgnoreCase("friend")) {
			JOptionPane.showMessageDialog(null, "Correct!");
		} else {
			// 8. print "INCORRECT" if the answer is wrong
			JOptionPane.showMessageDialog(null, "Incorrect!");
		}
	}

	private Component createImage(String imageUrl) throws MalformedURLException {
		URL url = new URL(imageUrl);
		Icon icon = new ImageIcon(url);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
