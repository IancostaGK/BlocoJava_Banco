package Banco;

import Banco.Models.Conta;
import Banco.Models.Transacao;
import java.util.ArrayList;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        ArrayList<Conta> conta_lista = new ArrayList<>();
        ArrayList<Transacao> transacao_lista = new ArrayList<>();
        Arquivo.ler_arquivo(conta_lista);
        Menu.menu(conta_lista, transacao_lista);
        Formatter saida = Arquivo.abrirGravacao();
        Arquivo.Escrever_aqruivo(saida, transacao_lista);
    }
}