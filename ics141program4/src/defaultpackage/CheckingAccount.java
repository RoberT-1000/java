
public class CheckingAccount extends Account {

	public CheckingAccount(String name, String type, double bl) {
		super(name, type, bl);
	}
	
	public double getYearEndBalance() {
		return getBalance();
	}
	
	public String toString() {
		return getName() + ", " + getType() + ", " + getBalance();
	}
}
