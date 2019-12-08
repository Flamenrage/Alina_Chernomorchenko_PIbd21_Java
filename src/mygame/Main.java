package mygame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class Main {

	private JFrame frame;
	private ITransport plane;
	PlaneDrawPanel panel;
	
	private JButton buttonUp;
	private JButton buttonRight;
	private JButton buttonLeft;
	private JButton buttonDown;
	private JButton buttonCreateNewPlane;
	private JButton buttonCreateNewBomberPlane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
	
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void createNewPlane() {
		
		plane = new WarPlane((int)(Math.random() * 200) + 50, (int)(Math.random() * 500) + 100, Color.GRAY);			
		panel = new PlaneDrawPanel(plane);
		panel.setBounds(10, 10, 900, 500);
		frame.getContentPane().add(panel);
		plane.SetPosition((int)(Math.random() * 200) + 100, (int)(Math.random() * 100) + 50,  panel.getWidth(),  panel.getHeight());					
		panel.repaint();
	}
	private void createNewBomberPlane() {
		plane = new BomberPlane((int)(Math.random() * 200) + 50, (int)(Math.random() * 500) + 100, 
											Color.GRAY, Color.RED, ((int)(Math.random() * 5)+6), true, true);
		panel = new PlaneDrawPanel(plane);
		panel.setBounds(10, 10, 900, 500);
		frame.getContentPane().add(panel);
		plane.SetPosition((int)(Math.random() * 200) + 100, (int)(Math.random() * 100) + 50,  panel.getWidth(),  panel.getHeight());			
		panel.repaint();
	}
	public static int rnd(int min, int max) {
		max -= min;
		return (int)(Math.random() * ++max) + min;
	}
	Random rnd = new Random();
	
	public Main() {
		initialize();
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buttonCreateNewBomberPlane = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C\r\n \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		buttonCreateNewBomberPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCreateNewBomberPlane.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
										
						createNewPlane();
						buttonUp.setEnabled(true);
						buttonRight.setEnabled(true);
						buttonLeft.setEnabled(true);
						buttonDown.setEnabled(true);
											
					}
				});
				
			}
		});
		buttonCreateNewBomberPlane.setBounds(28, 557, 201, 42);
		frame.getContentPane().add(buttonCreateNewBomberPlane);
		buttonCreateNewPlane = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0431\u043E\u043C\u0431\u0430\u0440\u0434\u0438\u0440\u043E\u0432\u0449\u0438\u043A"); buttonCreateNewPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewBomberPlane();
				buttonUp.setEnabled(true);
				buttonRight.setEnabled(true);
				buttonLeft.setEnabled(true);
				buttonDown.setEnabled(true);
				panel.repaint();
			}
		}); buttonCreateNewPlane.setBounds(241, 557, 201, 42); frame.getContentPane().add(buttonCreateNewPlane);
		
		buttonUp = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\up.png"));
		buttonUp.setEnabled(false);
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		
		
		buttonUp.setBounds(780, 557, 42, 42);
		frame.getContentPane().add(buttonUp);
		
		buttonLeft = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\left.png"));
		buttonLeft.setEnabled(false);
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		buttonLeft.setBounds(738, 599, 42, 42);
		frame.getContentPane().add(buttonLeft);
		
		 buttonRight = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\right.png"));
		buttonRight.setEnabled(false);
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
			
		buttonRight.setBounds(822, 599, 42, 42);
		frame.getContentPane().add(buttonRight);
		
		buttonDown = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\down.png"));
		buttonDown.setEnabled(false);
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
			
		buttonDown.setBounds(780, 599, 42, 42);
		frame.getContentPane().add(buttonDown);

	}
}
