package main;
/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * December 13, 2023
 * COSI 21A PA3
 * 
 * The Entry class contains controls
 * the parts of an Entry, ie. key and value.
 * There is also included a priority setter
 * that sets the priority of the key to its
 * value to maintain the properties of a
 * priority queue.
 * 
 * Known Bugs: NONE
 *
 */
public class Entry {
	
	private GraphNode key;
	private int value;
	
	/**
	 * Initializes a new Entry with its
	 * key and value. Sets its priority to value
	 * @param key
	 * @param value
	 */
	public Entry(GraphNode key, int value) {
		this.key = key;
		this.value = value;
		key.priority = value;
	}

	/**
	 * Returns the value of the entry
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns the key of an entry
	 * @return
	 */
	public GraphNode getKey() {
		return key;
	}

}
