package application;

import model.entities.Account;
import model.exception.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class program {

    public static void main( String[] args ) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Dados da conta: ");
        System.out.print("Número: ");
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextInt();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f", acc.getBalance());
        }
        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
