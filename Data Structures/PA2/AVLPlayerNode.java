package main;

import static org.junit.Assert.assertEquals;

/**
 * This class maintains the insertions and deletions of an
 * AVL tree. In this specific case, the class maintains the
 * correct order of the leader board for those in the chess
 * tournament. This class contains nodes with their two children
 * and parent. It also contains the mechanics so that the tree
 * can self-balance.
 * 
 * Known Bugs: The tree.String() method only prints the leaf nodes
 * of the AVL tree. The getPlayer() method returns for every value
 * except the first value inserted. Scoreboard is not implemented correctly.
 * 
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * November 15, 2023
 * COSI 21A PA2
 *
 */
/**
 * Your code goes in this file
 * fill in the empty methods to allow for the required
 * operations. You can add any fields or methods you want
 * to help in your implementations.
 */


public class AVLPlayerNode{
	private Player data;
	private double value;
	private AVLPlayerNode parent;
	private AVLPlayerNode leftChild;
	private AVLPlayerNode rightChild;
	private AVLPlayerNode root;
	private int rightWeight;
	private int balanceFactor;

	public AVLPlayerNode(Player data,double value){
		this.data = data;
		this.value = value;
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
		this.rightWeight = 0;
		this.balanceFactor = 0;
		this.root = this;

	}

	/**
	 * This method recursively inserts a new player into the tree.
	 * After the player is inserted, this method does the necessary
	 * balancing if need be.
	 * @param newGuy
	 * @param value
	 * @return
	 * 
	 * RUNTIME: O(logn)
	 */
	//This should return the new root of the tree
	//make sure to update the balance factor and right weight
	//and use rotations to maintain AVL condition
	public AVLPlayerNode insert(Player newGuy,double value){

		if (value < this.value) {
			if (leftChild == null) {
				leftChild = new AVLPlayerNode(newGuy, value);
				leftChild.parent = this;
			} 
			else {
				leftChild = leftChild.insert(newGuy, value);
			}
		} 
		else if (value > this.value) {
			if (rightChild == null) {
				rightChild = new AVLPlayerNode(newGuy, value);
				rightChild.parent = this;

			} 
			else {
				rightChild = rightChild.insert(newGuy, value);
			}
			rightWeight++;
		}

		updateBalanceFactor(); //computes the balance factor
		
		if (balanceFactor == 2) {
			if (leftChild.balanceFactor < 0) {
				leftChild.rotateLeft();
			}

			rotateRight();

		}
		else if (balanceFactor == -2) {
			if (rightChild.balanceFactor > 0) {
				rightChild.rotateRight();
			}
			rotateLeft();

		}
		return root; //returns the root of the tree after all balancing 
	}

	//This should return the new root of the tree
	//remember to update the right weight
	/**
	 * This method recursively deletes a value from tree while
	 * maintaining the AVL balancing properties. After the player
	 * is deleted, the necessary changes are made to the tree.
	 * @param value
	 * @return root
	 * 
	 * RUNTIME: O(logn)
	 */
	public AVLPlayerNode delete(double value){
		//TODO: write standard vanilla BST delete method
		//Extra Credit: use rotations to maintain the AVL condition
		if (value < this.value) {
			if (leftChild != null) {
				leftChild = leftChild.delete(value);
				if (leftChild != null) {
					leftChild.parent = this;
				}
			}
		} else if (value > this.value) {
			if (rightChild != null) {
				rightChild = rightChild.delete(value);
				if (rightChild != null) {
					rightChild.parent = this;
					rightWeight--;
				}
			}
		} else {
			if (leftChild == null && rightChild == null) {
				return null;
			} else if (leftChild == null) {
				return rightChild;
			} else if (rightChild == null) {
				return leftChild;
			} else {
				AVLPlayerNode successor = rightChild.getMinNode();
				this.value = successor.value;
				this.data = successor.data;
				rightChild = rightChild.delete(successor.value);
				if (rightChild != null) {
					rightChild.parent = this;
				}
				rightWeight--;
			}
		}


		updateBalanceFactor(); //computed balance factor
		if (balanceFactor == 2) {
			if (leftChild.balanceFactor < 0) {
				leftChild.rotateLeft();
			}

			rotateRight();

		}
		else if (balanceFactor == -2) {
			if (rightChild.balanceFactor > 0) {
				rightChild.rotateRight();
			}
			rotateLeft();

		}
		return root;

	}
	/**
	 * This method returns the minimum node
	 * 
	 * RUNTIME: O(logn)
	 * @return
	 */
	private AVLPlayerNode getMinNode() {
		if (leftChild == null) {
			return this;
		}
		return leftChild.getMinNode();
	}



	/**
	 * This method rotates the tree to the right
	 * by making the left child the new root of the tree
	 * 
	 * RUNTIME: O(1)
	 */
	//remember to maintain rightWeight
	private void rotateRight(){
		AVLPlayerNode newRoot = this.leftChild;
		this.leftChild = newRoot.rightChild;
		if(newRoot.rightChild != null) {
			newRoot.rightChild.parent = this;
		}

		newRoot.parent = this.parent;
		if (this.parent == null) {
			this.root = newRoot;
		}
		else if (this == this.parent.rightChild) {
			this.parent.rightChild = newRoot;
		}
		else {
			this.parent.leftChild = newRoot;
		}

		newRoot.rightChild = this;
		this.parent = newRoot;
		
		rightWeight++;
	}

