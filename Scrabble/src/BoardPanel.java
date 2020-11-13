import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class that extends JPanel and is used to display the board
 * 
 * JPanel is a grid layout. The border is numbers that represents the row/column. The interior
 * is the board spaces in the board object in the game instance
 * 
 * @author Jacob
 *
 */
public class BoardPanel extends JPanel {
	
	private Board board;
	private BoardSpace[][] currentBoard;
	private Dimension BOARD_SIZE = new Dimension(640, 640);
	private static final long serialVersionUID = 1L;
	
	private JLabel[] topRow;
	private JLabel[] firstColumn;
	
	/**
	 * Board Panel Constructor
	 * Takes no parameters
	 * Sets layout and initial buttons and labels
	 */
	public BoardPanel() {
		
		//Initial Board Panel (This is the same as any initial board object)
		board = new Board();
		//Get the board space array from the board object
		currentBoard = this.board.getBoardArray();
		
		//Read in and create the border labels
		try {
			BufferedImage zero = ImageIO.read(new File("0.jpg"));
			BufferedImage one = ImageIO.read(new File("1.jpg"));
			BufferedImage two = ImageIO.read(new File("2.jpg"));
			BufferedImage three = ImageIO.read(new File("3.jpg"));
			BufferedImage four = ImageIO.read(new File("4.jpg"));
			BufferedImage five = ImageIO.read(new File("5.jpg"));
			BufferedImage six = ImageIO.read(new File("6.jpg"));
			BufferedImage seven = ImageIO.read(new File("7.jpg"));
			BufferedImage eight = ImageIO.read(new File("8.jpg"));
			BufferedImage nine = ImageIO.read(new File("9.jpg"));
			BufferedImage ten = ImageIO.read(new File("10.jpg"));
			BufferedImage eleven = ImageIO.read(new File("11.jpg"));
			BufferedImage twelve = ImageIO.read(new File("12.jpg"));
			BufferedImage thirteen = ImageIO.read(new File("13.jpg"));
			BufferedImage fourteen = ImageIO.read(new File("14.jpg"));
			BufferedImage fifteen = ImageIO.read(new File("15.jpg"));
			
			JLabel zeroCol = new JLabel(new ImageIcon(zero));
			JLabel oneCol = new JLabel(new ImageIcon(one));
			JLabel twoCol = new JLabel(new ImageIcon(two));
			JLabel threeCol = new JLabel(new ImageIcon(three));
			JLabel fourCol = new JLabel(new ImageIcon(four));
			JLabel fiveCol = new JLabel(new ImageIcon(five));
			JLabel sixCol = new JLabel(new ImageIcon(six));
			JLabel sevenCol = new JLabel(new ImageIcon(seven));
			JLabel eightCol = new JLabel(new ImageIcon(eight));
			JLabel nineCol = new JLabel(new ImageIcon(nine));
			JLabel tenCol = new JLabel(new ImageIcon(ten));
			JLabel elevenCol = new JLabel(new ImageIcon(eleven));
			JLabel twelveCol = new JLabel(new ImageIcon(twelve));
			JLabel thirteenCol = new JLabel(new ImageIcon(thirteen));
			JLabel fourteenCol= new JLabel(new ImageIcon(fourteen));
			JLabel fifteenCol = new JLabel(new ImageIcon(fifteen));
			
			JLabel oneRow = new JLabel(new ImageIcon(one));
			JLabel twoRow = new JLabel(new ImageIcon(two));
			JLabel threeRow = new JLabel(new ImageIcon(three));
			JLabel fourRow = new JLabel(new ImageIcon(four));
			JLabel fiveRow = new JLabel(new ImageIcon(five));
			JLabel sixRow = new JLabel(new ImageIcon(six));
			JLabel sevenRow = new JLabel(new ImageIcon(seven));
			JLabel eightRow = new JLabel(new ImageIcon(eight));
			JLabel nineRow = new JLabel(new ImageIcon(nine));
			JLabel tenRow = new JLabel(new ImageIcon(ten));
			JLabel elevenRow = new JLabel(new ImageIcon(eleven));
			JLabel twelveRow = new JLabel(new ImageIcon(twelve));
			JLabel thirteenRow = new JLabel(new ImageIcon(thirteen));
			JLabel fourteenRow= new JLabel(new ImageIcon(fourteen));
			JLabel fifteenRow = new JLabel(new ImageIcon(fifteen));
			
			topRow = new JLabel[16];
			firstColumn = new JLabel[15];
			
			topRow[0] = zeroCol;
			topRow[1] = oneCol;
			topRow[2] = twoCol;
			topRow[3] = threeCol;
			topRow[4] = fourCol;
			topRow[5] = fiveCol;
			topRow[6] = sixCol;
			topRow[7] = sevenCol;
			topRow[8] = eightCol;
			topRow[9] = nineCol;
			topRow[10] = tenCol;
			topRow[11] = elevenCol;
			topRow[12] = twelveCol;
			topRow[13] = thirteenCol;
			topRow[14] = fourteenCol;
			topRow[15] = fifteenCol;
			
			firstColumn[0] = oneRow;
			firstColumn[1] = twoRow;
			firstColumn[2] = threeRow;
			firstColumn[3] = fourRow;
			firstColumn[4] = fiveRow;
			firstColumn[5] = sixRow;
			firstColumn[6] = sevenRow;
			firstColumn[7] = eightRow;
			firstColumn[8] = nineRow;
			firstColumn[9] = tenRow;
			firstColumn[10] = elevenRow;
			firstColumn[11] = twelveRow;
			firstColumn[12] = thirteenRow;
			firstColumn[13] = fourteenRow;
			firstColumn[14] = fifteenRow;
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//Set layout for BoardPanel
		setLayout(new GridLayout(16, 16));
		setPreferredSize(BOARD_SIZE);
		
		//Add label and button elements to this panel object
		for(int j = 0; j < 16 ; j++) {
			add(topRow[j]);
		}
		
		for(int i = 0; i < 15 ; i++) {
			for(int j = 0; j < 16; j++) {
				if(j == 0) {
					add(firstColumn[i]);
				} else {
					add(currentBoard[i][j - 1].getButton());
				}
			}
		}
	}

	/**
	 * Method to set the Board Panel object based on the board object
	 * @param board
	 */
	public void setBoardPanel(Board board) {
		
		//Remove all the components (so they can be re-added)
		setVisible(false);
		removeAll();
	
		//Take the board object passed in
		this.board = board;
		this.currentBoard = board.getBoardArray();
		
		//Set the top row with numbers for columns
		for(int j = 0; j < 16 ; j++) {
			add(topRow[j]);
		}
		
		//For each board space in BoardSpaceArray
		//Row
		for(int i = 0; i < 15 ; i++) {
			//Column
			for(int j = 0; j < 16; j++) {
				if(j == 0) {
					//If this is the first column we just want the number Jlables for the rows
					add(firstColumn[i]);
				} else {
					//If the space is open, display the BoardSpace Button. Else, display the tile button
					if(currentBoard[i][j - 1].isOpen()) {
						add(currentBoard[i][j - 1].getButton());
					} else {	
						add(currentBoard[i][j - 1].getTile().getButton());
					}
				}		
			}
		}
		
		revalidate();
		repaint();
		setVisible(true);
	}
	
	
}
