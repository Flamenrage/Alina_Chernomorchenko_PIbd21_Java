package mygame;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

public class Parking<T extends ITransport, U extends IPatch> {
	private HashMap<Integer, T> places;
	private HashMap<Integer, U> placesPatches;
	private int pictureWidth;
    private int pictureHeight;
    public int maxCount;

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
    public T getPlace(int i) {
    	if (places.containsKey(i)){
		return places.get(i);}
    	 else return null;
	}
	public U getPlacesPatches(int i) {
		if (placesPatches.containsKey(i)){
		return placesPatches.get(i);}
		 else return null;    	
	}
	public Parking(int sizes, int pictureWidth, int pictureHeight)
    {
		this.places = new HashMap<>(sizes);
	    this.placesPatches = new HashMap<>(sizes);
        setPictureWidth(pictureWidth);
        setPictureHeight(pictureHeight);
        this.maxCount = sizes;
    }
    public int addPlane(T plane) {
    	for (int i = 0; i < maxCount; i++)
        {
            if (CheckFreePlace(i))
            {
            	  places.put(i, plane);
                  places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 15, 
                    i % 5 * placeSizeHeight + 21, this.pictureWidth, this.pictureHeight);
                return i;
            }
        }
        return -1;
    }
    public int AddPlane(T plane, int index) {
    	if (CheckFreePlace(index)) {
    		places.put(index, plane);
    		places.get(index).SetPosition(5 + index / 5 * placeSizeWidth + 15, 
                    index % 5 * placeSizeHeight + 21, pictureWidth, pictureHeight);
    		return index;
    	}
    	return -1;
    }    
    public int AddPlane(T plane, U patches, int index) {
    	if (CheckFreePlace(index)) {
    		places.put(index, plane);
    		places.get(index).SetPosition(5 + index / 5 * placeSizeWidth + 15, 
                    index % 5 * placeSizeHeight + 21, pictureWidth, pictureHeight);
    		placesPatches.put(index, patches);
    		placesPatches.get(index).SetPosition(places.get(index).GetStartPosX(),
            		places.get(index).GetStartPosY());
    		return index;
    	}
    	return -1;
    }
	 public T Remove(int index) {
	    	
		 if (index < 0 || index> maxCount)
	        {
	            return null;
	        }
	        if (places.containsKey(index))
	        {
	        	T plane = places.get(index);
	            places.remove(index);
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
    	for (int i = 0; i < maxCount; i++)
        {
            if (CheckFreePlace(i))
            {
            	places.put(i, plane);
                places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 15, 
                    i % 5 * placeSizeHeight + 21, this.pictureWidth, this.pictureHeight);
                placesPatches.put(i, patches);
                placesPatches.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 15,
                		i % 5 * placeSizeHeight + 21);
                return i;
            }
        }
        return -1;
    }
   
    public U RemovePatches(int index) {
    	if (index < 0 || index > maxCount)
        {
            return null;
        }
        if (placesPatches.containsKey(index))
        {
        	U box = placesPatches.get(index);
        	placesPatches.remove(index);
        	return box;
        }
        return null;
    }
    private boolean CheckFreePlace(int index)
    {
    	return !(places.containsKey(index));
    }
    public void Draw(Graphics g)
    {
     DrawMarking(g);
   	 for (int i = 0; i < maxCount; i++)
       {
           if (!CheckFreePlace(i))
           {
               places.get(i).DrawPlane(g);
               if (placesPatches.containsKey(i)) {
               	placesPatches.get(i).Draw(g, places.get(i).GetMainColor(), placesPatches.get(i).GetPositionX(),
               			placesPatches.get(i).GetPositionY());
               }
           }
       }        
    }
    private void DrawMarking(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setStroke((new BasicStroke(3f)));
        g2.drawRect(0, 0, (maxCount / 5) * placeSizeWidth, 500);
        for (int i = 0; i < maxCount / 5; i++)
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