package mygame;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class PlaneTakePanel extends JPanel {
	ITransport plane;
	IPatch patch;
	public void drawplane(ITransport plane) {
		this.plane = plane;
	}
	public void drawplane(ITransport plane, IPatch patch) {
		this.plane = plane;
		this.patch = patch;
	}
	public void clear() {
		plane = null;
		patch = null;
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (plane != null) {
			plane.DrawPlane(g);
			if (patch != null) {
				patch.SetPosition(plane.GetStartPosX(), plane.GetStartPosY());
				patch.Draw(g,plane.GetMainColor(), patch.GetPositionX(), patch.GetPositionY());
			}
		}
	}
}
