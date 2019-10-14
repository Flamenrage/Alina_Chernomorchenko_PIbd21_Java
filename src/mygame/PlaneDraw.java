package mygame;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PlaneDraw extends JPanel {
	BomberPlane plane;

	public PlaneDraw(BomberPlane plane) {
	this.plane = plane;
	}

	public void paint(Graphics g) {
	super.paint(g);
	plane.DrawPlane(g);
	}
}
