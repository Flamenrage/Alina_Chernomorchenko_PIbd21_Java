package mygame;

import java.awt.Color;
import java.awt.Graphics;

public interface ITransport {
    void SetPosition(int x, int y, int width, int height);
    void MoveTransport(Direction direction);
    void DrawPlane(Graphics g);
    void SetMainColor(Color color);
    void SetDopColor(Color color);
    Color GetMainColor();
    Color GetDopColor();
    int GetStartPosX();
    int GetStartPosY();
    ITransport Clone();
}
