package mygame;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PlaneDrawPanel extends JPanel {
	ITransport plane;

	
	public PlaneDrawPanel(ITransport input) {
		plane = input;
	}
	public void paint(Graphics g) {
		super.paint(g);
		plane.DrawPlane(g);
	}
}

