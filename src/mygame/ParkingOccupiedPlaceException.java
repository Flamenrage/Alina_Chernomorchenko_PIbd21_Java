package mygame;

public class ParkingOccupiedPlaceException extends Exception {
	public ParkingOccupiedPlaceException(int index) {
		super("Здесь уже есть автомобиль" + index);
	}
}