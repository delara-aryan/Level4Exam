import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

import javax.activation.URLDataSource;

public class Anagram {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		System.out.println(anagrams("cinema"));
	}
	
	public static String anagrams(String word) throws MalformedURLException, IOException {
		String result = "";
		Scanner file = new Scanner(new URLDataSource(new URL("https://raw.githubusercontent.com/eneko/data-repository/master/data/words.txt")).getInputStream());
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		while(file.hasNext()) {
			String word2 = file.nextLine();
			if(word2.length() == word.length() && !(word2.equals(word))) {
				char[] chars2 = word2.toCharArray();
				Arrays.sort(chars2);
				if (Arrays.equals(chars, chars2)) {
					result += word2 + " ";
				}
			}
		}
		return result;
		
	}

}
