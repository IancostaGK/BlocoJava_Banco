package Banco.Models;

public abstract class Conta {
    protected String cc;
    protected double saldo;

    public Conta(String cc, double saldo) {
        this.cc = cc;
        this.saldo = saldo;
    }

    public String getCc() {
        return cc;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
