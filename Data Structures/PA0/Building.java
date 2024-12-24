package main;
/**
 * The building class holds an array of Floors and 
 * an instance of an elevator to process the jobs. 
 * The building will have a a lobby and numbered floors
 * up to some maximum. The building class contains the 
 * necessary code for the mechanics of the simulation.
 * Known Bugs:
 * 
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * Septemeber 7, 2023
 * COSI 21A PA0
 *
 */
public class Building {
	public int numFloors;
	public Floor [] floors;
	public Elevator elevator;
	public int jobs;

	/**
	 * The constructor for a building. Initializes the number of 
	 * floors inputed by the user. Initializes each floor as a Floor object.
	 * @param numFloors
	 */
	public Building(int numFloors) {
		this.numFloors = numFloors;
		this.floors = new Floor[numFloors + 1];
		jobs = 0;
		this.elevator = new Elevator(jobs, " ", " ");
		for(int i = 0; i <= numFloors; i++) {
			floors[i] = new Floor(i);
		}
	}
	
	/**
	 * This method enters an elevator request for a person
	 * at the lobby. If the floor they are trying to reach 
	 * does not exist in the building, it throws an exception
	 * and asks the user for a different floor.
	 * @param person
	 * @param floor
	 * @return
	 */
	public boolean enterElevatorRequest(Person person, int floor) {
		if(floor > 0 && floor <= numFloors) {
			elevator.createJob(person, floor);
			jobs++;
			return true;
		}
		return false;
	}
	
	/**
	 * This method initiates the elevator so 
	 * it can begin bringing people to their floors
	 */
	public void startElevator() {
		elevator.processAllJobs();

	}
	
	/**
	 * This method adds a person to their desired floor
	 * if the elevator has reached it
	 * @param person
	 * @param floor
	 */
	public void enterFloor(Person person, int floor) {
		if(person.getDesiredFloor() == floor) {
			floors[floor].enterFloor(person);
		}
	}
	
	/**
	 * This method returns the number of floors
	 * in the building
	 * @return
	 */
	public int getNumFloors() {
		return numFloors;
	}
	
	/**
	 * This method returns the Lobby of the building.
	 * @return
	 */
	public Floor getLobby() {
		return floors[0];
	}
	 
}
