package main;
/**
 * This class contains the necessary information for a Job
 * object. It keeps track of the Person requesting to job 
 * and the floor they are reqesting to go to. 
 * 
 * Known Bugs: This class has no bugs
 * 
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * Septemeber 7, 2023
 * COSI 21A PA0
 *
 */
public class Job {
	public Person person;
	public int floorNum;
	
	/**
	 * The Job constructor initializes the Person and the floor number.
	 * @param person
	 * @param floorNum
	 */
	public Job (Person person, int floorNum) {
		this.person = person;
		this.floorNum = floorNum;
	}
	
	/**
	 * This method returns the requested floor number
	 * @return
	 */
	public int getFloor() {
		return floorNum;
	}
	
	/**
	 * This method returns the Person who requested this job
	 * @return
	 */
	public Person getPerson() {
		return person;
	}
}