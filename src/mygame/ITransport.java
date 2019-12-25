package mygame;

import java.awt.Color;
import java.awt.Graphics;

public interface ITransport {

	void SetPosition(int x, int y, int width, int height);
    
    void MoveTransport(Direction direction);

	void DrawPlane(Graphics g);
	Color GetMainColor();
    Color GetDopColor();
    int GetStartPosX();
    int GetStartPosY();
    ITransport Clone();
}
