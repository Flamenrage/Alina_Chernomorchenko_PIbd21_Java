package mygame;
import java.util.ArrayList;

public class MultiLevelParking {

	ArrayList<Parking<ITransport, IPatch>> hangarLevels;
	private final int countPlaces = 20;
	public MultiLevelParking(int countStages, int pictureWidth, int pictureHeight) {
		hangarLevels = new ArrayList<>();
		for (int i = 0; i < countStages; i++) {
			hangarLevels.add(new Parking<ITransport, IPatch>(countPlaces, pictureWidth, pictureHeight));
		}
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
}