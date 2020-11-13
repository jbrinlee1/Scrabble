import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class RackTest {
	private ArrayList<Tile> rack = new ArrayList<Tile>();
	Rack testRack = new Rack();
	
	
	@Test
	void testSelectTile() {
		Tile a = new Tile("A", 1, null);
		testRack.addTile(a);
		Tile b = new Tile("B", 2, null);
		testRack.addTile(b);
		Tile c = new Tile("C", 3, null);
		testRack.addTile(c);
		assertEquals(3, testRack.getRackArray().size());
		testRack.selectTile(0);
		assertEquals(2, testRack.getRackArray().size());
		assertTrue(!testRack.getRackArray().contains(a));
		
	}

	@Test
	void testRemoveTileInt() {
		Tile a = new Tile("A", 1, null);
		testRack.addTile(a);
		Tile b = new Tile("B", 2, null);
		testRack.addTile(b);
		Tile c = new Tile("C", 3, null);
		testRack.addTile(c);
		testRack.removeTile(0);
		assertEquals(2, testRack.getRackArray().size());
		testRack.removeTile(0);
		assertEquals(1, testRack.getRackArray().size());
	}


	@Test
	void testRemoveTileTile() {
		Tile a = new Tile("A", 1, null);
		testRack.addTile(a);
		Tile b = new Tile("B", 2, null);
		testRack.addTile(b);
		Tile c = new Tile("C", 3, null);
		testRack.addTile(c);
		testRack.removeTile(a);
		assertEquals(2, testRack.getRackArray().size());
		testRack.removeTile(b);
		assertEquals(1, testRack.getRackArray().size());
	}

	@Test
	void testGetRackArray() {
		Tile a = new Tile("A", 1, null);
		testRack.addTile(a);
		Tile b = new Tile("B", 2, null);
		testRack.addTile(b);
		Tile c = new Tile("C", 3, null);
		testRack.addTile(c);
		assertEquals(3,testRack.getRackArray().size());
		
	}

}
