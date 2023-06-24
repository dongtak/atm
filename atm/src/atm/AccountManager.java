
package atm;

import java.util.ArrayList;

public class AccountManager {

	private ArrayList<Account> list = new ArrayList<Account>();

	private AccountManager() {
	}

	private static AccountManager instance = new AccountManager();

	public static AccountManager getInstance() {
		return instance;
	}

	public void createAccount(User user) {
		Account acc = null;

		int accNumber = generateRandomCode();
		int accPassword = Atm.inputNumber("계좌 비밀번호");

		acc = new Account(user.getUserCode(), accNumber, accPassword);
		this.list.add(acc);

		// AccountManager의 list에 추가된 객체를 생성과 동시에 반환받음
		// -> User 객체가 가진 acc즐겨찾ㄱ ㅣ목록에도 추가
		ArrayList<Account> accs = user.getAccs();
		accs.add(acc);
		user.setAccs(accs);

	}

	public void deleteAcc(int log) {// 비밀번호 추가할 것==================왜 안돼!!!!!!!!
		System.out.println("==계좌철회==");
		Account acc = inputAccNum(log);
		if (acc != null) {
			System.out.println("삭제");
			this.list.remove(acc);
		}

	}

	public void viewBalance(int log) {
		// 보유계좌목록 while
		// 1
		// 2
		// 3
		// . . . .
		// 번호 선택 시 해당 계좌잔액 출력
		// 나가기

		for (Account acc : this.list) {
			if (acc.getUserCode() == log) {
				System.out.println("[" + acc.getAccNumber() + "]" + ":" + acc.getMoney() + "원");
			}
		}
		System.out.println();

	}

	public void depositMoney(int log) {// 비밀번호 추가할 것
		System.out.println("==입금==");
		Account acc = inputAccNum(log);
		if (acc != null) {
			System.out.println("입금할 금액>");
			int money = acc.getMoney() + inputMoney();
			acc.setMoney(money);
		}

	}

	public void withdrawMoney(int log) {// 비밀번호 추가할 것
		System.out.println("==출금==");
		Account acc = inputAccNum(log);
		if (acc != null) {
			System.out.println("출금할 금액>");
			int wMoney = inputMoney();
			if (wMoney > acc.getMoney()) {
				System.err.println("잔액초과");
			} else {
				int money = acc.getMoney() - wMoney;
				acc.setMoney(money);
			}
		}

	}

	public void transferMoney(int log) {
		System.out.println("==이체==");
		Account acc = inputAccNum(log);
		if (acc != null) {
			System.out.println(acc.getAccNumber());
			Account to = accTo(log, acc);
			if (to != null) {
				System.out.println(to.getAccNumber());
				System.out.println("이체할 금액>");
				int money = inputMoney();
				if (money > acc.getMoney())
					System.err.println("잔액이 부족합니다");
				else {
					int withdraw = acc.getMoney() - money;
					acc.setMoney(withdraw);
					int transfer = to.getMoney() + money;
					to.setMoney(transfer);
				}
			}

		}

	}

	private int generateRandomCode() {// ####-####
		int code = 0;
		while (true) {
			code = (int) (Math.random() * 9000) + 1000;

			boolean dupl = false;
			for (Account acc : this.list) {
				if (acc.getAccNumber() == code)
					dupl = true;
			}

			if (!dupl)
				break;
		}

		return code;

	}

	private int inputMoney() {// 금액 입력

		int money = 0;
		while (true) {
			try {
				String in = Atm.scanner.next();
				money = Integer.parseInt(in);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자 입력");
			}
		}

		return money;

	}

	private Account inputAccNum(int log) {// 계좌번호 입력
		Account account = null;
		while (true) {
			try {
				System.out.println("계좌번호>");
				String in = Atm.scanner.next();
				int num = Integer.parseInt(in);

				for (Account acc : this.list) {
					if (acc.getAccNumber() == num && acc.getUserCode() == log) {
						account = acc;
						break;
					}
				}
				if (account == null) {
					System.err.println("잘못된 계좌번호입니다");
				}

				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자 입력");
			}
		}
		return account;
	}

	private Account accTo(int log, Account ac) {// 송금 계좌입력
		Account account = null;
		while (true) {
			try {
				System.out.println("송금할 계좌번호 입력>");
				String in = Atm.scanner.next();
				int num = Integer.parseInt(in);

				for (Account acc : this.list) {
					if (ac.getAccNumber() == num) {
						System.out.println("다른 계좌번호를 입력하세요");
						break;
					} else if (acc.getAccNumber() == num) {
						account = acc;
						break;
					}
				}
				if (account == null) {
					System.err.println("존재하지 않는 계좌번호입니다");
					break;
				}

				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자 입력");
			}
		}
		return account;
	}
}
