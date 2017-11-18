package com.wordpress.girinaga.diceGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TargetDefinePanel extends JPanel {
	private JTextField txtTarget;
	MainFrame frame;
	JLabel lblHuman;
	JLabel lblCom;
    Human human = new Human();
    static int target;
	/**
	 * Create the panel.
	 */
	public TargetDefinePanel(MainFrame frame) {
		this.frame = frame;
		
		lblCom = new JLabel("");
		lblCom.setIcon(new ImageIcon("img/dice.gif"));

		lblHuman = new JLabel("");
		lblHuman.setIcon(new ImageIcon("img/dice.gif"));

		// Provide minimum sizes for the two components in the split pane
		Dimension minimumSize = new Dimension(100, 50);
		lblCom.setMinimumSize(minimumSize);
		lblHuman.setMinimumSize(minimumSize);
		
		JLabel lblTarget = new JLabel("Target");
		add(lblTarget);
		
		txtTarget = new JTextField();
		txtTarget.setPreferredSize(new Dimension(80,23));
		add(txtTarget);	
		
		JButton btn = new JButton("SET");
		add(btn);		
		
		JButton btnDefaultTarget = new JButton("Set Target 101");
		add(btnDefaultTarget);
		
		setTarget(btn, btnDefaultTarget);
		
		//String target = JOptionPane.showInputDialog(null, "Define Target", "Set Game Target", JOptionPane.QUESTION_MESSAGE);
		
	}
	
	
	private void setTarget(JButton btn, JButton btnDefaultTarget){
		
		btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				 boolean bool = true;
				try{
				Integer.parseInt(txtTarget.getText());
				}catch(NumberFormatException exc){
					bool = false;
				}
				
				 if (txtTarget.getText() ==null ){         //LESSON: if u have this second if condition "" as the first chain or if there are two OR conditions and if that's second condition is for null and the first is for "" this, It will show you exception coz in the null scenario the first will be checked but it is not the null detector soon it will end up with exception before it look into the other OR condition in the brackets..so u must keep null detector in the first if loop chain to avoid null exceptions!  
						JOptionPane.showMessageDialog(null, "Target is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(bool && txtTarget.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Target is undefined!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(bool && Integer.parseInt(txtTarget.getText())<=0){
						JOptionPane.showMessageDialog(null, "Please enter a valid target!");
					}else if(bool && Integer.parseInt(txtTarget.getText())>0){
				    human.setTarget(Integer.parseInt(txtTarget.getText()));
				    PanelGameArena.str = "Target "+human.getTarget();
				    diceRolls();
					}
			}
		});
		
			btnDefaultTarget.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				human.setTarget(101);
				diceRolls();				
			}
		});		
	}
	
	private void diceRolls(){
		frame.hidePlayBtn();
		
		PanelGameArena.showThrowBtn();	
		PanelGameArena.pnlCenter.removeAll();
		PanelGameArena.pnlCenter.setBorder(BorderFactory.createTitledBorder("Dice on rolling.."));
		PanelGameArena.str = "Target "+human.getTarget();
		PanelGameArena.pnlCenter.add(lblCom, BorderLayout.EAST);
		PanelGameArena.pnlCenter.add(lblHuman, BorderLayout.WEST);	
		PanelGameArena.pnlCenter.repaint();
		PanelGameArena.pnlCenter.revalidate();
		
	}

}
