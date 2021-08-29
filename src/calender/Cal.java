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
	int mon; // 윤년 여부를 저장하는 함수 leapYear()의 리턴 값

	int[] n_day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 2월에 28일 배열
	int[] a_day = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 2월 29일 배열

	public Cal insertYM() { // 년도 월 입력
		Scanner scanner = new Scanner(System.in);

		System.out.println("년도를 입력하세요.(1995년 부터)");
		System.out.printf("YEAR> ");
		int year = scanner.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.printf("MONTH> ");
		int month = scanner.nextInt();

		this.year = year;
		this.month = month;

		mon = leapYear();
		return this;
	}

	public int leapYear() { // 윤년 여부

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
		System.out.println("   1. 일정 등록");
		System.out.println("   2. 일정 검색");
		System.out.println("   3. 달력 보기");
		System.out.println("   h. 도움말  q.종료");
		System.out.println("+----------------------+");
		System.out.println("명령 (1, 2, 3, h, q)");

		String i = scanner.next();
		scanner.nextLine();

		return i;
	}

	public void printCal() { // 달력 및 일정 여부 출력

		int calday = calDay();
		int fblank = 7 - calday; // 빈칸을 제외한 첫재쭐 날짜표기하는 개수

		int isDay;
		int[][] dalday;
		String[] day = { "Sun", "Mon", "Tus", "Wed", "Thu", "Fri", "Sat" };
		String noSche = "     ";
		String yesSche = "  *  ";

		int[][] daylist = spSche(schedule);

		System.out.printf("%13s<%4d년 %2d월>%13s\n", "", year, month, "");
		for (int i = 0; i < day.length; i++) {
			System.out.printf(" %3s ", day[i]);
		}
		System.out.println("");
		System.out.println("-----------------------------------");

		if (mon == 1) // 윤년인 경우
			isDay = a_day[month - 1];
		else // 평년인 경우
			isDay = n_day[month - 1];

		dalday = new int[isDay + 1][2];
		dalday[0][0] = 0;
		dalday[0][1] = 0; // 이해를 쉽게하기 위해 0번 인덱스 사용 X
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
		//처음주
		
		//시작주 공백
		for (int i = 0; i < calday; i++) {
			System.out.printf(" %3s ", "");
		}
		
		// 시작주 숫자
		for (int i = 1; i <= fblank; i++) {
			System.out.printf("  %02d ", i);
		}
		System.out.println("");
		
		//시작주 일정 여부 공백
		for (int i = 0; i < calday; i++) {
			System.out.printf(" %3s ", "");
		}
		// 시작주 일정 여부
		for (int i = 1; i <= fblank; i++) {
			if (dalday[i][1] == 1) {
				System.out.printf(yesSche);
			} else {
				System.out.printf(noSche);
			}
		}
		System.out.println("");

		//중간주들
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
		
		
		
		//마지막줄
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
		// HashMap<string,string>의 요소를 나누어서
		// 2차원 배열에 int형으로 저장
		// 일정을 나눠 담는 함수
//		//
		int ymdre = 0;

		ArrayList<String> list = new ArrayList<>(); // 일정의 개수는 가변이라
		// ArrayList를 사용

		int[][] ymd;

		for (String o : m.keySet()) { // o는 키 목록을 하나씩 돌아가면서 대입
			String scday = m.get(o); // get함수는 키에 해당하는 value값을 반환
			list.add(scday); // 날짜가 list 에 저장됨
			ymdre++;
		}
		// scday에 임시저장후 list라는 Arraylist 에 하나씩 저장
		// ymdre를 통해 list를 string 배열로 옮기기위한 배열개수 설정
		//

		String[] daylist = new String[ymdre];

		int cnt = 0;
		for (String value : list) {
			daylist[cnt++] = value;
		}

		// list를 string 배열로 옮기기위한 배열 생성
		// daylist에 list의 요소 개수만큼 대입 및
		// list 의 요소를 value에 넣어 대입

		// daylist에는 HashMap에 있는 키(일정-날짜)가 들어감
		// daylist[3] = {"1995-01-01","...","..."}

		ymd = new int[ymdre][3];

		for (int i = 0; i < ymdre; i++) {

			String[] numsp = daylist[i].split("-");
			for (int j = 0; j < 3; j++) {

				ymd[i][j] = Integer.parseInt(numsp[j]);

			}
		}
		// 결과
		// ymd = {{1995,01,01},{1995,...,...} ... }

		return ymd;

	}

	public int calDay() {// 1995년 1월 1일부터 year년 month 전월까지의 일 수, 요일을 맞추기 위해 계산
		int sum = 0; // 이를 통해 n년도 n월의 시작 요일을 알 수 있음

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

		for (String o : m.keySet()) { // o 는 키

			if (m.get(o).equals(value)) {

				keys.add(o);

			}

		}
		return keys; // key들이 들어 있는 ArrayList 반환
	}

	public void addSche() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("[일정 등록] 날짜를 입력하세요.");
		String addday = scanner.next();
		scanner.nextLine();

		System.out.println("일정을 입력하세요.");
		String sche = scanner.next();
		scanner.nextLine();
		FcaddSche(sche, addday);

		System.out.println("일정이 등록되었습니다.");
	}

	public void FcaddSche(String sche, String addday) { // 일정을 추가하는 함수

		schedule.put(sche, addday);

		return;

	}

	public void serSche() {
		int i = 1;// 번호 시작

		System.out.println("[일정 검색] 날짜를 입력하세요.");
		Scanner scanner = new Scanner(System.in);

		String serday = scanner.next();

		ArrayList<String> keys = scheToArray(serday);
		int n = keys.size();

		if (n == 0) {
			System.out.println("일정이 없습니다.");
			return;
		}

		System.out.println(n + "개의 일정이 있습니다.");
		for (String key : keys) {
			System.out.println(i + "." + key);
			i++;
		}
	}

	public ArrayList<String> scheToArray(String str) {
		// 입력해놓은 일정목록 schedule에서
		// 날짜가 들어있는 ArrayList를 반환

		ArrayList<String> keys = getKey(schedule, str);

		return keys;
	}
}
