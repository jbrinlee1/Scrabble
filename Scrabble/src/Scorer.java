import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Class that is used to score the scrabble game
 * 
 * @author Melisa Parta
 *
 */
public class Scorer {
	
	
	
	public int checkIfWordMultiplier(int row, int col) {
		int[][] location3WordMult = {{0, 0}, {0, 7}, {0, 14}, {7, 0}, {7, 14}, {14, 0}, {14, 7}, {14,14}};
		int[][] location2WordMult = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {10, 4}, {11, 3}, {12, 2}, {13, 1}, {1, 13}, {2, 12}, {3, 11}, {4, 10}, {10, 10}, {11, 11}, {12, 12}, {13, 13}};
			
		for(int a = 0; a < location3WordMult.length; a++)
		{
			if(row == location3WordMult[a][0] && col == location3WordMult[a][1]) {
				return 3;
			}
		}
			
		for(int b = 0; b < location2WordMult.length; b++)
		{
			if(row == location2WordMult[b][0] && col == location2WordMult[b][1]) {
				return 2;
			}
		}
		
		return 1;
	}
	
	public int letterMultiplier(int row, int col) {
		int[][] locationsOf2LetterMult = {{0, 3}, {0, 11}, {2, 6},{2, 8},{2, 12},{3, 0},{3, 7},{3, 14},{6, 2},{6, 6},{6, 8},{6, 12},{7, 3},{7, 11},{8, 2},{8, 6},{8, 8},{8, 12},{11, 0},{11, 7},{11, 14},{12, 6},{12, 8},{14, 3},{14, 11}};
		int[][] locationsOf3LetterMult = {{1, 5},{1, 9},{5, 1},{5, 5},{5, 9},{5, 13},{9, 1},{9, 5},{9, 9},{9, 13},{13, 5},{13, 9}};
	
		
		for(int a = 0; a < locationsOf3LetterMult.length; a++)
		{
			if(row == locationsOf3LetterMult[a][0] && col == locationsOf3LetterMult[a][1]) {
				return 3;
			}
		}
		
		for(int b = 0; b < locationsOf2LetterMult.length; b++)
		{
			if(row == locationsOf2LetterMult[b][0] && col == locationsOf2LetterMult[b][1]) {
				return 2;
			}
		}
		return 1;
	}
	
	public int calculateScore(ArrayList<int[]> boardLocation, BoardSpace[][] board) {
		int score = 0;
		int row;
		int col;
		int letterValue;
		int multiplierValue = 0;
		int doubleWordCnt = 0;
		int tripleWordCnt = 0;
		
		for(int i = 0; i < boardLocation.size(); i++) {
			row = boardLocation.get(i)[0];
			col = boardLocation.get(i)[1];
			letterValue = board[row][col].getTile().getValue();
			
			//applying letter multiplier and add up letter values
			score = score + (letterValue * letterMultiplier(row, col));
			
			//checking if word multiplier is present
			multiplierValue = checkIfWordMultiplier(row, col);
			if(multiplierValue == 3)
				tripleWordCnt++;
			else if(multiplierValue == 2)
				doubleWordCnt++;
		}
		
		//applying word multiplier
		if(tripleWordCnt > 0)
			score = score * (3 * tripleWordCnt);
		else if(doubleWordCnt > 0)
			score = score * (2 * doubleWordCnt);
		
		return score;
	}
	
}
