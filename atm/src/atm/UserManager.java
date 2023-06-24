
package atm;

import java.util.ArrayList;

public class UserManager {

	private AccountManager accManager = AccountManager.getInstance();

	private ArrayList<User> list = new ArrayList<User>();

	// Design Pattern (GOF) 설계 패턴 중,
	// 싱글 인스턴스를 만드는
	// Singleton Pattern 을 사용해보자

	// 1) 생성자를 숨긴다 private
	private UserManager() {
	}

	// 2) 클래스 내부에서 단일 인스턴스를 생성해준다
	private static UserManager instance = new UserManager();

	// 3) 외부에서 단일 인스턴스를 참조할 수 있도록 -> getter 를 제공한다
	public static UserManager getInstance() {
		return instance;
	}

	public void joinUser() {
		int userCode = generateRandomCode();
		System.out.print("id : ");
		String id = Atm.scanner.next();
		System.out.print("password : ");
		String password = Atm.scanner.next();
		System.out.print("name : ");
		String name = Atm.scanner.next();

		if (!duplId(id)) {
			User user = new User(userCode, name, id, password);
			this.list.add(user);
			accManager.createAccount(user);
			System.out.println("회원가입 완료");
		} else {
			System.err.println("중복되는 아이디 입니다.");
		}
	}

	public int leaveUser(int log) {
		for (User user : this.list) {
			if (user.getUserCode() == log) {
				this.list.remove(user);
				System.out.println("삭제완료");
				break;
			}
		}
		return 0;

	}

	public int loginUser() {// 리턴값으로 보내기
		if (this.list.size() == 0) {
			System.out.println("등록된 계정이 없습니다");
		} else {
			System.out.println("id : ");
			String id = Atm.scanner.next();
			System.out.println("password : ");
			String password = Atm.scanner.next();

			for (User user : this.list) {
				if (user.getId().equals(id) && user.getPassword().equals(password)) {
					System.out.println(user.getName() + "님 환영합니다");
					return user.getUserCode();// 로그인 성공시 로그값 리턴
				}
			}

		}
		return 0;// 아니면 -1

	}

	public User getUserByUserCode(int log) {
		for (User user : this.list) {
			if (user.getUserCode() == log)
				return user;
		}
		return null;
	}

	public int logoutUser() {
		System.out.println("안녕히가세요");
		return 0;
	}

	public ArrayList<User> getList() {
//		return (ArrayList<User>) this.list.clone();
		return (ArrayList<User>) this.list;
	}

	private boolean duplId(String id) {
		boolean dupl = false;
		for (User user : this.list) {
			if (user.getId().equals(id))
				dupl = true;
		}
		return dupl;
	}

	private int generateRandomCode() {
		int code = 0;

		while (true) {
			code = (int) (Math.random() * 9000) + 1000;

			boolean dupl = false;
			for (User user : this.list) {
				if (user.getUserCode() == code)
					dupl = true;
			}

			if (!dupl)
				break;
		}

		return code;
	}

}