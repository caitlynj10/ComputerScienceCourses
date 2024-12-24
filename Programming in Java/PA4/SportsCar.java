package main;
/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 * This is SportsCar class which is a sub-class
 * of the Car class. It extends the getters and setters
 * of the parent class, but has it's own constructor and 
 * toString() method.
 * 
 * Known Bugs: none
 *
 */
public class SportsCar extends Car{

	/*
	 * empty constructor to set an untouched
	 * SportsCar to 30 speed, 2 strength
	 */
	public SportsCar() {
		super();
		this.speed = 30;
		this.strength = 2;
		this.location = 0;
	}
	/*
	 * constructor for SportsCar that sets the
	 * speed and strength inputed by the user. 
	 * however, it does not exceed the bounds given
	 * and sets the speed and strength to the closest 
	 * bound.
	 */
	public SportsCar(int speed, int strength) {
		super(speed,strength);
		if(speed > 45) {
			this.speed = 45;
		}
		else if(speed < 20) {
			this.speed = 20;
		}
		if(strength > 3) {
			this.strength = 3;
		}
		else if(strength < 1) {
			this.strength = 1;
		}
		else {
			this.speed = speed;
			this.strength = strength;
		}

		this.location = 0;
		this.pitStop = 0;
	}
	

	/*
	 * prints the SportsCar's properties
	 */
	@Override
	public String toString() {
		return "SportsCar" + this.speed + "/" + this.strength;
	}
	
}
