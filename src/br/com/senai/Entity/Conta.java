package br.com.senai.Entity;

public class Conta {
    private String accountNumber;
    private String agency;
    private int dateOpened;
    private double balance;


    public Conta(String accountNumber, String agency, int dateOpened, double balance) {
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.dateOpened = dateOpened;
        this.balance = balance;
    }

    public Conta() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public int getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(int dateOpened) {
        this.dateOpened = dateOpened;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void depositar(double valor) {
        balance += valor;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void deposit(double amount) {
    }
}
