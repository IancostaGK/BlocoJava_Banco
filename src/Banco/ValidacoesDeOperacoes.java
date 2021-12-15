package Banco;

import Banco.Models.Conta;
import Banco.Models.Conta_PF;
import Banco.Models.Conta_PJ;
import Banco.Models.Transacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidacoesDeOperacoes {

    static Conta conta_existe(ArrayList<Conta> lista, String numero_conta){
        Conta conta = null;
        for(Conta item : lista){
            if (item.getCc().equals(numero_conta)){
                conta = item;
                break;
            }
        }
        return conta;
    }

    static boolean ContaEhPF(Conta conta){
        return(conta instanceof Conta_PF);
    }

    static boolean ContaEhPJ(Conta conta){
        return(conta instanceof Conta_PJ);
    }

    static void Validar_delete(ArrayList<Conta> lista, Conta conta) {
        if (conta != null){
            if (conta.getSaldo() == 0){
                lista.remove(conta);
                System.out.println("Conta deletada com sucesso!");
            }
            else
                System.out.println("Conta deve estar com saldo zerado para ser deletada!");
        }else
            System.out.println("Conta inexistente!");
    }

    static void OpcaoTransacao(ArrayList<Transacao> transacao_lista, Conta conta) {
        int tipo_operacao;
        double valor;
        if (conta != null){
            tipo_operacao = perguntar_tipo_transacao();
            valor = ValidacoesInput.perguntar_valor();
            if ((tipo_operacao == 1) || (tipo_operacao == 2)){
                validar_transicao(tipo_operacao, conta, valor, transacao_lista);
            } else {
                System.out.println("operação invalida");
            }
        } else
            System.out.println("Conta inexistente!");
    }

    static int perguntar_tipo_transacao(){
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("1 - Debito \n2 - Credito\n");
            System.out.print("Digite o tipo de operação:");
            return (s.nextInt());
        } catch (InputMismatchException e){
            return 0;
        }
    }

    static void validar_transicao(int tipo_operacao, Conta conta, double valor,
                                  ArrayList<Transacao> transacao_lista){
        if (tipo_operacao == 1){
            if (valida_saldo(conta, valor) && valor>0){
                realizar_transacao_debito(conta, valor, transacao_lista);
            } else
                System.out.println("Saldo insuficiente!");
        } else if (tipo_operacao == 2 && (valor > 0)){
            realizar_transacao_credito(conta, valor, transacao_lista);
        }
    }

    static boolean valida_saldo(Conta conta, double valor){
        if (ContaEhPJ(conta)){
            return (valor <= conta.getSaldo());
        } else{
            Conta_PF c1 = (Conta_PF) conta;
            double cheque_especial = c1.getCheque_especial();
            return (valor <= (conta.getSaldo() + cheque_especial));
        }
    }

    static void realizar_transacao_debito(Conta conta, double valor, ArrayList<Transacao> transacao_lista){
        conta.setSaldo(conta.getSaldo() - valor);
        Transacao transacao = new Transacao(conta, valor, "debito");
        transacao_lista.add(transacao);
        System.out.println("Valor debitado com sucesso!");
    }

    static void realizar_transacao_credito(Conta conta, double valor, ArrayList<Transacao> transacao_lista){
        conta.setSaldo(valor + conta.getSaldo());
        Transacao transacao = new Transacao(conta, valor, "credito");
        transacao_lista.add(transacao);
        System.out.println("Valor creditado com sucesso!");
    }

    static void ListarContasNegativas(ArrayList<Conta> lista) {
        for (Conta item : lista) {
            if (item.getSaldo() < 0) {
                System.out.println(item);
            }
        }
    }

    static void SaldoContasMaiorQueValor(ArrayList<Conta> lista) {
        double valor = ValidacoesInput.perguntar_valor();
        for (Conta item : lista) {
            if (item.getSaldo() > valor) {
                System.out.println(item);
            }
        }
    }

    static void listar_pf(ArrayList<Conta> lista){
        System.out.println("Contas tipo PF: ");
        for (Conta item : lista) {
            if (ContaEhPF(item)) {
                System.out.println(item);
            }
        }
    }

    static void listar_pj(ArrayList<Conta> lista){
        System.out.println("Contas tipo PJ: ");
        for (Conta item : lista) {
            if (ContaEhPJ(item)) {
                System.out.println(item);
            }
        }
    }

    static void OpcaoTransacoesConta(ArrayList<Conta> lista, ArrayList<Transacao> transacao_lista) {
        String cc = ValidacoesInput.perguntar_cc();
        if (conta_existe(lista, cc) != null){
            listar_transacoes_conta(cc, transacao_lista);
        } else{
            System.out.println("Conta não existe!");
        }
    }

    static void listar_transacoes_conta(String cc, ArrayList<Transacao> transacao_lista){
        for (Transacao t : transacao_lista) {
            if (cc.equals(t.getConta()))
                System.out.println(t);
        }
    }
}