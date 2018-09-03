package edu.nd.se2018.homework.hwk1;

import java.util.*;
public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> theMap = new HashMap<>();
		String[] splittedInput = input.split(" ");							//split string into words
		String[] splittedStop = stopwords.split(" ");
		for (String s:splittedInput) {
			boolean isStop = false;
			for (int i = 0; i < splittedStop.length; i++) {						
				if (s.equals(splittedStop[i])) {							//if the word is a stop word, raise flag
					isStop = true;
				}
			}
			if (!isStop) {													//if the word is not a stop word, add it to the map
				if (!theMap.containsKey(s)) {								//value = 1 if not already in map
					theMap.put(s, 1);
				}
				else {
					int sumSoFar = theMap.get(s);					
					theMap.put(s, sumSoFar +1);								//add 1 to value if already in map
				}
			}
		}
		
		int max = 0;
		boolean flag = false;
		String theKey = "";
		for (HashMap.Entry<String, Integer> entry : theMap.entrySet()) {
			if (max < entry.getValue()) {
				max = entry.getValue();										//check to see what the greatest value is
				theKey = entry.getKey();									//save the key with the greatest value
			}
			else if (max == entry.getValue()) {
				theKey = null;												//if there are two keys with the same max value, return null
			}
		}
		
		return theKey;
	}
	
	public static void main(String[] args) {
		Question2 mostFrequent = new Question2();
		String inputString2 = "the ideal architect should be a man of letters a skillful draftsman a mathematician familiar with historical studies a diligent student of philosophy acquainted with music not ignorant of medicine learned in the responses of jurisconsults familiar with astronomy and astronomical calculations";
		String stopWords = "and a hes the of up but with";
		String result = mostFrequent.getMostFrequentWord(inputString2, stopWords);
		System.out.println("The answer is:" + result);
	}
}
