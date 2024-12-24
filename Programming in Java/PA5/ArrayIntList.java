package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * May 5, 2023
 * PA5
 * This program focuses on implementing the ArrayList<Integer>
 * Java class without actually using ArrayList<Integer>, but
 * instead using int [] ]. This class implements properties of
 * ArrayList<Integer> such as add(int val), add(int index, int val),
 * indexOf(int val), and many more methods that can be found in
 * ArrayList.java. This class functions as an ArrayList, so when
 * calling the methods on the int [], it will ultimately mimic
 * that of the real ArrayList<Integer>.
 * Known Bugs: none
 */

public class ArrayIntList {
	public int [] elementData; //the "ArrayList<Integer>"
	public int size; //tracks how many ints are in the list
	public int capacity; //tracks how many ints the list can hold

	/**
	 * Constructs an empty list with a 
	 * default capacity of 10 and size 0
	 */
	public ArrayIntList() { //tested
		elementData = new int [10];
		this.capacity = 10;
		this.size = 0;
	}

	/**
	 * Constructs an empty list with a
	 * capacity from the parameters given
	 * by the user declaration; size 0.
	 * @param capacity
	 * Throws an exception if the capacity is negative
	 */
	public ArrayIntList(int capacity) { //tested
		if(capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be negative");
		}
		elementData = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	/**
	 * Adds a given value to the end of the list
	 * after increasing the capacity of the list
	 * if need be; increases size when done.
	 * @param value
	 */
	public void add(int value) { //tested
		ensureCapacity(size + 1);
		elementData[size] = value;
		this.size++;
	}

	/**
	 * Adds a given value at a given index and 
	 * shifts the rest of the values down to 
	 * accommodate this addition.Increases the
	 * capacity before (if need be) and size after.
	 * @param index
	 * @param value
	 */
	public void add(int index, int value) { //tested
		checkIndex(index, 0, size);
		ensureCapacity(size+1);
		for(int i = size; i > index; i--) {
			elementData[i] = elementData[i-1];
		}
		elementData[index] = value;
		size++;
	}

	/**
	 * Returns the value at a given index
	 * @param index
	 * @return value 
	 * If no value is found at the index, 
	 * an exception will be thrown.
	 */
	public int get(int index) { //tested
		if(size < index) { //throw exception if the index is not found in the array (if the index surpasses the size of the array)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds, size < index");

		}
		checkIndex(index, 0, size);
		return elementData[index];
	}

	/**
	 * Searches through the list and returns 
	 * the first occurance of given value; 
	 * -1 if not found
	 * @param value
	 * @return given value when found or -1
	 */
	public int indexOf(int value) { //tested
		for(int i = 0; i < elementData.length; i++) {
			if(elementData[i] == value) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * I created this method to allow for
	 * an easier way of testing capacity
	 * while doing JUnit Tests.
	 * @return the capacity of the list
	 */
	public int getCapacity() { //tested
		return this.capacity;
	}

	/**
	 * Removes the value at the give index
	 * and shifts the list to accommodate the
	 * change. decreases the size afterwards.
	 * @param index
	 */
	public void remove(int index) { //tested
		checkIndex(index, 0, size);
		for(int i = index+1; i < size; i++) {
			elementData[i-1] = elementData[i];
		}
		size--;
	}

	/**
	 * Used to return the number of ints in the list
	 * @return size
	 */
	public int size() {//tested
		return this.size;
	}

	/**
	 * Returns the int [] as a String to replicate
	 * the toString() method in the ArrayList.java class.
	 */
	public String toString() {//tested
		if(size == 0) {
			return "[]";
		}
		String printedArray = "[" + elementData[0];
		for(int i = 1; i < size; i++) {
			printedArray += ", " + elementData[i];
		}
		printedArray += "]";
		return printedArray;
	}

	/**
	 * Sets the size back to 0 and
	 * empties the ArrayList
	 */
	public void clear() {//tested
		size = 0;
	}

	/**
	 * Determines whether or not the list
	 * contains the given value.
	 * @param value
	 * @return true if the value's index is found (!-1)
	 */
	public boolean contains(int value) { //tested
		return indexOf(value) >= 0; 
	}

	/**
	 * Makes sure that the list's capacity can
	 * hold more elements. If not, the list 
	 * adds more capacity for the element.
	 * @param capacity
	 * Postcondition: elementData.length >= capacity
	 */
	public void ensureCapacity(int capacity) { //tested
		if(capacity > elementData.length) {
			int[] newList = new int[capacity]; //creates a new int[]
			this.capacity = capacity;
			for(int i=0; i < elementData.length; i++) {
				newList[i] = elementData[i]; //copies the elements into the new array
			}
			elementData = newList; //puts the new array into the old one so that the name is maintained
		}
	}

	/**
	 * Determines if the list is empty or not
	 * @return if size == 0 (empty or not)
	 */
	public boolean isEmpty() { //tested
		return size == 0;
	}

	/**
	 * Throws an exception if the given index is
	 * not in the bounds given.
	 * @param index
	 * @param min
	 * @param max
	 */
	public void checkIndex(int index, int min, int max) {//tested
		if(index < min || index > max) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds, expected between " + min + " and " + max);

		}
	}
}
