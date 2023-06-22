package atm;

/*
 * ATM 예제
 * ㄴ회원관리(가입/탈퇴/로그인/로그아웃)
 * ㄴ계좌관리(계약/철회/조회)
 * ㄴ뱅킹서비스(입금/출금/송금)
 * ㄴ파일처리(저장/로드)
 * 
 */

public class Main {
	public static void main(String[] args) {
		
		Atm system = new Atm("그린뱅크");
		system.run();

	}
}
