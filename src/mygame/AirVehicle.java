package mygame;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AirVehicle implements ITransport {

protected int _startPosX;
protected int _startPosY;
protected int _pictureWidth;
protected int _pictureHeight;
public int MaxSpeed;
public float Weight;
public Color MainColor;
public Color DopColor;
public int GetStartPosX() {
	return _startPosX;
}
public int GetStartPosY() {
	return _startPosY;
}
public void SetMainColor(Color mainColor) {
	MainColor = mainColor;
}
public void SetDopColor(Color dopColor){
	DopColor = dopColor;
}
public Color GetMainColor() {
	return MainColor;
}
public Color GetDopColor() {
	return DopColor;
}
public void SetPosition(int x, int y, int width, int height) {
    _startPosX = x;
    _startPosY = y;
    _pictureWidth = width;
    _pictureHeight = height;
}

abstract public void MoveTransport(Direction direction);
abstract public void DrawPlane(Graphics g);
abstract public ITransport Clone();
}
