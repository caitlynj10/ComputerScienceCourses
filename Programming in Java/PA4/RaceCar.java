package main;
/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 * This is RaceCar class which is a sub-class
 * of the Car class. It extends the getters and setters
 * of the parent class, but has it's own constructor and 
 * toString() method.
 * 
 * Known Bugs: none
 *
 */
public class RaceCar extends Car{	

	/*
	 * empty constructor to set an untouched
	 * RaceCar to 40 speed, 3 strength
	 */
	public RaceCar() {
		super();
		this.speed = 40;
		this.strength = 3;
		this.location = 0;
	}

	/*
	 * constructor for RaceCar that sets the
	 * speed and strength inputed by the user. 
	 * however, it does not exceed the bounds given
	 * and sets the speed and strength to the closest 
	 * bound.
	 */
	public RaceCar(int speed, int strength) {
		super(speed,strength);
		if(speed > 55) {
			this.speed = 55;
		}
		else if(speed < 30) {
			this.speed = 30;
		}
		
		if(strength > 4) {
			this.strength = 4;
		}
		else if(strength < 2) {
			this.strength = 2;
		}
		else {
			this.speed = speed;
			this.strength = strength;
		}
		this.location = 0;
	}

	/*
	 * prints the RaceCar's properties
	 */
	@Override
	public String toString() {

		return "RaceCar" + this.speed + "/" + this.strength;
	}

}
