package calender;

<<<<<<< HEAD
import java.util.Scanner;

public class calender {

//	public static void howtomonth(Scanner scan) {
//		
////		while (true) {
////			System.out.println("���� �Է��ϼ���.");
////			int month = scan.nextInt();
////			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
////				System.out.println(month + "���� 31�ϱ��� �ֽ��ϴ�.");
////				break;
////
////			} else if (month == 2) {
////				System.out.println(month + "���� 28�ϱ��� �ֽ��ϴ�.");
////				break;
////
////			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
////				System.out.println(month + "���� 30�ϱ��� �ֽ��ϴ�.");
////				break;
////
////			} else {
////				System.out.println("�˸��� ���� �Է����ּ���.");
////			}
////		}
//		
//
//	}

	public static void main(String[] args) {



		Scanner scanner = new Scanner(System.in); //�޼���� Ǯ��
		
		int[] monary = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		while (true) {
			System.out.println("���� �Է��ϼ���.");
			int month = scanner.nextInt();
			
//			if (monary[month-1] == 31) {
//				System.out.println(month + "���� 31�ϱ��� �ֽ��ϴ�.");
//				break;
//
//			} else if (monary[month-1] == 28) {
//				System.out.println(month + "���� 28�ϱ��� �ֽ��ϴ�.");
//				break;
//
//			} else if (monary[month-1] == 30) {
//				System.out.println(month + "���� 30�ϱ��� �ֽ��ϴ�.");
//				break;
//
//			} else {
//				System.out.println("�˸��� ���� �Է����ּ���.");
//			}
			System.out.printf("%d���� %d�ϱ��� �ֽ��ϴ�.\n",month,monary[month-1]);
		}
		
		
//		switch(month) { //����ġ���� �̿��� Ǯ��
//			case 1:
//			case 3:
//			case 5:
//			case 7:
//			case 8:
//			case 10:
//			case 12:
//				System.out.println(month+"���� 31�ϱ��� �ֽ��ϴ�.");
//				break;
//			case 4:
//			case 6:
//			case 9:
//			case 11:
//				System.out.println(month+"���� 30�ϱ��� �ֽ��ϴ�.");
//				break;
//			case 2:
//				System.out.println(month+"���� 28�ϱ��� �ֽ��ϴ�.");
//				break;
//		}
	}
=======
public class calender {
>>>>>>> refs/remotes/origin/master

}
