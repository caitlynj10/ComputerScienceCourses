package main;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * April 4, 2023
 *
 * This is the RaceTrack class of the program
 * that holds all the mechanics and logic for 
 * the full car race.
 * 
 * Known Bugs: If a car is damaged, passes a pitstop,
 * but exceeds the 75 mark by more than 75 (670--> 710),
 * the car will enter the pitstop at 775 instead of 675. 
 *
 */

public class RaceTrack {
	private Car[] carRace;
	private FinishLine finishLine;
	private PitStop pitStop;
	private int ticks;
	private int place;
	private TrackLoggerC logger;

	/*
	 * constructs the RaceTrack for the race
	 */
	public RaceTrack() {
		pitStop = new PitStop();
		carRace = new Car[10];
		this.ticks = 1;
		this.place = 1; //tracks place in race
		logger = new TrackLoggerC();

	}

	/*
	 * puts cars in the track and makes a 
	 * finishLine the size of the cars in the race
	 */
	public void setCars(Car [] cars) {
		this.carRace = cars;
		finishLine = new FinishLine(carRace.length); 
	}

	/*
	 * this method controls each tick. it checks the
	 * various conditions needed after each tick, 
	 * ending with checking for collisions after each
	 * car has moved/
	 */
	public void tick() {
		logger.logNewTick();

		for(int i = 0; i < carRace.length; i++) {
			Car car = carRace[i];

			if(car.getFinished() == false) { //skips all cars that are finished

				if(car.getPitStops() == 0) {
					if(car.getDamage() == true) {
						car.setLocation(car.getLocation() + car.getNewSpeed()); //if the car is damaged, it uses it's damaged speed
					}
					else {
						car.setLocation(car.getLocation() + car.getSpeed());

					}

					if((car.getUnit()) >= 75 && car.getDamage() == true) {
						pitStop.enterPitStop(car);
						logger.logEnterPit(car);
						car.setPitStops(1);
					}

					if(car.getLocation() >= 1000) {
						finishLine.enterFinishLine(car);
						logger.logFinish(car, place);
						place++;
						car.setFinished(true);
					}
				}

				/**
				 * this section displays a car staying in the pitstop for two turns
				 */
				else if(car.getPitStops() > 0){
					if(car.getPitStops() == 1) { //one turn in pitstop
						car.setPitStops(2);
					}
					else if(car.getPitStops() == 2) { //two turns in pitstop; leaves
						pitStop.exitPitStop(car);
						logger.logExitPit(car);
						car.setPitStops(0);
					}

				}

			}
		}


		checkCollision();

	}

	public void checkCollision() {

		for(int i = 0; i< carRace.length; i++) {
			for(int j = i+1; j< carRace.length; j++) {
				if(carRace[i] != null && carRace[j] != null && carRace[i].getFinished() == false && carRace[j].getFinished() == false) { //only check active and initialized cars

					Car car1 = carRace[i];
					Car car2 = carRace[j];

					double car1unit = car1.getUnit(); //gets the unit of the lap (ex 345 returns 45)
					double car2unit = car2.getUnit(); 

					if(car1unit == car2unit) {
						if(car1.getDamage() == false && car2.getDamage() == false) {
							logger.logDamaged(car1);
							logger.logDamaged(car2);
							car1.setNewSpeed(car1.getSpeed() - (car1.getStrength() * 5)); //only sets the newSpeed, not the original speed
							car2.setNewSpeed(car2.getSpeed() - (car2.getStrength() * 5));
							car1.setDamage(true);
							car2.setDamage(true);
						}
						else if(car1.getDamage() == true && car2.getDamage() == false) { //only one car gets the damage
							logger.logDamaged(car2);
							car2.setNewSpeed(car2.getSpeed() - (car2.getStrength() * 5));
							car2.setDamage(true);
						}
						else if(car1.getDamage() == false && car2.getDamage() == true) {
							logger.logDamaged(car1);
							car1.setNewSpeed(car1.getSpeed() - (car1.getStrength() * 5));
							car1.setDamage(true);
						}
					}
				}


			}

		}
	}
	/*
	 * runs the car race while the finish line is not completely full
	 */

	public void run() {
		while(!finishLine.finished()) {
			tick();
			ticks++;
		}
		int score = calculateScore(ticks-1);
		logger.logScore(score);
	}

	/**
	 * calculates the score based on what car has entered 
	 * the race and how many ticks occurred during the race
	 * @param ticks
	 * @return score
	 */
	public int calculateScore(int ticks) {
		int numRaceCars = 0;
		int numFormulaOnes = 0;
		int numSportsCars = 0;
		for (Car car : carRace) {
			if (car instanceof RaceCar) {
				numRaceCars++;
			} else if (car instanceof FormulaOne) {
				numFormulaOnes++;
			} else if (car instanceof SportsCar) {
				numSportsCars++;
			}
		}

		int score = 1000 - 20 * ticks;
		score += 150 * numRaceCars;
		score += 100 * numFormulaOnes;
		score += 200 * numSportsCars;
		return score;
	}

	public TrackLoggerC getLogger() {
		return logger;
	}

}
