package com.wordpress.girinaga.diceGame;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.Box;

public class ThrowResultPanel extends JPanel {
	
	File file = new File("DiceGameWinnings.txt");
	Computer computer = new Computer();
	Human human = new Human();
	Dice dice = new Dice();
	static int throwCount = 0;
	private static JPanel pnlEast;
	private static JPanel pnlWest;
	private JLabel lblWinCount= new JLabel();
	private JLabel lblComWin = new JLabel();
		
	/**
	 * Create the panel.
	 */
	public ThrowResultPanel(MainFrame frame, JToolBar toolBar) {
		
		String str = readFromFile();
		lblComWin.setText("Win Count     : " + str.split("#")[0]);
		lblWinCount.setText("Win Count    : "+str.split("#")[1]);			
		throwCount++;
		toolBar = PanelGameArena.getTargetPanelToolBar();	
		pnlWest = PanelGameArena.getPanelWest();
		pnlEast = PanelGameArena.getPanelEast();
		//pnlCenter = PanelGameArena.getPanelCenter();

		frame.showRerollBtn();
		frame.showScoreBtn();
		frame.hideHomeBtn();
		frame.showCloseBtn();		
		
		setLayout(new GridLayout(1, 8, 4, 4));

		Box leftVerticalBox = Box.createHorizontalBox();

		Box rightVerticalBox = Box.createHorizontalBox();
		
		//roll for human
	    dice.roll();	   
		
		Die[] dieHumanArray= dice.getDieArray();
		// System.out.println("human score in throw panel: "+ human.getScore());
		 
		
		for(int i=0; i<5; i++){
			//System.out.println("dice : "+dieHumanArray[i].getValue()+" "+dieHumanArray[i].getDieImage());
			ImageIcon imgPath = dieHumanArray[i].getDieImage();
			JLabel lbl1 = new JLabel();
			lbl1.setIcon(imgPath);
			rightVerticalBox.add(lbl1);
		}
		
	    human.setScore(dice.getScore());
		//System.out.println("human score: " + dice.getScore());	
		PanelGameArena.totalScore = human.getTotalScore();
		//System.out.println("humanScore total: " + human.getTotalScore());

		//roll for computer
		Die[] dieCompArr = computer.spinRoll();
		
		
		for(int i=0; i<5;i++){
			//System.out.println("computer : "+dieCompArr[i].getValue()+" "+dieCompArr[i].getDieImage());
			ImageIcon imgPath = dieCompArr[i].getDieImage();
			JLabel lbl1 = new JLabel();
			lbl1.setIcon(imgPath);
			leftVerticalBox.add(lbl1);
		}	
	
//		System.out.println("computer score: " + computer.getScore());		
//		System.out.println("computerScore total: " + computer.getTotalScore());

		add(leftVerticalBox);
		add(rightVerticalBox);
		
		
		Box computerVerticleBox = Box.createVerticalBox();	
		JLabel lblComScore = new JLabel("Score =            "+ computer.getScore());
		computerVerticleBox.add(lblComScore);		
		JLabel lblComTotScore = new JLabel("Total Score =  "+ computer.getTotalScore());
		computerVerticleBox.add(lblComTotScore);
		JLabel lblComThrowCount = new JLabel("Throw Count:  "+ThrowResultPanel.throwCount);
		computerVerticleBox.add(lblComThrowCount);		
		computerVerticleBox.add(lblComWin);
		pnlWest.add(computerVerticleBox);
		
				
		Box humanVerticleBox = Box.createVerticalBox();
		JLabel lblHumanScore = new JLabel("Score =           "+ human.getScore());
		humanVerticleBox.add(lblHumanScore);
		JLabel lblHumanTotScore = new JLabel("Total Score = "+ human.getTotalScore());
		humanVerticleBox.add(lblHumanTotScore);
		JLabel lblHumanThrowCount = new JLabel("Throw Count: "+ThrowResultPanel.throwCount);
		humanVerticleBox.add(lblHumanThrowCount);
		
		humanVerticleBox.add(lblWinCount);
		pnlEast.add(humanVerticleBox);
		
		//No Rerolls for final throw attempt
		if(human.getTotalScore() >= human.getTarget() && human.getTotalScore()==computer.getTotalScore()){
			frame.hideRerollBtn();
		}
		
		
		if(human.getTotalScore() >= human.getTarget() && human.getTotalScore() > computer.getTotalScore()){
			JOptionPane.showMessageDialog(null, "Congratulations! You Won. ", "Winning Criteria", JOptionPane.PLAIN_MESSAGE);
			removeAll();
			saveToFile("h");
			setForNewGame();
			
		}
		
		if(computer.getTotalScore() >= human.getTarget() && human.getTotalScore()< computer.getTotalScore()){
			JOptionPane.showMessageDialog(null, "You lose! ", "Winning Criteria", JOptionPane.PLAIN_MESSAGE);	
			removeAll();
			saveToFile("c");
			setForNewGame();
		}
	
		
		//JOptionPane.showMessageDialog(null, "Your Score "+ dice.getScore()+"\n Computer Score "+computer.getScore(), "Scores", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void saveToFile(String winner){

		String str = readFromFile();
		int compWinCount = Integer.parseInt(str.split("#")[0]);
		int humanWinCount = Integer.parseInt(str.split("#")[1]);
	
	FileWriter writer=null;
	try {
		writer = new FileWriter(file);
	} catch (IOException e) {
		e.printStackTrace();
	}
	BufferedWriter bufferedWriter = new BufferedWriter(writer);
	
	//first computerWin # second humanWin
	if(winner.equals("c")){
		compWinCount = compWinCount+1;
		lblComWin.setText("Win Count     : "+compWinCount);
		try {
			writer.write(compWinCount+"#"+humanWinCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}else if(winner.equals("h")){
		humanWinCount =humanWinCount+1;
		lblWinCount.setText("Win Count     : "+humanWinCount);
		try {
			writer.write(compWinCount+"#"+humanWinCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	try {
		writer.flush();
		writer.close();
		bufferedWriter.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	
	private String readFromFile(){
		int compWinCount=0;
		int humanWinCount=0;
		
		BufferedReader br=null;
	
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
					e.printStackTrace();
		}
		try {
			for (String line; (line = br.readLine()) != null;) {
				String[] data = line.split("#");
				compWinCount = Integer.parseInt(data[0]);
				humanWinCount = Integer.parseInt(data[1]);
				//br.close();
			}
		} catch (NumberFormatException | IOException e) {			
			e.printStackTrace();
		}
		return compWinCount+"#"+humanWinCount;	
	}
	
	private void setForNewGame(){
		dice.dieArray=null;
		dice.setScore(0);			
		dice.setDieArray(null);
		human.setScore(0);
		human.setDieFaceArray(null);
		human.setTotalScore();
		computer.setScore(0);
		computer.setTotalScore();
		computer.dieArray=null;
		computer.setDieArray(null);
		PanelGameArena.totalScore=0;
		throwCount=0;
	}

}
