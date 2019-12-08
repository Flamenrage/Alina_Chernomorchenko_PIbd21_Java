package mygame;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

@SuppressWarnings("serial")
public class DopColorTrHd extends TransferHandler {
	private ConfigPanel panel;
	public int getSourceActions(JComponent c) {
	    return COPY_OR_MOVE;
	}
	public Transferable createTransferable(JComponent c) {
		JTextField textField = (JTextField)c;
	    return new StringSelection(textField.getText());
	}
	public boolean canImport(TransferSupport supp) {
		return supp.isDataFlavorSupported(DataFlavor.stringFlavor);
	}
	public void setPanel(ConfigPanel panel) {
		this.panel = panel;
	}
	public boolean importData(TransferSupport supp) {
		if (!supp.isDrop())
			return false;
		BomberPlane plane = (BomberPlane) panel.getPlane();
		String data;
		try {
				data = (String)supp.getTransferable().getTransferData(DataFlavor.stringFlavor);
				switch(data) {
				case "Серый":
					plane.SetDopColor(Color.gray);
					break;
				case "Розовый":
					plane.SetDopColor(Color.pink);
					break;
				case "Красный":
					plane.SetDopColor(Color.red);
					break;
				case "Фиолетовый":
					plane.SetDopColor(Color.magenta);
					break;
				case "Рыжий":
					plane.SetDopColor(Color.orange);
					break;
				case "Желтый":
					plane.SetDopColor(Color.yellow);
					break;
			}
		}catch(Exception e) {
			return false;
		}
	
	panel.repaint();
	return true;
	}
}


