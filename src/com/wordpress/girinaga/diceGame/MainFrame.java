package com.wordpress.girinaga.diceGame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {	
		
	private JPanel parentPane;	
	private JToolBar toolBar;
	
	private JButton btnHome;
	private JButton btnAbout;
	private JButton btnPlay;	
	private JButton btnReroll;
	private JButton btnScore;
	private JButton btnSetTarget;
	private JButton btnClose;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		super("DICE GAME APPLICATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		//setMinimumSize(new Dimension(1024, 512));
		//setExtendedState(MAXIMIZED_BOTH);
		
		setBounds(100, 100, 800, 600);
		parentPane = new JPanel();
		parentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		parentPane.setLayout(new BorderLayout(0, 0));
		//parentPane.setBackground(new Color(75, 0, 130));
		parentPane.setBackground(new Color(0, 0, 200));
		parentPane.add(new HomePanel(MainFrame.this), BorderLayout.CENTER);
		
		setContentPane(parentPane);
		getToolBar();
		showAboutBtn();
		
//		JLabel image1 = new JLabel();		
//		image1.setIcon(new ImageIcon("img/animatedDice.gif"));
		JLabel title = new JLabel("Dice Game");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Eras Bold ITC", Font.PLAIN, 26));		
//		Box horizontalBox = Box.createHorizontalBox();
		//horizontalBox.add(image1);
		//horizontalBox.add(title);		
		//toolBar.add(horizontalBox, BorderLayout.NORTH);	
		
	}
	
//	public void showChildPanel(String strPanel) {
//		JPanel panel = null;			
//		contentPanel.removeAll();
//		contentPanel.add(panel);
//		contentPanel.revalidate();
//		contentPanel.repaint();
//	}
	
	public JToolBar getToolBar(){
		toolBar = new JToolBar();
		toolBar.setFloatable(false);// Cannot place toolbar everywhere
		toolBar.setPreferredSize(new Dimension(1000,50));		
		parentPane.add(toolBar, BorderLayout.NORTH);
		

		btnHome = new JButton("Home");		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     
				parentPane.removeAll();			 //remove panel	
				parentPane.add(new HomePanel(MainFrame.this), BorderLayout.CENTER);    //add panel
				parentPane.repaint();          //clean and polish panel
				parentPane.revalidate();       //set new panel				
			}
		});
	
		
		btnAbout = new JButton("About");		
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
//				parentPane.add(BorderLayout.CENTER, aboutPanel);
//				parentPane.revalidate();			
				
				parentPane.removeAll();        //remove panel
				parentPane.add(new AboutPanel(MainFrame.this), BorderLayout.CENTER );    //add panel
				parentPane.repaint();          //clean and polish panel
				parentPane.revalidate();       //set new panel				
			}
		});
	
		
		btnPlay = new JButton("Play");
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					parentPane.removeAll();
					parentPane.add(BorderLayout.CENTER, new PanelGameArena(MainFrame.this));
					//parentPane.add(BorderLayout.CENTER, new ThrowResultPanel(MainFrame.this,toolBar));
					parentPane.repaint();
					parentPane.revalidate();
				  				
				}			
		});
		toolBar.add(btnPlay);
				
		
		
		//hideRerollBtn();
		
		btnScore = new JButton("Score");
		btnScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideRerollBtn();
				//JOptionPane.showMessageDialog(null, "You scored "+ human.getScore(), "Score Detail", JOptionPane.PLAIN_MESSAGE);
				
				PanelGameArena.showThrowBtn();				
			}
		});
		toolBar.add(btnScore);
		hideScoreBtn();
		
		
		btnReroll = new JButton("Reroll");
		btnReroll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelGameArena.getPanelCenter().removeAll();
				PanelGameArena.getPanelCenter().add(new PanelReroll(MainFrame.this));	
				PanelGameArena.getPanelCenter().repaint();
				PanelGameArena.getPanelCenter().revalidate();
			}
		});
		toolBar.add(btnReroll);
		hideRerollBtn();
		
		//JButton btnNewGame = new JButton("New Game");
		
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				parentPane.removeAll();			 //remove panel	
				parentPane.add(new HomePanel(MainFrame.this), BorderLayout.CENTER);    //add panel
				parentPane.repaint();          //clean and polish panel
				parentPane.revalidate();       //set new panel	
				//toolBar.add(btnNewGame);			
			}
		});
		toolBar.add(btnClose);
		hideCloseBtn();
		
//		btnNewGame.addActionListener(new ActionListener() {			
//			@Override
//			public void actionPerformed(ActionEvent e) {				
//				parentPane.removeAll();		
//				parentPane.add(BorderLayout.CENTER, new PanelGameArena(MainFrame.this));
//				parentPane.repaint();          //clean and polish panel
//				parentPane.revalidate();
//			}
//	});
		
		return toolBar;
	}
	
	public void showAboutBtn(){
		toolBar.add(btnAbout);
		btnAbout.setVisible(true);
	}
	
	public void hideAboutBtn(){
		btnAbout.setVisible(false);
	}
	
	public void showPlayBtn(){
		btnPlay.setVisible(true);
	}
	
	public void hidePlayBtn(){
		btnPlay.setVisible(false);
	}
	
	public void showHomeBtn(){
		toolBar.add(btnHome);
		btnHome.setVisible(true);
	}
	
	public void hideHomeBtn(){
		btnHome.setVisible(false);
	}
	
	public void showRerollBtn(){
		btnReroll.setVisible(true);
	}
	
	public void hideRerollBtn(){
		btnReroll.setVisible(false);
	}
	
	public void showScoreBtn(){
		btnScore.setVisible(true);
	}
	
	public void hideScoreBtn(){
		btnScore.setVisible(false);
	}
	
	public void showCloseBtn(){
		btnClose.setVisible(true);
	}
	
	public void hideCloseBtn(){
		btnClose.setVisible(false);
	}
	
}
