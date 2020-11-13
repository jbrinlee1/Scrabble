import java.io.*;
import java.net.*;
import java.util.ArrayList;

//import com.google.gson.*;
import javax.net.ssl.HttpsURLConnection;

/**
 * Class that represents the dictionary with words that can be played. added 2 methods, one that uses an API to do lookup, Bing Spell Check API v7
 * gson-2.8.6.jar is a referenced library needed to compile code and 1 that uses the eDictionary.txt file to compare the words. 
 * 
 * @author Melisa Parta
 *
 */
public class Dictionary {
	String host = "https://api.cognitive.microsoft.com";
	String path = "/bing/v7.0/spellcheck";

	String key = "cc507d2c934047299053d13f440f5862";

	String mkt = "en-US";
	String mode = "proof";
	ArrayList<String> _DictionaryWords = null;
	String _DictonaryPath = "engDictionary.txt";
	
	public Dictionary() {
		LoadDictonaryWords();	
	} 
	
	public boolean check1(String checkThisWord) throws Exception {
		boolean isAWord = false;
		
		//stored dictionary file
	    String params = "?mkt=" + mkt + "&mode=" + mode;
	   
	    URL url = new URL(host + path + params);
	    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
	    
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    connection.setRequestProperty("Ocp-Apim-Subscription-Key", key);
	    connection.setDoOutput(true);
	    
	    DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
	    wr.writeBytes("text=" + checkThisWord);
	    wr.flush();
	    wr.close();	    
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    String line;
	    while ((line = in.readLine()) != null)
	    {	    	
			if (line.contains("suggestion"))
                 isAWord = false;
             else 
            	 isAWord = true;
	    }
	    in.close();
		return isAWord;
	}

	public void LoadDictonaryWords() {
	
		try {
			_DictionaryWords = new ArrayList<String>();
			FileReader fr = new FileReader(_DictonaryPath);
			BufferedReader br = new BufferedReader(fr);
			String _Line;

			while ((_Line = br.readLine()) != null)
			{
				_DictionaryWords.add(_Line.trim());	
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public boolean check2(String word) {
		String _DictionaryWord = null;
		Boolean _WordFound = false;
			
		for(int dictionary = 0; dictionary < _DictionaryWords.size(); dictionary++)
		{
			_DictionaryWord = _DictionaryWords.get(dictionary);
			if(word.equals(_DictionaryWord))
			{
				_WordFound = true;
				break;
			}
		}

		return _WordFound;
	}

}
