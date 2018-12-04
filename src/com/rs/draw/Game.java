package com.rs.draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.rs.controller.KeyHandler;

public class Game extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private Ball ball;
	private Obstacle obstacle;
	private Timer timer;
	public static int score;
	public static boolean gameover;
	public Game() {
		ball = new Ball();
		obstacle = new Obstacle();
		addKeyListener(new KeyHandler());
		setFocusable(true);
		gameover=false;
		score=0;
		timer = new Timer(20, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!gameover) {
			score+=1;
			obstacle.paint(g);
			ball.paint(g);
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString("Score : "+score,10, 30);
		}
		if (gameover) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString("Score : "+score,50, 100);
			g.setFont(new Font("Arial",Font.BOLD,40));
			g.drawString("Gameover",100, 200);
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString("Press Enter To Restart",10, 300);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ball.getBall().intersects(obstacle.getRect1())) {
			ball.y = obstacle.y1 - 25;
		 }else if (ball.getBall().intersects(obstacle.getRect2())) {
		 ball.y=obstacle.y2-25;
		 }else if (ball.getBall().intersects(obstacle.getRect3())) {
		 ball.y=obstacle.y3-25;
		 }
		
		if (ball.y<=-30||ball.y>=500) {
			gameover=true;
		}
		repaint();
	}

}
