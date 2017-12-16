/*  Quiz.java
    Farrell - Java Programming 7th edition
    Chapter 8 - Arrays
    Game Zone 1
	
    Programmer: Emily Mueller
    Date: 16 June 2017
*/

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
		String[] question = {"Q1 - A, B or C", 
		"Q2 - A, B or C", 
		"Q3 - A, B or C", 
		"Q4 - A, B or C", 
		"Q5 - A, B or C", 
		"Q6 - A, B or C", 
		"Q7 - A, B or C", 
		"Q8 - A, B or C", 
		"Q9 - A, B or C", 
		"Q10 - A, B or C"};
		char[] answer = {'A', 'B', 'C', 'A', 'B', 'C', 'A', 'B', 'C', 'A'};
		char input = 'Y';
		int questionNo;
		String tempS;
		Scanner sc = new Scanner(System.in);
		for(questionNo = 0; questionNo < question.length; questionNo ++) {
			while (input != answer[questionNo]) {
				System.out.println(question[questionNo]);
				input = sc.next().charAt(0);
				if (input != answer[questionNo])
					System.out.println("Try again");
			}
			System.out.println("Correct!");
		}
		
		System.exit(0);
    }
}