package br.com.senai.Entity;

public class ContaSalario extends Conta {
    private static final double TAX = 10.00;
    private int transactionsThisMonth;


    public ContaSalario() {
        super();
        this.transactionsThisMonth = 0;
    }


    public ContaSalario(String accountNumber, String agency, int dateOpened, double balance) {
        super(accountNumber, agency, dateOpened, balance);
        this.transactionsThisMonth = 0;
    }

    public void registerTransaction() { transactionsThisMonth++; }

    public double calculateTax() {
        if (transactionsThisMonth > 2) { return TAX; }
        return 0.00;
    }
}
