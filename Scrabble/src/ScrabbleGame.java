import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class that represents a Scrabble Game
 * 
 * 
 * User specifies the number of players
 * Players play to score specified by player
 * 
 * @author Jacob
 *
 */
public class ScrabbleGame {
	
	
	private int numPlayers;			//number of player - entered by user
	private int turnCounter;		//keeps track of players turn - set randomly to start
	private int scoreToWin;			//score to win - entered by user
	private boolean isGameOver;		//set to true when one players score > score to win
	private boolean isTurnOver;		//set to true when user wants to end their turn
	private Player[] players;		//array of players
	private Board board;			//board used for game instance
	private BagOfTile bagOfTile;	//bag of tile for game instance
	private Dictionary dictionary;	//dictionary used for game instance - set by programmer
	private Scorer scorer;			//scorer object that calculates and awards points
	private GUI gui;				//GUI
	private JFrame frame;			//Frame that pops up to get user input.

	
	/**
	 * Constructor of SrabbleGame
	 */
	public ScrabbleGame() {
		
		//Initialize all the instance variables
		board = new Board();
		bagOfTile = new BagOfTile();
		dictionary = new Dictionary();
		scorer = new Scorer();
		isGameOver = false;
		isTurnOver = false;
		gui = new GUI("Scrabble Game");
		
		//Create players and get score to win
		this.createPlayers();
		this.getScoreToWin();

	}
	
