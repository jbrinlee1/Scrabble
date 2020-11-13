import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Class that represents a space on the board
 * @author Jacob
 *
 */

public class BoardSpace {
	
	private final int multiplier;
	private final String multiplierType;
	private final ImageIcon spaceIcon;
	private final String iconPath;
	private final JButton button;
	
	private boolean open;
	private Tile tile;	
	
	/**
	 * BoardSpace constructor that initializes instance variables
	 * 
	 * Each board space has a button although we never implemented a GUI that could listen to button clicks to place tiles
	 * 
	 * @param mult - Multiplier quantity
	 * @param multType - Multiplier Type (L for letter or W for word)
	 */
	public BoardSpace(int mult, String multType, String iconPath) {
		
		this.multiplier = mult;
		this.multiplierType = multType;
		this.open = true;
		this.iconPath = iconPath;
		this.spaceIcon = new ImageIcon(iconPath);
		this.button = new JButton(this.spaceIcon);
		
	}

	/**
	 * Multiplier getter
	 * @return
	 */
	public int getMultiplier() {
		return multiplier;
	}

	/**
	 * Multiplier type getter
	 * @return
	 */
	public String getMultiplierType() {
		return multiplierType;
	}

	/**
	 * IsOpen getter
	 * @return
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * Setter for isOpen
	 * @param open
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * Getter for the tile on the space
	 * @return
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * Setter for the tile on the space
	 * @param tile
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}	
	
	/**
	 * Icon path getter for the space
	 * @return
	 */
	public String getIconPath() {
		return this.iconPath;
	}
	
	/**
	 * Image Icon getter for the space
	 * @return
	 */
	public ImageIcon getSpaceIcon() {
		return this.spaceIcon;
	}
	
	/**
	 * Button getter for the space
	 * @return
	 */
	public JButton getButton() {
		return this.button;
	}
	
	/**
	 * Method to remove tile from space
	 * @return
	 */
	public Tile removeTile() {
		Tile tempTile = this.tile;
		this.open = true;
		return tempTile;		
	}

}
