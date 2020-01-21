package mygame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MultiLevelParking {
	private int pictureWidth;
    private int pictureHeight;
	ArrayList<Parking<ITransport, IPatch>> hangarLevels;
	private final int countPlaces = 20;
	public MultiLevelParking(int countStages, int pictureWidth, int pictureHeight) {
		hangarLevels = new ArrayList<>();
		for (int i = 0; i < countStages; i++) {
			hangarLevels.add(new Parking<ITransport, IPatch>(countPlaces, pictureWidth, pictureHeight));
		}
		this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
	}
	public Parking<ITransport, IPatch> getHangar(int index){

		if ((index > -1) && (index < hangarLevels.size()))
		{
			return hangarLevels.get(index);
		}
		return null;
	}
	public ITransport getPlane(int i, int j) {
		if((i > -1) && (i < hangarLevels.size())) {
			if((j > -1) && (j < hangarLevels.get(i).maxCount)) {
				ITransport plane = hangarLevels.get(i).getPlace(j);
				hangarLevels.get(i).Remove(j);
				return plane;
			}
		}
		return null;
	}
	public IPatch getPatches(int i, int j) {
		if(i > -1 && i < hangarLevels.size()) {
			if(j > -1 && j < hangarLevels.get(i).maxCount) {
				IPatch patch = hangarLevels.get(i).getPlacesPatches(j);
				hangarLevels.get(i).Remove(j);
				return patch;
			}
		}
		return null;
	}
	public boolean loadData(String fileName) {
		String buffer = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			buffer = br.readLine();
			if (buffer.split(":")[0].equals("CountLevels")) {
				 int countLevel = Integer.parseInt(buffer.split(":")[1]);
	                if (hangarLevels != null) hangarLevels.clear();
	                hangarLevels = new ArrayList<>(countLevel);
			} else {
				br.close();
				return false;
			}
			int counter = -1;
			while (br.ready()) {
				buffer = br.readLine();
				ITransport plane = null;
				IPatch patches = null;
				if (buffer.equals("Level")) {
					counter++;
					hangarLevels.add(new Parking<>(countPlaces, pictureWidth, pictureHeight));
					continue;					
				} else if (buffer.split(":")[1].equals("WarPlane")) {
					plane = new WarPlane(buffer.split(":")[2]);
					hangarLevels.get(counter).AddPlane(plane, Integer.parseInt(buffer.split(":")[0]));					
				} else if (buffer.split(":")[1].equals("BomberPlane")) {
					plane = new BomberPlane(buffer.split(":")[3], buffer.split(":")[2]);
					if(buffer.split(":")[2].equals("PlanePatches")) patches = new PlanePatches(3);
					else if (buffer.split(":")[2].equals("PlaneMiddle")) patches = new PlaneMiddle(3);
					else if (buffer.split(":")[2].equals("PlaneBack")) patches = new PlaneBack(3);
					hangarLevels.get(counter).AddPlane(plane, patches, Integer.parseInt(buffer.split(":")[0]));					
				}
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean loadLevelData(String fileName, int index) {
		String buffer = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			buffer = br.readLine();
			if (buffer.equals("SingleLevel")) {
				hangarLevels.set(index, new Parking<>(countPlaces, pictureWidth, pictureHeight));				
			} else {
				br.close();
				return false;
			}
			while (br.ready()) {
				buffer = br.readLine();
				ITransport plane = null;
				IPatch patches = null;
				if (buffer.split(":")[1].equals("WarPlane")) {
					plane = new WarPlane(buffer.split(":")[2]);
					hangarLevels.get(index).AddPlane(plane, Integer.parseInt(buffer.split(":")[0]));					
				} else if (buffer.split(":")[1].equals("BomberPlane")) {
					plane = new BomberPlane(buffer.split(":")[3], buffer.split(":")[2]);
					if(buffer.split(":")[2].equals("PlanePatches")) patches = new PlanePatches(3);
					else if (buffer.split(":")[2].equals("PlaneMiddle")) patches = new PlaneMiddle(3);
					else if (buffer.split(":")[2].equals("PlaneBack")) patches = new PlaneBack(3);
					hangarLevels.get(index).AddPlane(plane, patches, Integer.parseInt(buffer.split(":")[0]));					
				}
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean saveData(String fileName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("CountLevels:" + hangarLevels.size());
			bw.newLine();
			for (Parking<ITransport, IPatch>  level : hangarLevels) {
				bw.write("Level");
				bw.newLine();
				for (int i = 0; i < countPlaces; i++) {
					ITransport plane = level.getPlace(i);
					if (plane != null) {
						if (!(plane instanceof BomberPlane)) {
							bw.write(i + ":WarPlane:" + plane.getConfig());
							bw.newLine();
						} else {
							IPatch patches = level.getPlacesPatches(i);
							if (patches != null) {
								bw.write(i + ":BomberPlane:" + patches.toString() + ":" + 
										plane.getConfig());
							} else {
								bw.write(i + ":BomberPlane:" + "PlanePatches" + ":" +
										plane.getConfig());
							}
							bw.newLine();
						}
					}
				}
			}
			bw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean saveLevelData(String fileName, int index) {
		try {
			if ((index > hangarLevels.size())||(index < 0)){
				return false;
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("SingleLevel");
			bw.newLine();
			Parking<ITransport, IPatch> level = hangarLevels.get(index);
			
			for (int i = 0; i < countPlaces; i++) {
				ITransport plane = level.getPlace(i);
				if (plane != null) {
					if (!(plane instanceof BomberPlane)) {
						bw.write(i + ":WarPlane:" + plane.getConfig());
						bw.newLine();
					} else {
						IPatch patches = level.getPlacesPatches(i);
						if (patches != null) {
							bw.write(i + ":BomberPlane:" + patches.toString() + ":" + 
									plane.getConfig());
						} else {
							bw.write(i + ":BomberPlane:" + "PlanePatches" + ":" +
									plane.getConfig());
						}
						bw.newLine();
					}
				}
			}
			bw.close();
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
}