package mygame;

public class ParkingNotFoundException extends NullPointerException {
	public ParkingNotFoundException(int index) {
		super("Не найден самолет " + index);
	}
}