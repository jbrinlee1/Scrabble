import java.util.EmptyStackException;
import java.util.Random;

/**
 * Class the represents a human player
 * @author Akina
 *
 */
public class Player {
	
	private int score;
	private String name;
	private Rack rack;
	
	/**
	 * Single constructor for player
	 * @param name - name of the player
	 */
	Player(String name){
		this.name = name;
		this.rack = new Rack();
		this.score = 0;
	}

	/**
	 * Method used to pick a tile for players rack
	 * @param bag - this is the bag of tile used in the game 
	 * @return bag - returns the same bag as the argument with one tile removed which is the tile the player picked
	 * @throws EmptyStackException - if the bag is empty the player cannot pick a tile. Exception is thrown
	 */
	public BagOfTile pickTileForRack(BagOfTile bag) throws EmptyStackException {
		
		if(bag.getBagOfTiles().size() == 0) {
			throw new EmptyStackException();
		}
		
		this.rack.addTile(bag.pickTile());
		return bag;		
	}
	
	/**
	 * Method used to remove a tile from the rack.
	 * @param tileNum
	 * @return the tile picked from the rack
	 */
	public Tile removeTileFromRack(int tileNum) {
		
		return this.rack.removeTile(tileNum);
		
	}
	
	/**
	 * Method to add a tile to the players rack
	 * @param tile
	 */
	public void addTileToRack(Tile tile) {
		
		this.rack.addTile(tile);
		
	}	
	
	/**
	 * Method used to increment the players score
	 * @param score - value to increment by
	 */
	public void incrementScore(int score) {
		this.score += score;
	}
	
	/**
	 * Method to get ArrayList of tiles that is the rack
	 * @return rack of the player object
	 */
	public Rack getRack() {
		return this.rack;
	}
	
	/**
	 * Method to get the players name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Method to get the players score
	 * @return
	 */
	public int getScore() {
		return this.score;	
	}
	

}
