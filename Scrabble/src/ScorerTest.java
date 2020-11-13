import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;




public class ScorerTest {
	
	Scorer scorer = new Scorer();
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void checkIf3WordMultiplerExists() {
		//expect = what the value should be
		//actual = the value returned from the function		
		//assert(expected, actual)

		int expected = 3;

		assertEquals(expected, scorer.checkIfWordMultiplier(1, 1));
		assertEquals(expected, scorer.checkIfWordMultiplier(1, 8));
	}
	
	@Test
	public void checkIf2WordMultiplerExists() {
		//expect = what the value should be
		//actual = the value returned from the function		
		//assert(expected, actual)
		
		int expected = 2;
		

		assertEquals(expected, scorer.checkIfWordMultiplier(2, 2));
	}
	
	@Test
	public void checkIf1WordMultiplerExists() {
		//expect = what the value should be
		//actual = the value returned from the function		
		//assert(expected, actual)
		
		int expected = 1;
		

		assertEquals(expected, scorer.checkIfWordMultiplier(1,2));
	}
	
	
	@Test
	public void checkIf3letterMultiplerExists() {
		//expect = what the value should be
		//actual = the value returned from the function		
		//assert(expected, actual)
		
		int expected = 3;
		

		assertEquals(expected, scorer.letterMultiplier(2,6));
	}
	
	@Test
	public void checkIf2letterMultiplerExists() {
		//expect = what the value should be
		//actual = the value returned from the function		
		//assert(expected, actual)
		
		int expected = 2;
		

		assertEquals(expected, scorer.letterMultiplier(1,4));
	}
	
	@Test
	public void checkIf1letterMultiplerExists() {
		//expect = what the value should be
		//actual = the value returned from the function		
		//assert(expected, actual)
		
		int expected = 1;
		

		assertEquals(expected, scorer.letterMultiplier(7,1));
	}
	

	
//@Test
//public void calculateScore() {
			
//		BoardSpace[][] board = {{values here}};
//		ArrayList<int[]> boardLocation =
		
		
		
		
//		assertEquals();
//	}

}
