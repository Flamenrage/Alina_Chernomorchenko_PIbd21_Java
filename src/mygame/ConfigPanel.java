package mygame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ConfigPanel extends JPanel {
	private ITransport plane;
	private IPatch patches;
	public ITransport getPlane() {
		return plane;
	}
	public void setPlane(ITransport plane) {
		this.plane = plane;
	}
	public IPatch getPatches() {
		return patches;
	}
	public void setPatches(IPatch patches) {
		this.patches = patches;
	}
	public void clearPatches() {
		patches = null;
	}
	public void clear() {
		plane = null;
		patches = null;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (plane != null) {
			plane.DrawPlane(g);
			if (patches != null) {
				g.setColor(Color.black);
				patches.SetPosition(plane.GetStartPosX(), plane.GetStartPosY());
				patches.Draw(g, plane.GetMainColor(), patches.GetPositionX(), patches.GetPositionY());
			}
		}
	}
}