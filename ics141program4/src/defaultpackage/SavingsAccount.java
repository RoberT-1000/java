
public class SavingsAccount extends Account implements TaxableEntity {

	final double INTERESTRATE = 0.06;
	
	public SavingsAccount(String name, String type, double bl) {
		super(name, type, bl);
	}
	
	public double interestAmount() {
		return (INTERESTRATE * super.getBalance());
	}
	
	public double taxAmount() {
		return (TAXRATE * super.getBalance());
	}
	
	public double getYearEndBalance() {
		return (super.getBalance() + this.interestAmount() - this.taxAmount());
	}

	public String toString() {
		return getName() + ", " + getType() + ", " + getBalance();
	}
}
