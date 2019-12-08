package mygame;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

@SuppressWarnings("serial")
public class ConfigPanelTrHd  extends TransferHandler {
	private ITransport plane;
	
	public Transferable createTransferable(JComponent c) {
		JTextField textField = (JTextField)c;
	    return new StringSelection(textField.getText());
	}
	public int getSourceActions(JComponent c) {
	    return COPY_OR_MOVE;
	}
	public boolean canImport(TransferSupport supp) {
		return supp.isDataFlavorSupported(DataFlavor.stringFlavor);
	}
	public ITransport getPlane() {
		return plane;
	}
	public boolean importData(TransferSupport supp) {
		if(!supp.isDrop()) {
			return false;
		}	

		ConfigPanel panelPlane = (ConfigPanel)supp.getComponent();
		String data;
		try {
			data = (String)supp.getTransferable().getTransferData(
					DataFlavor.stringFlavor);
			switch(data) {
				case "Орнамент 1":
					if(plane instanceof BomberPlane) {
						panelPlane.clearPatches();
						panelPlane.setPatches(new PlanePatches(3));
					}
					break;
				case "Орнамент 2":
					if(plane instanceof BomberPlane) {
						panelPlane.clearPatches();
						panelPlane.setPatches(new PlaneMiddle(3));
					}
					break;
				case "Орнамент 3":
					if(plane instanceof BomberPlane) {
						panelPlane.clearPatches();
						panelPlane.setPatches(new PlaneBack(3));
					}
					break;
				case "Самолет":
					panelPlane.clear();
					plane = new WarPlane(50, 200, Color.white);
					plane.SetPosition(panelPlane.getX() - 100, panelPlane.getY() + 20,
							panelPlane.getWidth(), panelPlane.getHeight());
					panelPlane.setPlane(plane);
					break;
				case "Бомбардировщик":
					panelPlane.clear();
					plane = new BomberPlane(50, 200, Color.white, Color.white, 10, true, false);
					plane.SetPosition(panelPlane.getX()- 100, panelPlane.getY() + 20, 
							panelPlane.getWidth(), panelPlane.getHeight());
					panelPlane.setPlane(plane);
					break;
			}
		}catch(Exception e) {
			return false;
		}
		panelPlane.repaint();
		panelPlane.repaint();
		return true;
	}
}
