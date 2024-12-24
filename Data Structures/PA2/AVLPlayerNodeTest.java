package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.AVLPlayerNode;
import main.Player;

public class AVLPlayerNodeTest {

	@Test
	public void testAVLPlayerNodeConstructor() {
		Player p1 = new Player("Mike", 1, 2400.00);
		Player p2 = new Player("Sandra", 2, 2300.00);
		Player p3 = new Player("Eric", 3, 2200.00);
		Player p4 = new Player("Fred", 4, 2100.00);
		
		AVLPlayerNode tree = new AVLPlayerNode(p1, p1.getELO());
		tree.insert(p2, p2.getELO());
		tree.insert(p3, p3.getELO());
		tree.insert(p4, p4.getELO());
		
		assertEquals("(((Fred)Eric)Sandra(Mike))",tree.treeString());
		
		AVLPlayerNode tree2 = new AVLPlayerNode(p1, p1.getID());
		tree2.insert(p2, p2.getID());
		tree2.insert(p3, p3.getID());
		tree2.insert(p4, p4.getID());
		
		assertEquals("((Mike)Sandra(Eric(Fred)))", tree2.treeString());
	}

	



	@Test
	public void testGetRank() {
		Player p1 = new Player("Mike", 1, 2400.00);
		Player p2 = new Player("Sandra", 2, 2300.00);
		Player p3 = new Player("Eric", 3, 2200.00);
		Player p4 = new Player("Fred", 4, 2100.00);
		
		AVLPlayerNode tree = new AVLPlayerNode(p1, p1.getELO());
		tree.insert(p2, p2.getELO());
		tree.insert(p3, p3.getELO());
		tree.insert(p4, p4.getELO());
				
		AVLPlayerNode tree2 = new AVLPlayerNode(p1, p1.getID());
		tree2.insert(p2, p2.getID());
		tree2.insert(p3, p3.getID());
		tree2.insert(p4, p4.getID());
		
		assertEquals(1, tree.getRank(p1.getELO()));
	}
	
	@Test
	public void testInsert() {
		Player p1 = new Player("Mike", 1, 2400.00);
		Player p2 = new Player("Sandra", 2, 2300.00);
		Player p3 = new Player("Eric", 3, 2200.00);
		Player p4 = new Player("Fred", 4, 2100.00);
		
		AVLPlayerNode tree = new AVLPlayerNode(p1, p1.getELO());
		;
		
		assertEquals("Mike", tree.insert(p2,p2.getELO()).getData().getName());
		
		assertEquals("Sandra", tree.insert(p3,p3.getELO()).getData().getName());
		
		assertEquals("Sandra", tree.insert(p4,p4.getELO()).getData().getName());
				
	}
	
	@Test
	public void testGetPlayer() {
		Player p1 = new Player("Mike", 1, 2400.00);
		Player p2 = new Player("Sandra", 2, 2300.00);
		Player p3 = new Player("Eric", 3, 2200.00);
		Player p4 = new Player("Fred", 4, 2100.00);
		
		AVLPlayerNode tree = new AVLPlayerNode(p1, p1.getELO());
		tree.insert(p2, p2.getELO());
		tree.insert(p3, p3.getELO());
		tree.insert(p4, p4.getELO());
				
		AVLPlayerNode tree2 = new AVLPlayerNode(p1, p1.getID());
		tree2.insert(p2, p2.getID());
		tree2.insert(p3, p3.getID());
		tree2.insert(p4, p4.getID());
		
		assertEquals(p2, tree.getPlayer(2));
	}

}

