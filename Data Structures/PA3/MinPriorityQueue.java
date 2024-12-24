package main;
/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * December 13, 2023
 * COSI 21A PA3
 * 
 * The MinPriorityQueue class will allow
 * us to add items with certain priorities
 * and extract them in O(1) time. HashMap will
 * be used in this class along with heaps to assist
 * in the implementation of a MinPriorityQueue.
 * 
 * Known Bugs: N/A
 *
 */

public class MinPriorityQueue {

	private HashMap hashMap;
	private GraphNode[] heap;
	private int size;
	private int capacity;


	/**
	 * Constructor for this class.
	 * Default capacity of 10.
	 */
	public MinPriorityQueue() {
		this.size = 0;
		this.capacity = 10;
		this.heap = new GraphNode[capacity]; //initial capacity 10
		this.hashMap = new HashMap();
	}

	/**
	 * This method inserts g into the queue
	 * with its priority; heapify is called 
	 * after to restore the heap property.
	 * @param g
	 */
	public void insert(GraphNode g) {

		if(size == heap.length-1) {
			resizeHeap();
		}

		size++;
		heap[size] = g;
		hashMap.set(g,size);
		heapify(g);

	}


	/**
	 * This method removes the element
	 * with the highest priority in O(1)
	 * time; heapify is called 
	 * after to restore the heap property.
	 * @param g
	 */
	public GraphNode pullHighestPriorityElement() {

		GraphNode root = heap[1];
		heap[1] = heap[size];
		hashMap.set(heap[1], 1);
		hashMap.set(root, -1);
		heap[size] = null;
		size--;
		heapify(root);

		return root;
	}

	/**
	 * This method calls heapify to restore
	 * the heap property of the queue
	 * @param g
	 */
	public void rebalance(GraphNode g) {
		int index = hashMap.getValue(g);
		heapify(g);
	}

	/**
	 * Checks if the heap is empty
	 * @return true if the heap is empty
	 */
	public boolean isEmpty() {

		return size == 0;

	}

	/**
	 * Checks if we should heapify up or
	 * heapify down after an insertion
	 * or deletion
	 * @param g
	 */
	public void heapify(GraphNode g) {
		int index = hashMap.getValue(g);

		if(index == 0) {
			heapifyDown(g);
		}
		else {
			heapifyUp(g);
		}

	}

	/**
	 * The standard heapifyUp method of
	 * the heap data structure; restores 
	 * the heap property
	 * @param g
	 */
	private void heapifyUp(GraphNode g) {
		int index = hashMap.getValue(g);
		int parent = (index)/2;

		while(index > 1 && heap[index].priority < heap[parent].priority) {
			swap(index, parent);
			index = parent;
			parent = (index)/2;
		}
	}

	/**
	 * The standard heapifyDown method of
	 * the heap data structure; restores 
	 * the heap property
	 * @param g
	 */
	private void heapifyDown(GraphNode g) {

		int min = hashMap.getValue(g);
		int index = min;
		int leftChild = 2*index;
		int rightChild = 2*index + 1;

		if(leftChild < size && heap[leftChild].priority < heap[min].priority) { 
			min = leftChild;
		}
		if(rightChild < size && heap[rightChild].priority < heap[min].priority) {
			min = rightChild;
		}

		if(min != index) {
			swap(index, min);
			heapifyDown(heap[min]);
		}
	}

	/**
	 * Swaps two elements of the heap
	 * AND updates their positions in the 
	 * hash table
	 * @param x
	 * @param y
	 */
	private void swap(int x, int y) {
		GraphNode chair = heap[x];
		heap[x] = heap[y];
		heap[y]  = chair;

		hashMap.set(heap[x], x);
		hashMap.set(heap[y], y);
	}

	
	/**
	 * Resizes the heap once the capacity
	 * is reached.
	 */
	private void resizeHeap() {
		GraphNode [] holder = new GraphNode[capacity * 2];
		for(int i = 0; i < capacity; i++) {
			holder[i] = heap[i];
		}
		capacity *= 2;
		heap = holder;
	}

	/**
	 * Returns the hashMap
	 * @return
	 */
	public HashMap getHashMap() {
		return this.hashMap;
	}

}
