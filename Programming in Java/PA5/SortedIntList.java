package main;

import java.util.*;
import java.util.NoSuchElementException;


/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * May 5, 2023
 * PA5
 * This program builds on the previous class, for
 * it extends ArrayIntList. Newly added in this class
 * is the field unique, which keeps track of if
 * the list is allowing duplicates or not. Furthermore,
 * this class focuses on sorted arrays, so the add(int val) 
 * method only adds values in increasing numerical order. Many
 * of the methods are inherited, but there are also method
 * specifically for this class, such as the min and max methods.
 * Known Bugs: none
 */

public class SortedIntList extends ArrayIntList{
	private boolean unique; //PRIVATE field to track if the list has duplicates or not
 
	/**
	 * Default constructor inherited from the
	 * parent class, but adding the unique tag
	 * and setting it to false (default)
	 */
	public SortedIntList() { //tested
		super();
		setUnique(false);
	}

	/**
	 * Creates a list with deafault capacity
	 * of 10, size of 0. Sets unique to given value
	 * @param unique
	 */
	public SortedIntList(boolean unique) { //tested
		elementData = new int [10];
		setUnique(unique);
		this.size = 0;
	}

	/**
	 * Inherited from the parent class, creating
	 * a list with the given capacity and sets
	 * unique to the given value.
	 * @param capacity
	 */
	public SortedIntList(int capacity) { //tested
		super(capacity);
		setUnique(false);
	}

	/**
	 * Constructs a sorted list with size 0, 
	 * given unique value, and give capacity.
	 * Sets unique to the given value.
	 * @param unique
	 * @param capacity
	 * Throws an exception if capacity is negative
	 */
	public SortedIntList(boolean unique, int capacity) { //tested
		if(capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be negative");
		}
		elementData = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
		setUnique(unique);
	}

	
	/**
	 * Adds the elements in numerical order. 
	 * If unique is on (true = no duplicates) 
	 * and the list already contains the value, 
	 * the given value is not added (would be a duplicate). 
	 * Goes through and finds the correct place 
	 * in the numerical order to add the value;
	 * shifts other elements as needed and
	 * increases size.
	 * @param value
	 */
	@Override
	public void add(int value) { //tested
		if(unique == true && contains(value)) { 
			return; //no duplicates allowed
		}
		int index = 0;
		while(index < size && elementData[index] < value) {
			index++; //finds what index to insert new number
		}
		ensureCapacity(size + 1);
		for(int i = size; i > index; i--) {
			elementData[i] = elementData[i-1]; //shifts values around the new number
		}
		elementData[index] = value; //inserts number
		size++;

	}


	/**
	 * Throws and exception because this class
	 * is all for SORTED lists, so it makes no
	 * sense to add the value at a specific index
	 * @param index
	 * @param value
	 */
	@Override
	public void add(int index, int value) { //tested
		throw new UnsupportedOperationException();
	}

	/**
	 * Determines the status of uniqueness
	 * @return true or false depending on if duplicates are allowed
	 */
	public boolean getUnique() { //tested
		return unique;
	}

	/**
	 * Searches for the index of the given value 
	 * by using binarySearch, which is way more
	 * efficient and has a faster run time.
	 * Works the same as the parent class, however,
	 * returns -1 if the index is not found
	 * @param value
	 */
	@Override
	public int indexOf(int value) { //tested
		int index = Arrays.binarySearch(elementData, 0, size, value);
		return index;
	}

	/**
	 * Throws an exception if the list is empty;
	 * otherwise returns the last value
	 * because the list is in increasing order
	 * @return last number
	 */
	public int max() { //tested
		if(size == 0) {
			throw new NoSuchElementException("This list is empty");
		}
		return elementData[size-1];
	}

	/**
	 * Throws an exception if the list is empty;
	 * otherwise returns the first value
	 * because the list is in increasing order
	 * @return first number
	 */
	public int min() {//tested
		if(size == 0) {
			throw new NoSuchElementException("This list is empty");
		}
		return elementData[0];
	}

	/**
	 * Changes the status of unique for the list.
	 * If the previous unique value and the given one
	 * are the same, nothing happens. If the original
	 * value was true and turns false, simply change the
	 * tag. However, to go from false to true, we must
	 * remove all duplicate numbers in the list.
	 * Calls removeDuplicates() to do so.
	 * @param value
	 */
	public void setUnique(boolean value) { //tested
		if(value == unique) {
			return;
		}
		else if(value == true) {
			removeDuplicates();
		}
		unique = value;
	}

	/**
	 * Method I decided to implement to help
	 * in removing duplicates from the unique-set
	 * list. Goes through and compares each element 
	 * to each other; if they are the same, removes the 
	 * second instance of it by calling remove(int index)
	 * from the parent class.
	 */
	public void removeDuplicates() { //tested
		for(int i = 0; i < elementData.length; i++) {
			int a = elementData[i];

			for(int j = i+1; j<size; j++) {
				int b = elementData[j];

				if(a == b) {
					remove(j);
				}
			}
		}
	}
	
	/**
	 * Emphasizes the sorted list by adding
	 * S before listing the array. If the list
	 * is unique, adds a U after it is listed.
	 */
	public String toString() { //tested
		String newArray = "S:" + super.toString();

		if(getUnique() == true) {
			newArray += "U";
		}
		return newArray;
	}

}
