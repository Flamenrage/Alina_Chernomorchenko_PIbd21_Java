package mygame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BomberPlane extends WarPlane {


	public Color DopColor;
    public int Bombs;
    public boolean Shoot;
    public boolean BackBombs;

	public BomberPlane(int maxSpeed, float weight, Color mainColor, Color dopColor,
			int bombs, boolean shoot, boolean backBombs) {
		super(maxSpeed, weight, mainColor);
        DopColor = dopColor;
        Bombs = bombs;
        Shoot = shoot;
        BackBombs = backBombs;
        planepatches = new PlanePatches(3);
	}
	public void DrawPlane(Graphics g)
	{
		int a = 2;
	g.setColor(Color.black);
	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(5.0f));
	
	if (Bombs >= 6)
	{
	g2.drawOval(_startPosX + 133/a, _startPosY - 30/a, 15/a, 10/a);
	g2.drawOval(_startPosX + 140/a, _startPosY - 5/a, 15/a, 10/a);
	g2.drawOval(_startPosX + 140/a, _startPosY + 20/a, 15/a, 10/a);
	
	g2.drawOval(_startPosX + 133/a, _startPosY + 130/a, 15/a, 10/a);
	g2.drawOval(_startPosX + 140/a, _startPosY + 105/a, 15/a, 10/a);
	g2.drawOval(_startPosX + 140/a, _startPosY + 80/a, 15/a, 10/a);
	
	
	g.setColor(DopColor);
	
	
	g2.fillOval(_startPosX + 133/a, _startPosY - 30/a, 15/a, 10/a);
	g2.fillOval(_startPosX + 140/a, _startPosY - 5/a, 15/a, 10/a);
	g2.fillOval(_startPosX + 140/a, _startPosY + 20/a, 15/a, 10/a);
	
	g2.fillOval(_startPosX + 133/a, _startPosY + 130/a, 15/a, 10/a);
	g2.fillOval(_startPosX + 140/a, _startPosY + 105/a, 15/a, 10/a);
	g2.fillOval(_startPosX + 140/a, _startPosY + 80/a, 15/a, 10/a);
	g2.setStroke(new BasicStroke(5.0f));
	
	switch (Bombs){
			
		case 6:
		break;
		case 7:
		
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
				
			g.setColor(DopColor);
			g2.fillOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
			
		break;
		case 8:
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
			g2.drawOval(_startPosX + 80/a, _startPosY + 5/a, 15/a, 10/a);
			
			g.setColor(DopColor);
			g2.fillOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
			g2.fillOval(_startPosX + 80/a, _startPosY + 5/a, 15/a, 10/a);
				
		break;
		case 9:
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
			g2.drawOval(_startPosX + 80/a, _startPosY + 5/a, 15/a, 10/a);
			g2.drawOval(_startPosX + 80/a, _startPosY + 90/a, 15/a, 10/a);
			g.setColor(DopColor);
			g2.fillOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
			g2.fillOval(_startPosX + 80/a, _startPosY + 5/a, 15/a, 10/a);
			g2.fillOval(_startPosX + 80/a, _startPosY + 90/a, 15/a, 10/a); 
			break;
			
		case 10:
			g.setColor(Color.BLACK);
			g2.drawOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
			g2.drawOval(_startPosX + 80/a, _startPosY + 5/a, 15/a, 10/a);
			g2.drawOval(_startPosX + 80/a, _startPosY + 90/a, 15/a, 10/a);
			g2.drawOval(_startPosX + 83/a, _startPosY + 112/a, 15/a, 10/a);
				
			g.setColor(DopColor);
			g2.fillOval(_startPosX + 83/a, _startPosY - 18/a, 15/a, 10/a);
			g2.fillOval(_startPosX + 80/a, _startPosY + 5/a, 15/a, 10/a);
			g2.fillOval(_startPosX + 80/a, _startPosY + 90/a, 15/a, 10/a);
			g2.fillOval(_startPosX + 83/a, _startPosY + 112/a, 15/a, 10/a); 
		break;
			
		}	
	 }
	 super.DrawPlane(g);
	 if (Shoot)
     { 	 g.setColor(DopColor);
         g.drawRect(_startPosX + 30/a, _startPosY + 18/a, 25/a, 5/a);
         g.drawRect(_startPosX + 30/a, _startPosY + 85/a, 25/a, 5/a);
         
         g.fillRect(_startPosX + 30/a, _startPosY + 18/a, 25/a, 5/a);
         g.fillRect( _startPosX + 30/a, _startPosY + 85/a, 25/a, 5/a);
     }
	 if (BackBombs){
	    Color myDopColor =  new Color(204, 0, 0);
		planepatches.Draw(g, myDopColor, _startPosX, _startPosY);		
	 }
	 }
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction) {
            case Right:
                if (_startPosX + step < _pictureWidth - planeWidth) {
                    _startPosX += step;

                }
                break;
            case Left:
                if (_startPosX - step > 5) {
                    _startPosX -= step;
                }
                break;
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            case Down:
                if (_startPosY + step < _pictureHeight - planeHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    @Override
    public ITransport Clone(){
    	ITransport tr = new BomberPlane(this.MaxSpeed, this.Weight, this.MainColor, this.DopColor,
    			this.Bombs, this.Shoot, this.BackBombs);
    	return tr;
    }
}
