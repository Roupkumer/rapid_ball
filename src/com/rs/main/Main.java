package com.rs.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rs.draw.Game;

import java.awt.CardLayout;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout layout;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setTitle("Rapid Ball");
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		layout=new CardLayout();
		contentPane.setLayout(layout);
		
		Game game=new Game();
		contentPane.add(game, "game");
		
		layout.show(contentPane, "game");
		
	}

}
