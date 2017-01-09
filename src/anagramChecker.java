import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class anagramChecker {
	ArrayList<String> wordList = new ArrayList<String>();
	ArrayList<String> anagrams = new ArrayList<String>();
	String userWord;

	public static void main(String[] args) {
		new anagramChecker();
	}
	
	public anagramChecker(){
		userWord = JOptionPane.showInputDialog("Enter a word");
		importWords();
		checkForAnagrams(userWord);
		System.out.println(anagrams);
	}
	
	public void checkForAnagrams(String word){
		char[] userChars = word.toCharArray();
		Arrays.sort(userChars);
		
		char[] tempCharArray;
		
		for(String currentWord: wordList){
			if(currentWord.length() == word.length()){
				tempCharArray = new char[word.length()];
				tempCharArray = currentWord.toCharArray();
				Arrays.sort(tempCharArray);
				if(tempCharArray == userChars){
					anagrams.add(currentWord);
				}
				tempCharArray = new char[word.length()];
			}
		
			
			/*
			if(currentWord.length() == word.length()){
				for(int i = 0; i < currentWord.length(); i++){
					tempCharList.add(currentWord.charAt(i));
				}
				
				for(int i = 0; i < userWordInChars.size(); i++){
					for(int j = 0; j < tempCharList.size(); j++){
						if(userWordInChars.get(i) == tempCharList.get(j)){
							counter++;
						}
					}
					System.out.println(counter);
					if(counter == userWordInChars.size()){
						anagrams.add(currentWord);
						System.out.println(counter);
					}
					counter = 0;
				}
				tempCharList = new ArrayList<Character>();
			}
			*/
			
		}
		
	}
	
	public void importWords(){
		try{
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader("wordList"));
			while((line = br.readLine())!= null){
				wordList.add(line);
			}
		}catch(Exception e){
			System.err.println("Could not import words");
		}
	}

}
