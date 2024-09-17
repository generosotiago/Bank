package br.com.senai.Service;

import br.com.senai.Entity.Conta;
import br.com.senai.Entity.Pessoa;

import java.util.*;

public class BancoService {
    private List<Conta> accounts = new ArrayList<>();
    private List<Pessoa> people = new ArrayList<>();

    public void registerAccount(Conta account) {
        accounts.add(account);
    }

    public List<Conta> getAccounts() {
        return accounts;
    }

    public void listAccounts() {
        for (Conta account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                    ", Agency: " + account.getAgency() +
                    ", Date Opened: " + account.getDateOpened() +
                    ", Balance: " + account.getBalance());

        }
    }

    public void updateAccount(String accountNumber, double newBalance) {
        for (Conta account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.setBalance(newBalance);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void updateAccountNumber(String newAccountNumber, String oldAccountNumber) {
        for (Conta account : accounts) {
            if (account.getAccountNumber().equals(oldAccountNumber)) {
                for (Conta acc : accounts) {
                    if (acc.getAccountNumber().equals(newAccountNumber)) {
                        System.out.println("New account number is already in use.");
                        return;
                    }
                }
                account.setAccountNumber(newAccountNumber);
                return;
            }
        }
        System.out.println("Old account number not found.");
    }


    public void linkPersonToAccount(String personName, Conta account) {
        for (Pessoa person : people) {
            if (person.getName().equals(personName)) {
                if (person.getAccount() == null) {
                    person.setAccount(account);
                    return;
                } else {
                    System.out.println("Person already has an account.");
                    return;
                }
            }
        }
        System.out.println("Person not found.");
    }

    public void registerPerson(String personName) {
        people.add(new Pessoa(personName));
    }

    public void accountTransaction(String accountNumber, double amount, boolean deposit) {
        for (Conta account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (deposit) {
                    account.deposit(amount);
                } else {
                    account.withdraw(amount);
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

}