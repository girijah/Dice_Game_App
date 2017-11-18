package com.wordpress.girinaga.diceGame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePanel(MainFrame frame) {
		frame.getToolBar();	
		frame.showAboutBtn();
		
		setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][]"));
		  
		  JLabel lblNewLabel_1 = new JLabel("The Dice");
		  add(lblNewLabel_1, "cell 20 0,alignx right,aligny baseline");
		  lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 34));
		  
		  JLabel lblNewLabel = new JLabel("");
		  lblNewLabel.setIcon(new ImageIcon("img/DiceImage.GIF"));		  
		  add(lblNewLabel, "cell 20 1,alignx right,aligny bottom");
	}

}
