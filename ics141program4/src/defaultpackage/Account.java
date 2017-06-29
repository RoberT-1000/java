
public abstract class Account {
	protected String name;
	protected String type;
	protected double balance;
	
	public Account() {
		name = null;
		type = null;
		balance = 0.00;
	}
	
	public Account(String name, String type, double bl) {
		this.name = name;
		this.type = type;
		balance = bl;
	}
	
	public void deposit(double m) {
		balance = balance + m;
	}
	
	public double withdraw(double n) {
		if (n > balance) {
			n = balance;
			balance = 0.00;
		} else {
			balance = balance - n;
		}
		return n;
	}
	
	public String getName() {return name;}
	public String getType() {return type;}
	public double getBalance() {return balance;}
	
	public abstract String toString();
}