	/**
	 * This method balances the tree by rotating
	 * the contents to the left, by making the
	 * right child the new root.
	 * 
	 * RUNTIME: O(1)
	 */
	//remember to maintain rightWeight
	private void rotateLeft(){
		AVLPlayerNode newRoot = this.rightChild;
		this.rightChild = newRoot.leftChild;
		if(newRoot.leftChild != null) {
			newRoot.leftChild.parent = this;
		}

		newRoot.parent = this.parent;
		if (this.parent == null) {
			this.root = newRoot;
		}
		else if (this == this.parent.leftChild) {
			this.parent.leftChild = newRoot;
		}
		else {
			this.parent.rightChild = newRoot;
		}

		newRoot.leftChild = this;
		this.parent = newRoot;

		rightWeight--;
	}

	/**
	 * This method should return a player based on
	 * their value.
	 * @param value
	 * @return
	 * 
	 * RUNTIME: O(log n)
	 */
	//this should return the Player object stored in the node with this.value == value
	public Player getPlayer(double value){
		if(value == this.value) {
			return data;
		}
		else if (value < this.value && leftChild != null) {
			return leftChild.getPlayer(value);
		}
		else if(value > this.value && rightChild != null) {
			return rightChild.getPlayer(value);
		}
		return null;
	}

	/**
	 * This method returns the rank of a player
	 * @param value
	 * @return
	 * 
	 * RUNTIME: O(log n)
	 */
	//this should return the rank of the node with this.value == value
	public int getRank(double value){
		if( value == this.value) {
			if(rightChild != null) {
				return rightChild.countNodes() + 1;
			}
			return 1;
		}
		else if (value < this.value) {
			if(leftChild != null) {
				return leftChild.getRank(value);
			}
			return 0;
		}
		else {
			if(rightChild != null) {
				return rightChild.getRank(value) + leftChild.countNodes() + 1;
			}
			return leftChild.countNodes() + 1;
		}

	}



	/**
	 * This method updates the balance factor of a 
	 * tree by calculating and returning it's height
	 * to see if the tree must be balanced or not
	 * 
	 * RUNTIME: O(n)
	 */
	private void updateBalanceFactor() {
		int leftHeight = 0;
		int rightHeight = 0;

		if (leftChild != null) {
			leftHeight = 1 + leftChild.getHeight();
		}
		if (rightChild != null) {
			rightHeight = 1 + rightChild.getHeight();
		}

		balanceFactor = leftHeight - rightHeight;
	}


	/**
	 * This method calculates the height of a node
	 * @return
	 * 
	 * RUNTIME: O(n)
	 */
	private int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;

		if (leftChild != null) {
			leftHeight = leftChild.getHeight() + 1;
		}
		if (rightChild != null) {
			rightHeight = rightChild.getHeight() + 1;
		}

		if (leftHeight > rightHeight) {
			return leftHeight;
		} else {
			return rightHeight;
		}
	}

	/**
	 * This method counts the number of nodes in a tree.
	 * Used when maintaining the right weight
	 * 
	 * RUNTIME: O(n)
	 * @return
	 */

	private int countNodes() {
		if (rightChild != null) {
			return rightChild.countNodes() + 1;
		}
		return 1;
	}

	/**
	 * This method should returnt the contents of the tree
	 * as a String.
	 * 
	 * RUNTIME: O(n)
	 * @return
	 */
	//this should return the tree of names with parentheses separating subtrees
	//eg "((bob)alice(bill))"
	public String treeString(){
		String printedTree = "";
		
		if (leftChild != null) {
			printedTree += "(" + leftChild.treeString() + ")";
		}
		printedTree += data.getName();
		//printedTree += this.getRoot().data.getName();

		if (rightChild != null) {
			printedTree +=  "(" + rightChild.treeString() + ")";
		}
		
		return printedTree.toString();
	}


	//this should return a formatted scoreboard in descending order of value
	//see example printout in the pdf for the command L
	public String scoreboard(){
		String printedScoreboard = "";


		if(rightChild != null) {
			printedScoreboard += rightChild.scoreboard();
		}
		printedScoreboard += data.getName() + "   " + data.getID() + "   " + data.getELO() + "\n";

		if(leftChild != null) {
			printedScoreboard += leftChild.scoreboard();
		}


		return printedScoreboard;
	}



	/**
	 * This method returns the root of the tree
	 * 
	 * RUNTIME: O(1)
	 * @return
	 */
	public AVLPlayerNode getRoot() {
		return this.root;
	}

	/**
	 * This method returns a player's data
	 * 
	 * RUNTIME: O(1)
	 * @return
	 */
	public Player getData() {
		return this.data;
	}

	
}


