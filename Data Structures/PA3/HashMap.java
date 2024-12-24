package main;
/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * December 13, 2023
 * COSI 21A PA3
 * 
 * The HashMap class holds the mechanics for 
 * setting, getting, and checking Entries in
 * the HashMap. The load factor below will be 
 * used to assure that the table is rehashed 
 * when it needs to be used. This class will be 
 * used in MinPriorityQueue
 * 
 * Known Bugs: NONE
 *
 */

public class HashMap {
	private Entry[] buckets;
	private int size;
	private static final double LOAD_FACTOR = 0.75;
	private int count;

	/**
	 * Constructor for HashMap class
	 * Default size of 10
	 */
	public HashMap() {
		this.size = 10;
		buckets = new Entry[size];
	}

	/**
	 * This method checks the hashmap to see if there
	 * is an entry for the key. If there is, this 
	 * method changes its value to value; adds it
	 * the hashmap with that value.
	 * @param key
	 * @param value
	 */
	public void set(GraphNode key, int value) {
		int index = hashFunction(key);
			

		if (index != -1) {
			if((double) (count + 1) / size > LOAD_FACTOR) {
				rehash();
				index = hashFunction(key);
			}
			buckets[index] = new Entry(key, value);
			count++;
		}

	}

	/**
	 * This method returns the value for the entry
	 * with g as the key
	 * @param g
	 * @return value of g
	 */
	public int getValue(GraphNode g) {
		int index = hashFunction(g);

		if(index != -1 && buckets[index] != null && buckets[index].getKey().equals(g)) {
			
			return buckets[index].getValue();
		}

		else {
			return 0;
		}
	
	}


	/**
	 * This method returns true if the 
	 * hashmap has the key g
	 * @param g
	 * @return true if contains g
	 */
	public boolean hasKey(GraphNode g) {
		int index = hashFunction(g);


		return (index != -1 && buckets[index] != null && buckets[index].getKey().equals(g));
	}


	/**
	 * This method contains the procedure for
	 * linear probing with a hash function.
	 * h(k) = (hash(k) + i) % m
	 * @param key
	 * @return
	 */
	public int hashFunction(GraphNode key) {
		int hashCode = key.getId().hashCode();

		int i = 0;
		int index = Math.abs((hashCode % size) + i% size); //function for linear probing
		int initial = index;

		while(buckets[index] != null && !buckets[index].getKey().equals(key)) { 
			//the index is not empty and the key is not already in the hashmap
			i++;
			index = Math.abs((hashCode % size) + i % size);
			if(index == initial) {
				return -1;
			}
		}
		

		return index;
	}

	/**
	 * This method rehashes the hash table
	 * if the load factor is greater than .75
	 */
	public void rehash() {

		int newSize = size * 2;
		Entry[] newBuckets = new Entry[newSize];

		for(Entry e : buckets) {
			if(e != null) {
				int hashCode = e.getKey().getId().hashCode();
				int i = 0;
				int index = Math.abs(((hashCode % newSize) + i) % newSize);
				while(newBuckets[index] != null) {
					i++;
					index = Math.abs(((hashCode % newSize) + i) % newSize);
				}
				newBuckets[index] = e;
			}
		}

		buckets = newBuckets;
		size = newSize;
	}

	/**
	 * FOR TESTING PURPOSES
	 * @param args
	 */

	public static void main(String[] args) {
		HashMap hashMap = new HashMap(); // Initialize hashmap with size 5
		//System.out.println(hashMap.size);
		

		// Add elements to the hashmap
		
		GraphNode n1 = new GraphNode("node1", false);
		GraphNode n2 = new GraphNode("node2", false);
		GraphNode n3 = new GraphNode("node3", false);
		GraphNode n4 = new GraphNode("node4", false);

		hashMap.set(n1, 10);
		hashMap.set(n2, 20);
		hashMap.set(n3, 30);
		hashMap.set(n4, 40);
		
		// Retrieve values and check for keys
		System.out.println("Value for node1: " + hashMap.getValue(n1)); // Expected output: 10
		System.out.println("HasKey for node2: " + hashMap.hasKey(n2)); // Expected output: true

	
		// Add more elements to trigger rehashing
		
		GraphNode n5 = new GraphNode("node5", false);
		GraphNode n6 = new GraphNode("node6", false);
		GraphNode n7 = new GraphNode("node7", false);
		hashMap.set(n5, 50);
		hashMap.set(n6, 60);
		hashMap.set(n7, 70);

		// Check updated values and keys after rehashing
		System.out.println("Value for node1 after rehashing: " + hashMap.getValue(n5)); // Expected output: 10
		System.out.println("HasKey for node6 after rehashing: " + hashMap.hasKey(n6)); // Expected output: true

		// Print out the hash table
		printHashTable(hashMap);
	}

	/**
	 * This method prints the hash table
	 * @param hashMap
	 */
	public static void printHashTable(HashMap hashMap) {
		System.out.println("\nHash Table:");
		for (int i = 0; i < hashMap.buckets.length; i++) {
			if (hashMap.buckets[i] != null) {
				System.out.println("Index " + i + ": Key=" + hashMap.buckets[i].getKey() + ", Value=" + hashMap.buckets[i].getValue());
			} else {
				System.out.println("Index " + i + ": Empty");
			}
		}
	}

}
