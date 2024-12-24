package main;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 * This is the abstract Car class that holds the 
 * methods and variables to be used throughout the program.
 * 
 * Known Bugs: none
 *
 */
public abstract class Car {
	public int speed;
	public int newSpeed; //tracks the new speed after collision
	public int strength;
	public double location;
	public boolean damaged; //tracks if the car is damaged
	public int pitStop; //tracks how long the car is in pitstop
	public boolean finished; //tracks if the car is finished
	
	/*
	 * empty constructor
	 */
	public Car() {
		
	}
	
	/*
	 * constructor that initializes main fields
	 */
	public Car(int speed, int strength) {
		this.speed = speed;
		this.strength = strength;
		this.location = 0;
	}
	
	/*
	 * returns any Car location
	 */
	public double getLocation() {
		return this.location;
	}
	
	/*
	 * returns the unit of which lap the car is on
	 * ex: car at location 245 is at unit 45 of the lap;
	 * this method would return 45
	 */
	public int getUnit() {
		return (int) (getLocation() % (100));
	}
	
	/*
	 * returns Car's set speed
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	/*
	 * returns Car's strength
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/*
	 * sets the Car's speed
	 */
	public void setSpeed(int sd) {
		this.speed = sd;
	}
	
	/*
	 * set's the Car's speed after damage and after pitstop
	 */
	public void setNewSpeed(int sd) {
		this.newSpeed = sd;
	}
	
	/*
	 * keeps track of the new speed after damage
	 */
	public int getNewSpeed() {
		return this.newSpeed;
	}
	
	/*
	 * sets location upon leaving pitstop if unit exceeds 75
	 */
	public void setLocation(double loc) {
		this.location = loc;
	}
	
	/*
	 * returns if Car has damage
	 */
	public boolean getDamage() {
		return this.damaged;
	}
	
	/*
	 * sets Car's damage after collision and pitstop
	 */
	public void setDamage(boolean damage) {
		this.damaged = damage;
	}
	
	/*
	 * returns number of ticks the car has spent in pitstop
	 */
	public int getPitStops() {
		return this.pitStop;
	}
	
	/*
	 * sets the number of turns car has spent in pitstop 
	 * to a certain amount to keep track
	 */
	public void setPitStops(int ps) {
		this.pitStop = ps;
	}
	
	/*
	 * sets Car's finished status during the race
	 */
	public void setFinished(boolean finish) {
		this.finished = finish;
	}

	/*
	 * returns if Car is finished or not to alert the ticks 
	 */
	public boolean getFinished() {
		return this.finished;
	}
	
	/*
	 * to be implemented in various sub-classes
	 */
	public abstract String toString();
	
	
}
