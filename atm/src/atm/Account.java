package atm;

public class Account {

	private int userCode; // R
	private int accNumber; // R
	private int accPwd; // R
	private int deposit;

	public Account(int userCode, int accNumber, int accPwd) {
		this.userCode = userCode;
		this.accNumber = accNumber;
		this.accPwd = accPwd;
	}

	public Account(int userCode, int accNumber, int accPwd, int deposit) {
		this.userCode = userCode;
		this.accNumber = accNumber;
		this.accPwd = accPwd;
		this.deposit = deposit;
	}

	public Account(int accountNumber) {
		this.accNumber = accountNumber;
	}

	public int getUserCode() {
		return this.userCode;
	}

	public int getAccNumber() {
		return this.accNumber;
	}

	public int getAccPwd() {
		return this.accPwd;
	}

	public void setAccPwd(int accPwd) {
		this.accPwd = accPwd;
	}

	public int getDeposit() {
		return this.deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	@Override
	public String toString() {
		return String.format("%d(%d) : %d",this.accNumber,this.accPwd,this.userCode);
	}
}
