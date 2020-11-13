import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.EmptyStackException;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class PlayerTest {
	
	Rack rack = new Rack();
	Player player = new Player("Mimi");
	int score ;

	@Test
	void testGetRack() {
		Tile tile1 = new Tile("O", 3, null);
		this.player.addTileToRack(tile1);
		int rackTileNum = this.player.getRack().getRackArray().size();
		assertEquals(1, rackTileNum);
		Tile tile2 = new Tile("P", 2, null);
		this.player.addTileToRack(tile2);
		rackTileNum = this.player.getRack().getRackArray().size();
		assertEquals(2, rackTileNum);
		
	}

	@Test
	void testGetName() {
		assertEquals(player.getName(), "Mimi");
	}

	@Test
	void testPickTileForRack() {
		BagOfTile bag = new BagOfTile();		
		//Make sure the rack starts empty
		assertEquals(player.getRack().getRackArray().size(), 0);
		//Pick a tile
		player.pickTileForRack(bag);
		//Rack array should be size one
		assertEquals(player.getRack().getRackArray().size(), 1);
		
	}

	@Test
	void testRemoveTileFromRack() {
		BagOfTile bag = new BagOfTile();		
		
		assertEquals(player.getRack().getRackArray().size(), 0);
		player.pickTileForRack(bag);
		player.pickTileForRack(bag);
		
		player.removeTileFromRack(0);
		//Rack array should be size one
		assertEquals(player.getRack().getRackArray().size(), 1);
		player.removeTileFromRack(0);
		assertEquals(player.getRack().getRackArray().size(), 0);
		
	}
	
	@Test
	void testGetScore() {
		player.incrementScore(50);
		assertEquals(player.getScore(),50); 
		
	}
	
	@Test
	void testIncrementScore() {
		Player test = new Player("Test");
		assertEquals(test.getScore(), 0);
		test.incrementScore(50);
		assertEquals(test.getScore(), 50);
		
	}
	
	@Test //Jacob, can I remove this? moved it up. 
	void pickTileForRackTest() {
		Player test = new Player("Test");
		BagOfTile bag = new BagOfTile();
		
		//Make sure the rack starts empty
		assertEquals(test.getRack().getRackArray().size(), 0);
		//Pick a tile
		test.pickTileForRack(bag);
		//Rack array should be size one
		assertEquals(test.getRack().getRackArray().size(), 1);
		
	}
	
	@Rule
	final ExpectedException exception = ExpectedException.none();
	
	@Test 
	public void testPickFromEmptyRack(){
		Player test = new Player("Test");
		BagOfTile bag = new BagOfTile();
		
		for(int i = 0 ; i < 98 ; i++) {
			bag.pickTile();
		}
		
		exception.expect(EmptyStackException.class);
		test.pickTileForRack(bag);
		
	}
	

	
	

}
