package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers) {
        int maxLength = 1;
        boolean isMirror = false;
        int tempLength = 0;
    	
    	if (numbers.length == 0) {										//it is impossible to mirror with no elements in array
            return 0;
        }

        for (int i = 0; i < numbers.length; i++) {
            tempLength = 1;
            int count = i;

            for (int j = numbers.length - 1; j >= 0; j--) {  				//start from the end of the array and work toward left
                if (numbers[count] == numbers[j]) {		
                    if (isMirror) {
                        tempLength++;										//if it is part of mirror, add 1 to length
                        maxLength = Math.max(tempLength, maxLength);		//update maxLength if current length is larger
                    }
                    isMirror = true;
                    count++;
                    if (count >= numbers.length)							//end if we have gone too far in the string
                        break;
                }
                else if (numbers[j] != numbers[i]) {						//if we reach the end of the mirror, end the mirror count
                	if (isMirror) {
                		isMirror = false;
                		count = i;											
                		tempLength = 1;										//reset the temporary mirror length to 1 (potential start of mirror)
                	}
                }
                else if (j == count || j == (count+1)) {					//for an even or odd length and we reached the middle, it is the end of the mirror and exit loop
                    isMirror = false;
                    break;
                }
            }
        }    
        return maxLength;    
	}
    
	public static void main(String[] args) {
		Question3 mirror = new Question3();
		int result = mirror.getMirrorCount(new int[] {1,2,3,3,2,1});
		System.out.println("The answer is:" + result);
	}
}