	/**
	 * The play method contain the game logic
	 */
	public void play() {
		
		//////////////////////////////////////////////// GAME VARIABLES //////////////////////////////////////////////////
		int playOrReplace;								
		int numTilesRemoved;				
		int tileToPlayResponse;
		int tileToRemoveResponse;
		
		ArrayList<int[]> spacesPlayed;
		
		boolean validMove = false;
		
		//Get random person to start
		this.turnCounter = ThreadLocalRandom.current().nextInt(0, numPlayers);
		
		///////////////////////////////////////////////// GAME LOOP //////////////////////////////////////////////////////
		
		while(!isGameOver) {
			
			//Update the GUI
			this.gui.update(this.board, this.players[turnCounter], this.players);
			
			//New turn starts, it is not move
			isTurnOver = false;
			
			//Does the player want to play a word or replace a tile
			playOrReplace = getPlayOrReplace();
			
			//Play word or replace tiles
			if(playOrReplace == 0) {
				
		////////////////////////////////////////////// PLAY WORD BLOCK OF CODE ////////////////////////////////////////////
				
				//Array list to hold the moved made during this turn
				spacesPlayed = new ArrayList<int[]>();
								
				while(!isTurnOver) {
					
					//Define size of the rack to determine what the user is selecting
					int sizeOfRack = players[turnCounter].getRack().getRackArray().size();
					//Get tile to place from the player
					tileToPlayResponse = playTile(players[turnCounter].getRack());
					
					if(tileToPlayResponse == sizeOfRack) { //If the player selects end turn
						isTurnOver = true;		
					} else if(tileToPlayResponse == sizeOfRack + 1) {  //Else if the player selects undo last turn
						//Get element that needs to be undone
						int removeNum = spacesPlayed.size() - 1;
						//Get board space of that element
						int[] removeMove = spacesPlayed.get(removeNum);
						//Remove the tiles from the board and add that tile to the players rack
						players[turnCounter].addTileToRack(board.removeTileFromBoard(removeMove[0] + 1, removeMove[1] + 1));
						//Remove element from move stored for this turn
						spacesPlayed.remove(removeNum);
						//Update board
						this.gui.update(this.board, this.players[turnCounter], this.players);
					} else { //Else, the player selected a tile
						//Create variable to hold the next move they're going to make
						int[] space = new int[2];
						
						//Get the location the players would like to place the tile
						int row = getColumnRow("row");
						int column = getColumnRow("column");
						//Check the rows and column entered above are a valid move
						validMove = board.isMoveValid(row, column, spacesPlayed);
						
						//If move is not valid
						if(!validMove) {
							//Ask for another move until move is valid
							while(!validMove) {	
								row        = getColumnRow("row");
								column     = getColumnRow("column");
								validMove  = board.isMoveValid(row, column, spacesPlayed);
							}	
						}
						
						//Once we have a valid move, store the move and place it into the spacesPlayer variable that holds all the moves
						space[0] = row;
						space[1] = column;
						spacesPlayed.add(space);
						
						//Now that we have a valid move, update the board, and update the display
						this.board.updateBoard(row + 1, column + 1, players[turnCounter].getRack().removeTile(tileToPlayResponse));
						this.gui.update(this.board, this.players[turnCounter], this.players);
					}
				}
				
				
				//Get spaces that will make up all potential words			
				ArrayList<ArrayList<int[]>> potentialWords = board.getSpacesOfPotentialWords(spacesPlayed);
				
				//Get Potential words
				ArrayList<String> potWords = getPotentialWordsAsStrings(potentialWords);
				
				//Is the word played a word
				boolean scorable = true;
				//If there are no potential words, scorable = false
				if(potWords.size() == 0) {
					scorable = false;
				} else { 
					//Loop through all the words, if one is not a word then scorable is false;
					for(String str : potWords) {
						if(dictionary.check2(str.toLowerCase()) == false) {
							scorable = false;
						}
					
					}
				}
				
				
				if(scorable) { //If player played a valid word
					
					int xPoints = this.scorer.calculateScore(potentialWords.get(0), this.board.getBoardArray());
					
					//Let the player know the score and word played
					
					String wordPlayed = "";
					wordPlayed += potWords.get(0);
					
					for(int i = 1 ; i < potWords.size() ; i++) {
						wordPlayed += " and ";
						wordPlayed += potWords.get(i);
					}
					
					JOptionPane.showMessageDialog(gui, players[turnCounter].getName() + " earn " + Integer.toString(xPoints) + " points playing the word " + wordPlayed);
					
					players[turnCounter].incrementScore(xPoints);
					System.out.println (players[turnCounter].getScore());
					
					try {
						
						for(int i = 0 ; i < spacesPlayed.size() ; i++) {
							this.bagOfTile = players[turnCounter].pickTileForRack(this.bagOfTile);
						}
						
					} catch(EmptyStackException e) {
						//If exception thrown, the bag of tiles is empty and the game is over.
						isGameOver = true;					
					}
					
				} else { //If player played an invalid word
					
					//For each turn taken
					for(int i = 0 ; i < spacesPlayed.size() ; i++) {
						//Get the position the ith move
						int[] currentSpace = spacesPlayed.get(i);
						//Remove the tiles from the board and add the tile back to the rack
						players[turnCounter].addTileToRack(board.removeTileFromBoard(currentSpace[0] + 1, currentSpace[1] + 1)); 
					}
					
					//Tell the user the word played is not a valid word
					JOptionPane.showMessageDialog(gui, "At least one of the words played was not found in the dictionary.\nThe tiles you placed this turn will go back to your rack. You got a score of 0 this turn.");
					
					//Update the gui
					this.gui.update(this.board, this.players[turnCounter], this.players);
					
				}

			} else {
				
		///////////////////////////////////////////////// REPLACE TILES BLOCK OF CODE ///////////////////////////////////////////////
				
				//Counter for tiles removed
				numTilesRemoved = 0;
				
				//Ask for tiles to remove until they press end turn
				while(!isTurnOver) {

					//Define options for tiles to remove and size of rack
					int sizeOfRack = players[turnCounter].getRack().getRackArray().size();
					Object[] tileOptions = getTileOptions(players[turnCounter].getRack());
					
					//Prompt player for tiles to remove
					tileToRemoveResponse = JOptionPane.showOptionDialog(frame,"Which tile would you like to remove"             , "Click one option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, tileOptions     , tileOptions[0]    );
					
					//If player clicks end turn, set isTurnOver to true
					if(tileToRemoveResponse == sizeOfRack) {
						isTurnOver = true;
					} else {
						//Else remove the tile from the rack
						Tile tileRemoved = players[turnCounter].getRack().removeTile(tileToRemoveResponse);
						//Add the tile back to the rack
						this.bagOfTile.addTile(tileRemoved);
						//Update graphic
						gui.update(this.board, players[turnCounter], players	);
						gui.setVisible(true);
						//Increament tiles removed
						numTilesRemoved++;
					}
				}
				
				//Once turn is over fill the rack with new tiles
				for(int i = 0 ; i < numTilesRemoved ; i++) {
					this.bagOfTile = players[turnCounter].pickTileForRack(this.bagOfTile);
				}
				
			}
			
			
			///////////////////////////////// TURN IS OVER - CHECK SCORE - INCREMENT PLAYER //////////////////////////////////////

			//If this players score is above score to win, the game is over and display the winner
			if(players[turnCounter].getScore() > scoreToWin) {
				isGameOver = true;
				JOptionPane.showMessageDialog(gui, "Congratulations " + players[turnCounter].getName() + "! You're the winner");
			}
			
			//INCREMENT PLAYER
			if(turnCounter == numPlayers - 1) {
				turnCounter = 0;	
			} else {
				turnCounter++;
			}
		}
		
		//Game loop is over, exit the program
		gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
	}
	
	
	
	
	//////////////////////////////////////////// HELPER FUNCTIONS ////////////////////////////////////////////////////////////////////////
	
	/**
	 * Method used to get the qty of players and players names who will player the game
	 */
	private void createPlayers() {
		
		//How many players
		Object[] playerOptions = {"Two Players", "Three Players", " Four Players"};
		this.numPlayers = JOptionPane.showOptionDialog(frame, "How many players would like to play?"        , null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, playerOptions     , playerOptions[0]    ) + 2;
	
		this.players = new Player[this.numPlayers]; 
		
		//Create player objects by asking user for their names
		for(int i = 0 ; i < numPlayers ; i++) {
			String playersName = JOptionPane.showInputDialog("Please enter the name of player " + (i + 1));
			//Create Player
			Player tempPlayer = new Player(playersName);
			//Fill rack with 7 tiles
			for(int j = 0 ; j < 7 ; j++) {
				this.bagOfTile = tempPlayer.pickTileForRack(this.bagOfTile);
				//System.out.println(this.bagOfTile.getBagOfTiles().size());
			}
			//Create players array
			this.players[i] = tempPlayer;
		}
		
	}
	
	/**
	 * Method used to get and set the score to win from the players
	 */
	private void getScoreToWin() {
		
		//Valid score boolean to make sure the user enters a positive input
		boolean validScore = false;
		//Ask the user what score they would like to play to
		String scoreAsString = JOptionPane.showInputDialog("What score would you like to play to? ");
		//While score is not valid
		while(!validScore) {
			//Try to parse an Integer from the text entered in
			try {
				this.scoreToWin = Integer.parseInt(scoreAsString);
				//If input isn't positive
				if(this.scoreToWin <= 0) {
					//Tell the user to input a positive integer
					scoreAsString = JOptionPane.showInputDialog("You've entered an invalid score. \nPlease enter a positive integer to play to.");
				} else {
					//If the integer is positive and no exception was thrown valid score is true	
					validScore = true;
				}
			} catch (NumberFormatException e) {
				scoreAsString = JOptionPane.showInputDialog("You've entered an invalid score.\nPlease enter a positive integer to play to.");
			}
		}
		
		//Set score to win for the game instance variable and for the display panel
		scoreToWin = Integer.parseInt(scoreAsString);
		gui.getDisplayPanel().setScoreToWin(scoreToWin);
	}
	
	/**
	 * Method used to determine if the player would like to play a word or replace tiles on their rack
	 * @return 0 if the player would like to play a word or 1 if the player would like to replace tiles
	 */
	private int getPlayOrReplace() {
		
		//Create play or replace objects to be placed on the option pane
		Object[] playOrReplaceOptions = {"Play word!", "Replace tiles"};
		JOptionPane pane = new JOptionPane("It's " + players[turnCounter].getName() + "'s turn\n" + "Would you like to play or work or replace tiles?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, playOrReplaceOptions, playOrReplaceOptions[0]);
		
		//Create dialog object so we can control the location
		JDialog d = pane.createDialog(null);
		//Don't allow the user to close
		d.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		//Position the window based on the main frame (which is positioned in the center of the screen)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		d.setLocation(dim.width/2-200, dim.height/2 + 395 - d.getSize().height);
		d.setResizable(false);
		d.setVisible(true);
		
		//Return input from user
		if(pane.getValue() == playOrReplaceOptions[0]) {
			return 0;
		} else {
			return 1;
		}
	
	}
	
	/**
	 * Method to get the tile the player would like to play
	 * @param rack of the current player
	 * @return 0-6 (a tile position in the rack), 7 (to end their turn), or 8 (to undo the last move)
	 */
	private int playTile(Rack rack) {
		
		Object[] tileOptions;
		int sizeOfRack = rack.getRackArray().size();
		
		if(sizeOfRack == 7) { //This is the first tile to be removed, don't allow undo or end turn (one tile must be placed)
			tileOptions = new Object[sizeOfRack];
			//Populate the object array with images from tiles in the players rack
			for(int j = 0 ; j < sizeOfRack ; j++) {
				tileOptions[j] = rack.getRackArray().get(j).getImageIcon();
			}
			
		} else { //This is not the first tile to be picked
			//Define options for tiles to remove (Add two for undo and end turn button)
			tileOptions = new Object[sizeOfRack + 2];
			//Populate the object array with images from tiles in the players rack
			for(int j = 0 ; j < sizeOfRack ; j++) {
				tileOptions[j] = rack.getRackArray().get(j).getImageIcon();
			}
			//Add end turn at the end of option array
			tileOptions[sizeOfRack] = "End Turn";
			tileOptions[sizeOfRack + 1] = "Undo";
		}
		
		//Prompt user for decision
		JOptionPane pane = new JOptionPane("Which tile would you like to play?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, tileOptions, tileOptions[0]);
		JDialog d = pane.createDialog(null);
		
		//Create dialog (above) in order to set location based on the main frame (below)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		d.setLocation(dim.width/2-200, dim.height/2 + 395 - d.getSize().height);
		d.setResizable(false);
		d.setVisible(true);
		
		if(pane.getValue() == tileOptions[0]) {
			return 0;
		} else if (pane.getValue() == tileOptions[1]) {
			return 1;
		} else if (pane.getValue() == tileOptions[2]) {
			return 2;
		} else if (pane.getValue() == tileOptions[3]) {
			return 3;
		} else if (pane.getValue() == tileOptions[4]) {
			return 4;
		} else if (pane.getValue() == tileOptions[5]) {
			return 5;
		} else if (pane.getValue() == tileOptions[6]) {
			return 6;
		} else if (pane.getValue() == tileOptions[7]) {
			return 7;
		} else if (pane.getValue() == tileOptions[8]) {
			return 8;
		}
		
		return 0;
	
	}
	
	/**
	 * Method used to get the row or column the player would like to place the tile
	 * @param columnOrRow String that is used in the prompt to the player (usually "column" or "row")
	 * @return 0-14 which represents the space in the boardArray they would like to place the tile
	 */
	private int getColumnRow(String columnOrRow) {
		
		//Create options for moves
		Object[] ColumnRowOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
		
		//Create option pane and dialog
		JOptionPane pane = new JOptionPane("Which " + columnOrRow +" would you like to place the tile?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, ColumnRowOptions, ColumnRowOptions[0]);
		JDialog d = pane.createDialog(null);
		
		//Position based on the main frame
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		d.setLocation(dim.width/2-200, dim.height/2 + 395 - d.getSize().height);
		d.setResizable(false);
		d.setVisible(true);
	
		if(pane.getValue() == ColumnRowOptions[0]) {
			return 0;
		} else if (pane.getValue() == ColumnRowOptions[1]) {
			return 1;
		} else if (pane.getValue() == ColumnRowOptions[2]) {
			return 2;
		} else if (pane.getValue() == ColumnRowOptions[3]) {
			return 3;
		} else if (pane.getValue() == ColumnRowOptions[4]) {
			return 4;
		} else if (pane.getValue() == ColumnRowOptions[5]) {
			return 5;
		} else if (pane.getValue() == ColumnRowOptions[6]) {
			return 6;
		} else if (pane.getValue() == ColumnRowOptions[7]) {
			return 7;
		} else if (pane.getValue() == ColumnRowOptions[8]) {
			return 8;
		} else if (pane.getValue() == ColumnRowOptions[9]) {
			return 9;
		} else if (pane.getValue() == ColumnRowOptions[10]) {
			return 10;
		} else if (pane.getValue() == ColumnRowOptions[11]) {
			return 11;
		} else if (pane.getValue() == ColumnRowOptions[12]) {
			return 12;
		} else if (pane.getValue() == ColumnRowOptions[13]) {
			return 13;
		} else if (pane.getValue() == ColumnRowOptions[14]) {
			return 14;
		}
		
		return 0;
	}
	
	/**
	 * Helper method used in the play method to get the options of tiles to be used in the JOption pane based on size of rack
	 * @param rack
	 * @return Object array with options of tiles
	 */
	private Object[] getTileOptions(Rack rack) {
		
		int sizeOfRack = rack.getRackArray().size();
		
		//Define options for tiles to remove (Number in tiles in rack plus one for end turn
		Object[] tileOptions = new Object[sizeOfRack + 1];
		
		//Populate the object array with images from tiles in the players rack
		for(int j = 0 ; j < sizeOfRack ; j++) {
			tileOptions[j] = rack.getRackArray().get(j).getImageIcon();
		}
		
		//Add end turn at the end of option array
		tileOptions[sizeOfRack] = "End Turn";
		
		return tileOptions;
		
	}
	
	/**
	 * Method that converts spaces on the board to strings based on the letter of the tile in that position
	 * @param boardSpacesOfPotentialWords - An array list of array lists of moves (int[])
	 * @return ArrayList of Strings that are words the player played
	 */
	private ArrayList<String> getPotentialWordsAsStrings(ArrayList<ArrayList<int[]>> boardSpacesOfPotentialWords){
		
		//Array to store strings / words
		ArrayList<String> potentialWords = new ArrayList<String>();
		
		//For every potential word in the argument
		for(ArrayList<int[]> word : boardSpacesOfPotentialWords) {

			String string = "";
			
			//For each board space of that word
			for(int[] space : word) {
				//Add the letter of the tile in that position to the string			
				string = string + this.board.getBoardArray()[space[0]][space[1]].getTile().getLetter();
			}
				//Once all the letters are added, add the string the the returned array list of strings
				potentialWords.add(string);
		}		
		
		return potentialWords;
		
	}
	
}
