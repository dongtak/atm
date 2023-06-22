package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {

	public static final Scanner sc = new Scanner(System.in);

	private Account[] ac;
	private ArrayList<Account> list = new ArrayList<>();

	private AccountManager() {

	}

	private static AccountManager instance = new AccountManager();

	public static AccountManager getInstance() {
		return instance;
	}

}
