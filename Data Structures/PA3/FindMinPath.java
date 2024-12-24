package main;
/**
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * December 13, 2023
 * COSI 21A PA3
 * 
 * The FindMinPath class contains the mechanics
 * and implementation for finding the shortest path.
 * Dijkstras Algorithm is used in this class. As the 
 * shortest path is being found, the algorithm is printing
 * out the turns of the shortest path.
 * 
 * Known Bugs: 
 *
 */
import java.io.FileWriter;
import java.io.IOException;

public class FindMinPath {

	/**
	 * Dijkstras Algorithm for finding the
	 * shortest path. Returns null if not found.
	 * @param graphWrapper
	 * @return
	 */
	public static GraphNode Dijkstras(GraphWrapper graphWrapper) {
		MinPriorityQueue Q = new MinPriorityQueue();
		GraphNode home = graphWrapper.getHome();
		home.priority = 0;
		Q.insert(home);

		while(!Q.isEmpty()) {
			GraphNode current = Q.pullHighestPriorityElement();

			if(current.isGoalNode()) {
				return current;
			}
			searchNeighbors(current, Q);
		}

		return null;
	}

	/**
	 * This method searches each neighbor of 
	 * the node we are currently on.
	 * @param current
	 * @param mpq
	 */
	private static void searchNeighbors(GraphNode current, MinPriorityQueue mpq) {
		if(current.hasNorth()) {
			searchOneNeighbor(current, current.getNorth(), "North", mpq);
		}
		if(current.hasSouth()) {
			searchOneNeighbor(current, current.getSouth(), "South", mpq);
		}
		if(current.hasEast()) {
			searchOneNeighbor(current, current.getEast(), "East", mpq);
		}
		if(current.hasWest()) {
			searchOneNeighbor(current, current.getWest(), "West", mpq);
		}
	}

	/**
	 * The bulk of Dijkstras Algorithm. Searches
	 * one neighbor and completes a series of checks
	 * and reassignments to assure that we our being
	 * given the shortest path to take.
	 * @param current
	 * @param neighbor
	 * @param dir
	 * @param mpq
	 */
	private static void searchOneNeighbor(GraphNode current, GraphNode neighbor, String dir, MinPriorityQueue mpq) {
		int x = current.priority + getDistance(current, neighbor);

		if(!mpq.getHashMap().hasKey(neighbor)) {
			neighbor.priority = x;
			neighbor.previousNode = current;
			neighbor.previousDirection = dir;
			mpq.insert(neighbor);
		}
		else if (mpq.getHashMap().hasKey(neighbor) && x < neighbor.priority) {
			neighbor.priority = x;
			neighbor.previousNode = current;
			neighbor.previousDirection = dir;
			mpq.rebalance(neighbor);
		}
	}

	/**
	 * Computes the distance between the current node
	 * and it's desired neighbor
	 * @param current
	 * @param neighbor
	 * @return distance
	 */
	private static int getDistance(GraphNode current, GraphNode neighbor) {
		int distance = 0;
		if(current.hasNorth() && current.getNorth() == neighbor) {
			distance = current.getNorthWeight();
			System.out.println("North");
		}
		else if(current.hasSouth() && current.getSouth() == neighbor) {
			distance = current.getSouthWeight();
			System.out.println("South");
		}
		else if(current.hasEast() && current.getEast() == neighbor) {
			distance = current.getEastWeight();
			System.out.println("East");
		}
		else if(current.hasWest() && current.getWest() == neighbor) {
			distance = current.getWestWeight();
			System.out.println("West");
		}

		return distance;
	}

	/**
	 * Prints the directions/turns we have taken
	 * to get to our location using the shortest 
	 * path.
	 * @param g
	 */
	private static void printAnswer(GraphNode g) {
		try (FileWriter writer = new FileWriter("answer.txt")){


			String path = "";
			boolean skipNode = false;
			while(g != null && g.previousDirection != null) {
				if(!skipNode) {
					skipNode = true;
					path = "\n" + g.previousDirection  + path;
				}
				else {
					path = "\n" + g.previousDirection  + path;

				}
				g = g.previousNode;
			}
			path = path.substring(path.indexOf('\n')+1);
			writer.write(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		GraphWrapper gw = new GraphWrapper(true);

		GraphNode goal = Dijkstras(gw);

		if(goal != null) {
			printAnswer(goal);
		}
		else {
			System.out.println("goal not found");
		}

	}

}
