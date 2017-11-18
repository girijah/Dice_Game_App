package com.wordpress.girinaga.diceGame;

import java.io.*;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

import javax.swing.JToolBar;
import javax.swing.JButton;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AboutPanel(MainFrame frame) {
		frame.getToolBar();
		//frame.showAboutBtn();
		frame.showHomeBtn();
		frame.hidePlayBtn();
		
		setLayout(new MigLayout("", "[][][]", "[][]"));
		
		JLabel lblANoteOn = new JLabel("Game Rules");
		add(lblANoteOn, "cell 4 0,aligny top");
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, "cell 4 1 7 1 grow");

		/*Scanner input = null;

		try {

			input = new Scanner(new File("src/gameAboutPage.txt"));
			System.out.println(input);
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "showing file related error!");
			ex.printStackTrace();
		}

		while (input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
			textArea.append(line + "\n");
		}

		input.close();*/

		String lineSeparator = System.getProperty("line.separator");

			File file = new File("src/gameAboutPage.txt");
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				StringBuilder contents = new StringBuilder();
				String text;
				while ((text = reader.readLine()) != null) {
					contents.append(text).append(lineSeparator);
				}
				textArea.append(contents.toString());
				//System.out.println(contents.toString());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "showing file related error!");
				e.printStackTrace();
			}

	}

}
