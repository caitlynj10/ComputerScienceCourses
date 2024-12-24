package main;

public class Simulation {

	public static void main(String[] args) {
		Building building1 = new Building(3);
		Person person1 = new Person("John", "Smith");
		Person person2 = new Person("Lily", "White");
		Person person3 = new Person("Caitlyn", "Jones");
		building1.enterElevatorRequest(person1,  2);
		building1.enterElevatorRequest(person2, 3);
		building1.enterElevatorRequest(person3, 1);
		building1.startElevator();
	}

}
