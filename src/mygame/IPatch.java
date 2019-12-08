package mygame;

import java.awt.Color;
import java.awt.Graphics;

public interface IPatch {
	void Draw(Graphics g, Color color, int startPosX, int startPosY);
	public void SetPosition(int positionX, int positionY);
	public int GetPositionX();
	public int GetPositionY();
	public String toString();

}
