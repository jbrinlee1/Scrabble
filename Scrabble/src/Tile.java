import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Class that represents the tiles (letters) that players hold and place on the board
 * 
 * @author Jacob
 *
 */
public class Tile {
	
	//Each tile has a letter and value
	private String letter;
	private int value;
	private ImageIcon imageIcon;
	private JButton button;
	
	/**
	 * Tile constructor
	 * @param letter of tile
	 * @param value of tile
	 * @param Image of tile
	 */
	public Tile(String letter, int value, String imagePath) {
		this.letter = letter;
		this.value = value;
		this.imageIcon = new ImageIcon(imagePath);
		this.button = new JButton(this.imageIcon);
	}

	/**
	 * Letter getter
	 * @return
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * Value getter
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Image Icon getter
	 * @return
	 */
	public ImageIcon getImageIcon() {
		return this.imageIcon;
	}
	
	/**
	 * Button getter
	 * @return
	 */
	public JButton getButton() {
		return this.button;
	}

}
