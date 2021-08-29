package calender;

import java.util.ArrayList;
import java.util.Scanner;

public class realcalender {

	public static void main(String[] args) {

		Cal cal = new Cal();
		while (true) {
			switch (cal.printMenu()) {
			
			
			case "1":
				cal.addSche();
				break;
				
				
			case "2":
				cal.serSche();
				break;
				
			case "3":
				cal.insertYM();
				cal.printCal();
				break;
				
			case "h":	
			case "H":
				System.out.println("대충 힌트");
				break;
				
			case "q":	
			case "Q":
				System.out.println("Bye");
				return;
				
			default :
				System.out.println("올바른 문자를 입력해주세요");
				break;
			}
			System.out.println("");
		}

	}
}//

