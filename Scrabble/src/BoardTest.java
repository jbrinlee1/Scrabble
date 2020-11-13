import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BoardTest {

	Board testBoard = new Board();
	
	@Test
	void testUpdateBoard() {
		Tile tile1 = new Tile("A", 1, null);
		this.testBoard.updateBoard(2, 2, tile1);
		String actualLetter = this.testBoard.getBoardArray()[1][1].getTile().getLetter();
		assertEquals("A", actualLetter);
		int actualValue = this.testBoard.getBoardArray()[1][1].getTile().getValue();
		assertEquals(1, actualValue);
		
	}

	@Test
	void testRemoveTileFromBoard() {
		Tile tile2 = new Tile("W", 5, null);
		this.testBoard.updateBoard(8, 8, tile2);
		this.testBoard.removeTileFromBoard(8, 8);
		assertEquals(true, this.testBoard.getBoardArray()[7][7].isOpen());
	}

	
	@Test
	void testisMoveValid() {
		
		//checking first move
		ArrayList<int[]> previousMoves = new ArrayList<int[]>();
		boolean result1 = this.testBoard.isMoveValid(7, 7, previousMoves);
		assertTrue(result1); 
		result1 = this.testBoard.isMoveValid(7, 8, previousMoves);
		assertEquals(false, result1);
		int[] move1 = {8,8};
		if(previousMoves.contains(move1)) {
			result1 = this.testBoard.isMoveValid(7, 8, previousMoves);
			assertEquals(true, result1);
		}
		
		//checking top left
		assertEquals(false, this.testBoard.isMoveValid(0, 0, previousMoves));
		int[] move2 = {0,1};
		if(previousMoves.contains(move2)) { 
		assertEquals(true, this.testBoard.isMoveValid(0, 0, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(0, 2, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(1, 0, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(1, 1, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(1, 2, previousMoves));
		}
		
		//checking top right
		assertEquals(false, this.testBoard.isMoveValid(0, 14, previousMoves));
		int[] move3 = {0,14};
		if(previousMoves.contains(move3)) { 
		assertEquals(true, this.testBoard.isMoveValid(0, 13, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(1, 14, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(1, 13, previousMoves));
		}
		
		//checking bottom left
		assertEquals(false, this.testBoard.isMoveValid(14, 0, previousMoves));
		int[] move4 = {13,1};
		if(previousMoves.contains(move4)) { 
		assertEquals(true, this.testBoard.isMoveValid(13, 0, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(14, 0, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(14, 1, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(14, 2, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(12, 1, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(12, 0, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(12, 2, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(13, 2, previousMoves));
		}
		
		//checking bottom right
		assertEquals(false, this.testBoard.isMoveValid(14, 14, previousMoves));
		int[] move5 = {13,14};
		if(previousMoves.contains(move5)) { 
		assertEquals(true, this.testBoard.isMoveValid(14, 14, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(14, 13, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(12, 14, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(13, 13, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(12, 13, previousMoves));
		}
		
		//checking word direction
		int[] move6 = {10,10};
		int[] move7 = {10,11};
		if(previousMoves.contains(move6) && previousMoves.contains(move7)) { 
		assertEquals(true, this.testBoard.isMoveValid(10, 12, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(10, 13, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(9, 10, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(11, 10, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(10, 9, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(11, 11, previousMoves));
		}
		//checking word vertical direction
		int[] move8 = {10,10};
		int[] move9 = {9,10};
		if(previousMoves.contains(move8) && previousMoves.contains(move9)) { 
		assertEquals(true, this.testBoard.isMoveValid(8, 10, previousMoves));
		assertEquals(true, this.testBoard.isMoveValid(11, 10, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(12, 10, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(9, 11, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(10, 11, previousMoves));
		assertEquals(false, this.testBoard.isMoveValid(11, 11, previousMoves));
				}
	}

}
