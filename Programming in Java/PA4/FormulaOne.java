package main;
/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 * This is FormulaOne class which is a sub-class
 * of the Car class. It extends the getters and setters
 * of the parent class, but has it's own constructor and 
 * toString() method.
 * 
 * Known Bugs: none
 *
 */
public class FormulaOne extends Car{

	/*
	 * empty constructor to set an untouched
	 * FormulaOne to 50 speed, 4 strength
	 */
	public FormulaOne() {
		super();
		this.speed = 50;
		this.strength = 4;
		this.location = 0;
	}

	/*
	 * constructor for FormulaOne that sets the
	 * speed and strength inputed by the user. 
	 * however, it does not exceed the bounds given
	 * and sets the speed and strength to the closest 
	 * bound.
	 */
	public FormulaOne(int speed, int strength) {
		super(speed,strength);
		if(speed > 70) {
			this.speed = 70;
		}
		else if(speed < 30) {
			this.speed = 30;
		}
		if(strength > 5) {
			this.strength = 5;
		}
		else if(strength < 3) {
			this.strength = 3;
		}
		else {
			this.speed = speed;
			this.strength = strength;
		}
		this.location = 0;
		this.pitStop = 0;

	}


	/*
	 * prints the FormulaOne's properties
	 */
	@Override
	public String toString() {

		return "FormulaOne" + this.speed + "/" + this.strength;
	}

}
