package BankAccount;

public class Bank {
	double bal;

	public Bank(double bal) {
		super();
		this.bal = bal;
	}
	
	public double withdraw(double amt) {
		
		if(bal>amt) {
			return bal - amt;
		}else {
			throw new BalInsufficentError;
		}
	}
	
	

public double deposit(double amt) {
	if(amt>0) {
		return amt+bal;
	}else {
		return NegDepositError;
	}
}
