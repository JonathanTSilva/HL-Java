package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		
		Account acc = new Account(1001, "Alex", 1000.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING - pegar um objeto do tipo bacc e atribuí-lo para uma variável do tipo acc
		Account acc1 = bacc; // A herança é uma relação "É um". bacc é um acc;
		Account acc2 = new BusinessAccount(1003, "Bob", 1000.0, 500.0); // Ele pode ser tanto Account, quando BusinessAccount
		Account acc3 = new SavingsAccount(1004, "Anna", 1000.0, 0.01); // Pegar objeto de subclasse e atribui-lo para var da super
		
		System.out.println(acc1);
		
		// DOWNCASTING - 
		//BusinessAccount bacc2 = acc2; // Erro = incompatibilidade de tipos
		// Mesmo tendo instanciado ela como BusinessAccount, essa variável acc2 é do tipo Account. A conversão não é natural.
		// Para contornar esse problema, fazer um casting manual
		BusinessAccount bacc3 = (BusinessAccount)acc2;
		bacc3.loan(100.0);
		
		// Erro em tempo de execução:
		// BusinessAccount bacc4 = (BusinessAccount)acc3; // acc3 foi instanciada como SavingsAccount = é Account mas não BusinessAccount
		// Na hora de fazer o downcasting, nem sempre dá certo e o computador não sabe disso. Vai do programador
		
		// INSTANCEOF
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount bacc5 = (BusinessAccount)acc3;
			bacc5.loan(200.0);
			System.out.println("Loan!");
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount sacc5 = (SavingsAccount)acc3;
			sacc5.updateBalance();
			System.out.println("Update!");
		}
		
		// SOBREPOSIÇÃO
		acc.withdraw(200.0);
		System.out.println(acc.getBalance());
		
		acc3.withdraw(200.0);
		System.out.println(acc3.getBalance());
		
		// PALAVRA SUPER
		acc2.withdraw(200.0);
		System.out.println(acc2.getBalance());
	}
}
