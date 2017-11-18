package com.wordpress.girinaga.diceGame;

import javax.swing.ImageIcon;

public interface DieIntf {

	public ImageIcon getDieImage();
	
	public void setImage(ImageIcon image);
	
	public int getValue();
	
	public void setValue(int value);	
	
}
