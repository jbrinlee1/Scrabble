import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * This is the main GUI that extends JFrame
 * 
 * It holds the RackPanel, Board Panel, and the Display Panel using a BorderLayout
 * 
 * @author Jacob
 *
 */
public class GUI extends JFrame{
	
	private BoardPanel boardPanel;
	private RackPanel rackPanel;
	private DisplayPanel displayPanel;
	private boolean startGame;
	private boolean viewRules;
	
	/**
	 * GUI Constructor creates opening screen, allows user to click start when ready to play, then sets layout for the entire game
	 * @param title Tile of the game
	 */
	public GUI(String title) {
		super(title);
		
		/////////////////////////// SET UP GUI FOR OPENING SCREEN ///////////////////////////
		
		//Start game is false until user presses begin button
		startGame = false;
		
		//Set layout options (Border layout, exit on close, size, open location, ability for user to resize)
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setResizable(false);

		//Create panel to hold welcome screen buttons
		JPanel welcomeButtons = new JPanel();
		welcomeButtons.setLayout(new BorderLayout());
		
		//Create welcome panel
		JLabel welcomeLabel = new JLabel("<html>Welcome to Our Scrabble Game<br/><br/>" +
										 "To begin, click the Start Scrabble Game button below. <br/><br/>" +
										 "To view the rules, click the View the Rules button below.  <html>"
										);
		
		//Create Rules label
		String text = "<html><h1 align = 'center'>Scrabble Rules</h1>";
		text += "When playing Scrabble, anywhere from two to four players will enjoy the game."
				+ " The object when playing is to score more points than other players. "
				+ "As words are placed on the game board, "
				+ "points are collected and each letter that is used in the game will have a different point value. "
				+ "The main strategy is to play words that have the highest possible score based on the combination of letters.<br/>";
		text += "<u>The Scrabble Board</u> <br/>";
		text += "The board offers 15*15 cells. <br/>";
		text += "<u>Scrabble Tiles</u> <br/>";
		text += "There are 100 tiles that are used in the game and 98 of them will contain letters and point values. There are 2 blank tiles that can be used as wild tiles to take the place of any letter. When a blank is played, it will remain in the game as the letter it substituted for.\n" + 
				"Different letters in the game will have various point values and this will depend on how rare the letter is and how difficult it may be to lay that letter. Blank tiles will have no point values. You can find the tile values on the right bottom of a tile.<br/>";
		text += "<u>Extra Point Values</u> <br/>";
		text += "When looking at the board, players will see that some squares offer multipliers. Should a tile be placed on 2L or 3L positions, the value of the tile will be multiplied by 2x or 3x.  Should a tile be placed on 2W or 3W positions, the value of the word will be multiplied by 2x or 3x. When using the extra point squares on the board, they can only be used one time. If a player places a word here, it cannot be used as a multiplier by placing another word on the same square. <br/>";
		text += "<u>Starting the Game</u> <br/>";
		text += "The player starts the game will be decided randomly by the program. A prompt will display and game starts.\n" + 
				"Every player will start their turn having seven tiles on the rack which is located on the left side of the board. There are two options during any turn. The player can play a word, or they can replace tiles for new tiles. In most cases, players will try to place a word, otherwise they willnot get a score. The player need to decide the location they want to place the tile by choosing from row number and column number respectively. If they location the player is trying to use is invalid, the program will prompt the player another try. After playing one turn, player clicks end game to pass it to the next player.\n" + 
				"When a player chooses to exchange tiles, they can choose to exchange one to seven of the tiles they currently hold. After tiles are exchanged, the turn is over and players will have to wait until their next turn to place a word on the board.\n" + 
				"<br/>";
		text += "<u>The First Word Score</u> <br/>";
		text += "When the game begins, the first player will place their word on the star spin in the centre of the board. The star is a double square and will offer a double word score. All players following will build their words off of this word, extending the game to other squares on the board.\n" + 
				"Play continues in a clockwise direction around the Scrabble board.<br/>";
		text += "<u>Replacing Scrabble Tiles</u> <br/>";
		text += "Once tiles are played on the board, players will draw new tiles to replace those. Players will always have seven tiles during the game. Drawing tiles is always done by the program randomly.<br/>";
		text += "<u>The End of a Scrabble Game</u> <br/>";
		text += "Player will indicate the score they want to play up to in the beginning of the game. Once the score is reached, the game will end and the player with the highest score wins.<br/>";
		text += "<u>Accepted Scrabble Words</u> <br/>";
		text += "Any word that is found in a standard English dictionary can be used in the game of Scrabble. If the word played is not an accepted word, the tiles played will be removed from the baord and placed back in that players rack. No points will be awarded for that turn.\n" + 
				"<br/>";
		text += "<html><h1 align = 'center'>ENJOY YOUR GAME!</h1>";
		JLabel rules = new JLabel(text);
		rules.setFont(new Font("arial", Font.PLAIN, 12));
		
		//Create start button
		JButton startButton = new JButton("Start Scrabble Game!");
		JButton rulesButton = new JButton("View the Rules");
		
		welcomeButtons.add(startButton, BorderLayout.NORTH);
		welcomeButtons.add(rulesButton, BorderLayout.SOUTH);
		
		//Add components to content pane
		getContentPane().add(welcomeLabel, BorderLayout.CENTER);
		getContentPane().add(welcomeButtons, BorderLayout.SOUTH);
		
		//Set GUI visible
		setVisible(true);
		
		//Once Player presses start the game begins
		while(!startGame) {
			
			viewRules = false;
			
			//If the start button is selected, start game is set true and the frame will be updated accordingly
			startButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					startGame = true;					
				}
			});	

			//If play selects the rules button, then viewRules is true and the frame will be updated to show the rules
			rulesButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					viewRules = true;
				}
			});
				
			if(viewRules) {
				
				//Set up for rules to show in GUI/JFrame
				setVisible(false);
				getContentPane().removeAll();
				this.setSize(900,600);
				Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
				this.setLocation(dimen.width/2-this.getSize().width/2, dimen.height/2-this.getSize().height/2);
				getContentPane().add(rules, BorderLayout.NORTH);
				getContentPane().add(startButton, BorderLayout.SOUTH);
				getContentPane().revalidate();
				getContentPane().repaint();
				setVisible(true);
				
				
			}		
		}
		
		//Remove welcome components and hide the GUI for now
		setVisible(true);
		getContentPane().removeAll();
		
		/////////////////////////// SET UP GUI FOR SCRABBLE GAME SCREEN ///////////////////////////
		
		//Increase the size of the object
		setSize(790, 790);
		
		//Center in screen
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		//Create BoardPanel Object
		boardPanel = new BoardPanel();
		rackPanel = new RackPanel();
		displayPanel = new DisplayPanel();
		
	}
	
	/**
	 * Method to update all the JPanels in the GUI/JFrame based on the rack, player scores, and the board
	 * 
	 * @param board - current board
	 * @param player - current player
	 * @param players - all the players
	 */
	public void update(Board board, Player player, Player[] players) {
		
		//Update the board
		this.boardPanel.setBoardPanel(board);
		getContentPane().add(this.boardPanel, BorderLayout.CENTER);
		
		//Update the rack
		this.rackPanel.setDisplay(player.getRack(), player.getName());
		getContentPane().add(rackPanel, BorderLayout.WEST);
		
		//Update the display
		this.displayPanel.setDisplay(players);
		getContentPane().add(this.displayPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	/**
	 * Rack Panel getter
	 * @return
	 */
	public RackPanel getRackPanel() {
		return this.rackPanel;
	}
	
	/**
	 * Display Panel getter
	 * @return
	 */
	public DisplayPanel getDisplayPanel() {
		return this.displayPanel;
	}
	
}
