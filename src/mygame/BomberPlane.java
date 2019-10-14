package mygame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BomberPlane {

	private int _startPosX;

	private int _startPosY;

	private int _pictureWidth;

	private int _pictureHeight;

	private int carWidth = 200;

	private int carHeight = 200;



	private int velocity;
	public void SetMaxSpeed(int velocity) {
	    this.velocity = velocity;

	}
	public int GetMaxSpeed() {
	    return velocity;
	}
	private float massa;
	public void SetWeight(float massa) {
	    this.massa = massa;

	}

	public float GetWeight() {
	    return massa;
	}

	private Color mcolor;
	public void SetMainColor(Color mcolor) {
	    this.mcolor = mcolor;

	}
	public Color GetMainColor() {
	    return mcolor;
	}
	private Color dcolor;
	public void SetDopColor(Color dcolor) {
	    this.dcolor = dcolor;

	}
	public Color GetDopColor() {
	    return dcolor;
	}
	private int shell;
	public void SetBombs(int shell) {
	    this.shell = shell;

	}
	public int GetBombs() {
	    return shell;

	}
	private boolean yellowshell;

	public void SetShoot(boolean yellowshell) {
	    this.yellowshell = yellowshell;

	}
	public boolean GetShoot() {
	    return yellowshell;

	}



	public BomberPlane(int maxSpeed, float weight, Color mainColor, Color dopColor, int bombs, boolean shoot) {
	    SetMaxSpeed(maxSpeed);
	    SetWeight(weight);
	    SetMainColor(mainColor);
	    SetDopColor(dopColor);
	    SetBombs(bombs);
	    SetShoot(shoot);
	}

	public void SetPosition(int x, int y, int width, int height) {
	    _startPosX = x;
	    _startPosY = y;
	    _pictureWidth = width;
	    _pictureHeight = height;
	}
	public void MoveTransport(Direction direction) {
	    float step = GetMaxSpeed() * 100 / GetWeight();
	    switch (direction) {
	        // вправо
	        case Right:
	            if (_startPosX + step < _pictureWidth - carWidth) {
	                _startPosX += step;
	            }
	            break;
	            //влево
	        case Left:
	            if (_startPosX - step > 0) {
	                _startPosX -= step;
	            }
	            break;
	            //вверх
	        case Up:
	            if (_startPosY - step > 30) {
	                _startPosY -= step;
	            }
	            break;
	            //вниз
	        case Down:
	            if (_startPosY + step < _pictureHeight - carHeight) {
	                _startPosY += step;
	            }
	            break;
	    }
	}
	int count;
	public void DrawPlane(Graphics g)
	{
	
	
	g.setColor(Color.black);
	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(5.0f));
	
	if (GetBombs() >= 6)
	{
	g2.drawOval(_startPosX + 133, _startPosY - 30, 15, 10);
	g2.drawOval(_startPosX + 140, _startPosY - 5, 15, 10);
	g2.drawOval(_startPosX + 140, _startPosY + 20, 15, 10);
	
	g2.drawOval(_startPosX + 133, _startPosY + 130, 15, 10);
	g2.drawOval(_startPosX + 140, _startPosY + 105, 15, 10);
	g2.drawOval(_startPosX + 140, _startPosY + 80, 15, 10);
	
	
	g.setColor(Color.RED);
	
	
	g2.fillOval(_startPosX + 133, _startPosY - 30, 15, 10);
	g2.fillOval(_startPosX + 140, _startPosY - 5, 15, 10);
	g2.fillOval(_startPosX + 140, _startPosY + 20, 15, 10);
	
	g2.fillOval(_startPosX + 133, _startPosY + 130, 15, 10);
	g2.fillOval(_startPosX + 140, _startPosY + 105, 15, 10);
	g2.fillOval(_startPosX + 140, _startPosY + 80, 15, 10);
	g2.setStroke(new BasicStroke(5.0f));
	
	switch (GetBombs()){
			
		case 6:
		
		break;
		case 7:
		
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83, _startPosY - 18, 15, 10);
				
			g.setColor(Color.RED);
			g2.fillOval(_startPosX + 83, _startPosY - 18, 15, 10);
			
		break;
		case 8:
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83, _startPosY - 18, 15, 10);
			g2.drawOval(_startPosX + 80, _startPosY + 5, 15, 10);
			
			g.setColor(Color.RED);
			g2.fillOval(_startPosX + 83, _startPosY - 18, 15, 10);
			g2.fillOval(_startPosX + 80, _startPosY + 5, 15, 10);
				
		break;
		case 9:
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83, _startPosY - 18, 15, 10);
			g2.drawOval(_startPosX + 80, _startPosY + 5, 15, 10);
			g2.drawOval(_startPosX + 80, _startPosY + 90, 15, 10);
			g.setColor(Color.RED);
			g2.fillOval(_startPosX + 83, _startPosY - 18, 15, 10);
			g2.fillOval(_startPosX + 80, _startPosY + 5, 15, 10);
			g2.fillOval(_startPosX + 80, _startPosY + 90, 15, 10); 
			break;
			
		case 10:
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83, _startPosY - 18, 15, 10);
			g2.drawOval(_startPosX + 80, _startPosY + 5, 15, 10);
			g2.drawOval(_startPosX + 80, _startPosY + 90, 15, 10);
			g2.drawOval(_startPosX + 83, _startPosY + 112, 15, 10);
				
			g.setColor(Color.RED);
			g2.fillOval(_startPosX + 83, _startPosY - 18, 15, 10);
			g2.fillOval(_startPosX + 80, _startPosY + 5, 15, 10);
			g2.fillOval(_startPosX + 80, _startPosY + 90, 15, 10);
			g2.fillOval(_startPosX + 83, _startPosY + 112, 15, 10); 
		break;
			
		}
		g2.setStroke(new BasicStroke(5.0f));
			
			
		}
			g.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(5.0f));
			g2.drawOval( _startPosX + 20, _startPosY + 33, 140, 44); // тело
			g2.drawRect( _startPosX + 30, _startPosY + 23, 20, 64); // хвост
			
			g2.drawOval( _startPosX + 100, _startPosY - 32, 30, 180); //крыло
			g.setColor(GetMainColor());
			
			
			
			g.fillOval(_startPosX + 20, _startPosY + 33, 140, 44); //br
			g.fillRect( _startPosX + 30, _startPosY + 23, 20, 64); //br
			g.fillOval( _startPosX + 100, _startPosY - 32, 30, 180); //br
			
			if (GetShoot())
			{
			g2.setStroke(new BasicStroke(5.0f));
			g.setColor(Color.BLACK);
			g.drawOval(_startPosX + 90, _startPosY + 40, 30, 20);
			g.setColor( new Color(0, 236, 255));
			g.fillOval(_startPosX + 90, _startPosY + 40, 30, 20);
			}
		
		}

}
