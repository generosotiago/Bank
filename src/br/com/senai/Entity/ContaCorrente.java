package br.com.senai.Entity;

public class ContaCorrente extends Conta {
    private static final double TAX = 30.00;

    public ContaCorrente() {}

    public ContaCorrente(String accountNumber, String agency, int dateOpened, double balance) {
        super(accountNumber, agency, dateOpened, balance);
    }

    public double calculateTax() {
        return TAX;
    }
}
