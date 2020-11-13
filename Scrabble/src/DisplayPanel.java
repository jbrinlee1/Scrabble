import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Display panel that extends JPanel
 * 
 * This is used to display the players scores and the score to win
 * using a GridBagLayout
 * 
 * 
 * @author Jacob
 *
 */
public class DisplayPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	int scoreToWin;
	private JLabel scoreTitle;
	private JLabel scoreToWinLabel;
	private ArrayList<JLabel> playersNameLabels;
	private ArrayList<JLabel> playersScoreLabels;
	private GridBagConstraints c;
	
	/**
	 * Display constructor that initializes the JPanel settings and the instance variables
	 */
	public DisplayPanel(){
		
		setBorder(BorderFactory.createTitledBorder("Game Display"));
		setLayout(new GridBagLayout());
		Dimension PANEL_SIZE = getPreferredSize();
		PANEL_SIZE.height = 150;
		setPreferredSize(PANEL_SIZE);
		
		scoreTitle = new JLabel("Scores:");
		c = new GridBagConstraints();
		
	}
	
	/**
	 * Display method that updates the display based on the players latest scores
	 * 
	 * @param players
	 */
	public void setDisplay(Player[] players) {
	
		removeAll();
		
		c.gridwidth = 2; //Span 2 columns
		c.gridx = 0;	//First Row
		c.gridy = 0;	//First Column
		c.ipady = 20;	//Make this taller
		c.ipadx = 790;	//Make width the full width of the panel
		c.anchor = GridBagConstraints.FIRST_LINE_START; //Push to the top left of space
		
		add(this.scoreTitle, c); //Add Scores: based on above
		
		playersNameLabels = new ArrayList<JLabel>();
		playersScoreLabels = new ArrayList<JLabel>();
		
		//For each player in game
		for(int i = 0 ; i < players.length ; i++) {
			
			//Create a temp name and score label
			JLabel tempNameLabel = new JLabel("  " + players[i].getName());
			JLabel tempScoreLabel = new JLabel("  " + Integer.toString(players[i].getScore()));
			
			//Store those labels 
			playersNameLabels.add(tempNameLabel);
			playersScoreLabels.add(tempScoreLabel);
			
		}
		
		//Again for each player, add to the panel object
		for(int i = 0 ; i < players.length ; i++) {
			
			c.gridwidth = 1; //Span one column
			c.ipady = 0; // reset height to default
			c.ipadx = 40; // Set width to 40;
			c.gridx = 0; //First column
			c.gridy = i + 1; //Increment rows based on number of players
			
			add(playersNameLabels.get(i), c); //Add players name label
		
			c.gridx = 1; //Second column
			c.gridy = i + 1; //Increment rows based on number of players
			
			add(playersScoreLabels.get(i), c); //Add players score label
		
		}
		
		//Display score to win
		c.gridx = 0;
		c.gridy = players.length + 1;
		c.ipady = 40;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		
		scoreToWinLabel = new JLabel("Score to win: " + scoreToWin);
		add(scoreToWinLabel, c);
		
		revalidate();
		repaint();

	}
	
	/**
	 * Method used to set the score to win that will be used on the display
	 * @param scoreToWin
	 */
	public void setScoreToWin(int scoreToWin) {
		this.scoreToWin = scoreToWin;
	}

}
