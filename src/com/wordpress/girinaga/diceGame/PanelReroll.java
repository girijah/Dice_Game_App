package com.wordpress.girinaga.diceGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PanelReroll extends JPanel {
	
	ArrayList<Integer> keepNumberArray = new ArrayList<Integer>();
	
	Random random = new Random();	
	Human human = new Human();
	Dice dice = new Dice();
	int firstRerollTotal = 0;
	int rolledTotal;
	int rerollCount;
	//static int rerollAttempt=1;
	
		
	JRadioButton btt1;
	JRadioButton btt2;
	JRadioButton btt3;
	JRadioButton btt4;
	JRadioButton btt5;
	
	/**
	 * Create the panel.
	 */
	public PanelReroll(MainFrame frame) {
		frame.hideScoreBtn();
		frame.hideRerollBtn();
		int[] dieArr = Human.dieArray;	
		
		btt1 = new JRadioButton(""+dieArr[0]);	
		btt2 = new JRadioButton(""+dieArr[1]);	
		btt3 = new JRadioButton(""+dieArr[2]);	
		btt4 = new JRadioButton(""+dieArr[3]);	
		btt5 = new JRadioButton(""+dieArr[4]);
		
		add(btt1);
		add(btt2);
		add(btt3);
		add(btt4);
		add(btt5);
		
		//rerollAttempt++; //first reroll
		rolledTotal=0;
		for(int i=0;i<dieArr.length;i++){
			System.out.println();
			rolledTotal = rolledTotal + dieArr[i]; 
		}
		
		
		btt1.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 keepNumberArray.add(dieArr[0]);
	         }
	      });
		
				
		btt2.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 keepNumberArray.add(dieArr[1]);
	         }
	      });
		
		btt3.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 keepNumberArray.add(dieArr[2]);
	         }
	      });
		
		btt4.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 keepNumberArray.add(dieArr[3]);
	         }
	      });
		
		btt5.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 keepNumberArray.add(dieArr[4]);
	         }
	      });
		
		JButton rollRestButton = new JButton("Roll Rest");		
		JButton confirmButton = new JButton("Confirm");	
		
		JButton rerollButton = new JButton("Reroll");		
		
		
		JButton keepButton = new JButton("Keep");
		add(keepButton);		
		keepButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(keepButton);				
				add(rollRestButton);
				repaint();
				revalidate();
				
				int total = 0;
				for(int i=0; i<keepNumberArray.size();i++){
					System.out.println("keepNumberArray "+keepNumberArray.get(i));
				total = total + keepNumberArray.get(i);	
				}			
					
			}
		});
		
		//second and the last roll attempt
			rollRestButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.showScoreBtn();
				remove(rollRestButton);
				rerollCount = 5 - keepNumberArray.size();	
				
			//	rerollAttempt++;
				int rerollScore = 0;
				for (int i = 0; i < rerollCount; i++) {
					int number = random.nextInt(6);
					number = number + 1;
					rerollScore = rerollScore + number;
					keepNumberArray.add(number) ;
				}
							
			
				for(int i=0; i<keepNumberArray.size();i++){
					System.out.println(" new rolled keepNumberArray "+keepNumberArray.get(i));
					firstRerollTotal = firstRerollTotal + keepNumberArray.get(i);	
				}
				
				int prevTot = human.getTotalScore();
				
				//remove the last roll scores
				int deductedTot = prevTot - rolledTotal;
				int totalScore = deductedTot + firstRerollTotal;
				System.out.println("new total "+totalScore);
				JOptionPane.showMessageDialog(null, "Previous Total "+prevTot+"\n New Total "+ totalScore, "Confirmation", JOptionPane.PLAIN_MESSAGE);	
				human.setScore(firstRerollTotal - rolledTotal);
				human.setTotalScore();
				
				add(confirmButton);
				add(rerollButton);
				
				repaint();
				revalidate();
				
			}
		});
			
			confirmButton.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
				remove(rerollButton);	
				repaint();
				frame.showScoreBtn();
				}
			});
			
			rerollButton.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					removeAll();
					
					ArrayList<Integer> secRerollkeepNumberArray = new ArrayList<Integer>();
					
					btt1 = new JRadioButton(""+keepNumberArray.get(0));	
					btt2 = new JRadioButton(""+keepNumberArray.get(1));	
					btt3 = new JRadioButton(""+keepNumberArray.get(2));	
					btt4 = new JRadioButton(""+keepNumberArray.get(3));	
					btt5 = new JRadioButton(""+keepNumberArray.get(4));
					
					add(btt1);
					add(btt2);
					add(btt3);
					add(btt4);
					add(btt5);
					
					btt1.addActionListener(new ActionListener() {
				         @Override
				         public void actionPerformed(ActionEvent e) {
				        	 secRerollkeepNumberArray.add(keepNumberArray.get(0));
				         }
				      });
					
							
					btt2.addActionListener(new ActionListener() {
				         @Override
				         public void actionPerformed(ActionEvent e) {
				        	 secRerollkeepNumberArray.add(keepNumberArray.get(1));
				         }
				      });
					
					btt3.addActionListener(new ActionListener() {
				         @Override
				         public void actionPerformed(ActionEvent e) {
				        	 secRerollkeepNumberArray.add(keepNumberArray.get(2));
				         }
				      });
					
					btt4.addActionListener(new ActionListener() {
				         @Override
				         public void actionPerformed(ActionEvent e) {
				        	 secRerollkeepNumberArray.add(keepNumberArray.get(3));
				         }
				      });
					
					btt5.addActionListener(new ActionListener() {
				         @Override
				         public void actionPerformed(ActionEvent e) {
				        	 secRerollkeepNumberArray.add(keepNumberArray.get(4));
				         }
				      });
					
					JButton kpButton = new JButton("Keep");
					add(kpButton);
					repaint();
					revalidate();
					kpButton.addActionListener(new ActionListener() {			
						@Override
						public void actionPerformed(ActionEvent e) {
							remove(kpButton);				
							//add(rollRestButton);
							repaint();
							revalidate();
							
							int total = 0;
							for(int i=0; i<secRerollkeepNumberArray.size();i++){
							//	System.out.println("keepNumberArray "+keepNumberArray.get(i));
							total = total + secRerollkeepNumberArray.get(i);	
							}	
							int rerolCount = 5 - secRerollkeepNumberArray.size();	
							
							int rerollScore = 0;
							for (int i = 0; i < rerolCount; i++) {
								int number = random.nextInt(6);
								number = number + 1;
								rerollScore = rerollScore + number;
								secRerollkeepNumberArray.add(number) ;
							}
							
						
							int rerollTotal = 0;
							int doubleRerollTotal = 0;
							for(int i=0; i<secRerollkeepNumberArray.size();i++){
								System.out.println(" new rolled secRerollkeepNumberArray "+secRerollkeepNumberArray.get(i));
								doubleRerollTotal = doubleRerollTotal + secRerollkeepNumberArray.get(i);	
							}
							
							int prevTot = human.getTotalScore();
							
							//remove the last roll scores
							int deductedTot = prevTot - firstRerollTotal;
							int totalScore = deductedTot + doubleRerollTotal;
							System.out.println("new total "+totalScore);
							JOptionPane.showMessageDialog(null, "Previous Total "+prevTot+"\n Reroll Total "+ totalScore, "Reroll", JOptionPane.PLAIN_MESSAGE);	
							human.setScore(doubleRerollTotal - firstRerollTotal);
							human.setTotalScore();
							frame.showScoreBtn();
								
						}
					});
					
				}
			});
	}

}
