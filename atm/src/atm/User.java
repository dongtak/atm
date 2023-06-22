package atm;

import java.util.ArrayList;

public class User {

	private int userCode; // R
	private String name; // R
	private String id; // R
	private String pwd; // R
	private int age;
	private ArrayList<Account> accs;

	public User(int userCode, String name, String id, String pwd) {
		this.accs = new ArrayList<Account>();
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.pwd = pwd;

	}

	public User(int userCode, String name, String id, String pwd, int age) {
		this.accs = new ArrayList<Account>();
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.age = age;
	}

	public User(int userCode, String name, String id, String pwd, int age, ArrayList<Account> accs) {
		this.accs = new ArrayList<Account>();
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.accs = accs;
	}

	public int getUserCode() {
		return this.userCode;
	}

	public String getId() {
		return this.id;
	}

	public String getPwd() {
		return this.pwd;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public ArrayList<Account> getAccs() {
		return (ArrayList<Account>) this.accs.clone();// 복제본 제공
	}

	public void setAccs(ArrayList<Account> accs) {
		this.accs = accs;
	}

	@Override
	public String toString() {
		String str = String.format("%s(%d) : %s/%s", this.name, this.userCode, this.id, this.pwd);

		for (int i = 0; i < this.accs.size(); i++) {
			str += "\n" + this.accs.get(i);
		}
		return str;
	}

}
