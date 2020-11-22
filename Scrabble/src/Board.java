import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;


/**
 * Class that represents the scrabble board
 * @author Jacob Brinlee
 *
 */
public class Board {
	
	private BoardSpace[][] board = new BoardSpace[15][15];
	
	/**
	 * Board Constructor
	 * Fill the BoardSpace array with multiple and multiplier type
	 */
	public Board() {
		
		//Initialize row 1
		board[0][0] = new BoardSpace(3, "W", "3W.jpg");
		board[0][1] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][2] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][3] = new BoardSpace(2, "L", "2L.jpg");
		board[0][4] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][5] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][6] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][7] = new BoardSpace(3, "W", "3W.jpg");
		board[0][8] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][9] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][10] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][11] = new BoardSpace(2, "L", "2L.jpg");
		board[0][12] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][13] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[0][14] = new BoardSpace(3, "W", "3W.jpg");
		
		//Initialize row 2
		board[1][0] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][1] = new BoardSpace(2, "W", "2W.jpg");
		board[1][2] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][3] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][4] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][5] = new BoardSpace(3, "L", "3L.jpg");
		board[1][6] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][7] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][8] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][9] = new BoardSpace(3, "L", "3L.jpg");
		board[1][10] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][11] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][12] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[1][13] = new BoardSpace(2, "W", "2W.jpg");
		board[1][14] = new BoardSpace(1, "", "Blank Space.jpg" );
		
		//Initialize row 3
		board[2][0] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][1] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][2] = new BoardSpace(2, "W", "2W.jpg");
		board[2][3] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][4] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][5] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][6] = new BoardSpace(2, "L", "2L.jpg");
		board[2][7] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][8] = new BoardSpace(2, "L", "2L.jpg");
		board[2][9] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][10] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][11] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][12] = new BoardSpace(2, "W", "2W.jpg");
		board[2][13] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[2][14] = new BoardSpace(1, "", "Blank Space.jpg" );		
		
		//Initialize row 4
		board[3][0] = new BoardSpace(2, "L", "2L.jpg");
		board[3][1] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][2] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][3] = new BoardSpace(2, "W", "2W.jpg");
		board[3][4] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][5] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][6] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][7] = new BoardSpace(2, "L", "2L.jpg");
		board[3][8] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][9] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][10] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][11] = new BoardSpace(2, "W", "2W.jpg");
		board[3][12] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][13] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[3][14] = new BoardSpace(2, "L", "2L.jpg");
		
		//Initialize row 5
		board[4][0] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][1] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][2] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][3] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][4] = new BoardSpace(2, "W", "2W.jpg");
		board[4][5] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][6] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][7] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][8] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][9] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][10] = new BoardSpace(2, "W", "2W.jpg");
		board[4][11] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][12] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][13] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[4][14] = new BoardSpace(1, "", "Blank Space.jpg" );
		
		//Initialize row 6
		board[5][0] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][1] = new BoardSpace(3, "L", "3L.jpg");
		board[5][2] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][3] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][4] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][5] = new BoardSpace(3, "L", "3L.jpg");
		board[5][6] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][7] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][8] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][9] = new BoardSpace(3, "L", "3L.jpg");
		board[5][10] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][11] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][12] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[5][13] = new BoardSpace(3, "L", "3L.jpg");
		board[5][14] = new BoardSpace(1, "", "Blank Space.jpg" );
		
		//Initialize row 7
		board[6][0] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][1] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][2] = new BoardSpace(2, "L", "2L.jpg");
		board[6][3] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][4] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][5] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][6] = new BoardSpace(2, "L", "2L.jpg");
		board[6][7] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][8] = new BoardSpace(2, "L", "2L.jpg");
		board[6][9] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][10] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][11] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][12] = new BoardSpace(2, "L", "2L.jpg");
		board[6][13] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[6][14] = new BoardSpace(1, "", "Blank Space.jpg" );
		
		//Initialize row 8
		board[7][0] = new BoardSpace(3, "W", "3W.jpg");
		board[7][1] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][2] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][3] = new BoardSpace(2, "L", "Blank Space.jpg" );
		board[7][4] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][5] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][6] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][7] = new BoardSpace(1, "Star", "Star.jpg");
		board[7][8] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][9] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][10] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][11] = new BoardSpace(2, "L", "Blank Space.jpg" );
		board[7][12] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][13] = new BoardSpace(1, "", "Blank Space.jpg" );
		board[7][14] = new BoardSpace(3, "W", "3W.jpg");
		
		//Initialize row 9-15
		for(int i = 8 ; i < 15 ; i++) {
			for(int j = 0 ; j < 15 ; j++) {
				board[i][j] = new BoardSpace(board[14 - i][j].getMultiplier(), board[14 - i][j].getMultiplierType(), board[14 - i][j].getIconPath());
			}
		}		
		
	}
	
	
	/**
	 * Method to print the board
	 */
	public void printBoard() {
		
		System.out.printf("%-8s", " ");
		for(int i = 1 ; i < 16 ; i++) {
			System.out.printf("%-8s", i);
		}
		System.out.println("");		
		System.out.printf("%-8s","1");
		for(int i = 0 ; i < 15 ; i++) {
			for(int j = 0 ; j < 15 ; j++) {
				if(board[i][j].isOpen()) {
					if(j == 14) {
						System.out.println(board[i][j].getMultiplier() + board[i][j].getMultiplierType());
						if(i != 14) {
							System.out.printf("%-8s", i+2);
						}
					} else {
						System.out.printf("%-8s", board[i][j].getMultiplier() + board[i][j].getMultiplierType());
					}
				} else {
					if(j == 14) {
						System.out.println(board[i][j].getTile().getLetter());
						if(i != 14) {
							System.out.printf("%-8s", i+2);
						}
					} else {
						System.out.printf("%-8s", board[i][j].getTile().getLetter());
					}
				}
			}
		}
		System.out.println("");
	}
	
	
	/**
	 * Method that updates the board object
	 * 
	 * @param row
	 * @param column
	 * @param tile
	 */
	public void updateBoard(int row, int column, Tile tile) {

		//if (isMoveValid(row, column) == true) {
			// Set board space details at specified location
			board[row - 1][column - 1].setTile(tile);
			board[row - 1][column - 1].setOpen(false);
		//}
	}
	
	public Tile removeTileFromBoard(int row, int column) {
		
		return board[row - 1][column - 1].removeTile();
		
	}
	
	
	/**
	 * Getter method
	 * @return BoardSpace Array
	 */
	public BoardSpace[][] getBoardArray(){
		return this.board;
	}
	
	public boolean isMoveValid(int r, int c, ArrayList<int[]> previousMoves) {		
		
		//If the space isn't open, the player cannot place a tile there
		if(!board[r][c].isOpen()) {
			JOptionPane.showMessageDialog(null, "That space is not open, please choose another space to place your tile.");
			return false;
		}
		
		//This is the first move
		if(previousMoves.isEmpty()) {
			
			//Star is open, the tile must be placed on the star
			if(board[7][7].isOpen() && (r != 7 || c != 7)) {
				JOptionPane.showMessageDialog(null, "The first tile must be placed on the star. Try row 8 and column 8.");
				return false;
			} 
			
			//If star isn't open, tile placed must be next to another tile on first move
			if(!board[7][7].isOpen()) {
				
				if(!nextToTile(r, c)) {
					return false;
				}
			}
		} else if (previousMoves.size() == 1) { //This is the second move
			
			int[] firstMove = previousMoves.get(0);
			
			//Tile must be placed on the same row or same column as the first tile placed
			if(r != firstMove[0] && c != firstMove[1] ){
				JOptionPane.showMessageDialog(null, "The second tile must be placed on the same row OR on the same column as the first tile");
				return false;
			}
			
			//Tile must be placed next to another tile
			if(!nextToTile(r, c)) {
				return false;
			}
			
		} else if (previousMoves.size() > 1) {
			
			int[] firstMove = previousMoves.get(0);
			int[] secondMove = previousMoves.get(1);

			//If the first and second move have the same row, the word is horizontal and the row must be the same
			if(firstMove[0] == secondMove[0] && r != firstMove[0]) {
				JOptionPane.showMessageDialog(null, "You're playing a word horizontally. The row must be the same as the previous moves");
				return false;
			}
			
			//If the first and second move have the same column, the word is vertical and the row must be the same
			if(firstMove[1] == secondMove[1] && c != firstMove[1]) {
				JOptionPane.showMessageDialog(null, "You're playing a word vertically. The column must be the same as the previous moves");
				return false;
			}
			
			//Tile must be placed next to another tile
			if(!nextToTile(r , c)) {
				return false;
			}
		}
		return true;
	}	

	private boolean nextToTile(int r, int c) {
		
		if(r == 0 && c == 0) { //If in the top left corner, don't look up or left
			if(board[r][c + 1].isOpen() && board[r + 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}	
		} else if(r == 14 && c == 14) { //If in the bottom right corner, don't look down or right
			if(board[r][c - 1].isOpen() && board[r - 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}	
		} else if(r == 14 && c == 0) { //If in the bottom left corner, don't look down or left
			if(board[r][c + 1].isOpen() && board[r - 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}	
		} else if(r == 0 && c == 14) { //If in the top right, don't look up or right
			if(board[r][c - 1].isOpen() && board[r + 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}					
		} else if(r == 0) { //If on the top, don't look up
			if(board[r][c + 1].isOpen() && board[r][c - 1].isOpen() && board[r + 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}	
		} else if(r == 14) { //If on the bottom, don't look down
			if(board[r][c + 1].isOpen() && board[r][c - 1].isOpen() && board[r - 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}
		} else if(c == 0) { //if on the left, don't look right
			if(board[r][c + 1].isOpen() && board[r - 1][c].isOpen() && board[r + 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}
		} else if(c == 14) { //If on the right, don't look left
			if( board[r][c - 1].isOpen() && board[r - 1][c].isOpen() && board[r + 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}
		} else { //Else look in all directions
			if(board[r][c + 1].isOpen() && board[r][c - 1].isOpen() && board[r - 1][c].isOpen() && board[r + 1][c].isOpen()) {
				JOptionPane.showMessageDialog(null, "The tile you're placing should be next to another tile on the board.");
				return false;
			}	
		}
		return true;
		
	}

	
	
//////////////////////////////////////////////////////////////Get word played/////////////////////////////////////////////////////////////

	
	/**
	 * Method that gets the spaces (1D array where the first element is the row and the second element is the column) 
	 * of potential words. We know the tiles the user placed but to find out the word they made we also have to look at the tiles
	 * they wanted to use that were already on the board.
	 * 
	 * For each tile placed the method gets all the tiles one the board vertically and horizontally
	 * 
	 * Then it calls a sort method that sorts the spaces in order and removes any duplicates
	 * 
	 * @param playedMoves - an ArrayList of 1D, 2 element arrays that represents where the player placed tiles on their move
	 * @return an ArrayList of sorted ArrayLists of 1D, 2 element arrays that represents all tiles used in creation of a word
	 */
	public ArrayList<ArrayList<int[]>> getSpacesOfPotentialWords(ArrayList<int[]> playedMoves) {
		
		
		ArrayList<ArrayList<int[]>> potentialWords = new ArrayList<ArrayList<int[]>>();

		for(int[] tile : playedMoves) {
			ArrayList<int[]> spacesRow = new ArrayList<int[]>();
			ArrayList<int[]> spacesColumn = new ArrayList<int[]>();
			int r = tile[0];
			int c = tile[1];
			spacesRow.add(tile);
			spacesColumn.add(tile);	
					
  ///////////////////////////////////////////////////////////////////Row			
			
			//Search right
			for(int i = 1 ; i < 15 ; i++) {
				//If at the edge of the board break to prevent runtime error
				if((r + i) == 15) {
					break;
				}
				//If the space to the right has a tile, save the location
				if(!board[r + i][c].isOpen()) {
					int[] space = new int[2];
					space[0] = r + i;
					space[1] = c;
					spacesRow.add(space);
					
				} else { //Else there is a break in tiles so don't add any more
					break;
				}
			}
				
			//Search left
			for(int i = 1 ; i < 15 ; i++) {
				//If at the edge of the board break to prevent runtime error
				if((r - i) == -1) {
					break;
				}
				//If space to the left has tile, save the location
				if(!board[r - i][c].isOpen()) {
					int[] space = new int[2];
					space[0] = r - i;
					space[1] = c;
					spacesRow.add(space);
					
				} else { //Else there is a break in tiles so don't add any more
					break;
				}
			}

			//Take continues spaces with tiles to the left and right. These are all the tiles in the row that could be a potential word.
			potentialWords.add(spacesRow);
		//////////////////////////////////////////////////////////////////Column
		
			//Search up
			for(int i = 1 ; i < 15 ; i++) {
				//If at the edge of the board break to prevent runtime error
				if((c + i) == 15) {
					break;
				}
				//If space has tile, save the location
				if(!board[r][c + i].isOpen()) {
					int[] space = new int[2];
					space[0] = r;
					space[1] = c + i;
					spacesColumn.add(space);
					
				} else { //Else there is a break in tiles so don't add any more
					break;
				}
			}
			
			//Search down
			for(int i = 1 ; i < 15 ; i++) {
				//If at the edge of the board break to prevent runtime error
				if((c - i) == -1) {
					break;
				}
				//If space has tile, save the location
				if(!board[r][c - i].isOpen()) {
					int[] space = new int[2];
					space[0] = r;
					space[1] = c - i;
					spacesColumn.add(space);
					
				} else { //Else there is a break in tiles so don't add any more
					break;
				}
			}
			//Take continues spaces with tiles to the top and bottom. These are all the tiles in the column that could be a potential word.
			potentialWords.add(spacesColumn);
		}
		
	
		potentialWords = sortPotentialWords(potentialWords);
		return removeDuplicates(potentialWords);
	}

	
	/**
	 * Method used in getSpacesOfPotentialWords to sort ArrayLists of int arrays.
	 * @param potentialSpaces is an ArrayList of 1D, 2 element int arrays that contain spaces of tiles that make words
	 * @return an ArrayList of sorted 1D, 2 element in arrays.
	 */
	private ArrayList<ArrayList<int[]>> sortPotentialWords(ArrayList<ArrayList<int[]>> potentialSpaces){
		
		ArrayList<ArrayList<int[]>> potentialWords = potentialSpaces;
		ArrayList<ArrayList<int[]>> sortedPotentialWords = new ArrayList<ArrayList<int[]>>();
		
		//For each potential word
		for(int i = 0 ; i < potentialWords.size() ; i++) {
			
			ArrayList<int[]> word = potentialWords.get(i);
			
			//For all words that aren't one letter
			if(word.size() != 1) {
				Collections.sort(word, new Comparator<int[]>() {
					@Override
					public int compare(int[] a, int[] b) {
						if(a[0] - b[0] == 0) {
							return a[1] - b[1];
						} else {
							return a[0] - b[0];
						}
					}
				});
				//Add word which has been sorted
				sortedPotentialWords.add(word);		
			}
		}
		
		return sortedPotentialWords;
	}
	
	
	/** 
	 * Method that removes duplicate ArrayList of spaces
	 * @param potentialWords
	 * @return
	 */
	private ArrayList<ArrayList<int[]>> removeDuplicates(ArrayList<ArrayList<int[]>> potentialWords){
		
		//For every word
		for(int i = 0 ; i < potentialWords.size() ; i++) {
			
			//Save that word
			ArrayList<int[]> tempWord = potentialWords.get(i);
			
			//For every words after the ith word
			for(int j = i + 1 ; j < potentialWords.size(); j++) {
				
				ArrayList<int[]> tempWordComp = potentialWords.get(j);
				
				//If the two words are the same size, they could be the same
				if(tempWord.size() == tempWordComp.size()) {
					
					boolean sameSpaces = true;
					
					//For each space on board compare
					for(int k = 0 ; k < tempWord.size(); k++) {
						
						//If any space in the same location of the word is, the arrays are different
						if(tempWord.get(k)[0] != tempWordComp.get(k)[0] && tempWord.get(k)[1] != tempWordComp.get(k)[1]) {
							sameSpaces = false;							
						}
						
					}
					//There was no space different to throw a false, then remove the comparable word - it is a duplicate.
					if(sameSpaces) {
						potentialWords.remove(j);
						j--;
					}	
				}
			}	
		}

		return potentialWords;
	}
	
}
	
	
	
