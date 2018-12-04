package com.rs.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.rs.controller.KeyHandler;

public class Ball extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public static int x,y,r;
	public static boolean left,right;
	private Timer timer;
	public Ball() {
		x=100;
		y=50;
		r=25;
		
		addKeyListener(new KeyHandler());
		setFocusable(true);
		
		timer=new Timer(20, this);
		timer.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillOval(x, y, r, r);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		moveBall();
		repaint();
	}
	
	private void moveBall() {
		y+=1;
		if (left) {
			x-=4;
		}else if (right) {
			x+=4;
		}
		
		if (x<=0) {
			x=0;
		}
		if (x>=320) {
			x=320;
		}
		
		
		
	}
	
	public Rectangle getBall(){
		Rectangle ball=new Rectangle(x, y, r, r);
		return ball;
	}
}
