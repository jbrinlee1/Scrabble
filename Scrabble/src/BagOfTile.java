import java.util.ArrayList;
import java.util.Random;

/**
 * Class that represents the entire bag of tiles for the game. The players draw tiles from the bag of tiles.
 * 
 * @author Jacob
 *
 */
public class BagOfTile {
	
	//ArrayList of tiles in the bag
	private ArrayList<Tile> bagOfTiles = new ArrayList<Tile>();
	
	public BagOfTile() {
		
		//Create all the tiles that will be placed in the bag

		//Add 12 e tiles to the bag
		for(int ii = 0 ; ii < 12 ; ii++) {
			Tile e = new Tile("E", 1, "E.jpg");
			bagOfTiles.add(e);
		}
		
		//Add 9 a and i tiles to the bag
		for(int ii = 0 ; ii < 9 ; ii++) {
			Tile a = new Tile("A", 1, "A.jpg");
			Tile i = new Tile("I", 1, "I.jpg");
			bagOfTiles.add(a);
			bagOfTiles.add(i);
		}
		
		//Add 8 o tiles to the bag
		for(int ii = 0 ; ii < 8 ; ii++) {
			Tile o = new Tile("O", 1, "O.jpg");	
			bagOfTiles.add(o);
		}
		
		//Add 6 n, r, and t tiles to the bag
		for(int ii = 0 ; ii < 6 ; ii++) {
			Tile n = new Tile("N", 1, "N.jpg");
			Tile r = new Tile("R", 1, "R.jpg");
			Tile t = new Tile("T", 1, "T.jpg");	
			bagOfTiles.add(n);
			bagOfTiles.add(r);
			bagOfTiles.add(t);
		}
		
		//Add 4 l, s, d, and u tiles to the bag
		for(int ii = 0 ; ii < 4 ; ii++) {
			Tile l = new Tile("L", 1, "L.jpg");			
			Tile s = new Tile("S", 1, "S.jpg");			
			Tile u = new Tile("U", 1, "U.jpg");		
			Tile d = new Tile("D", 2, "D.jpg");
			bagOfTiles.add(l);
			bagOfTiles.add(s);
			bagOfTiles.add(u);
			bagOfTiles.add(d);
		}
		
		//Add 3 g tiles to the bag
		for(int ii = 0 ; ii < 3 ; ii++) {
			Tile g = new Tile("G", 2, "G.jpg");
			bagOfTiles.add(g);
		}
		
		//Add 2 blank, b, c, m, p, f, h, v, w, and y tiles to the bag
		for(int ii = 0 ; ii < 2 ; ii++) {
			Tile blank = new Tile("blank", 0, "Blank.jpg");	
			Tile b = new Tile("B", 3, "B.jpg");			
			Tile c = new Tile("C", 3, "C.jpg");			
			Tile m = new Tile("M", 3, "M.jpg");			
			Tile p = new Tile("P", 3, "P.jpg");			
			Tile f = new Tile("F", 4, "F.jpg");			
			Tile h = new Tile("H", 4, "H.jpg");			
			Tile v = new Tile("V", 4, "V.jpg");			
			Tile w = new Tile("W", 4, "W.jpg");
			Tile y = new Tile("Y", 4, "Y.jpg");
			bagOfTiles.add(blank);
			bagOfTiles.add(b);
			bagOfTiles.add(c);
			bagOfTiles.add(m);
			bagOfTiles.add(p);
			bagOfTiles.add(f);
			bagOfTiles.add(h);
			bagOfTiles.add(v);
			bagOfTiles.add(w);
			bagOfTiles.add(y);
		}
		
		
		//Add 1 k, j , x, q, and z tile to the bag
		Tile k = new Tile("K", 5, "K.jpg");
		Tile j = new Tile("J", 8, "J.jpg");			
		Tile x = new Tile("X", 8, "X.jpg");			
		Tile q = new Tile("Q", 10, "Q.jpg");
		Tile z = new Tile("Z", 10, "Z.jpg");
		bagOfTiles.add(k);
		bagOfTiles.add(j);
		bagOfTiles.add(x);
		bagOfTiles.add(q);
		bagOfTiles.add(z);
		
	}
	
	/**
	 * Method to pick a tile from the bag
	 * @return
	 */
	public Tile pickTile() {
		//Get random number between 0 and number of tiles in the bag
		Random random = new Random();
		int sizeOfBag = bagOfTiles.size();
		int numPick = random.nextInt(sizeOfBag);
		//Get the tile at that location (return it)
		Tile pickedTile = bagOfTiles.get(numPick);
		//Then remove that tile from the tile array list
		this.bagOfTiles.remove(numPick);
		
		return pickedTile;
	}
	
	/**
	 * Method that adds a tile back to the bag
	 * @param tile
	 */
	public void addTile(Tile tile) {
		this.bagOfTiles.add(tile);
	}
	
	/**
	 * Method to get the bag of tiles array of tiles
	 * @return
	 */
	public ArrayList<Tile> getBagOfTiles(){
		return bagOfTiles;
	}
	
	

}
