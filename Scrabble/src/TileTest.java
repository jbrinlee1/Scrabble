import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TileTest {

	String letter = "A";
	int value = 1;
	Tile tile = new Tile("A", 1, null);
	
	@Test
	void testGetLetter() {
		assertEquals(tile.getLetter(),"A");
	}

	@Test
	void testGetValue() {
		assertEquals(tile.getValue(),1);
	}


}
