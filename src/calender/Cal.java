package calender;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Cal {

	public static HashMap<String, String> schedule = new HashMap<String, String>();

	static final int BYEAR = 1995;
	static final int BDAY = 0;

	int year;
	int month;
	int mon; // ���� ���θ� �����ϴ� �Լ� leapYear()�� ���� ��

	int[] n_day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 2���� 28�� �迭
	int[] a_day = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 2�� 29�� �迭

	public Cal insertYM() { // �⵵ �� �Է�
		Scanner scanner = new Scanner(System.in);

		System.out.println("�⵵�� �Է��ϼ���.(1995�� ����)");
		System.out.printf("YEAR> ");
		int year = scanner.nextInt();

		System.out.println("���� �Է��ϼ���.");
		System.out.printf("MONTH> ");
		int month = scanner.nextInt();

		this.year = year;
		this.month = month;

		mon = leapYear();
		return this;
	}

	public int leapYear() { // ���� ����

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					return 1;
				return 0;
			}
			return 1;
		}
		return 0;
	}

	public String printMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("+----------------------+");
		System.out.println("   1. ���� ���");
		System.out.println("   2. ���� �˻�");
		System.out.println("   3. �޷� ����");
		System.out.println("   h. ����  q.����");
		System.out.println("+----------------------+");
		System.out.println("��� (1, 2, 3, h, q)");

		String i = scanner.next();
		scanner.nextLine();

		return i;
	}

	public void printCal() { // �޷� �� ���� ���� ���

		int calday = calDay();
		int fblank = 7 - calday; // ��ĭ�� ������ ù���� ��¥ǥ���ϴ� ����

		int isDay;
		int[][] dalday;
		String[] day = { "Sun", "Mon", "Tus", "Wed", "Thu", "Fri", "Sat" };
		String noSche = "     ";
		String yesSche = "  *  ";

		int[][] daylist = spSche(schedule);

		System.out.printf("%13s<%4d�� %2d��>%13s\n", "", year, month, "");
		for (int i = 0; i < day.length; i++) {
			System.out.printf(" %3s ", day[i]);
		}
		System.out.println("");
		System.out.println("-----------------------------------");

		if (mon == 1) // ������ ���
			isDay = a_day[month - 1];
		else // ����� ���
			isDay = n_day[month - 1];

		dalday = new int[isDay + 1][2];
		dalday[0][0] = 0;
		dalday[0][1] = 0; // ���ظ� �����ϱ� ���� 0�� �ε��� ��� X
		for (int j = 0; j < 2; j++) {
			for (int i = 1; i <= isDay; i++) {
				if (j == 0)
					dalday[i][0] = i;
				else
					dalday[i][1] = 0;
			}
		}

		for (int i = 0; i < daylist.length; i++) {
			if (year == daylist[i][0] && month == daylist[i][1]) {
				dalday[daylist[i][2]][1] = 1;
			}
		}
		//ó����
		
		//������ ����
		for (int i = 0; i < calday; i++) {
			System.out.printf(" %3s ", "");
		}
		
		// ������ ����
		for (int i = 1; i <= fblank; i++) {
			System.out.printf("  %02d ", i);
		}
		System.out.println("");
		
		//������ ���� ���� ����
		for (int i = 0; i < calday; i++) {
			System.out.printf(" %3s ", "");
		}
		// ������ ���� ����
		for (int i = 1; i <= fblank; i++) {
			if (dalday[i][1] == 1) {
				System.out.printf(yesSche);
			} else {
				System.out.printf(noSche);
			}
		}
		System.out.println("");

		//�߰��ֵ�
		int j = 0;
		
		int repeat = 1;
		while (repeat == 1) {
			for (int i = fblank + 1 + 7 * j; i <= fblank + 1 + 7 * j + 6; i++) {
				System.out.printf("  %02d ", dalday[i][0]);
				if( i == fblank + 1 + 7 * j + 6 && isDay < fblank + 1 + 7 * (j+1) + 6) {
					break;
				}
			}
			System.out.println("");
			for (int i = fblank + 1 + 7 * j; i <= fblank + 1 + 7 * j + 6; i++) {

				if (dalday[i][1] == 1) {
					System.out.printf(yesSche);

				} else {
					System.out.printf(noSche);

				}
				if( i == fblank + 1 + 7 * j + 6 && isDay < fblank + 1 + 7 * (j+1) + 6) {
					fblank = fblank + 1 + 7 * j + 6;
					repeat =0;
					break;
				}
			}
			System.out.println("");
			j++;
		}
		
		
		
		//��������
		for (int i = fblank+1; i <= isDay; i++) {
			System.out.printf("  %02d ", i);
		}
		System.out.println("");
		for (int i = fblank+1; i <= isDay; i++) {
			if (dalday[i][1] == 1) {
				System.out.printf(yesSche);
			} else {
				System.out.printf(noSche);
			}
		}


	}

	public int[][] spSche(HashMap<String, String> m) {
		// HashMap<string,string>�� ��Ҹ� �����
		// 2���� �迭�� int������ ����
		// ������ ���� ��� �Լ�
//		//
		int ymdre = 0;

		ArrayList<String> list = new ArrayList<>(); // ������ ������ �����̶�
		// ArrayList�� ���

		int[][] ymd;

		for (String o : m.keySet()) { // o�� Ű ����� �ϳ��� ���ư��鼭 ����
			String scday = m.get(o); // get�Լ��� Ű�� �ش��ϴ� value���� ��ȯ
			list.add(scday); // ��¥�� list �� �����
			ymdre++;
		}
		// scday�� �ӽ������� list��� Arraylist �� �ϳ��� ����
		// ymdre�� ���� list�� string �迭�� �ű������ �迭���� ����
		//

		String[] daylist = new String[ymdre];

		int cnt = 0;
		for (String value : list) {
			daylist[cnt++] = value;
		}

		// list�� string �迭�� �ű������ �迭 ����
		// daylist�� list�� ��� ������ŭ ���� ��
		// list �� ��Ҹ� value�� �־� ����

		// daylist���� HashMap�� �ִ� Ű(����-��¥)�� ��
		// daylist[3] = {"1995-01-01","...","..."}

		ymd = new int[ymdre][3];

		for (int i = 0; i < ymdre; i++) {

			String[] numsp = daylist[i].split("-");
			for (int j = 0; j < 3; j++) {

				ymd[i][j] = Integer.parseInt(numsp[j]);

			}
		}
		// ���
		// ymd = {{1995,01,01},{1995,...,...} ... }

		return ymd;

	}

	public int calDay() {// 1995�� 1�� 1�Ϻ��� year�� month ���������� �� ��, ������ ���߱� ���� ���
		int sum = 0; // �̸� ���� n�⵵ n���� ���� ������ �� �� ����

		for (int i = BYEAR; i < year; i++) {
			if (mon == 1) {
				sum += 366;
			} else {
				sum += 365;
			}
		}

		for (int i = 1; i < month; i++) {
			if (mon == 1) {
				sum += a_day[i - 1];
			} else
				sum += n_day[i - 1];
		}

		sum %= 7;

		return sum;
	}

	public static ArrayList<String> getKey(HashMap<String, String> m, Object value) {

		ArrayList<String> keys = new ArrayList<>();

		for (String o : m.keySet()) { // o �� Ű

			if (m.get(o).equals(value)) {

				keys.add(o);

			}

		}
		return keys; // key���� ��� �ִ� ArrayList ��ȯ
	}

	public void addSche() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("[���� ���] ��¥�� �Է��ϼ���.");
		String addday = scanner.next();
		scanner.nextLine();

		System.out.println("������ �Է��ϼ���.");
		String sche = scanner.next();
		scanner.nextLine();
		FcaddSche(sche, addday);

		System.out.println("������ ��ϵǾ����ϴ�.");
	}

	public void FcaddSche(String sche, String addday) { // ������ �߰��ϴ� �Լ�

		schedule.put(sche, addday);

		return;

	}

	public void serSche() {
		int i = 1;// ��ȣ ����

		System.out.println("[���� �˻�] ��¥�� �Է��ϼ���.");
		Scanner scanner = new Scanner(System.in);

		String serday = scanner.next();

		ArrayList<String> keys = scheToArray(serday);
		int n = keys.size();

		if (n == 0) {
			System.out.println("������ �����ϴ�.");
			return;
		}

		System.out.println(n + "���� ������ �ֽ��ϴ�.");
		for (String key : keys) {
			System.out.println(i + "." + key);
			i++;
		}
	}

	public ArrayList<String> scheToArray(String str) {
		// �Է��س��� ������� schedule����
		// ��¥�� ����ִ� ArrayList�� ��ȯ

		ArrayList<String> keys = getKey(schedule, str);

		return keys;
	}
}
