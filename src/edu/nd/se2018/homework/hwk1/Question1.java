package edu.nd.se2018.homework.hwk1;

import java.lang.reflect.Array;
import java.util.*;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers) {
		HashSet h = new HashSet();
		int finalSum = 0;
		int tempArray[];
		for (int i = 0; i < Array.getLength(numbers); i++) {
			h.add(numbers[i]);									//add values to hashSet: only unique values
		}
		
		Iterator<Integer> it = h.iterator();
		while(it.hasNext()) {
			finalSum += it.next();								//add unique values together
		}
		return finalSum;	
		
	}
	
	public static void main(String[] args) {
		Question1 sumNumbers = new Question1();
		int result = sumNumbers.getSumWithoutDuplicates(new int[] {1,2,2,2,2,2,2});
		System.out.println("The answer is:" + result);
	}
}
