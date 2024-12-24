package main;
/**
 * The Floor class holds one constructor and
 * one method to handle some of the logic of 
 * a Floor.
 * 
 * Known Bugs: The enterFloor(Person person) method
 * is not technically used, so when asked to print
 * a list of people on a floor, it will show up as
 * null.
 * 
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * Septemeber 7, 2023
 * COSI 21A PA0
 *
 */
public class Floor {
	public Person [] peopleAtFloor;
	public int floorNum;
	public int peopleCount;
	
	/**
	 * This is the constructor for the Floor object.
	 * It initializes the floor number and the array
	 * of people located at the floor.
	 * @param floorNum
	 */
	public Floor(int floorNum) {
		this.floorNum = floorNum;
		this.peopleAtFloor = new Person[100];
		this.peopleCount = 0;
	}
	
	/**
	 * This method should have been used to track
	 * the poeple located at the floor, but it isn't.
	 * @param person
	 */
	public void enterFloor(Person person) {
		if(peopleAtFloor[floorNum] == null) {
			peopleAtFloor[floorNum] = person;
			peopleCount++;
		}
		throw new UnsupportedOperationException();
	}
}
