package main;
/**
 * The elevator class contains the mechanics the elevator
 * needs to process a job and drop people at their floor. 
 * It has fields thst keep track of the elevator's location 
 * and person's location to ensure a smooth ride on the elevator.
 * 
 * Known Bugs: The simulation works at the most basic level.
 * ie. if there were to be more than 3 jobs, the elevator cannot
 * process them. similarly, if someone were to call for the elevator
 * while it is moving, it will not process the request until after
 * the elevator returns to the lobby.
 * 
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * Septemeber 7, 2023
 * COSI 21A PA0
 *
 */
public class Elevator {

	/**
	 * This specifies the number of people that can be brought to their floors by an Elevator 
	 * instance at any given time. 
	 * <p>DO NOT REMOVE THIS FIELD</p>
	 * <p>You may edit it. But keep it public.</p>
	 */
	public static int maxOccupants = 3;
	public Job[] jobs;
	public Job [] inLobby;
	public Person person;
	public String elevatorLoc;
	public int numJobs;
	public String fName;
	public String lName;
	public int currentFloor;

	/**
	 * Constructor for the elevator class. The parameters I chose
	 * were to ensure that later in this class, Person person could be
	 * called outside of the Person class.
	 * @param numJobs
	 * @param fName
	 * @param lName
	 */
	public Elevator(int numJobs, String fName, String lName) {
		currentFloor = 0;
		this.jobs = new Job[maxOccupants]; //NO MORE THAN 3 JOBS (PEOPLE IN AN ELEVATOR) AT A TIME
		this.inLobby = new Job[numJobs];
		this.numJobs = numJobs;
		person = new Person(fName, lName);
		elevatorLoc = "Elevator at Lobby";
	}
	
	/**
	 * This method creates a Job job object based on the 
	 * the person's name and desired floor they would like
	 * to go to. It then adds the jobs to Job [] to ensure
	 * that only 3 jobs are being processed at a time. It also
	 * ensures that the order of jobs in first come first serve, 
	 * starting at the first index of the array (first person in line).
	 * @param person
	 * @param desiredFloor
	 */
	public void createJob(Person person, int desiredFloor) {
		person.setDesiredFloor(desiredFloor);
		Job job = new Job(person, desiredFloor);
		for(int i = 0; i < jobs.length; i++) {
			if(jobs[i] == null) {
				jobs[i] = job;
				break;
			}
		}

	}

	/**
	 * This method through the array of jobs 
	 * and processes each one. Once the array 
	 * is fully null, the elevator will return 
	 * to the bottom floor. If my program was 
	 * fully working, this method would check 
	 * if there were more jobs to be processed
	 * in the lobby.
	 */
	public void processAllJobs() {
		

		for(int i = 0; i< jobs.length; i++) {
			if(jobs[i] != null) {
				processJob(jobs[i]);
				jobs[i] = null;
			}
		}
		while (currentFloor > 0) {
			
			elevatorLoc = "Elevator at floor " + currentFloor;
			currentFloor--;
			if(currentFloor == 0) {
				elevatorLoc = "Elevator at Lobby";
			}
			System.out.println(elevatorLoc);	
		}

		

	}


	/**
	 * This method processes a single job. To start, it
	 * prints out the elevator's current location. Then it 
	 * moves to the next floor (higher or lower) than the current
	 * floor to move the next person in line's floor. Once the person
	 * who requested this job has arrived at it's floor, the person
	 * exits the elevator.
	 * @param job
	 */
	public void processJob(Job job) {

		int desiredFloor = job.getFloor();

		System.out.println(elevatorLoc);


		while(currentFloor < desiredFloor) {
			currentFloor++;
			elevatorLoc = "Elevator at floor " + currentFloor;
			System.out.println(elevatorLoc);
			person.setCurrentFloor(currentFloor);
		}


		while(currentFloor > desiredFloor) {
			currentFloor--;
			elevatorLoc = "Elevator at floor " + currentFloor;
			System.out.println(elevatorLoc);
			person.setCurrentFloor(currentFloor);


		}
		Person person = job.getPerson();
		exit(person, currentFloor);


	}

	/**
	 * This method puts the person into their floor 
	 * and updates their location as the current 
	 * floor/desired floor they are on.
	 * @param person
	 * @param floor
	 */
	public void exit(Person person, int floor) {
		floor = currentFloor;		
		person.setCurrentFloor(floor);

		System.out.println(person.toString() + " exited"  + person.getLocation());
		


	}

	/**
	 * This method returns the current floor the elevator is on.
	 * @return
	 */
	public int getElevatorFloor() {
		return currentFloor;
	}


}