package br.com.senai.Entity;

public class Pessoa {
    private String name;
    private Conta account;


    public Pessoa(String name) {
        this.name = name;
        this.account = null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Conta getAccount() {
        return account;
    }
    public void setAccount(Conta account) {
        if (this.account == null) {
            this.account = account;
        } else {
            System.out.println("A pessoa já está associada a uma conta.");
        }
    }
}
