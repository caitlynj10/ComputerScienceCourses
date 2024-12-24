package main;
/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 * This is FinishLine class whichs holds the methods
 * for dealing with cars that have finished the race.
 * 
 * Known Bugs: none
 *
 */
public class FinishLine {
	
	private Car [] finishedCars;
	private int index; //tracks where the cars are in the finish line
	
	/*
	 * constructs a finishLine with the length 
	 * of the amount of Cars in the race
	 */
	public FinishLine(int length) {
		finishedCars = new Car [length];
		this.index = 0;
	}
	
	/*
	 * enters a car in the finishLine[] and increments
	 */
	public void enterFinishLine(Car car) {
		finishedCars[index] = car;
		index++;
	}
	

	/*
	 * makes sure every possible car in 
	 * the finish line is an initialized and
	 * active car to continue the race
	 */
	public boolean finished() {
		boolean finish = false;
		for(int i = 0; i<finishedCars.length; i++) {
			if(finishedCars[i] == null || finishedCars[i].getFinished() == false) {
				finish = false;
			}
			else {
				finish = true;
			}
		}
		 return finish;
	}
	

}
