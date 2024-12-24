package main;
/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 * This is the PitStop class which contains the 
 * methods for dealing with cars while they are
 * in the PitStop
 * 
 * Known Bugs: none
 *
 */
public class PitStop {
	
	private Car [] pitStopCars;
	
	/*
	 * constructs a new PitStop
	 */
	public PitStop() {
		pitStopCars = new Car [10];
	}

	/*
	 * enters the cars in the PitStop
	 */
	public void enterPitStop(Car car) {
		int i = 0;
		while(i < 10) {
			pitStopCars[i] = car;
			i++;
		}
		
	}
	
	/*
	 * upon exiting the PitStop, this method
	 * returns the Car to it's original speed
	 * and sets its location to the 75 mark of
	 * the lap it is on and advances the cars
	 * forward to their next location. 
	 */
	public void exitPitStop(Car car) {
		car.setSpeed(car.getSpeed());
			if(car.getLocation() % 100 > 75) {
				int temp = (int) (car.getLocation() % 100); //80
				int hold = temp - 75; //5
				car.setLocation(car.getLocation() - hold + car.getSpeed());  //375
			}
			else {
				car.setLocation(car.getLocation() + car.getSpeed());
			}
			car.setDamage(false); //removes damage once leaving pitstop
			car = null; //removes car from pitstop
	}

}
