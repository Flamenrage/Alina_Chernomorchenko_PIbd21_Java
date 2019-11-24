package mygame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class ParkingMain {
	
	private final int panelHangarWidth = 870;
	private final int panelHangarHeight = 560;
	private Parking<ITransport, IPatch> hangar;
	private ITransport plane;
	private IPatch patch;
	private JFrame frame;
	private JTextField textFieldIndex;
	private PanelParking panelHangar;
	private JButton buttonParkPlane;
	private JButton buttonParkBomberPlane;
	private JButton buttonTakePlane;
	private PlaneTakePanel panelTake;
	private JLabel ParkLabel;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingMain window = new ParkingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParkingMain() {
		initialize();
		initializeHangarPanel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1267, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		hangar = new Parking<ITransport, IPatch>(20, panelHangarWidth, panelHangarWidth);
		
		buttonParkPlane = new JButton("Самолет");
		buttonParkPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(frame, "Выберите основной цвет", Color.gray);
				if (newColor != null) {
					plane = new WarPlane(100, 1000, newColor);
					
					int place = hangar.addPlane(plane);
					
					panelHangar.repaint();
				}
			}
		});
		buttonParkPlane.setBounds(901, 70, 166, 55);
		frame.getContentPane().add(buttonParkPlane);
		
		buttonParkBomberPlane = new JButton("Бомбардировщик");
		buttonParkBomberPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, "Выберите основной цвет", Color.gray);
				if (mainColor != null) {
					Color dopColor = JColorChooser.showDialog(frame, "Выберите дополонительный цвет", Color.red);
					if (dopColor != null) {
						plane = new BomberPlane(100, 100, 
								mainColor, dopColor, 10, true, true);
						
						Random rnd = new Random();
						switch (rnd.nextInt(3)) {
							case 0:
								patch = new PlanePatches(3);
								break;
							case 1:
								patch = new PlaneMiddle(3);
								break;
							case 2:
								patch = new PlaneBack(3);
								break;
						}
						
						int place = hangar.addPlane(plane, patch);
					
						panelHangar.repaint();
						
					}					
				}
			}
		});
		buttonParkBomberPlane.setBounds(901, 131, 166, 55);
		frame.getContentPane().add(buttonParkBomberPlane);
		
		JLabel label_1 = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label_1.setBounds(901, 267, 48, 14);
		frame.getContentPane().add(label_1);
		
		textFieldIndex = new JTextField();
		textFieldIndex.setBounds(961, 264, 58, 20);
		frame.getContentPane().add(textFieldIndex);
		textFieldIndex.setColumns(10);
		
		buttonTakePlane = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		buttonTakePlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIndex.getText() != "") {
					plane = hangar.Remove(Integer.parseInt(textFieldIndex.getText()));
					if (plane != null) {
						panelTake.clear();
						patch = hangar.RemovePatches(Integer.parseInt(textFieldIndex.getText()));
						if (patch != null) {
							panelTake.drawplane(plane, patch);
						} else {
							panelTake.drawplane(plane);
						}
						panelTake.plane.SetPosition(50, 50, panelHangarWidth, panelHangarHeight);
						panelHangar.repaint();
						panelTake.repaint();
					}
				}
			}
		});
		buttonTakePlane.setBounds(901, 294, 119, 23);
		frame.getContentPane().add(buttonTakePlane);
		
		panelTake = new PlaneTakePanel();
		panelTake.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTake.setBounds(901, 330, 185, 186);
		frame.getContentPane().add(panelTake);
	}
	public void initializeHangarPanel(){
		panelHangar = new PanelParking(hangar);
		panelHangar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHangar.setBounds(10, 11, panelHangarWidth, panelHangarHeight);
		frame.getContentPane().add(panelHangar);
		
		ParkLabel = new JLabel("Припарковать:");
		ParkLabel.setBounds(901, 36, 100, 16);
		frame.getContentPane().add(ParkLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0435\u0442", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(892, 238, 208, 295);
		frame.getContentPane().add(panel);
	
		btnNewButton_1 = new JButton("Убрать несколько");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIndex.getText() != "") {
					panelTake.clear();		
					int k = Integer.parseInt(textFieldIndex.getText());
					plane = hangar.Remove(k);	
					panelTake.clear();
					panelTake.drawplane(plane);
					panelTake.plane.SetPosition(50, 50, panelHangarWidth, panelHangarHeight);
					panelHangar.repaint();
					panelTake.repaint();
					hangar.RemoveMultiplyPlane(k);	
					panelHangar.repaint();
					}
				}
			
		});
		btnNewButton_1.setBounds(901, 529, 147, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Добавить несколько");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int k = 3;
				ITransport plane;
				Color newColor = JColorChooser.showDialog(frame, "Выберите основной цвет", Color.gray);
				if (newColor != null) {
					plane = new WarPlane(100, 1000, newColor);
					
				    hangar.addMultiplyPlane(plane, k);
					
					panelHangar.repaint();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setBounds(1070, 85, 167, 25);
		
		
		btnNewButton = new JButton("Добавить несколько");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = 3;
				ITransport plane;
				Color newColor = JColorChooser.showDialog(frame, "Выберите основной цвет", Color.gray);
				if (newColor != null) {

				for (int i = 0; i<k; i++){
				plane = new WarPlane(100, 1000, newColor);
				int place = hangar.addPlane(plane);
				panelHangar.repaint();
				}
				}
				
			}
		});
		//btnNewButton.setBounds(901, 529, 166, 25);
		//frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Добавить несколько");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, "Выберите основной цвет", Color.gray);
				if (mainColor != null) {
					Color dopColor = JColorChooser.showDialog(frame, "Выберите дополонительный цвет", Color.red);
					if (dopColor != null) {
						plane = new BomberPlane(100, 100, 
								mainColor, dopColor, 10, true, true);
						int k = 3;
						hangar.addMultiplyPlane(plane, k);
					
						panelHangar.repaint();
						
					}					
				}
			}
		});
		button.setBounds(1070, 147, 167, 23);
		frame.getContentPane().add(button);
		//btnNewButton_2.setOpaque(false);
		//btnNewButton_2.setContentAreaFilled(false);
		//btnNewButton_2.setBorderPainted(false);
	}
}