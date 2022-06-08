package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import model.Exception.*;

class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialDeposit = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, initialDeposit, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.printf("New balance: %.2f%n", account.getBalance());

		} 
		catch (DomainException e) {
			System.out.println("Withdraw error:" + e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
