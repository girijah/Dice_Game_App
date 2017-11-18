package com.wordpress.girinaga.diceGame;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Computer {
	private int score;
	private static int totalScore;
	
	ArrayList<Die[]> computerRollHistory = new ArrayList<Die[]>();	
	Die[] dieArray = new Die[5];
	Random random = new Random();
	
	
	
	public Die[] spinRoll() {
		for (int i = 0; i < 5; i++) {
			int number = random.nextInt(6);
			number = number + 1;
			score = score + number;
			Die dieFace = new Die(number, new ImageIcon("img/die_face_"+number+".png"));
			dieArray[i]= dieFace;			
		}	
		setTotalScore();
		return dieArray;
	}

	public void setDieArray(Die[] dieArray) {
		this.dieArray = dieArray;
	}
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {		
		this.score = score;
	}

	public int getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore() {
		totalScore = totalScore + score;
	}

	public ArrayList<Die[]> getComputerRollHistory() {
		return computerRollHistory;
	}

	public void setComputerRollHistory(ArrayList<Die[]> computerRollHistory) {
		this.computerRollHistory = computerRollHistory;
	}

	

}
