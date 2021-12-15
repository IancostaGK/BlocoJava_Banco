package Banco;

import Banco.Models.Conta;
import Banco.Models.Transacao;
import java.util.ArrayList;

public class Menu {

    static void menu(ArrayList<Conta> lista, ArrayList<Transacao> transacao_lista) {
        Conta conta;
        int resp;
        String numero_conta;
        do {
            resp = opcoes();
            switch (resp) {
                case 1:
                    CriaContas.criar_conta(lista);
                    break;
                case 2:
                    numero_conta = ValidacoesInput.perguntar_cc();
                    conta = ValidacoesDeOperacoes.conta_existe(lista, numero_conta);
                    ValidacoesDeOperacoes.Validar_delete(lista, conta);
                    break;
                case 3:
                    numero_conta = ValidacoesInput.perguntar_cc();
                    conta = ValidacoesDeOperacoes.conta_existe(lista, numero_conta);
                    ValidacoesDeOperacoes.OpcaoTransacao(transacao_lista, conta);
                    break;
                case 4:
                    menu_relatorios(lista, transacao_lista);
                    break;
                case 5:
                    System.out.println("Obrigado pela visita!");
                    break;
                default:
                    System.out.println("Numero invalido!");
            }
        } while (resp != 5);
    }

    static void menu_relatorios(ArrayList<Conta> lista, ArrayList<Transacao> transacao_lista) {
        int resp_relatorios;
        do {
            resp_relatorios = opcoes_relatorios();
            switch (resp_relatorios) {
                case 1:
                    ValidacoesDeOperacoes.ListarContasNegativas(lista);
                    break;
                case 2:
                    ValidacoesDeOperacoes.SaldoContasMaiorQueValor(lista);
                    break;
                case 3:
                    ValidacoesDeOperacoes.listar_pf(lista);
                    ValidacoesDeOperacoes.listar_pj(lista);
                    break;
                case 4:
                    ValidacoesDeOperacoes.OpcaoTransacoesConta(lista, transacao_lista);
                    break;
                default:
                    if (resp_relatorios != 5)
                        System.out.println("Numero invalido!");
            }
        } while (resp_relatorios != 5);
    }

    static int opcoes_relatorios() {
        System.out.print("\n------------\nDeseje qual opção deseja selecionar\n" +
                "1 - Listar clientes com saldo negativo\n" +
                "2 - Listar os clientes que tem saldo acima de um determinado valor\n" +
                "3 - Listar todas as contas separadas por tipo (PF ou PJ)\n" +
                "4 - Listar as operações realizadas em uma determinada conta\n" +
                "5 - Voltar\n------------\n");
        return ValidacoesInput.perguntar_int_menu();
    }

    static int opcoes() {
        System.out.print(
                "------------\nDeseje qual opção deseja selecionar\n" +
                        "1 - Criar Conta\n" +
                        "2 - Deletar conta\n" +
                        "3 - Alterar Saldo\n" +
                        "4 - Relatórios Gerencias\n" +
                        "5 - sair\n" +
                        "------------\n");
        return ValidacoesInput.perguntar_int_menu();
    }
}