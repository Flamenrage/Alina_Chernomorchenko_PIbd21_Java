package mygame;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WarPlane extends AirVehicle{
	protected int planeWidth = 200;

    protected  int planeHeight = 150;
    
    protected IPatch planepatches;
    public WarPlane(int maxSpeed, float weight, Color mainColor)
    {
    	MaxSpeed = maxSpeed;
	    Weight = weight;
	    MainColor = mainColor;
	   
	   
    }
    @Override
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - planeWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - planeHeight)

                {
                    _startPosY += step;
                }
                break;
        }
    }
    @Override
    public void DrawPlane(Graphics g)
    {
    	int a = 2;
    	g.setColor(Color.black);
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setStroke(new BasicStroke(5.0f));
    	g.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5.0f));
		g2.drawOval( _startPosX + 20/a, _startPosY + 33/a, 140/a, 44/a); // тело
		g2.drawRect( _startPosX + 30/a, _startPosY + 23/a, 20/a, 64/a); // хвост
		g2.drawOval( _startPosX + 100/a, _startPosY - 32/a, 30/a, 180/a); //крыло
		g.setColor(MainColor);
		g.fillOval(_startPosX + 20/a, _startPosY + 33/a, 140/a, 44/a); //br
		g.fillRect( _startPosX + 30/a, _startPosY + 23/a, 20/a, 64/a); //br
		g.fillOval( _startPosX + 100/a, _startPosY - 32/a, 30/a, 180/a); //br
		g2.setStroke(new BasicStroke(5.0f)); // окошко
		g.setColor(Color.BLACK);
		g.drawOval(_startPosX + 90/a, _startPosY + 40/a, 30/a, 20/a);
		g.setColor( new Color(0, 236, 255));
		g.fillOval(_startPosX + 90/a, _startPosY + 40/a, 30/a, 20/a);
		
    }
}
