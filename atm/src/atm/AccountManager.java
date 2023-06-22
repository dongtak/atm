
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

	public void deleteAcc(int log) {
		System.out.println("삭제할 계좌번호 입력");// 내 계좌만 삭제 가능하도록
		int no = Atm.scanner.nextInt();


		int n = 0;
		for (Account ac : this.list) {
			System.out.println(ac+"뭐야");
			if (ac.getAccNumber() == no && ac.getUserCode() == log) {
				System.out.println("정말 삭제하시겠습니까?");
				System.out.println("1>예   2>아니오");
				int yn = Atm.scanner.nextInt();
				if (yn == 1) {
					System.out.println(this.list.get(n).getAccNumber());
					ac.setMoney(6000);
					System.out.println(ac.getMoney());
					
					System.out.println("계좌삭제완료");
					break;
				} else {
					System.out.println("삭제 취소");
					break;
				}

			}
			n++;

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

		for (Account ac : this.list) {
			if (ac.getUserCode() == log) {
				System.out.println("[" + ac.getAccNumber() + "]" + ":" + ac.getMoney() + "원");
			}
		}
		System.out.println();

	}

	public void inputMoney() {
		
	}

	public void outMoney() {

	}

	public void moveMoney() {

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
}
