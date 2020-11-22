import java.io.*;
import java.util.ArrayList;


/**
 * Class that represents the dictionary with words that can be played. 
 * 
 * @author Jacob Brinlee
 *
 */
public class Dictionary {

	//Instance variables
	ArrayList<String> dictionaryWords = null;
	String dictonaryPath = "engDictionary.txt";
	
	/**
	 * Dictionary constructor
	 */
	public Dictionary() {
		LoadDictonaryWords();	
	} 
	
	/**
	 * Method to read in the dictionary file and store in array
	 * 
	 * Could use Trie to improve time complexity 
	 */
	public void LoadDictonaryWords() {
	
		try {
			dictionaryWords = new ArrayList<String>();
			FileReader fr = new FileReader(dictonaryPath);
			BufferedReader br = new BufferedReader(fr);
			String _Line;

			while ((_Line = br.readLine()) != null)
			{
				dictionaryWords.add(_Line.trim());	
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * Method to check if a word is actually a word
	 */
	public boolean checkWord(String word) {
		
		//For each word in the dictionary
		for(int i = 0; i < dictionaryWords.size(); i++) {
			//If word found, return true
			if(word.equals(dictionaryWords.get(i))) { return true; }
		}
		//Else return false
		return false;
	}

}
