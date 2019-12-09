package mygame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PlaneBack implements IPatch {
	private NumberOfPatches numberOfPatches;

	public PlaneBack(int n) {
		switch (n) {
		case 1:
			numberOfPatches = NumberOfPatches.One;
			break;
		case 2:
			numberOfPatches = NumberOfPatches.Two;
			break;
		case 3:
			numberOfPatches = NumberOfPatches.Three;
			break;
		default:
			numberOfPatches = NumberOfPatches.Zero;
			break;
		}
	}
	@Override
	public void Draw(Graphics g, Color color, int startPosX, int startPosY) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5.0f));

		int a = 2;
		switch (numberOfPatches) {
		case One:
			g.setColor(color);
			g.drawRect(startPosX + 50/a, startPosY + 40/a, 30/a, 20/a); 
			g.setColor( new Color(255, 255, 0));
			g.fillRect(startPosX + 50/a, startPosY + 40/a, 30/a, 20/a); 
			g.setColor(Color.RED);
	         g.drawOval(startPosX +29/a, startPosY + 15/a, 33/a, 12/a); //
	         g.drawOval(startPosX + 29/a, startPosY + 83/a, 33/a, 12/a);
	      
	         g.fillOval(startPosX + 29/a, startPosY + 15/a, 33/a, 12/a);
	         g.fillOval( startPosX + 29/a, startPosY + 83/a, 33/a, 12/a);

			break;
		case Two:
			g.setColor(color);
			g.drawOval(startPosX + 105/a, startPosY - 6/a, 20/a, 30/a); // ������� �������
			g.drawOval(startPosX + 105/a, startPosY + 85 /a, 20/a, 30/a); // ������ �������
			g.setColor( new Color(255, 255, 0)); 
			g.fillOval(startPosX + 105/a, startPosY - 6/a, 20/a, 30/a);
			g.fillOval(startPosX + 105/a, startPosY + 85/a , 20/a, 30/a);
			g.setColor(Color.RED);
			break;
		case Three:
			g.setColor(color);
			g.drawOval(startPosX + 50/a, startPosY + 40/a, 30/a, 20/a); // ���
			g.drawOval(startPosX + 105/a, startPosY - 6/a, 20/a, 30/a); // ������� �������
			g.drawOval(startPosX + 105/a, startPosY + 85/a , 20/a, 30/a); // ������ �������
			g.setColor( new Color(255, 255, 0)); 
			g.fillOval(startPosX + 50/a, startPosY + 40/a, 30/a, 20/a); // ������
			g.fillOval(startPosX + 105/a, startPosY - 6/a, 20/a, 30/a);
			g.fillOval(startPosX + 105/a, startPosY + 85 /a, 20/a, 30/a);
			g.setColor(Color.RED);
			 g.drawOval(startPosX +29/a, startPosY + 15/a, 33/a, 12/a); //
	         g.drawOval(startPosX + 29/a, startPosY + 83/a, 33/a, 12/a);
	      
	         g.fillOval(startPosX + 29/a, startPosY + 15/a, 33/a, 12/a);
	         g.fillOval( startPosX + 29/a, startPosY + 83/a, 33/a, 12/a);
			break;
		default:
			break;
		}
		
	}
}
