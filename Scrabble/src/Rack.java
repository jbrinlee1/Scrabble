import java.util.ArrayList;

/**
 * Class that represents the rack of tiles. Each player has a rack of tiles they're able to play on their turn
 * @author Jacob
 *
 */
public class Rack {
	
	private ArrayList<Tile> rack = new ArrayList<Tile>();
	
	//Default constructor
	
	/**
	 * Method that removes tile from rack to be played
	 * @param tileLocation
	 * @return the selected tile
	 */
	public Tile selectTile(int tileLocation) {
		Tile tempTile;
		tempTile = this.rack.get(tileLocation);
		rack.remove(tileLocation);
		
		return tempTile;
	}
	
	/**
	 * Method that removes tile from rack to be added back to the bag
	 * @param tileLocation
	 * @return
	 */
	public Tile removeTile(int tileLocation) {
		
		Tile tempTile;
		tempTile = this.rack.get(tileLocation);
		rack.remove(tileLocation);
		
		return tempTile;
	}
	
	/**
	 * Method to add a tile on the rack
	 * @param tile
	 */
	public void addTile(Tile tile) {
		rack.add(tile);
	}
	
	/**
	 * Method to remove a tile that will be played
	 * @param tile
	 */
	public void removeTile(Tile tile) {
		rack.remove(tile);
	}
	
	/**
	 * Method to display the rack for the player in the eclipses console
	 */
	public void rackDisplay() {
		System.out.println("The following tiles are on your rack");
		int tileNum = 1;
		for(Tile tile : rack) {
			System.out.printf("%-4s", tileNum + " - ");
			System.out.printf("%-14s", "Letter: " + tile.getLetter());
			System.out.printf("%-13s", "Value: " + tile.getValue());
			System.out.println("");
			tileNum++;
		}
		
	}
	
	/**
	 * Getter for the rack array
	 * @return the rack array
	 */
	public ArrayList<Tile> getRackArray(){
		return this.rack;
	}
		

}
