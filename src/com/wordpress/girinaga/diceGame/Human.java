package com.wordpress.girinaga.diceGame;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Human {
	private int score;
	private static int totalScore;
	private static int target=101;
	static int[] dieArray = new int[5];;
	ArrayList<Die[]> humanRollHistory = new ArrayList<Die[]>();
	Random random = new Random();
	
	public Human(){
		
	}
	

	public int getTarget() {
		return target;
	}


	public void setTarget(int target) {
		this.target = target;
	}	
	
	
	public int[] spinRoll() {
		
		for (int i = 0; i < 5; i++) {
			int number = random.nextInt(6);
			number = number + 1;
			score = score + number;
			dieArray[i] = number;
		}
		
		setTotalScore();
		System.out.println("score in human class: "+ getScore());
		return dieArray;
	}

	
	public void setDieFaceArray(int[] dieFaceArray) {
		this.dieArray = dieFaceArray;
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
		return humanRollHistory;
	}

	public void setComputerRollHistory(ArrayList<Die[]> computerRollHistory) {
		this.humanRollHistory = computerRollHistory;
	}

}
