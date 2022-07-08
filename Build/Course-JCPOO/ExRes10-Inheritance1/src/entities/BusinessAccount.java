package entities;

public class BusinessAccount extends Account {
	
	private Double loanLimit; // limite de empréstimo
	
	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanlimit) {
		super(number, holder, balance); // Construtor da super classe (Account);
		this.loanLimit = loanlimit;
	}

	public Double getLoanlimit() {
		return loanLimit;
	}

	public void setLoanlimit(Double loanlimit) {
		this.loanLimit = loanlimit;
	}
	
	public void loan(double amount) {
		if (amount <= loanLimit) {
			balance += amount - 10.0; // Neste caso, se o atributo balance estivesse como private, não conseguiria enxergá-lo
		}
	}
	
	@Override
	public void withdraw(double amount) {
	    super.withdraw(amount);
	    balance -= 2.0;
	}
}
