package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import main.ArrayIntList;
import main.SortedIntList;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * May 5, 2023
 * PA5
 * This is the JUnit test class for the SortedIntList class.
 * Every method is tested in this class at least twice,
 * including the exceptions.
 * Known Bugs: none
 */
class SortedIntListTest {

	
	@Test
	void constructorTests() {
		SortedIntList list = new SortedIntList(); //no params
		assertEquals(10, list.getCapacity());
		assertEquals(0, list.size());
		assertEquals(false, list.getUnique());
		assertEquals("S:[]", list.toString());

		
		
		list = new SortedIntList(true); //unique param
		assertEquals(10, list.getCapacity());
		assertEquals(0, list.size());
		assertEquals(true, list.getUnique());
		assertEquals("S:[]U", list.toString());

		
		list = new SortedIntList(12); //capacity param
		assertEquals(12, list.getCapacity());
		assertEquals(0, list.size());
		assertEquals(false, list.getUnique());
		assertEquals("S:[]", list.toString());
		
		
		list = new SortedIntList(true, 35); //capacity AND unique param
		assertEquals(35, list.getCapacity());
		assertEquals(0, list.size());
		assertEquals(true, list.getUnique());
		assertEquals("S:[]U", list.toString());

		
		assertThrows(IllegalArgumentException.class, () -> {
			new SortedIntList(-2);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new SortedIntList(true, -90);
		});
		
		

	}
	
	@Test
	void addTests() {
		SortedIntList list = new SortedIntList();
		list.add(-3);
		list.add(8);
		list.add(7);
		list.add(3);
		
		assertEquals("S:[-3, 3, 7, 8]", list.toString());
		
		list.add(9);
		list.add(7);
		list.add(67);
				
		assertThrows(UnsupportedOperationException.class, () -> {
			list.add(6,78);
		});
		
		assertEquals("S:[-3, 3, 7, 7, 8, 9, 67]", list.toString());
		list.removeDuplicates();
		assertEquals("S:[-3, 3, 7, 8, 9, 67]", list.toString());
		
		assertEquals(3, list.indexOf(8));
		assertEquals(67, list.max());
		assertEquals(-3, list.min());
		
		list.clear();
		assertEquals(0, list.size());
	}
	
	@Test
	void uniqueTests() {
		SortedIntList list = new SortedIntList(true);
		
		list.add(23);
		list.add(34);
		list.add(56);
		list.add(12);
		list.add(45);
		list.add(34);
		
		assertEquals("S:[12, 23, 34, 45, 56]U", list.toString());

		list.setUnique(false);
		assertEquals(false, list.getUnique());
		
		list.add(45);
		list.add(67);
		list.add(89);
		list.add(23);
		list.add(78);
		list.add(89);
		assertEquals("S:[12, 23, 23, 34, 45, 45, 56, 67, 78, 89, 89]", list.toString());

		list.setUnique(true);
		assertEquals(true, list.getUnique());
		list.add(12);
		list.add(89);
		assertEquals("S:[12, 23, 34, 45, 56, 67, 78, 89]U", list.toString());
		
		assertThrows(UnsupportedOperationException.class, () -> {
			list.add(0,11);
		});
		
		assertEquals(89, list.max());
		assertEquals(12, list.min());

		list.clear();
		assertEquals(0, list.size());
		
		assertThrows(NoSuchElementException.class, () -> {
			list.max();
		});
	}
	
	

}
