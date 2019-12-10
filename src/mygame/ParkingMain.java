package mygame;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;

public class ParkingMain {
	
	private final int panelHangarWidth = 870;
	private final int panelHangarHeight = 560;
	private final int countLevels = 5;
	private MultiLevelParking hangar;
	private ArrayList<ITransport> bankPlane;
	private ArrayList<IPatch> bankPatches;
	private int bankIndex = 0;
	private ITransport plane;
	private IPatch patch;
	private JFrame frame;
	private JTextField textFieldIndex;
	private PanelParking panelHangar;
	private JButton buttonTakePlane;
	private PlaneTakePanel panelTake;
	private JList<String> list;
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
	}
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1270, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		hangar = new MultiLevelParking(countLevels,panelHangarWidth, panelHangarWidth);
		bankPlane = new ArrayList<>();
		bankPatches = new ArrayList<>();
		for (int i=0; i<20; i++){
			bankPlane.add(null);
		}
		for (int i=0; i<20; i++){
			bankPatches.add(null);
		}
		panelHangar = new PanelParking(hangar.getHangar(0));
		panelHangar.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHangar.setBounds(10, 34, panelHangarWidth, panelHangarHeight);
		String[] levels = new String[countLevels];
		for(int i = 0; i < countLevels; i++) {
			levels[i] = "Уровень " + (i + 1);
		}
		list = new JList(levels);
		list.setSelectedIndex(0);
		list.setBounds(1079, 30, 166, 186);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int index = list.getSelectedIndex();
				panelHangar.setHangar(hangar.getHangar(index));
				panelHangar.repaint();
			}
		});
		frame.getContentPane().add(list);
		frame.getContentPane().add(panelHangar);
		JButton btnAddPlane = new JButton("\u0417\u0430\u043A\u0430\u0437\u0430\u0442\u044C \u043A\u043E\u0440\u0430\u0431\u043B\u044C");
		btnAddPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaneConfig configFrame = new PlaneConfig();
				configFrame.frame.setVisible(true);
				configFrame.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				configFrame.initializeConfig(panelHangar, hangar, list);
			}
		});
		btnAddPlane.setBounds(892, 169, 147, 44);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(8, 0, 1006, 26);
		frame.getContentPane().add(menuBar);

		JMenu menuFile = new JMenu("\u0424\u0430\u0439\u043B");
		menuBar.add(menuFile);

		JMenuItem itemLoadAll = new JMenuItem("Загрузить все");
		itemLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("C:\\tmp\\file.txt"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый документ", "txt");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					if(hangar.loadData(chooser.getSelectedFile().getPath())) {
						JOptionPane.showMessageDialog(null, "Загружено");
						panelHangar.setHangar(hangar.getHangar(list.getSelectedIndex()));
						panelHangar.repaint();
					} else {
						JOptionPane.showMessageDialog(null, "Ошибка");
					}
				}
			}
		});
		menuFile.add(itemLoadAll);

		JMenuItem mItemSaveAll = new JMenuItem("Сохранить все");
		mItemSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("C:\\tmp\\file.txt"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый документ","txt");
				chooser.setFileFilter(filter);
				int result = chooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					if (hangar.saveData(chooser.getSelectedFile().getPath())) {
						JOptionPane.showMessageDialog(null, "Сохранено");
					}else {
						JOptionPane.showMessageDialog(null, "Ошибка");
					}
				}
			}
		});

		JMenuItem menuItemLoadLevel = new JMenuItem("Загрузить уровень");
		menuItemLoadLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("C:\\tmp\\fileLevel.txt"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый документ","txt");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					if(hangar.loadLevelData(chooser.getSelectedFile().getPath(), list.getSelectedIndex())) {
						JOptionPane.showMessageDialog(null, "Загружено");
						panelHangar.setHangar(hangar.getHangar(list.getSelectedIndex()));
						panelHangar.repaint();
					} else {
						JOptionPane.showMessageDialog(null, "Ошибка");
					}
				}
			}
		});
		menuFile.add(menuItemLoadLevel);
		menuFile.add(mItemSaveAll);

		JMenuItem menuItemSaveLevel = new JMenuItem("Сохранить уровень");
		menuItemSaveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("C:\\tmp\\fileLevel.txt"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовый документ", "txt");
				chooser.setFileFilter(filter);
				int result = chooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					if (hangar.saveLevelData(chooser.getSelectedFile().getPath(), list.getSelectedIndex())) {
						JOptionPane.showMessageDialog(null, "Сохранено");
					}else {
						JOptionPane.showMessageDialog(null, "Ошибка");
					}
				}
			}
		});
		menuFile.add(menuItemSaveLevel);
		frame.getContentPane().add(btnAddPlane);
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
					
					plane = hangar.getPlane(list.getSelectedIndex(),Integer.parseInt(textFieldIndex.getText()));
					
					if (plane != null) {
						panelTake.clear();
						bankPlane.set(bankIndex, plane);
						patch = hangar.getPatches(list.getSelectedIndex(), Integer.parseInt(textFieldIndex.getText()));
						if (patch != null) {
							panelTake.drawplane(plane, patch);
							bankPatches.set(bankIndex, patch);
						} else {
							panelTake.drawplane(plane);
						}
						bankIndex++;
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
		JButton button_view_collection = new JButton("\u041A\u043E\u043B\u043B\u0435\u043A\u0446\u0438\u044F");
		button_view_collection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyCollectionInfo info = new MyCollectionInfo();
				info.viewMyCollection(bankPlane, bankPatches);
				info.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				info.setVisible(true);
			}
		});
		button_view_collection.setBounds(1015, 294, 119, 23);
		frame.getContentPane().add(button_view_collection);
		}
	}