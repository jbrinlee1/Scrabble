import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BagOfTileTest {

	ArrayList<Tile> bagOfTiles = new ArrayList<Tile>();
	
	
	@Test
	public void initialSizeTest() {
		BagOfTile bag = new BagOfTile();
		assertEquals(bag.getBagOfTiles().size(), 100);
	}
	
	@Test
	public void sizeAfterPickTile() {
		BagOfTile bag = new BagOfTile();
		bag.pickTile();
		assertEquals(bag.getBagOfTiles().size(), 99);
		bag.pickTile();
		assertEquals(bag.getBagOfTiles().size(), 98);
		
	}
	
	@Test
	public void sizeAfterAddTile() {
		BagOfTile bag = new BagOfTile();
		Tile a = new Tile("A", 1, "A.jpg");
		bag.addTile(a);
		assertEquals(bag.getBagOfTiles().size(),101);
		Tile e = new Tile("E", 1, "E.jpg");
		bag.addTile(e);
		assertEquals(bag.getBagOfTiles().size(),102);
		
	}
	
}
