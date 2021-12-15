package Banco.Models;

import Banco.Models.Conta;

public class Conta_PJ extends Conta {
    private String nome_empresa;
    private String CNPJ;

    public Conta_PJ(String cc, String nome_empresa, String CNPJ, double saldo) {
        super(cc, saldo);
        this.nome_empresa = nome_empresa;
        this.CNPJ = CNPJ;
    }

    public String toString(){
        return("Conta: " + this.cc + " | Empresa: "+ this.nome_empresa + " | CNPJ: "+ this.CNPJ
                + " | Saldo: "+ this.saldo);
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
