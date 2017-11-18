package com.wordpress.girinaga.diceGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class PanelGameArena extends JPanel {

	Computer computer = new Computer();
	Human human = new Human();
	JLabel lblMessages;

	static String str = "Target* ";
	static int totalScore;
	static JPanel pnlCenter;
	private static JPanel pnlEast;
	private static JPanel pnlWest;
	private static JPanel pnlSouth;
	private static JToolBar toolBar;
	private static JButton btnThrow;

	/**
	 * Create the panel.
	 */
	public PanelGameArena(MainFrame frame) {
		lblMessages = new JLabel(str);
		toolBar = frame.getToolBar();
		frame.hidePlayBtn();
		frame.showHomeBtn();

		btnThrow = new JButton("Throw");
		btnThrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThrow.setVisible(false);
				pnlWest.removeAll();
				pnlEast.removeAll();
				pnlCenter.removeAll();
				pnlCenter.setBorder(BorderFactory
						.createTitledBorder("Dice Rolled Result.."));
				pnlCenter.add(new ThrowResultPanel(frame, toolBar));
				pnlCenter.repaint();
				pnlCenter.revalidate();
				lblMessages.setText("Target " + human.getTarget());
			}
		});

		
		pnlCenter = new JPanel(new BorderLayout());

		Box leftVerticalBox = Box.createVerticalBox();
		Box rightVerticalBox = Box.createVerticalBox();

		pnlSouth = new JPanel(new FlowLayout());
		pnlSouth.setBorder(BorderFactory.createTitledBorder("Messages..."));
		pnlSouth.add(lblMessages);

		pnlWest = new JPanel(new FlowLayout());
		pnlWest.setBorder(BorderFactory.createTitledBorder("Computer..."));
		JLabel labell = new JLabel();
		labell.setIcon(new ImageIcon("img/comptr.GIF"));
		leftVerticalBox.add(labell);
		pnlWest.add(leftVerticalBox);

		pnlEast = new JPanel(new FlowLayout());
		pnlEast.setBorder(BorderFactory.createTitledBorder("You..."));
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("img/human.GIF"));
		rightVerticalBox.add(label);
		pnlEast.add(rightVerticalBox);

		// Set up the content-pane with BorderLayout and adds the panels
		setLayout(new BorderLayout());

		add(pnlEast, BorderLayout.EAST);
		add(pnlWest, BorderLayout.WEST);
		add(pnlSouth, BorderLayout.SOUTH);
		add(pnlCenter, BorderLayout.CENTER);

		pnlCenter.add(BorderLayout.CENTER, new TargetDefinePanel(frame));
	}

	public static JToolBar getTargetPanelToolBar() {
		return toolBar;
	}

	public static void showThrowBtn() {
		toolBar.add(btnThrow);
		btnThrow.setVisible(true);

	}

	public static JPanel getPanelEast() {
		return pnlEast;
	}

	public static JPanel getPanelWest() {
		return pnlWest;
	}

	public static JPanel getPanelCenter() {
		return pnlCenter;
	}

}
