package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ArrayIntList;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * May 5, 2023
 * PA5
 * This is the JUnit test class for the ArrayIntList class.
 * Every method is tested in this class at least twice,
 * including the exceptions.
 * Known Bugs: none
 */
class ArrayIntListTest {

	@Test
	void defaultConstructorTest() {
		ArrayIntList list = new ArrayIntList();
		
		assertEquals(0, list.size());
		assertEquals(10, list.getCapacity());
		assertEquals("[]", list.toString());
		assertEquals(true, list.isEmpty());

	}
	
	@Test
	void capacityConstructorTest() {
		ArrayIntList list = new ArrayIntList(25);
		assertEquals(25, list.getCapacity());
		assertEquals(0, list.size());
		assertEquals("[]", list.toString());
		
		
		list = new ArrayIntList(90);
		assertEquals(90, list.getCapacity());
		assertEquals(0, list.size());
		assertEquals("[]", list.toString());
		assertEquals(true, list.isEmpty());

		assertThrows(IllegalArgumentException.class, () -> {
			new ArrayIntList(-2);
		});
		
	}
	
	@Test
	void addAtEndTest() {
		ArrayIntList list = new ArrayIntList();
		list.add(9);
		list.add(3);
		list.add(7);
		assertEquals(3, list.size());
		assertEquals("[9, 3, 7]", list.toString());
		assertEquals(10, list.getCapacity());
		assertEquals(3, list.get(1));
		
		
		list = new ArrayIntList(4);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals(4, list.size());
		assertEquals(4, list.getCapacity());
		assertEquals("[1, 2, 3, 4]", list.toString());
		list.add(5);
		list.add(6);
		assertEquals(6, list.size());
		assertEquals(6, list.getCapacity());
		assertEquals("[1, 2, 3, 4, 5, 6]", list.toString());
		assertEquals(4, list.get(3));
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());

				
	}
	
	
	@Test
	void addAtIndexTest() {
		ArrayIntList list = new ArrayIntList(5);
		assertEquals(5, list.getCapacity());
		assertEquals(0, list.size());
		list.add(0,2);
		list.add(1,4);
		list.add(2,6);
		list.add(3,8);
		list.add(4,10);
		assertEquals("[2, 4, 6, 8, 10]", list.toString());
		assertEquals(5, list.getCapacity());
		assertEquals(5, list.size());
		assertEquals(6, list.get(2));

		
		list.add(0,1);
		list.add(2,3);
		list.add(4,5);
		list.add(6,7);
		list.add(8,9);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", list.toString());
		assertEquals(10, list.getCapacity());
		assertEquals(10, list.size());
		assertEquals(10, list.get(9));
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());
		

	}
	
	@Test
	void getTest() {
		ArrayIntList list = new ArrayIntList(4);
		assertEquals(0, list.get(0));
		
		list.add(9);
		list.add(18);
		
		assertEquals(18, list.get(1));
		
		list.add(0,7);
		list.add(3,56);
		assertEquals(7, list.get(0));
		assertEquals(9, list.get(1));
		assertEquals(18, list.get(2));
		assertEquals(56, list.get(3));
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());
		

		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(1);
		});

	}
	
	@Test
	void indexOfTest() {
		ArrayIntList list = new ArrayIntList(7);
		assertEquals(7, list.getCapacity());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(7);
		list.add(7);
		
		assertEquals(7, list.size());
		assertEquals(1, list.indexOf(2));
		assertEquals(-1, list.indexOf(10));
		assertEquals(5, list.indexOf(7));
		assertEquals(-1, list.indexOf(8));
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());

	}
	
	@Test
	void capacityTest() {
		ArrayIntList list = new ArrayIntList();
		assertEquals(10, list.getCapacity());

		list = new ArrayIntList(5);
		assertEquals(5, list.getCapacity());

		list = new ArrayIntList(68);
		assertEquals(68, list.getCapacity());

		list = new ArrayIntList(743);
		assertEquals(743, list.getCapacity());
		assertEquals(true, list.isEmpty());

		
	}
	
	@Test
	void removeTest() {
		ArrayIntList list = new ArrayIntList();
		assertEquals(10, list.getCapacity());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(4, 10);
		list.add(5, 20);
		list.add(6, 30);
		list.add(7, 40);
		
		assertEquals(8, list.size());
		
		list.remove(0);
		list.remove(3);
		
		assertEquals(6, list.size());
		assertEquals("[2, 3, 4, 20, 30, 40]", list.toString());
		
		list.add(50);
		list.add(3, 5);
		
		list.remove(1);
		list.remove(4);
		
		assertEquals(6, list.size());
		assertEquals("[2, 4, 5, 20, 40, 50]", list.toString());
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());

	}
	
	@Test
	void sizeTest() {
		ArrayIntList list = new ArrayIntList();
		assertEquals(0, list.size());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals(4, list.size());
		
		list.remove(2);
		list.add(2,8);
		list.add(9);
		
		assertEquals(5, list.size());
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());


	}
	
	@Test
	void containsTest() {
		ArrayIntList list = new ArrayIntList();
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(4, 15);
		list.add(5, 16);
		list.add(6, 17);
		list.add(7, 18);
		
		assertEquals(true, list.contains(11));
		assertEquals(true, list.contains(17));
		assertEquals(false, list.contains(90));
		assertEquals(false, list.contains(10));
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());
		
	}
	
	@Test
	void ensureCapacityTest() {
		ArrayIntList list = new ArrayIntList(3);
		assertEquals(3, list.getCapacity());
		list.ensureCapacity(4);
		assertEquals(4, list.getCapacity());

		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		
		list = new ArrayIntList(6);
		list.ensureCapacity(5);
		assertEquals(6, list.getCapacity());
	}
	
	@Test
	void checkIndexTest() {
		ArrayIntList list = new ArrayIntList(3);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(0,1);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.checkIndex(-1, 0, 3);
		});
				
	}
}
