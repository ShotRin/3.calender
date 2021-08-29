package calender;

<<<<<<< HEAD
import java.util.Scanner;

public class calender {

//	public static void howtomonth(Scanner scan) {
//		
////		while (true) {
////			System.out.println("달을 입력하세요.");
////			int month = scan.nextInt();
////			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
////				System.out.println(month + "월은 31일까지 있습니다.");
////				break;
////
////			} else if (month == 2) {
////				System.out.println(month + "월은 28일까지 있습니다.");
////				break;
////
////			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
////				System.out.println(month + "월은 30일까지 있습니다.");
////				break;
////
////			} else {
////				System.out.println("알맞은 수를 입력해주세요.");
////			}
////		}
//		
//
//	}

	public static void main(String[] args) {



		Scanner scanner = new Scanner(System.in); //메서드로 풀이
		
		int[] monary = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		while (true) {
			System.out.println("달을 입력하세요.");
			int month = scanner.nextInt();
			
//			if (monary[month-1] == 31) {
//				System.out.println(month + "월은 31일까지 있습니다.");
//				break;
//
//			} else if (monary[month-1] == 28) {
//				System.out.println(month + "월은 28일까지 있습니다.");
//				break;
//
//			} else if (monary[month-1] == 30) {
//				System.out.println(month + "월은 30일까지 있습니다.");
//				break;
//
//			} else {
//				System.out.println("알맞은 수를 입력해주세요.");
//			}
			System.out.printf("%d월은 %d일까지 있습니다.\n",month,monary[month-1]);
		}
		
		
//		switch(month) { //스위치문을 이용한 풀이
//			case 1:
//			case 3:
//			case 5:
//			case 7:
//			case 8:
//			case 10:
//			case 12:
//				System.out.println(month+"월은 31일까지 있습니다.");
//				break;
//			case 4:
//			case 6:
//			case 9:
//			case 11:
//				System.out.println(month+"월은 30일까지 있습니다.");
//				break;
//			case 2:
//				System.out.println(month+"월은 28일까지 있습니다.");
//				break;
//		}
	}
=======
public class calender {
>>>>>>> refs/remotes/origin/master

}
