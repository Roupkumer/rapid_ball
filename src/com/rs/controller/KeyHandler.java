package com.rs.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import com.rs.draw.Ball;
import com.rs.draw.Game;
import com.rs.draw.Obstacle;

public class KeyHandler implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			Ball.right=true;
			Ball.left=false;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			Ball.right=false;
			Ball.left=true;
		}
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			Game.gameover=false;
			Game.score=0;
			Ball.x=100;
			Ball.y=50;
			
			Random random =new Random();
			Obstacle.x1=random.nextInt(250);
			Obstacle.y1=550;
			Obstacle.x2=random.nextInt(250);
			Obstacle.y2=750;
			Obstacle.x3=random.nextInt(250);
			Obstacle.y3=950;
			System.out.println("Enter");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
