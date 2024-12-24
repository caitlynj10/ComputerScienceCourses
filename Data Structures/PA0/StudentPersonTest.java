package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Building;
import main.Person;

class StudentPersonTest {

	@Test
	void testPeople() {
		Building build1 = new Building(4);
		Person person1 = new Person("Caitlyn", "Jones");
		assertEquals("Caitlyn Jones", person1.toString());
		assertEquals(0, person1.getCurrentFloor());
		person1.setDesiredFloor(1);
		assertEquals(" in Lobby", person1.getLocation());
		assertEquals(true, person1.enterBuilding(build1, 2));
		
		
		Person person2 = new Person("Hailey", "Gold");
		assertEquals("Hailey Gold", person2.toString());
		assertEquals(0, person2.getCurrentFloor());
		person2.setDesiredFloor(2);
		person2.setCurrentFloor(2);
		assertEquals(" in Floor 2", person2.getLocation());
		assertEquals(false, person1.enterBuilding(build1, 5));

		
		Person person3 = new Person("Sophie", "Moran");
		assertEquals("Sophie Moran", person3.toString());
		assertEquals(0, person3.getCurrentFloor());
		person3.setDesiredFloor(5);
		person3.setCurrentFloor(3);
		assertEquals(" Waiting to be serviced", person3.getLocation());
		assertEquals(false, person1.enterBuilding(build1, 0));

	}

	
	
	

}
