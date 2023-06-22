package atm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Atm {
	public static final Scanner sc = new Scanner(System.in);

	private String brandName;
	private Calendar cal;
	private SimpleDateFormat sdf;
	private UserManager um;
	private AccountManager am;
	private FileManager fm;

	private final int USERMANAGE = 1;
	private final int ACCMANAGE = 2;
	private final int BANKING = 3;
	private final int FILEMANAGE = 4;
	private final int QUIT = 5;

	private int log;
	private int sel;

	public Atm(String brandName) {
		this.brandName = brandName;
		this.um = UserManager.getInstance();
		this.am = AccountManager.getInstance();
		this.fm = FileManager.getInstance();
	}

	// 초기화
	private void init() {
		this.cal = Calendar.getInstance();
		this.sdf = new SimpleDateFormat("YYYY년 MM월 dd일 E요일 HH:mm");
	}

	// 실행
	public void run() {
		init();
		while (isRun()) {
			currentTime();
			printAlldata();
			printMenu();
			selectMenu();
			if (this.sel == USERMANAGE) {
				this.um.runUm();
			} else if (this.sel == ACCMANAGE) {
				this.am.run();
			} else if (this.sel == BANKING) {

			} else if (this.sel == FILEMANAGE) {

			}
		}
	}

	private void printAlldata() {
		try {
			System.out.println("회원목록:");
			for (User user : um.getList())
				System.out.println(user);
			System.out.println("------------");
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

	}

	private boolean isRun() {
		if (this.sel == QUIT) {
			System.out.println("-뿅-");
			return false;
		}
		return true;
	}

	private void printMenu() {
		System.out.println(this.brandName);
//		System.out.println("로그인상태:" + this.log);
		System.out.println("[1]회원관리");
		System.out.println("[2]계좌관리");
		System.out.println("[3]뱅킹서비스");
		System.out.println("[4]파일처리");
		System.out.println("[5]종료");
	}

	private void selectMenu() {
		System.out.print("메뉴선택>");
		while (true) {
			String sel = sc.next();
			try {
				this.sel = Integer.parseInt(sel);
				if (this.sel > 0 && this.sel < 6) {
					break;
				} else {
					System.err.println("범위초과");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("숫자 입력");
			}
		}
	}

	public Atm(int log) {
		this.log = log;
	}

	// 맻시고?
	private void currentTime() {
		String text = this.sdf.format(cal.getTime());
		System.out.println(text);
	}

}
