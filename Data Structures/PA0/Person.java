package main;
/**
 * This class contains the required and necessary information
 * for a Person object. It's main purposes are to keep track
 * of the location and floor of a given person.
 * 
 * Known Bugs: This class has no bugs
 * 
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * Septemeber 7, 2023
 * COSI 21A PA0
 *
 */
public class Person {
	public String firstName;
	public String lastName;
	public Building building;
	public String location;
	public int desiredFloor;
	public int currentFloor;


	/**
	 * Constructor for the Person class initializes the person's
	 * first and last name, the building they are trying to enter,
	 * and their current floor (always going to be Lobby).
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.building = building;
		this.currentFloor = 0;
		//throw new UnsupportedOperationException();
	}

	/**
	 * This method returns true if the requested floor is 
	 * not the lobby AND the building has the requested floor.
	 * If possible, then the Person's desired floor will be
	 * set to their requested floor.
	 * @param building
	 * @param floor
	 * @return
	 */
	public boolean enterBuilding(Building building, int floor) {
		if (floor > 0 && floor <= building.getNumFloors()) {
			setDesiredFloor(floor);
			return true;
		}
		return false;

	}

	/**
	 * Returns the location of the person. If the 
	 * elevator's current floor equals the Person's 
	 * desired floor (they have arrived at their floor),
	 * location becomes their floor, and they stay there 
	 * until the program stops running. If the elevator is 
	 * between floors when getLocation is called, the location
	 * is Waiting to be serviced. Otherwise, the person should
	 * be in the Lobby
	 * @return
	 */
	public String getLocation() {
		if(getCurrentFloor() == getDesiredFloor()) {
			location = " in Floor " + getCurrentFloor();
		}
		
		else if (getCurrentFloor() == 0) {
			location = " in Lobby";
		}
		else {
			location = " Waiting to be serviced";
		}
		return location;
	}

	/**
	 * Returns the person's desired/requested floor
	 * @return
	 */
	public int getDesiredFloor() {
		return desiredFloor; 
	}
	
	/**
	 * toString() to print out the person's first 
	 * and last name.
	 */
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * Sets the Person person's desired floor
	 * as the floor they requested. Helper method
	 * to make the mechanics of the program easier
	 * in other methods.
	 * @param desiredFloor
	 */
	public void setDesiredFloor(int desiredFloor) {
		this.desiredFloor = desiredFloor;
	}
	
	/**
	 * Returns a Persons current floor.
	 * @return
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	/**
	 * Sets the Person person's current floor to
	 * match the floor that the elevator is on. 
	 * Helper method to make it easier to track
	 * when the desired floor and current floor
	 * are equal.
	 * @param currentFloor
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
}
