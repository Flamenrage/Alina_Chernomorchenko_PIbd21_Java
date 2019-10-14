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


public class Main {

	private static JFrame frame;
	private BomberPlane plane;
	private PlaneDraw planehelper;
	JPanel panel;
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
	
	/**
	 * Launch the application.
	 */
	public static int rnd(int min, int max) {
		max -= min;
		return (int)(Math.random() * ++max) + min;
	}
	Random rnd = new Random();
	private JTextField textField;
	private JButton buttonUp;
	
	
	public Main() {
		initialize();
		
	}
	
	/* 
	

	picturePanelShip = new DrawingHelper();
	picturePanelShip.setBackground(Color.WHITE);
	picturePanelShip.setBounds(0, 0, 333, 261);
	frame.getContentPane().add(picturePanelShip);
	  */
	 
	/*ship = new Ship(rnd.nextInt(2) * 200 + 100, rnd.nextInt(2) * 90 + 10, Color.BLUE);
			ship.SetPosition(rnd.nextInt(2) * 10 + 10, rnd.nextInt(2) * 30 + 70, picturePanelShip.getWidth(),
					picturePanelShip.getHeight());
			picturePanelShip.addShip(ship);
			frame.repaint();*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buttonUp = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\up.png"));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		
		
		
		buttonUp.setBounds(780, 557, 42, 42);
		frame.getContentPane().add(buttonUp);
		
		
		JButton buttonLeft = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\left.png"));
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		buttonLeft.setBounds(738, 599, 42, 42);
		frame.getContentPane().add(buttonLeft);
		
		JButton buttonRight = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\right.png"));
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		
		
		buttonRight.setBounds(822, 599, 42, 42);
		frame.getContentPane().add(buttonRight);
		
		
		JButton buttonDown = new JButton(new ImageIcon("D:\\Универ\\программирование\\Новая папка\\down.png"));
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plane.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		
		int BOARDS_WIDTH = 888;
		int BOARDS_HEIGHT = 549;
		buttonDown.setBounds(780, 599, 42, 42);
		frame.getContentPane().add(buttonDown);
		
		JButton buttonCreate = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								
						plane = new BomberPlane(rnd(100, 400), rnd(1000, 1500), Color.GRAY,
								Color.RED, 10, true);
						panel = new PlaneDraw(plane);
						
						panel.setSize(BOARDS_WIDTH, BOARDS_HEIGHT);
						
						frame.getContentPane().add(panel);
						plane.SetPosition(500, 100, BOARDS_WIDTH,
								BOARDS_HEIGHT);
						panel.repaint();					
						
					}
				});
				
			}
		});
		
		buttonCreate.setBounds(131, 623, 97, 25);
		frame.getContentPane().add(buttonCreate);
		
		
		
		
		textField = new JTextField();
		textField.setBounds(12, 588, 71, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JButton buttonBombs = new JButton("\u0417\u0430\u0434\u0430\u0442\u044C"); buttonBombs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n;
				try {
					String strN = textField.getText(); //извлекаем текст из 1 окна
					n = Integer.parseInt(strN); //преобразуем в int
					plane.SetBombs(n);
					panel.repaint();
				} catch (NumberFormatException ex) {
					
					return;
				}
			}
		}); buttonBombs.setBounds(12, 623, 97, 25); frame.getContentPane().add(buttonBombs);
		
		JLabel label = new JLabel("\u0417\u0430\u0434\u0430\u0439\u0442\u0435 \u043A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0431\u043E\u043C\u0431:");
		label.setBounds(12, 559, 170, 16);
		frame.getContentPane().add(label);
		
		
	}
}
