package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {

	// design pattern 설계 패턴
	// 23가지
	// https://medium.com/geekculture/23-java-design-patterns-c1ff40faa5cd
	private final int OFFLINE = -1;
	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int QUIT = 5;
	private ArrayList<User> list;

	private int size;
	private int log;
	private boolean exist;
	private int sel;

	public void runUm() {
		init();
		while (isRun()) {
			printMenu();
			selectMenu();
			if (this.log == this.OFFLINE) {
				if (this.sel == JOIN) {
					join();
				} else if (this.sel == LOGIN) {
					logIn();
				}
			} else if (this.sel == LEAVE) {
				leave();
			} else if (this.sel == LOGOUT) {
				logOut();
			}

		}

	}

	private boolean isRun() {
		if (this.sel == QUIT) {
			return false;
		}
		return true;
	}

	// 메뉴출력
	private void printMenu() {
		System.out.println("회원관리>");
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]나가기");

	}

	// 메뉴선택
	private void selectMenu() {
		System.out.print("메뉴선택>");
		while (true) {
			String sel = Atm.sc.next();
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

	// 초기화
	private void init() {
		this.sel = 0;
		this.list = new ArrayList<>();
		this.size = 0;
		this.log = this.OFFLINE;
		this.exist = false;
	}

	public ArrayList<User> getList() {
		return (ArrayList<User>) this.list.clone();
	}

	// 회원가입
	private void join() {
		System.out.println("회원가입");
		System.out.println("아이디>");
		String uid = Atm.sc.next();
		if (this.size > 0)
			findId(uid);// 아이디 조회

		if (!this.exist) {// 입력아이디가 존재하지 않는경우
			System.out.println("비밀번호>");
			String pwd = Atm.sc.next();

			System.out.println("이름>");
			String name = Atm.sc.next();
			while (true) {
				int code = (int) (Math.random() * 9000) + 1000;
				findCode(code);
				if (!this.exist) {
					System.out.println("당신의 코드는 : " + code + "입니다");
					this.list.add(new User(code, name, uid, pwd));
					break;
				}
			}

			// temp없이 배열을 늘릴 수 있다??띠용 그동안 우리 뭐했지???

			System.out.println("저장완료");

			this.size++;// 사실상 가입인원 수 카운트용
		} else

			System.out.println("이미 존재하는 아이디");

	}

	// 회원탈퇴
	private void leave() {
		this.list.remove(this.log);// 이렇게 간편한걸 ;D
		System.out.println("회원탈퇴");
		this.log = -1;
		this.size--;
	}

	// 로그인
	private void logIn() {
		System.out.println("아이디>");
		String uid = Atm.sc.next();
		System.out.println("비밀번호>");
		String pwd = Atm.sc.next();

		for (int i = 0; i < this.size; i++) {
			// getId , getPwd 로 조회
			if (this.list.get(i).getId().toString().equals(uid) && this.list.get(i).getPwd().toString().equals(pwd)) {
				this.log = i;
				System.out.println(uid + "님 환영합니다");
			}

		}
		if (this.log == this.OFFLINE) {
			System.err.println("아이디/비밀번호가 틀렸습니다");
		}

	}

	// 로그아웃
	private void logOut() {
		System.out.println("안녕히가세요");
		this.log = -1;
	}

	// 아이디 조회
	private void findId(String id) {
		this.exist = false;
		for (int i = 0; i < this.size; i++) {
			if (id.toString().equals(this.list.get(i).getId().toString())) {// getId 조회용
				this.exist = true;
			}
		}

	}

	private void findCode(int code) {
		for (int i = 0; i < this.size; i++) {
			if (code == this.list.get(i).getUserCode()) {
				i = this.size;
				this.exist = true;
			}
		}
	}

	// 싱글 인스턴스를 만드는
	// Singleton Pattern
	// 유일한 인스턴스(객체)를 가져와 공유하면서 사용하게 허용

	// 1 생성자를 숨긴다
	private UserManager() {

	}

	// 2 클래스 내부에서 단일 인스턴스를 생성해준다
	private static UserManager instance = new UserManager();

	// 3 외부에서 단일 인스턴스를 참조할 수 있도록 getter를 제공한다
	public static UserManager getInstance() {

		return instance;
	}

}// UserManager.java