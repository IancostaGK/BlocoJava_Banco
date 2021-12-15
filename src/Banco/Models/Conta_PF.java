package Banco.Models;

import Banco.Models.Conta;

public class Conta_PF extends Conta {
    private String nome_pessoa;
    private String CPF;
    private double cheque_especial;

    public Conta_PF(String cc, String nome_pessoa, String CPF, double saldo, double cheque_especial) {
        super(cc, saldo);
        this.nome_pessoa = nome_pessoa;
        this.CPF = CPF;
        this.cheque_especial = cheque_especial;
    }
    public String toString(){
        return("Conta: " + this.cc + " | Pessoa: "+ this.nome_pessoa + " | CPF: "+ this.CPF+ " | Saldo: "+ this.saldo
                + " | Cheque_especial: " + this.cheque_especial);
    }

    public double getCheque_especial() {
        return cheque_especial;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setCheque_especial(double cheque_especial) {
        this.cheque_especial = cheque_especial;
    }
}
