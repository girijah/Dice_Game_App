package com.wordpress.girinaga.diceGame;

import javax.swing.ImageIcon;

public class Die implements DieIntf, Comparable<Die>{
	private int dieTopFace;
	private ImageIcon image;
	
	public Die(int faceValue, ImageIcon image){
		this.dieTopFace = faceValue;
		this.image = image;
	}

	@Override
	public ImageIcon getDieImage() {		
		return image;
	}

	@Override
	public void setImage(ImageIcon image) {		
		this.image = image;
	}

	@Override
	public int getValue() {		
		return dieTopFace;
	}

	@Override
	public void setValue(int value) {
		this.dieTopFace = value;		
	}

	@Override
	public int compareTo(Die o) {
		
		return 0;
	}

}
