package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

//  Fazer um programa para ler os dados de uma conta bancária e depois realizar um
//  saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
//  ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
//  saque da conta. Implemente a conta bancária conforme projeto abaixo:
//      
//             Account
//      -number: Integer
//      -holder: String
//      -balance: Double
//      -withdrawLimit: Double
//      ----------------------
//      +deposit(amount:Double): void
//      +withdraw(amount:Double): void
    
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        
        Account acc = new Account(number, holder, balance, withdrawLimit);
        
        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        
        try {
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());
        }
        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
        
        sc.close();

    }

}
