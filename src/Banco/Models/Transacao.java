package Banco.Models;

import Banco.Models.Conta;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {
    private Conta conta;
    private double valor;
    private String tipo;
    private Date date = new Date();
    String data_formatada = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date);

    public Transacao(Conta conta, double valor, String tipo) {
        this.conta = conta;
        this.valor = valor;
        this.tipo = tipo;
        this.data_formatada = data_formatada;
    }

    public String toString(){
        return("Conta: " + conta.getCc() + " | valor: " + valor
                + " | Tipo de transição: " + tipo + " | data: " + data_formatada);
    }

    public String getConta() {
        return conta.getCc();
    }
}
