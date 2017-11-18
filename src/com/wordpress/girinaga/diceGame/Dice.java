package com.wordpress.girinaga.diceGame;

import java.util.Random;

import javax.swing.ImageIcon;


public class Dice {	

	Human human = new Human();
	Die[] dieArray = new Die[5];
	private int score = 0;
	
//	Die dieFace1 = new Die(1, new ImageIcon("img/die_face_1.png"));
//	Die dieFace2 = new Die(2, new ImageIcon("img/die_face_2.png"));
//	Die dieFace3 = new Die(3, new ImageIcon("img/die_face_3.png"));
//	Die dieFace4 = new Die(4, new ImageIcon("img/die_face_4.png"));
//	Die dieFace5 = new Die(5, new ImageIcon("img/die_face_5.png"));
//	Die dieFace6 = new Die(6, new ImageIcon("img/die_face_6.png"));
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Die[] roll(){
		int[] dieFaceArray = human.spinRoll();
		for (int i = 0; i < 5; i++) {
			int number = dieFaceArray[i];
			score = score + number;
			String imagePath = "img/die_face_"+number+".png";
			Die dieFace= new Die(number, new ImageIcon(imagePath));	
			dieArray[i]= dieFace;	
		}
		
		System.out.println("score from dice "+score);
		System.out.println("human score in Dice: "+ human.getScore());
		return dieArray;
	}
	
	public Die[] reroll(){
		
	return null;	
	}
	
	public Die[] getDieArray() {
		return dieArray;
	}

	public void setDieArray(Die[] dieArray) {
		this.dieArray = dieArray;
	}

//	public void score(){
//		
//	}

}
