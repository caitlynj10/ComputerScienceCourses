package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Building;
import main.Person;

class StudentBuildingTest {

	@Test
	void testConstructor() {
		Building building1 = new Building(3);
		assertEquals(3, building1.numFloors);
		
		
		Building building2 = new Building(0);
		assertEquals(0, building2.numFloors);
		
		
		
		Building building3 = new Building(8);
		assertEquals(8, building3.numFloors);
	}
	
	
	@Test
	void testRequests() {
		Building build1 = new Building(2);
		Person person = new Person("John", "Smith");
		assertEquals(true, build1.enterElevatorRequest(person,1));
		
		
		Building build2 = new Building(3);
		Person person2 = new Person("Lily", "White");
		assertEquals(false, build2.enterElevatorRequest(person2,4));
		
		
		Building build3 = new Building(3);
		Person person3 = new Person("Joey", "Johnson");
		assertEquals(true, build3.enterElevatorRequest(person3,3));
	}
	
	
	@Test
	void testNumFloors() {
		Building build1 = new Building(2);
		assertEquals(2, build1.getNumFloors());
		
		
		Building build2 = new Building(5);
		assertEquals(5, build2.getNumFloors());
		
		Building build3 = new Building(8);
		assertEquals(8, build3.getNumFloors());
	}
	
}
