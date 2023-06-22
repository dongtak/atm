package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {

	public static final Scanner sc = new Scanner(System.in);

	private Account[] ac;
	private ArrayList<Account> list = new ArrayList<>();
	private int sel;
	private final int CREATE_AC = 1;
	private final int REVOKE_AC = 2;
	private final int DISPLAY_AC = 3;
	private final int QUIT = 4;

	public void run() {
		init();
		while (isRun()) {
			printMenu();
			selectMenu();
			if (this.sel == CREATE_AC) {

			} else if (this.sel == REVOKE_AC) {

			} else if (this.sel == DISPLAY_AC) {

			}
		}
	}

	private void init() {

	}

	private boolean isRun() {
		if (this.sel == QUIT) {
			return false;
		}
		return true;
	}

	private void printMenu() {
		System.out.println("[1]계좌신설");
		System.out.println("[2]계좌파기");
		System.out.println("[3]계좌조회");
		System.out.println("[4]나가기");
	}

	private void selectMenu() {
		System.out.print("메뉴선택>");
		while (true) {
			String sel = sc.next();
			try {
				this.sel = Integer.parseInt(sel);
				if (this.sel > 0 && this.sel < 5) {
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

	private void creatAc() {
		System.out.println("회원코드를 입력하세요");
		int uCode = -1;

		try {
			String code = Atm.sc.next();
			uCode = Integer.parseInt(code);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("숫자입력");
		}
		
	}

	private void revokeAc() {

	}

	private void displayAc() {

	}

	private AccountManager() {

	}

	private static AccountManager instance = new AccountManager();

	public static AccountManager getInstance() {
		return instance;
	}

}
