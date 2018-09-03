package edu.nd.se2018.homework.hwk1;

import java.util.*;
public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		HashMap<String, Integer> theMap = new HashMap<>();
		String[] splittedInput = input.split(" ");
		String[] splittedStop = stopwords.split(" ");
		for (String s:splittedInput) {
			boolean isStop = false;
			for (int i = 0; i < splittedStop.length; i++) {
				if (s.equals(splittedStop[i])) {
					isStop = true;
				}
			}
			if (!isStop) {
				if (!theMap.containsKey(s)) {
					theMap.put(s, 1);
				}
				else {
					int sumSoFar = theMap.get(s);
					theMap.put(s, sumSoFar +1);
				}
			}
		}
		
		int max = 0;
		boolean flag = false;
		String theKey = "";
		for (HashMap.Entry<String, Integer> entry : theMap.entrySet()) {
			if (max < entry.getValue()) {
				max = entry.getValue();
				theKey = entry.getKey();
			}
			else if (max == entry.getValue()) {
				theKey = null;
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
