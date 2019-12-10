package mygame;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;
public class PlaneConfig {

	public JFrame frame;

	private ConfigPanel panelPlane;
	private PanelParking thisHangarPanel;
	private MultiLevelParking thisHangar;
	private JList<String> thisList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaneConfig window = new PlaneConfig();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void initializeConfig(PanelParking thisHangarPanel, MultiLevelParking thisHangar,
			JList<String> thisList) {
		this.thisHangarPanel = thisHangarPanel;
		this.thisHangar = thisHangar;
		this.thisList = thisList;
	}
	/**
	 * Create the application.
	 */
	public PlaneConfig() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Drag&Drop");
		frame.setBounds(100, 100, 594, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelPlane = new ConfigPanel();
		panelPlane.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPlane.setBounds(162, 43, 188, 150);
		ConfigPanelTrHd transHandConfig = new ConfigPanelTrHd();
		panelPlane.setTransferHandler(transHandConfig);
		frame.getContentPane().add(panelPlane);
		
		JLabel label = new JLabel("Выберите вид:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 13, 137, 18);
		frame.getContentPane().add(label);
		
		JList<String> listPlanes = new JList<String>();
		listPlanes.setBounds(10, 43, 99, 104);
		listPlanes.setBorder(new LineBorder(new Color(0, 0, 0)));
		listPlanes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		dlm.addElement("Самолет");
		dlm.addElement("Бомбардировщик");
		listPlanes.setModel(dlm);
		listPlanes.setDragEnabled(true);
		frame.getContentPane().add(listPlanes);
		
		JLabel labelMainColor = new JLabel("\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0446\u0432\u0435\u0442");
		labelMainColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMainColor.setBounds(162, 206, 188, 23);
		labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		MainColorTrHd thMainColor = new MainColorTrHd();
		thMainColor.setPanel(panelPlane);
		labelMainColor.setTransferHandler(thMainColor);
		frame.getContentPane().add(labelMainColor);
		
		JLabel labelDopColor = new JLabel("\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0446\u0432\u0435\u0442");
		labelDopColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDopColor.setBounds(162, 242, 188, 23);
		labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDopColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		DopColorTrHd thDopColor = new DopColorTrHd();
		thDopColor.setPanel(panelPlane);
		labelDopColor.setTransferHandler(thDopColor);
		frame.getContentPane().add(labelDopColor);
		
		JList<String> listPatches = new JList<String>();
		listPatches.setBounds(10, 187, 99, 118);
		DefaultListModel<String> dlmPatch = new DefaultListModel<String>();
		dlmPatch.addElement("Орнамент 1");
		dlmPatch.addElement("Орнамент 2");
		dlmPatch.addElement("Орнамент 3");
		listPatches.setModel(dlmPatch);
		listPatches.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPatches.setDragEnabled(true);
		listPatches.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(listPatches);
		
		JLabel labelColor = new JLabel("\u0426\u0432\u0435\u0442\u0430");
		labelColor.setBounds(400, 16, 79, 14);
		frame.getContentPane().add(labelColor);
		
		JLabel label_type = new JLabel("Выберите орнамент:");
		label_type.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_type.setBounds(10, 160, 140, 14);
		frame.getContentPane().add(label_type);
		
		JScrollPane scrollPaneColors = new JScrollPane();
		scrollPaneColors.setBounds(400, 45, 103, 60);
		frame.getContentPane().add(scrollPaneColors);
		
		JList<String> listColors = new JList<String>();
		scrollPaneColors.setViewportView(listColors);
		DefaultListModel<String> dlmColor = new DefaultListModel<String>();
		dlmColor.addElement("Серый");
		dlmColor.addElement("Розовый");
		dlmColor.addElement("Красный");
		dlmColor.addElement("Фиолетовый");
		dlmColor.addElement("Оранжевый");
		dlmColor.addElement("Желтый");
		listColors.setModel(dlmColor);
		listColors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listColors.setDragEnabled(true);
		listColors.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnAccept = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((panelPlane.getPlane() != null) && (panelPlane.getPatches() != null)) {
					thisHangar.getHangar(thisList.getSelectedIndex()).addPlane(panelPlane.getPlane(), panelPlane.getPatches());
					thisHangarPanel.repaint();
				}else if((panelPlane.getPlane() != null) && (panelPlane.getPatches() == null)) {
					thisHangar.getHangar(thisList.getSelectedIndex()).addPlane(panelPlane.getPlane());
					thisHangarPanel.repaint();
				}
				frame.dispose();
			}
		});
		btnAccept.setBounds(380, 207, 99, 23);
		frame.getContentPane().add(btnAccept);
		
		JButton buttonCancel = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		buttonCancel.setBounds(380, 243, 99, 23);
		frame.getContentPane().add(buttonCancel);
	}
}
