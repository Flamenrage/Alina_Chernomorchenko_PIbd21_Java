package mygame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class MyCollectionInfo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;
	public static void main(String[] args) {
		try {
			MyCollectionInfo dialog = new MyCollectionInfo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MyCollectionInfo() {
		setBounds(100, 100, 900, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textArea = new JTextArea();
			textArea.setBounds(10, 11, 900, 500);
			contentPanel.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	public void viewMyCollection(ArrayList<ITransport> a_1, ArrayList<IPatch> a_2) {
		String res = "";
		for (int i = 0; i < a_1.size(); i++) {
			res = res + a_1.get(i) + "\n" + a_2.get(i) + "\n";
		}
		textArea.setText(res);
	}

}