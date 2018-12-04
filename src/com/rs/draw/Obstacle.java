package com.rs.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Obstacle extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	public static int x1,y1,x2,y2,x3,y3,w,h;
	private Random random;
	private Timer timer;
	public Obstacle() {
		random =new Random();
		x1=random.nextInt(250);
		y1=550;
		x2=random.nextInt(250);
		y2=750;
		x3=random.nextInt(250);
		y3=950;
		w=100;
		h=25;
		timer=new Timer(20, this);
		timer.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(x1, y1, w, h);
		g.fillRect(x2, y2, w, h);
		g.fillRect(x3, y3, w, h);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		moveObstacle();
		repaint();
	}

	private void moveObstacle() {
		y1-=2;
		y2-=3;
		y3-=2;
		if (y1<=-30) {
			x1=random.nextInt(250);
			y1=550;
		}
		if (y2<=-30) {
			x2=random.nextInt(250);
			y2=550;
		}
		if (y3<=-30) {
			x3=random.nextInt(250);
			y3=550;
		}
	}
	public Rectangle getRect1() {
		Rectangle rect1=new Rectangle(x1, y1, w, h);
		return rect1;
	}
	public Rectangle getRect2() {
		Rectangle rect1=new Rectangle(x2, y2, w, h);
		return rect1;
	}
	public Rectangle getRect3() {
		Rectangle rect1=new Rectangle(x3, y3, w, h);
		return rect1;
	}
}
