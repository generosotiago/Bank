package br.com.senai;
import br.com.senai.Entity.Conta;
import br.com.senai.Entity.ContaCorrente;
import br.com.senai.Entity.ContaPoupanca;
import br.com.senai.Entity.ContaSalario;
import br.com.senai.Service.BancoService;

import java.util.Scanner;


public class Main {
    private static BancoService bancoService = new BancoService();
    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Register Account");
            System.out.println("2. List Accounts");
            System.out.println("3. Update Account");
            System.out.println("4. Link Person to Account");
            System.out.println("5. Account Transaction");
            System.out.println("6. Register Person");
            System.out.println("7. Edit Account");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int option = ler.nextInt();
            ler.nextLine();

            switch (option) {
                case 1:
                    registerAccount();
                    break;
                case 2:
                    bancoService.listAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    linkPersonToAccount();
                    break;
                case 5:
                    accountTransaction();
                    break;
                case 6:
                    registerPerson();
                    break;
                case 7:
                    updateAccountNumber();
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void registerAccount() {
        System.out.println("Choose Account type:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.println("3. Conta Salário");
        int type = ler.nextInt();
        ler.nextLine();

        System.out.print("Account Number: ");
        String number = ler.nextLine();
        System.out.print("Agency: ");
        String agency = ler.nextLine();
        System.out.print("Date opened (yyyymmdd): ");
        int dateOpened = ler.nextInt();
        System.out.print("Initial balance: ");
        double balance = ler.nextDouble();
        ler.nextLine();

        Conta account = null;
        switch (type) {
            case 1:
                account = new ContaCorrente(number, agency, dateOpened, balance);
                break;
            case 2:
                account = new ContaPoupanca(number, agency, dateOpened, balance);
                break;
            case 3:
                account = new ContaSalario(number, agency, dateOpened, balance);
                break;
            default:
                System.out.println("Invalid Account Type.");
                return;
        }
        bancoService.registerAccount(account);
        System.out.println("Account registered successfully.");
    }

    private static void updateAccount() {
        System.out.print("What's your account number: ");
        String accountNumber = ler.nextLine();
        System.out.print("New balance: ");
        double newBalance = ler.nextDouble();
        ler.nextLine();

        bancoService.updateAccount(accountNumber, newBalance);
        System.out.println("Account balance updated successfully.");
    }

    private static void linkPersonToAccount() {
        System.out.print("Account holder name: ");
        String personName = ler.nextLine();
        System.out.print("Account holder: ");
        String accountNumber = ler.nextLine();

        Conta account = null;
        for (Conta acc : bancoService.getAccounts()) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                account = acc;
                break;
            }
        }

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        bancoService.linkPersonToAccount(personName, account);
        System.out.println("Person linked to account successfully.");
    }

    private static void accountTransaction() {
        System.out.print("Account number: ");
        String accountNumber = ler.nextLine();
        System.out.print("Value: ");
        double amount = ler.nextDouble();
        System.out.print("Choose 1 for Deposit or 2 for Withdraw: ");
        boolean deposit = ler.nextInt() == 1;
        ler.nextLine();

        bancoService.accountTransaction(accountNumber, amount, deposit);
        System.out.println("Successful transaction!");
    }

    private static void registerPerson() {
        System.out.print("Holder name: ");
        String personName = ler.nextLine();

        bancoService.registerPerson(personName);
        System.out.println("Holder registered successfully.");
    }

    private static void updateAccountNumber() {
        System.out.print("Account number to edit: ");
        String oldAccountNumber = ler.nextLine();
        System.out.print("New account number: ");
        String newAccountNumber = ler.nextLine();

        bancoService.updateAccountNumber(newAccountNumber, oldAccountNumber);
        System.out.println("Account number update successfully.");
    }
}

