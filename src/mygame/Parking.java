package mygame;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Parking<T extends ITransport, U extends IPatch> {
	private T[] places;
	private U[] placesPatches;
	private int pictureWidth;
    private int pictureHeight;
    
	public int getPictureWidth() {
		return pictureWidth;
	}
	private void setPictureWidth(int pictureWidth) {
		this.pictureWidth = pictureWidth;
	}
	public int getPictureHeight() {
		return pictureHeight;
	}
	private void setPictureHeight(int pictureHeight) {
		this.pictureHeight = pictureHeight;
	}
	private final int placeSizeWidth = 210;
    private final int placeSizeHeight = 100;
    @SuppressWarnings("unchecked")
	public Parking(int sizes, int pictureWidth, int pictureHeight)
    {
        this.places = (T[]) new ITransport[sizes];
        this.placesPatches = (U[]) new IPatch[sizes];
        setPictureWidth(pictureWidth);
        setPictureHeight(pictureHeight);
        for (int i = 0; i < places.length; i++)
        {
            places[i] = null;
            placesPatches[i] = null;
            
        }
    }
    public int addPlane(T plane) {
    	for (int i = 0; i < places.length; i++)
        {
            if (this.CheckFreePlace(i))
            {
                places[i] = plane;
                places[i].SetPosition(5 + i / 5 * placeSizeWidth + 15, 
                    i % 5 * placeSizeHeight + 21, this.pictureWidth, this.pictureHeight);
                return i;
            }
        }
        return -1;
    }
	 public T Remove(int index) {
	    	
	    	if (index < 0 || index> places.length)
	        {
	            return null;
	        }
	        if (!this.CheckFreePlace(index))
	        {
	            T plane = places[index];
	            places[index] = null;
	            return plane;
	        }
	        return null;
	    }
  
    public void addMultiplyPlane (T plane, int k){
    	for (int i = 0; i<k; i++){
    		ITransport tr = plane.Clone();
    		addPlane((T)tr);
		}
    }
    public void RemoveMultiplyPlane (int k){
    	for (int i = k+1; i<20; i++){
    		Remove(i);
		}
    }
   
   
    public int addPlane(T plane, U patches) {
    	for (int i = 0; i < places.length; i++)
        {
            if (this.CheckFreePlace(i))
            {
                places[i] = plane;
                places[i].SetPosition(5 + i / 5 * placeSizeWidth + 15, 
                    i % 5 * placeSizeHeight + 21, this.pictureWidth, this.pictureHeight);
                placesPatches[i] = patches;
                placesPatches[i].SetPosition(5 + i / 5 * placeSizeWidth + 15,
                		i % 5 * placeSizeHeight + 21);
                return i;
            }
        }
        return -1;
    }
   
    public U RemovePatches(int index) {
    	if (index < 0 || index > places.length)
        {
            return null;
        }
        if (placesPatches[index] != null)
        {
            U box = placesPatches[index];
            placesPatches[index] = null;
            return box;
        }
        return null;
    }
    private boolean CheckFreePlace(int index)
    {
        return (places[index] == null);
    }
    public void Draw(Graphics g)
    {
    	DrawMarking(g);
        for (int i = 0; i < places.length; i++)
        {
            if (!CheckFreePlace(i))
            {
                places[i].DrawPlane(g);
                if (placesPatches[i] != null) {
                	placesPatches[i].Draw(g, places[i].GetMainColor(), placesPatches[i].GetPositionX(),
                			placesPatches[i].GetPositionY());
                }
            }
        }        
    }
    private void DrawMarking(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setStroke((new BasicStroke(3f)));
        g2.drawRect(0, 0, (places.length / 5) * placeSizeWidth, 500);
        for (int i = 0; i < places.length / 5; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                g2.drawLine(i * placeSizeWidth, j * placeSizeHeight,
                i * placeSizeWidth + 110, j * placeSizeHeight);
            }
            g2.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 500);
        }
        g2.setStroke((new BasicStroke(1f)));
    }
}