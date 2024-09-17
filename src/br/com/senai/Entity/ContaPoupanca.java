package br.com.senai.Entity;

public class ContaPoupanca extends Conta {
    private static final double INTEREST_RATE = 0.15;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(String accountNumber, String agency, int dateOpened, double balance) {
        super(accountNumber, agency, dateOpened, balance);
    }

    public void applyInterest() {
        double interest = getBalance() * INTEREST_RATE;
        deposit(interest);
    }
}
