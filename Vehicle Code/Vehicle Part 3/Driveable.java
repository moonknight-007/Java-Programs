public interface Driveable{
	double MAX_SPEED_CAR = 250.00;
	double MAX_SPEED_BIKE = 100.00;
	
	public void stop();
	public void accelerate(int value);
	public void breaks(int value);
}
